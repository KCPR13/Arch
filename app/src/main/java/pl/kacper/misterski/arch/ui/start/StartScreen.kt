package pl.kacper.misterski.arch.ui.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.kacper.misterski.arch.ui.start.model.LocationStatusUiModel

@Composable
internal fun StartScreen(
    modifier: Modifier = Modifier,
    onDogsSelected: () -> Unit,
    onNewsSelected: () -> Unit,
    locationStatusUiModel: LocationStatusUiModel
) {
    Column(modifier) {

        LocationStatus(locationStatusUiModel)
        Spacer(Modifier.fillMaxWidth())

        Button(modifier = Modifier.padding(16.dp),
            onClick = { onDogsSelected.invoke() }) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(pl.kacper.misterski.arch.R.string.dogs_title),
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.fillMaxWidth())
        Button(modifier = Modifier.padding(16.dp),
            onClick = { onNewsSelected.invoke() }) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(pl.kacper.misterski.arch.R.string.news_title),
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
private fun LocationStatus(locationStatusUiModel: LocationStatusUiModel) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(text = locationStatusUiModel.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = locationStatusUiModel.imageVector,
            contentDescription = "Location Status",
            tint = Color.Blue,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
private fun StartScreenPreview() {
    StartScreen(
        onDogsSelected = {},
        onNewsSelected = {},
        locationStatusUiModel = LocationStatusUiModel("Title", Icons.Default.LocationOn)
    )
}