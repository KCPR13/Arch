package pl.kacper.misterski.feature.onboarding.ui.summary

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pl.kacper.misterski.feature.onboarding.R
import pl.kacper.misterski.feature.onboarding.ui.common.Avatar
import pl.kacper.misterski.feature.onboarding.ui.common.AvatarPlaceholder
import pl.kacper.misterski.feature.onboarding.ui.common.ContinueButton

@Composable
fun SummaryScreen(
    modifier: Modifier = Modifier,
    email: String,
    fullName: String,
    phoneNumber: String,
    avatarUri: Uri?,
    onContinue: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        AvatarSection(avatarUri)

        Spacer(modifier = Modifier.height(24.dp))

        TitleSection()

        Spacer(modifier = Modifier.height(16.dp))

        EmailSection(email)

        Spacer(modifier = Modifier.height(16.dp))

        FullNameSection(fullName)

        Spacer(modifier = Modifier.height(16.dp))

        PhoneNumberSection(phoneNumber)

        Spacer(modifier = Modifier.height(32.dp))

        ContinueButtonSection(onContinue)
    }
}

@Composable
private fun AvatarSection(avatarUri: Uri?) {
    if (avatarUri != null) {
        Avatar(
            uri = avatarUri,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondary)
        )
    } else {
        AvatarPlaceholder()
    }
}

@Composable
private fun TitleSection() {
    Text(
        text = stringResource(R.string.summary),
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun EmailSection(email: String) {
    Text(
        text = stringResource(R.string.email),
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = email,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
private fun FullNameSection(fullName: String) {
    Text(
        text = stringResource(R.string.full_name_label),
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = fullName,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
private fun PhoneNumberSection(phoneNumber: String) {
    Text(
        text = stringResource(R.string.phone_number),
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = phoneNumber,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun ContinueButtonSection(onContinue: () -> Unit) {
    ContinueButton(
        onClick = onContinue,
        enabled = true
    )
}
