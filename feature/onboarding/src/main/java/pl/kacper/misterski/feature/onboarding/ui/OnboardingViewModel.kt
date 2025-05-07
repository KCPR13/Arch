package pl.kacper.misterski.feature.onboarding.ui

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import pl.kacper.misterski.feature.onboarding.ui.email.EmailUiModel
import pl.kacper.misterski.feature.onboarding.ui.full_name.FullNameUiModel
import pl.kacper.misterski.feature.onboarding.ui.phone.PhoneUiModel
import pl.kacper.misterski.feature.onboarding.ui.photo.PhotoUiModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val UI_STATE_KEY = "uiState"
    }

    val uiState: StateFlow<OnboardingUiState> = savedStateHandle.getStateFlow(
        key = UI_STATE_KEY,
        initialValue = OnboardingUiState()
    )

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
        val emailValid = email.isNotEmpty() &&
            android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        savedStateHandle[UI_STATE_KEY] = uiState.value.copy(
            emailUiModel = EmailUiModel(
                email = email,
                showError = !emailValid,
                enableContinueButton = emailValid
            )
        )
    }

    private fun updatePhone(phone: String) {
        savedStateHandle[UI_STATE_KEY] = uiState.value.copy(
            phoneUiModel = PhoneUiModel(
                phoneNumber = phone,
                continueButtonEnabled = phone.isNotEmpty()
            )
        )
    }

    private fun updateFullName(fullName: String) {
        savedStateHandle[UI_STATE_KEY] = uiState.value.copy(
            fullNameUiModel = FullNameUiModel(
                fullName = fullName,
                enableContinueButton = fullName.isNotEmpty()
            )
        )
    }

    private fun updatePhotoUri(uri: Uri?) {
        savedStateHandle[UI_STATE_KEY] = uiState.value.copy(
            photoUiModel = PhotoUiModel(
                uriString = uri?.toString(),
                continueButtonEnabled = uri != null
            )
        )
    }

    private fun updateCurrentStep(step: OnboardingStep) {
        savedStateHandle[UI_STATE_KEY] = uiState.value.copy(
            currentStep = step
        )
    }

    private fun dropCurrentStep() {
        val newStepPosition = uiState.value.currentStep.position - 1
        val newStep = OnboardingStep.entries.find { step ->
            step.position == newStepPosition
        }
        savedStateHandle[UI_STATE_KEY] = uiState.value.copy(
            currentStep = newStep ?: uiState.value.currentStep
        )
    }
}