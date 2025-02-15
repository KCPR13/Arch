package pl.kacper.misterski.arch.ui.start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.kacper.misterski.dog.R

@Composable
fun StartScreen(modifier: Modifier = Modifier,
                onDogsSelected: () -> Unit,
                onNewsSelected: () -> Unit,) {
    Column(modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(modifier = Modifier.padding(16.dp),
            onClick = { onDogsSelected.invoke()}) {
            Text(modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.dogs_title),
                textAlign = TextAlign.Center)
        }
        Spacer(Modifier.fillMaxWidth())
        Button(modifier = Modifier.padding(16.dp),
            onClick = {onNewsSelected.invoke()}) {
            Text(modifier = Modifier.fillMaxWidth(),
                text = stringResource(pl.kacper.misterski.arch.R.string.news_title),
                textAlign = TextAlign.Center)
        }

    }
}

@Preview
@Composable
private fun StartScreenPreview() {
    StartScreen(onDogsSelected = {}, onNewsSelected = {})
}