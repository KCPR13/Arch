package pl.kacper.misterski.dog.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.dog.domain.use_case.GetDogsUseCase
import pl.kacper.misterski.dog.ui.mapper.mapToDogsUiModels
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(getDogsUseCase: GetDogsUseCase) : ViewModel() {

    val uiState = getDogsUseCase.invoke().map { result ->
        when (result) {
            is Result.Failure -> DogsUiState.Failure(result.error)
            is Result.Success -> DogsUiState.Success(result.data.mapToDogsUiModels())
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        DogsUiState.Loading
    )
}