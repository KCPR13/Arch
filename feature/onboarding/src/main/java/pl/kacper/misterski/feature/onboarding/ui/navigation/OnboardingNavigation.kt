package pl.kacper.misterski.feature.onboarding.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.kacper.misterski.common.ui.navigation.animatedDestination
import pl.kacper.misterski.feature.onboarding.ui.OnboardingViewModel
import pl.kacper.misterski.feature.onboarding.ui.common.TopBar
import pl.kacper.misterski.feature.onboarding.ui.email.EmailScreen
import pl.kacper.misterski.feature.onboarding.ui.full_name.FullNameScreen
import pl.kacper.misterski.feature.onboarding.ui.phone.PhoneScreen
import pl.kacper.misterski.feature.onboarding.ui.photo.PhotoScreen
import pl.kacper.misterski.feature.onboarding.ui.summary.SummaryScreen

fun NavGraphBuilder.onboarding(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onOnboardingCompleted: () -> Unit
) {
    animatedDestination(pl.kacper.misterski.common.ui.navigation.NavigationItem.Onboarding.route) {
        val navController = rememberNavController()
        val viewModel: OnboardingViewModel = hiltViewModel()

        val emailUiState by viewModel.emailUiState.collectAsStateWithLifecycle()
        val phoneUiState by viewModel.phoneUiState.collectAsStateWithLifecycle()
        val fullNameUiState by viewModel.fullNameUiState.collectAsStateWithLifecycle()
        val photoUiState by viewModel.photoUiState.collectAsStateWithLifecycle()
        val currentStep by viewModel.currentStep.collectAsStateWithLifecycle()


        Scaffold(
            modifier = modifier,
            topBar = {
                TopBar(
                    step = currentStep.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onBackClick = {
                        if (currentStep > 1){
                            navController.popBackStack()
                            viewModel.dropCurrentStep()
                        } else{
                            onBackClick.invoke()
                        }
                    }
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = NavigationItem.Email.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(NavigationItem.Email.route) {
                    EmailScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        onContinueClicked = {
                            viewModel.updateCurrentStep(2)
                            navController.navigate(NavigationItem.FullName.route)
                        }, onEmailChanged = { viewModel.updateEmail(it) },
                        uiState = emailUiState
                    )
                }

                composable(NavigationItem.FullName.route) {
                    FullNameScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        uiState = fullNameUiState,
                        onFullNameChanged = { newFullName ->
                            viewModel.updateFullName(newFullName)
                        },
                        onContinueClicked = {
                            viewModel.updateCurrentStep(3)
                            navController.navigate(NavigationItem.Phone.route)
                        }
                    )
                }

                composable(NavigationItem.Phone.route) {
                    PhoneScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        uiState = phoneUiState,
                        onPhoneNumberChanged = { newPhoneNumber ->
                            viewModel.updatePhone(newPhoneNumber)
                        },
                        onContinueClicked = {
                            viewModel.updateCurrentStep(4)
                            navController.navigate(NavigationItem.Photo.route)
                        }
                    )
                }

                composable(NavigationItem.Photo.route) {
                    PhotoScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        onPhotoSelected = { newAvatarUri ->
                            viewModel.updatePhotoUri(newAvatarUri)
                        },
                        onContinue = {
                            viewModel.updateCurrentStep(5)
                            navController.navigate(NavigationItem.Summary.route)
                        },
                        uiState = photoUiState
                    )
                }

                composable(NavigationItem.Summary.route) {
                    SummaryScreen(
                        email = emailUiState.email,
                        fullName = fullNameUiState.fullName,
                        phoneNumber = phoneUiState.phoneNumber,
                        avatarUri = photoUiState.uri,
                        onContinue = onOnboardingCompleted
                    )
                }
            }
        }
    }
}