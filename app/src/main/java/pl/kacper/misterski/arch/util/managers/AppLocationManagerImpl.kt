package pl.kacper.misterski.arch.util.managers

import android.location.LocationManager

class AppLocationManagerImpl(private val locationManager: LocationManager): AppLocationManager {
    override fun isLocationEnabled(): Boolean {
         return locationManager.isLocationEnabled
    }
}