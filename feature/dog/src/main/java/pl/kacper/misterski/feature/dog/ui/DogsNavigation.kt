package pl.kacper.misterski.feature.dog.ui

import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import pl.kacper.misterski.common.ui.navigation.NavigationItem
import pl.kacper.misterski.common.ui.navigation.animatedDestination

fun NavGraphBuilder.dogs(modifier: Modifier, onBackClick: () -> Unit) {
    animatedDestination(NavigationItem.Dog.route) {
        val viewModel: DogsViewModel = hiltViewModel()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

        DogsScreen (
            modifier = modifier,
            uiState = uiState,
            onBackClick = onBackClick,
        )
    }
}
