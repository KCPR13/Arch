package pl.kacper.misterski.feature.dog.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import pl.kacper.misterski.feature.dog.ui.model.DogsUiModel
import pl.kacper.misterski.common.ui.error.ErrorScreen
import pl.kacper.misterski.common.ui.loading.LoadingScreen
import pl.kacper.misterski.dog.R


@Composable
internal fun DogsScreen(modifier: Modifier, uiState: DogsUiState, onBackClick: () -> Unit) {

    when (uiState) {
        is DogsUiState.Failure -> ErrorScreen(
            message = uiState.error.message ?: "Unknown Error"
        )

        is DogsUiState.Loading -> LoadingScreen(
            Modifier.size(
                60.dp
            )
        )
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
        Text(
            text = stringResource(R.string.dogs),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Change to desired column count
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(8.dp)
        ) {
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
            Text(stringResource(pl.kacper.misterski.ui.R.string.back))
        }
    }
}

@Composable
private fun DogItem(model: DogsUiModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally),
            painter = rememberAsyncImagePainter(model.url),
            contentDescription = "Loaded Image"
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = model.title,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDogsScreen() {
    MaterialTheme {
        DogsScreen(
            modifier = Modifier,
            onBackClick = {},
            uiState = DogsUiState.Loading
        )
    }
}
