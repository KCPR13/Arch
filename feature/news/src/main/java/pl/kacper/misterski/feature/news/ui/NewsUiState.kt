package pl.kacper.misterski.feature.news.ui

import pl.kacper.misterski.news.ui.model.NewsUiModel

sealed class NewsUiState {
    data object Loading : NewsUiState()
    data class Success(val list: List<NewsUiModel>) : NewsUiState()
    data class Failure(val error: Throwable) : NewsUiState()
}
