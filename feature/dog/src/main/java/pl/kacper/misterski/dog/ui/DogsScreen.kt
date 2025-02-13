package pl.kacper.misterski.dog.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import pl.kacper.misterski.core.ui.ErrorScreen
import pl.kacper.misterski.dog.R
import pl.kacper.misterski.dog.ui.model.DogsUiModel


@Composable
fun DogsScreen(modifier: Modifier, uiState: DogsUiState, onBackClick: () -> Unit) {

    when (uiState) {
        is DogsUiState.Failure -> ErrorScreen(message = uiState.error.message ?: "Unknown Error")
        is DogsUiState.Loading -> CircularProgressIndicator()
        is DogsUiState.Success -> DogsListScreen(
            modifier = modifier,
            models = uiState.list,
            onBackClick = { onBackClick.invoke() })
    }
}

@Composable
private fun DogsListScreen(
    modifier: Modifier, models: List<DogsUiModel>,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(models) { item ->
                DogItem(item)
            }
        }
        Button(
            onClick = { onBackClick.invoke() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(stringResource(R.string.back))
        }
    }
}

@Composable
private fun DogItem(model: DogsUiModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = rememberAsyncImagePainter(model.url),
            contentDescription = "Loaded Image"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = model.title, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDogsScreen() {
    DogsScreen(
        modifier = Modifier,
        onBackClick = {},
        uiState = DogsUiState.Loading
    )
}
