package org.testarossa.portfolio.portfolio.presentation.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.Shapes
import org.testarossa.portfolio.core.presentation.utils.LocalImage
import org.testarossa.portfolio.portfolio.presentation.about.component.MyInfo
import org.testarossa.portfolio.portfolio.presentation.about.component.avatar

@Composable
fun AboutScreen() {
    val localString = rememberStrings()
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val widthSizeClass = windowSizeClass.windowWidthSizeClass

    val column = when (widthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 1
        WindowWidthSizeClass.MEDIUM -> 2
        else -> 3
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = localString.get("about"),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = MediumPadding).align(Alignment.CenterHorizontally)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(column),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(MediumPadding),
            horizontalArrangement = Arrangement.spacedBy(MediumPadding),
            verticalArrangement = Arrangement.spacedBy(MediumPadding)
        ) {
            if (column < 3) {
                avatar(
                    modifier = Modifier.size(200.dp).clip(Shapes.medium),
                )
            }
            item(span = { GridItemSpan(this.maxLineSpan) }) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = localString.get("about_home_title"),
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Medium),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                        textAlign = if (column < 3) TextAlign.Justify else TextAlign.Center,
                        modifier = Modifier.widthIn(max = 700.dp).fillMaxWidth()
                    )
                }
            }
            if (column == 3) {
                item {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        LocalImage(
                            modifier = Modifier.size(200.dp).clip(Shapes.medium),
                            path = "drawable/img_avatar.jpg",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            // info
            item {
                MyInfo(modifier = Modifier.padding(top = MediumPadding).fillMaxWidth())
            }

            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text("Skills")
                }
            }
        }
    }
}