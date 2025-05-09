package pl.kacper.misterski.feature.onboarding.ui

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.kacper.misterski.feature.onboarding.ui.email.EmailUiModel
import pl.kacper.misterski.feature.onboarding.ui.full_name.FullNameUiModel
import pl.kacper.misterski.feature.onboarding.ui.phone.PhoneUiModel
import pl.kacper.misterski.feature.onboarding.ui.photo.PhotoUiModel
import javax.inject.Inject


@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {

    var uiState by mutableStateOf(OnboardingUiState())
        private set


    fun onAction(action: OnboardingAction) {
        when (action) {
            is OnboardingAction.DropCurrentStep -> dropCurrentStep()
            is OnboardingAction.EmailUpdate -> updateEmail(email = action.email)
            is OnboardingAction.FullNameUpdate -> updateFullName(fullName = action.fullName)
            is OnboardingAction.PhoneUpdate -> updatePhone(phone = action.phone)
            is OnboardingAction.PhotoUpdate -> updatePhotoUri(uri = action.uri)
            is OnboardingAction.StepUpdate -> updateCurrentStep(step = action.step)
        }
    }


    private fun updateEmail(email: String) {
        val emailValid =
            email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        uiState = uiState.copy(
            emailUiModel = EmailUiModel(
                email = email,
                showError = !emailValid,
                enableContinueButton = emailValid
            )
        )
    }

    private fun updatePhone(phone: String) {
        uiState = uiState.copy(
            phoneUiModel = PhoneUiModel(
                phoneNumber = phone,
                continueButtonEnabled = phone.isNotEmpty()
            )
        )
    }

    private fun updateFullName(fullName: String) {
        uiState = uiState.copy(
            fullNameUiModel = FullNameUiModel(
                fullName = fullName,
                enableContinueButton = fullName.isNotEmpty()
            )
        )
    }

    private fun updatePhotoUri(uri: Uri?) {
        uiState = uiState.copy(
            photoUiModel = PhotoUiModel(
                uri = uri,
                continueButtonEnabled = uri != null
            )
        )
    }

    private fun updateCurrentStep(step: OnboardingStep) {
        uiState = uiState.copy(currentStep = step)
    }

    private fun dropCurrentStep() {
        val newStepPosition = uiState.currentStep.position - 1
        val newStep = OnboardingStep.entries.find { step -> step.position == newStepPosition }
        uiState = uiState.copy(currentStep = newStep ?: uiState.currentStep)
    }
}