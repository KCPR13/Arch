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

    private val _emailUiState = MutableStateFlow(EmailUiModel())
    val emailUiState = _emailUiState.asStateFlow()

    private val _phoneUiState = MutableStateFlow(PhoneUiModel())
    val phoneUiState = _phoneUiState.asStateFlow()

    private val _fullNameUiState = MutableStateFlow(FullNameUiModel())
    val fullNameUiState = _fullNameUiState.asStateFlow()

    private val _photoUiState = MutableStateFlow(PhotoUiModel())
    val photoUiState = _photoUiState.asStateFlow()

    private val _currentStep = MutableStateFlow(1)
    val currentStep = _currentStep.asStateFlow()


    fun updateEmail(email: String) {
        _emailUiState.update {
            val emailValid =
                email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            EmailUiModel(
                email = email,
                showError = !emailValid,
                enableContinueButton = emailValid
            )
        }
    }

    fun updatePhone(phone: String) {
        _phoneUiState.update {
            PhoneUiModel(phoneNumber = phone, continueButtonEnabled = phone.isNotEmpty())
        }
    }

    fun updateFullName(fullName: String) {
        _fullNameUiState.update {
            FullNameUiModel(fullName = fullName, enableContinueButton = fullName.isNotEmpty())
        }
    }

    fun updatePhotoUri(uri: Uri?) {
        _photoUiState.update {
            PhotoUiModel(uri = uri, continueButtonEnabled = uri != null)
        }
    }

    fun updateCurrentStep(step: Int) {
        _currentStep.update { step }
    }

    fun dropCurrentStep() {
        _currentStep.update {
            it.minus(1)
        }
    }
}