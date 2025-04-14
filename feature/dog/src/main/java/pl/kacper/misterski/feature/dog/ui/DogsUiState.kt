package pl.kacper.misterski.feature.dog.ui

import pl.kacper.misterski.feature.dog.ui.model.DogsUiModel

internal sealed class DogsUiState {
    data object Loading : DogsUiState()
    data class Success(val list: List<DogsUiModel>) : DogsUiState()
    data class Failure(val error: Throwable) : DogsUiState()
}
