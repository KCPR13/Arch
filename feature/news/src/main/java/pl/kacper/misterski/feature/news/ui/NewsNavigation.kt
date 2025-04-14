package pl.kacper.misterski.feature.news.ui

import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import pl.kacper.misterski.common.ui.navigation.NavigationItem
import pl.kacper.misterski.common.ui.navigation.animatedDestination


fun NavGraphBuilder.news(modifier: Modifier, onBackClick: () -> Unit) {
    animatedDestination(NavigationItem.News.route) {
        val viewModel: NewsViewModel = hiltViewModel()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

        NewsScreen(
            modifier = modifier,
            uiState = uiState,
            onBackClick = onBackClick,
            onRefresh = { viewModel.fetchData() }
        )
    }
}