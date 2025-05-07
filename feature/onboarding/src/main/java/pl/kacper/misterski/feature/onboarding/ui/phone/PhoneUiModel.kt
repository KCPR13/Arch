package pl.kacper.misterski.feature.onboarding.ui.phone

import java.io.Serializable

data class PhoneUiModel(val phoneNumber: String = "", val continueButtonEnabled: Boolean = false) : Serializable
