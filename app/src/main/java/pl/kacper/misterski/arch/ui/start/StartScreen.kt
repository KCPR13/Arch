package pl.kacper.misterski.arch.ui.start

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartScreen(modifier: Modifier = Modifier,
                onDogsSelected: () -> Unit) {
    Column(modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button({onDogsSelected.invoke()}) {
            Text("Dogs")
        }

    }
}

@Preview
@Composable
private fun StartScreenPreview() {
    StartScreen(onDogsSelected = {})
}