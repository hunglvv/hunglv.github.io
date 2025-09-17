package org.testarossa.portfolio.portfolio.presentation.navigation_bar.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import coil3.Uri
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import io.ktor.client.request.request
import myportfolio.composeapp.generated.resources.Res
import org.testarossa.portfolio.core.presentation.utils.LocalImage
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.SocialContacts

@Composable
 fun SocialButtons(
    modifier: Modifier = Modifier,
){
    val uriHandler = LocalUriHandler.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialContacts.entries.forEach { contact ->
            SocialButton(
                onClick = {
                    uriHandler.openUri(contact.link)
                },
                resource = contact.thumb
            )
        }
    }
}

@Composable
private fun SocialButton(
    onClick: () -> Unit,
    resource: String,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        LocalImage(
            modifier = Modifier.size(28.dp).clip(CircleShape),
            path = resource,
            colorFilter = ColorFilter.tint( MaterialTheme.colorScheme.onSurface)
        )

    }
}