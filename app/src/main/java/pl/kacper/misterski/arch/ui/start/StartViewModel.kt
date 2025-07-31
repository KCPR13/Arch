package pl.kacper.misterski.arch.ui.start

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Close
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pl.kacper.misterski.arch.extensions.isCameraPermissionGranted
import pl.kacper.misterski.arch.ui.start.model.LocationStatusUiModel
import pl.kacper.misterski.arch.util.managers.AppLocationManagerImpl
import javax.inject.Inject



data class StartState(
    val cameraPermissionGranted : Boolean
)

@HiltViewModel
internal class StartViewModel @Inject constructor(@ApplicationContext context: Context, appLocationManager: AppLocationManagerImpl) : ViewModel() {


    private val _startState = MutableStateFlow(
        StartState(
            cameraPermissionGranted = context.isCameraPermissionGranted()
        )
    )
    val startState = _startState.asStateFlow()
    val locationStatus = if (appLocationManager.isLocationEnabled()) {
        LocationStatusUiModel("Location enabled", Icons.Default.LocationOn)
    } else {
        LocationStatusUiModel("Location disabled", Icons.Rounded.Close)
    }

    fun updateCameraPermissionGranted(isGranted: Boolean) {
        _startState.update{
            it.copy(cameraPermissionGranted = isGranted)
        }
    }

}