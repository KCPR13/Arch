package pl.kacper.misterski.feature.onboarding.ui

import android.net.Uri

sealed interface OnboardingAction {
    data class EmailUpdate(val email: String) : OnboardingAction
    data class PhoneUpdate(val phone: String) : OnboardingAction
    data class FullNameUpdate(val fullName: String) : OnboardingAction
    data class PhotoUpdate(val uri: Uri?) : OnboardingAction
    data class StepUpdate(val step: OnboardingStep) : OnboardingAction
    data object DropCurrentStep : OnboardingAction
}