package pl.kacper.misterski.feature.onboarding.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.kacper.misterski.common.ui.navigation.animatedDestination
import pl.kacper.misterski.feature.onboarding.ui.OnboardingAction
import pl.kacper.misterski.feature.onboarding.ui.OnboardingStep
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

        val uiState = viewModel.uiState

        Scaffold(
            modifier = modifier,
            topBar = {
                TopBar(
                    step = uiState.currentStep.position.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onBackClick = {
                        if (uiState.currentStep.position > 1) {
                            navController.popBackStack()
                            viewModel.onAction(OnboardingAction.DropCurrentStep)
                        } else {
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
                            viewModel.onAction(OnboardingAction.StepUpdate(OnboardingStep.FULL_NAME))
                            navController.navigate(NavigationItem.FullName.route)
                        }, onEmailChanged = viewModel::onAction,
                        uiState = uiState.emailUiModel
                    )
                }

                composable(NavigationItem.FullName.route) {
                    FullNameScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        uiState = uiState.fullNameUiModel,
                        onFullNameChanged = viewModel::onAction,
                        onContinueClicked = {
                            viewModel.onAction(OnboardingAction.StepUpdate(OnboardingStep.PHONE))
                            navController.navigate(NavigationItem.Phone.route)
                        }
                    )
                }

                composable(NavigationItem.Phone.route) {
                    PhoneScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        uiState = uiState.phoneUiModel,
                        onPhoneNumberChanged = viewModel::onAction,
                        onContinueClicked = {
                            viewModel.onAction(OnboardingAction.StepUpdate(OnboardingStep.PHOTO))
                            navController.navigate(NavigationItem.Photo.route)
                        }
                    )
                }

                composable(NavigationItem.Photo.route) {
                    PhotoScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        onPhotoSelected = viewModel::onAction,
                        onContinue = {
                            viewModel.onAction(OnboardingAction.StepUpdate(OnboardingStep.SUMMARY))
                            navController.navigate(NavigationItem.Summary.route)
                        },
                        uiState = uiState.photoUiModel
                    )
                }

                composable(NavigationItem.Summary.route) {
                    SummaryScreen(
                        email = uiState.emailUiModel.email,
                        fullName = uiState.fullNameUiModel.fullName,
                        phoneNumber = uiState.phoneUiModel.phoneNumber,
                        avatarUri = uiState.photoUiModel.uri,
                        onContinue = onOnboardingCompleted
                    )
                }
            }
        }
    }
}