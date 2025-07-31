package pl.kacper.misterski.arch.ui.start

import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
        val state by viewModel.startState.collectAsStateWithLifecycle()

        StartScreen(
            modifier = modifier,
            onDogsSelected = onDogsSelected,
            onNewsSelected = onNewsSelected,
            onOnboardingSelected = onOnboardingSelected,
            locationStatusUiModel = viewModel.locationStatus,
            state = state,
            onCameraPermissionGranted = viewModel::updateCameraPermissionGranted
        )
    }
}