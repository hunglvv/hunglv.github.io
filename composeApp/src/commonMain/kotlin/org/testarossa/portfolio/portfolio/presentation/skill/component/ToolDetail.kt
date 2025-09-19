package org.testarossa.portfolio.portfolio.presentation.skill.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.NormalPadding

@Composable
fun ToolDetail(
    modifier: Modifier=Modifier,
    icon: ImageVector,
    title: String,
){
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsHoveredAsState()
    Column(
        modifier = modifier
            .clickable(
                onClick = {},
                interactionSource = interactionSource,
                indication = null
            )
            .then(
                if (isFocused) Modifier.shadow(4.dp, MaterialTheme.shapes.medium)
                else Modifier
            )
            .background(MaterialTheme.colorScheme.surfaceContainerLowest, MaterialTheme.shapes.medium)
            .border(
                0.5.dp,
                MaterialTheme.colorScheme.outlineVariant,
                MaterialTheme.shapes.medium
            )
            .padding(vertical = MediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(NormalPadding)
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(36.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )
    }
}