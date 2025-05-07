package pl.kacper.misterski.feature.onboarding.ui.photo

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import pl.kacper.misterski.feature.onboarding.R
import pl.kacper.misterski.feature.onboarding.ui.OnboardingAction
import pl.kacper.misterski.feature.onboarding.ui.common.Avatar
import pl.kacper.misterski.feature.onboarding.ui.common.AvatarPlaceholder
import pl.kacper.misterski.feature.onboarding.ui.common.ContinueButton

@Composable
fun PhotoScreen(
    modifier: Modifier = Modifier,
    uiState: PhotoUiModel,
    onPhotoSelected: (OnboardingAction) -> Unit,
    onContinue: () -> Unit
) {

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        onPhotoSelected(OnboardingAction.PhotoUpdate(uri))
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.select_your_profile_picture),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (uiState.uriString != null) {
            Avatar(
                uri = uiState.uriString.toUri(),
                modifier = Modifier
                    .size(128.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
        } else {
            AvatarPlaceholder()
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { photoPickerLauncher.launch("image/*") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.pick_a_photo))
        }

        Spacer(modifier = Modifier.height(24.dp))
        ContinueButton(
            onClick = onContinue,
            enabled = uiState.continueButtonEnabled
        )
    }
}