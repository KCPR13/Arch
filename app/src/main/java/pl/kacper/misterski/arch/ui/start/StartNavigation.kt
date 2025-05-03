package pl.kacper.misterski.arch.ui.start

import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import pl.kacper.misterski.common.ui.navigation.NavigationItem
import pl.kacper.misterski.common.ui.navigation.animatedDestination

fun NavGraphBuilder.start(
    modifier: Modifier,
    onDogsSelected: () -> Unit,
    onNewsSelected: () -> Unit,
    onOnboardingSelected: () -> Unit,
) {
    animatedDestination(NavigationItem.Start.route) {
        val viewModel: StartViewModel = hiltViewModel()

        StartScreen(
            modifier = modifier,
            onDogsSelected = onDogsSelected,
            onNewsSelected = onNewsSelected,
            onOnboardingSelected = onOnboardingSelected,
            locationStatusUiModel = viewModel.locationStatus
        )
    }
}