package pl.kacper.misterski.arch.ui.start

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Close
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import pl.kacper.misterski.arch.ui.start.model.LocationStatusUiModel
import pl.kacper.misterski.arch.util.managers.AppLocationManagerImpl
import pl.kacper.misterski.domain.dog.use_case.GetDogsUseCase
import javax.inject.Inject


@HiltViewModel
internal class StartViewModel @Inject constructor(
    appLocationManager: AppLocationManagerImpl,
    private val dogsUseCase: GetDogsUseCase
) :
    ViewModel() {

    val locationStatus = if (appLocationManager.isLocationEnabled()) {
        LocationStatusUiModel("Location enabled", Icons.Default.LocationOn)
    } else {
        LocationStatusUiModel("Location disabled", Icons.Rounded.Close)
    }

    // TODO K FLOW BUG 2
    fun onCombineTestSelected() {
        combine(simpleFlow(), dogsUseCase.invoke(null)) { simpleFlow, dogs ->
            Log.e("StartViewModel", simpleFlow)
            Log.e("StartViewModel", "dogs result: $dogs")
        }.launchIn(viewModelScope)
    }

    private fun simpleFlow() = flow {
        delay(1000)
        emit("SIMPLE FLOW 1 SEC")
    }

}