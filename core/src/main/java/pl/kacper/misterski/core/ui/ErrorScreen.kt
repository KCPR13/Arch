package pl.kacper.misterski.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorScreen(modifier: Modifier = Modifier, message: String) {
    Column(modifier) {
        Text(message)
    }

}

@Preview
@Composable
private fun ErrorScreenPreview() {
    ErrorScreen(message = "test")
}