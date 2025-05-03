package pl.kacper.misterski.feature.onboarding.ui

import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import pl.kacper.misterski.common.ui.navigation.NavigationItem
import pl.kacper.misterski.common.ui.navigation.animatedDestination
import pl.kacper.misterski.feature.onboarding.email.EmailScreen

fun NavGraphBuilder.onboarding(modifier: Modifier, onBackClick: () -> Unit) {
    animatedDestination(NavigationItem.Onboarding.route) { // TODO K cleanup
//        val viewModel: NewsViewModel = hiltViewModel()
//        val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

        EmailScreen {  }
//        (
//            modifier = modifier,
//            uiState = uiState,
//            onBackClick = onBackClick,
//            onRefresh = { viewModel.fetchData() }
//        )
    }
}