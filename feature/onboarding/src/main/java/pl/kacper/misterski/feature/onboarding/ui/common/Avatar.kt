package pl.kacper.misterski.feature.onboarding.ui.common

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter


@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    uri: Uri
) {
    Image(
        painter = rememberAsyncImagePainter(uri),
        contentDescription = "Selected Avatar",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}