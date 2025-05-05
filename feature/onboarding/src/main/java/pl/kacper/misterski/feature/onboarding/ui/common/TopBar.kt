package pl.kacper.misterski.feature.onboarding.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.kacper.misterski.feature.onboarding.R


@Composable
fun TopBar(modifier: Modifier = Modifier, step: String, onBackClick: () -> Unit) {
    Box(modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.onboarding_step, step),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.End
        )
        Image(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back),
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    onBackClick.invoke()
                })

    }
}