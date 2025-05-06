package pl.kacper.misterski.feature.onboarding.ui

import pl.kacper.misterski.feature.onboarding.ui.email.EmailUiModel
import pl.kacper.misterski.feature.onboarding.ui.full_name.FullNameUiModel
import pl.kacper.misterski.feature.onboarding.ui.phone.PhoneUiModel
import pl.kacper.misterski.feature.onboarding.ui.photo.PhotoUiModel

data class OnboardingUiState(
    val currentStep: OnboardingStep = OnboardingStep.EMAIL,
    val emailUiModel: EmailUiModel = EmailUiModel(),
    val phoneUiModel: PhoneUiModel = PhoneUiModel(),
    val fullNameUiModel: FullNameUiModel = FullNameUiModel(),
    val photoUiModel: PhotoUiModel = PhotoUiModel()
)

