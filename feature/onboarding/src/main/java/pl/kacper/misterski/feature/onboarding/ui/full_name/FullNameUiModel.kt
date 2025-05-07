package pl.kacper.misterski.feature.onboarding.ui.full_name

import java.io.Serializable

data class FullNameUiModel(val enableContinueButton: Boolean = false, val fullName: String = "") : Serializable
