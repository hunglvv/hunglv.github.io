package org.testarossa.portfolio.portfolio.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.core.presentation.theme.LargePadding
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.NormalPadding
import org.testarossa.portfolio.core.presentation.theme.SmallPadding
import org.testarossa.portfolio.core.presentation.utils.LocalImage
import org.testarossa.portfolio.core.presentation.utils.isCompactHeight
import org.testarossa.portfolio.core.presentation.utils.isCompactWidth
import org.testarossa.portfolio.core.presentation.utils.isDesktopSize
import org.testarossa.portfolio.portfolio.presentation.home.component.TyperWriterText
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.component.SocialButtons

@Composable
fun HomeScreenRoot(
    onViewProject: () -> Unit
) {
    val uriHandler = LocalUriHandler.current
    val localString = rememberStrings()
    Box(modifier = Modifier.fillMaxSize()) {
        LocalImage(
            modifier = Modifier.fillMaxSize(),
            path = "drawable/img_home.webp",
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(MediumPadding)
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.7f), MaterialTheme.shapes.medium)
                .padding(horizontal = MediumPadding, vertical = NormalPadding)
                .align(
                    if (isCompactWidth()) Alignment.BottomStart else Alignment.CenterStart
                )
                .then(
                    if (isCompactHeight()) Modifier.verticalScroll(rememberScrollState()) else Modifier
                )
        ) {
            Text(
                text = localString.get("hello_im"),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            )
            Spacer(modifier = Modifier.height(NormalPadding))
            Text(
                text = localString.get("my_full_name"),
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Black),
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(MediumPadding))
            TyperWriterText()
            Spacer(modifier = Modifier.height(MediumPadding))
            Text(
                text = localString.get("home_overview"),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.widthIn(max = 360.dp).fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(LargePadding))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(NormalPadding)
            ) {
                TextButton(
                    onClick = onViewProject,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = MaterialTheme.colorScheme.onSurface
                    ),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = localString.get("view_my_work"),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surface
                    )
                }
                TextButton(
                    onClick = {
                        uriHandler.openUri("https://www.topcv.vn/xem-cv/WAhUAw9fV1BSCVZbBVFXBVZQAgQMXVMFAAoFAgf0a0")
                    },
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurface.copy(0.8f)
                    ),
                    shape = MaterialTheme.shapes.small
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(SmallPadding)
                    ) {
                        Icon(
                            Icons.Default.Download,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = localString.get("download_cv"),
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            if (!isDesktopSize()) {
                Spacer(modifier = Modifier.height(MediumPadding))
                SocialButtons()
            }
        }

        Text(
            text = "Made by Compose Multiplatform",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(MediumPadding).align(Alignment.BottomEnd)
        )
    }
}