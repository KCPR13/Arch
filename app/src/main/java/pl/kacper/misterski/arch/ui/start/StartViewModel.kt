package pl.kacper.misterski.arch.ui.start

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Close
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.kacper.misterski.arch.ui.start.model.LocationStatusUiModel
import pl.kacper.misterski.arch.util.managers.AppLocationManagerImpl
import javax.inject.Inject


@HiltViewModel
class StartViewModel @Inject constructor(appLocationManager: AppLocationManagerImpl) : ViewModel() {

    val locationStatus = if (appLocationManager.isLocationEnabled()) {
        LocationStatusUiModel("Location enabled", Icons.Default.LocationOn)
    } else {
        LocationStatusUiModel("Location disabled", Icons.Rounded.Close)
    }


}