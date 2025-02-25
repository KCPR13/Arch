package pl.kacper.misterski.feature.news.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.domain.news.use_case.GetNewsUseCase
import pl.kacper.misterski.feature.news.ui.mapper.mapToNewsUiModels
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val uiState = _uiState
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            NewsUiState.Loading
        )

    init {
        fetchData()
    }


    fun fetchData() {
        viewModelScope.launch {
            _uiState.update { NewsUiState.Loading }
        }
        getNewsUseCase.invoke().map { result ->
            when (result) {
                is Result.Failure -> NewsUiState.Failure(result.error)
                is Result.Success -> NewsUiState.Success(result.data.mapToNewsUiModels())
            }
        }.onEach { state ->
            _uiState.update { state }
        }.catch { error ->
            _uiState.update { NewsUiState.Failure(error) }
        }.launchIn(viewModelScope)
    }


}