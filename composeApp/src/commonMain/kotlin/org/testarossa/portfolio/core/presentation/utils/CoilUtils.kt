package org.testarossa.portfolio.core.presentation.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import io.ktor.client.request.request
import myportfolio.composeapp.generated.resources.Res
import org.testarossa.portfolio.portfolio.domain.Platform
import org.testarossa.portfolio.portfolio.domain.getPlatform

@Composable
fun LocalImage(
    modifier: Modifier = Modifier,
    path: String,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null,
) {
    val context = LocalPlatformContext.current
    val platform = getPlatform()
    if (platform == Platform.MOBILE){
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(Res.getUri(path))
                .build(),
            contentDescription = null,
            contentScale = contentScale,
            modifier = modifier,
            colorFilter = colorFilter,
        )
    }else{
        var request by remember {
            mutableStateOf<ImageRequest?>(null)
        }

        LaunchedEffect(Unit) {
            request = ImageRequest.Builder(context)
                .data(Res.readBytes(path))
                .memoryCacheKey(path)
                .diskCacheKey(path)
                .build()
        }
        request?.let {
            AsyncImage(
                model = request,
                contentDescription = null,
                contentScale = contentScale,
                modifier = modifier,
                colorFilter = colorFilter,
            )
        }
    }
}