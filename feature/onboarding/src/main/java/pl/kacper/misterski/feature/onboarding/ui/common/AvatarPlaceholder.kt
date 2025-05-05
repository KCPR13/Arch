package pl.kacper.misterski.feature.onboarding.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.kacper.misterski.feature.onboarding.R


@Composable
fun AvatarPlaceholder(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        ) {
            Text(
                text = stringResource(R.string.no_photo),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(androidx.compose.ui.Alignment.Center)
            )
        }
    }
}