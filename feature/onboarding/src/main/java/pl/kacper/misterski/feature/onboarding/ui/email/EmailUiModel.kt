package pl.kacper.misterski.feature.onboarding.ui.email

import java.io.Serializable

data class EmailUiModel(
    val email: String = "",
    val showError: Boolean = false,
    val enableContinueButton: Boolean = false
) : Serializable

