package pl.kacper.misterski.feature.news.ui

import pl.kacper.misterski.feature.news.ui.model.NewsUiModel

internal sealed class NewsUiState {
    data object Loading : NewsUiState()
    data class Success(val list: List<NewsUiModel>) : NewsUiState()
    data class Failure(val error: Throwable) : NewsUiState()
}
