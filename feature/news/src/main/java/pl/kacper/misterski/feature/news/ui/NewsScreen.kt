package pl.kacper.misterski.feature.news.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.kacper.misterski.feature.news.ui.model.NewsUiModel
import pl.kacper.misterski.core.ui.error.ErrorScreen
import pl.kacper.misterski.core.ui.loading.LoadingScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    modifier: Modifier,
    uiState: NewsUiState,
    onBackClick: () -> Unit,
    onRefresh: () -> Unit
) {

    val refreshState = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = uiState is NewsUiState.Loading,
        state = refreshState,
        onRefresh = onRefresh
    ) {

        when (uiState) {
            is NewsUiState.Failure -> ErrorScreen(
                message = uiState.error.message ?: "Unknown Error"
            )

            is NewsUiState.Loading -> LoadingScreen(Modifier.size(60.dp))
            is NewsUiState.Success -> NewsListScreen(
                modifier = modifier,
                models = uiState.list,
                onBackClick = { onBackClick.invoke() }
            )
        }
    }
}

@Composable
private fun NewsListScreen(
    modifier: Modifier, models: List<NewsUiModel>,
    onBackClick: () -> Unit
) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "News2",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(models) { item ->
                    NewItem(Modifier.padding(8.dp), item)
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
private fun NewItem(modifier: Modifier, model: NewsUiModel) {
    Card(modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = model.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.fillMaxWidth())
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = model.body,
                fontSize = 18.sp,
            )
        }
    }

}

@PreviewLightDark
@Preview
@Composable
fun PreviewDogsScreen() {
    MaterialTheme {
        NewsScreen(
            modifier = Modifier,
            onBackClick = {},
            uiState = NewsUiState.Loading,
            onRefresh = {}
        )
    }

}
