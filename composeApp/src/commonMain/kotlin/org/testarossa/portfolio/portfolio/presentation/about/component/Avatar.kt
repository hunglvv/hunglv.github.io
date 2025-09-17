package org.testarossa.portfolio.portfolio.presentation.about.component

import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import org.testarossa.portfolio.core.presentation.utils.LocalImage


fun LazyGridScope.avatar(
    modifier: Modifier = Modifier,
) {
    item(span = { GridItemSpan(this.maxLineSpan) }) {
        LocalImage(
            modifier = modifier.clip(MaterialTheme.shapes.medium),
            path = "drawable/img_avatar.jpg",
            contentScale = ContentScale.Crop
        )
    }
}