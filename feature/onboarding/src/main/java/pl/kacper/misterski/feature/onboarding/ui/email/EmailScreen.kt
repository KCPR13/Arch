package pl.kacper.misterski.feature.onboarding.ui.email

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import pl.kacper.misterski.feature.onboarding.R
import pl.kacper.misterski.feature.onboarding.ui.common.ContinueButton


@Composable
fun EmailScreen(
    modifier: Modifier,
    onContinueClicked: () -> Unit,
    onEmailChanged: (String) -> Unit,
    uiState: EmailUiModel
) {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        delay(300)
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.enter_email), style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(24.dp))


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            value = uiState.email,
            onValueChange = onEmailChanged
        )

        if (uiState.showError) {
            Text(
                text = stringResource(R.string.email_error_message),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        ContinueButton(
            onClick = onContinueClicked,
            enabled = uiState.enableContinueButton
        )
    }
}

@Preview
@Composable
private fun EmailScreenPreview() {
    MaterialTheme {
        EmailScreen(
            Modifier,
            {},
            {},
            EmailUiModel()
        )
    }
}