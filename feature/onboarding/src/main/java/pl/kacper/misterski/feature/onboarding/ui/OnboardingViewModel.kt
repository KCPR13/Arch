package pl.kacper.misterski.feature.onboarding.ui

import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pl.kacper.misterski.feature.onboarding.ui.email.EmailUiModel
import pl.kacper.misterski.feature.onboarding.ui.full_name.FullNameUiModel
import pl.kacper.misterski.feature.onboarding.ui.phone.PhoneUiModel
import pl.kacper.misterski.feature.onboarding.ui.photo.PhotoUiModel
import javax.inject.Inject


@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState = _uiState.asStateFlow()


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
        _uiState.update {
            val emailValid =
                email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            it.copy(
                emailUiModel = EmailUiModel(
                    email = email,
                    showError = !emailValid,
                    enableContinueButton = emailValid
                )
            )
        }
    }

    private fun updatePhone(phone: String) {
        _uiState.update {
            it.copy(
                phoneUiModel = PhoneUiModel(
                    phoneNumber = phone,
                    continueButtonEnabled = phone.isNotEmpty()
                )
            )
        }
    }

    private fun updateFullName(fullName: String) {
        _uiState.update {
            it.copy(
                fullNameUiModel = FullNameUiModel(
                    fullName = fullName,
                    enableContinueButton = fullName.isNotEmpty()
                )
            )
        }
    }

    private fun updatePhotoUri(uri: Uri?) {
        _uiState.update {
            it.copy(photoUiModel = PhotoUiModel(uri = uri, continueButtonEnabled = uri != null))
        }
    }

    private fun updateCurrentStep(step: OnboardingStep) {
        _uiState.update {
            it.copy(currentStep = step)
        }
    }

    private fun dropCurrentStep() {
        _uiState.update {
            val newStepPosition = it.currentStep.position - 1
            val newStep = OnboardingStep.entries.find { step -> step.position == newStepPosition }
            it.copy(currentStep = newStep ?: it.currentStep)
        }
    }
}