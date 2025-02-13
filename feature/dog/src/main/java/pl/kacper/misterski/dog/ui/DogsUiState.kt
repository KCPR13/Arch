package pl.kacper.misterski.dog.ui

import pl.kacper.misterski.dog.ui.model.DogsUiModel

sealed class DogsUiState {
    data object Loading : DogsUiState()
    data class Success(val list: List<DogsUiModel>) : DogsUiState()
    data class Failure(val error: Throwable) : DogsUiState()
}
