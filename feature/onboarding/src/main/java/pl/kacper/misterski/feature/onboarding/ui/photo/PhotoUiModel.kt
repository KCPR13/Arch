package pl.kacper.misterski.feature.onboarding.ui.photo

import java.io.Serializable

data class PhotoUiModel(val uriString: String? = null, val continueButtonEnabled: Boolean = false) : Serializable
