package org.testarossa.portfolio.portfolio.presentation.resume.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
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
    project: MyProject
) {
    val localString = rememberStrings()
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsHoveredAsState()
    val scale by animateFloatAsState(if (isFocused) 1.2f else 1f, label = "")

    var currentThumb by remember { mutableStateOf("") }

    LaunchedEffect(project, isFocused) {
        currentThumb = project.pathImage.replace("%d", "1")
        if (isFocused) {
            var i = 1
            while (i <= project.sizeImage) {
                currentThumb = project.pathImage.replace("%d", "$i")
                kotlinx.coroutines.delay(500)
                i++
            }
        }
    }

    Surface(
        modifier = modifier,
        shadowElevation = if (isFocused) 4.dp else 0.dp,
        interactionSource = interactionSource,
        onClick = {},
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceContainerLowest,
        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.padding(MediumPadding).fillMaxWidth()) {
            LocalImage(
                modifier = Modifier.fillMaxWidth().aspectRatio(3 / 4f).scale(scale),
                path = currentThumb
            )
            Spacer(modifier = Modifier.height(LargePadding))

            Text(
                text = project.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            Text(
                text = localString.get(project.description),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                textAlign = TextAlign.Start
            )

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
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

        }
    }
}