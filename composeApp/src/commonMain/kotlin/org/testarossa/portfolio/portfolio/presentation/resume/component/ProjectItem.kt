package org.testarossa.portfolio.portfolio.presentation.resume.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.core.presentation.theme.LargePadding
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.NormalPadding
import org.testarossa.portfolio.core.presentation.theme.SmallPadding
import org.testarossa.portfolio.core.presentation.utils.LocalImage
import org.testarossa.portfolio.portfolio.domain.MyProject

@Composable
fun ProjectItem(
    modifier: Modifier = Modifier,
    project: MyProject,
    onViewProject: () -> Unit
) {
    val localString = rememberStrings()
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsHoveredAsState()
    val scale by animateFloatAsState(if (isFocused) 1.2f else 1f, label = "")

    val currentThumb = remember(project) { project.pathImage.replace("%d", "1") }

    Surface(
        modifier = modifier,
        shadowElevation = if (isFocused) 4.dp else 0.dp,
        interactionSource = interactionSource,
        onClick = {},
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceContainerLowest,
        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(bottom = MediumPadding)) {
            Box(
                Modifier.fillMaxWidth().aspectRatio(0.85f).clipToBounds(),
                contentAlignment = Alignment.Center
            ) {
                if (currentThumb.isNotEmpty()) {
                    LocalImage(
                        modifier = Modifier.fillMaxSize().scale(scale),
                        path = currentThumb,
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Spacer(modifier = Modifier.height(LargePadding))

            Text(
                text = project.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = MediumPadding)
            )
            Text(
                text = localString.get(project.description),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(
                    start = MediumPadding,
                    top = MediumPadding,
                    end = MediumPadding
                ).fillMaxWidth().heightIn(min = 100.dp)
            )

            FlowRow(
                modifier = Modifier
                    .padding(start = MediumPadding, end= MediumPadding, top = MediumPadding)
                    .fillMaxWidth()
                    .heightIn(min = 148.dp),
                horizontalArrangement = Arrangement.spacedBy(NormalPadding),
                verticalArrangement = Arrangement.spacedBy(NormalPadding)
            ) {
                project.techs.forEach { tech ->
                    Text(
                        text = tech,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.background(
                            MaterialTheme.colorScheme.surfaceContainer,
                            MaterialTheme.shapes.medium
                        ).padding(vertical = SmallPadding, horizontal = NormalPadding)
                    )
                }
            }
            TextButton(
                onClick = onViewProject,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.onSurface
                ),
                contentPadding = PaddingValues(horizontal = LargePadding),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(SmallPadding)
                ) {
                    Icon(
                        Icons.AutoMirrored.Default.OpenInNew,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.surface
                    )

                    Text(
                        text = localString.get("view"),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surface
                    )
                }

            }

        }
    }
}