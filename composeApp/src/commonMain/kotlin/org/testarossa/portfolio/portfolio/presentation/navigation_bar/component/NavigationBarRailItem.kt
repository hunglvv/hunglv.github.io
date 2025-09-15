package org.testarossa.portfolio.portfolio.presentation.navigation_bar.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.testarossa.portfolio.core.presentation.theme.Surface
import org.testarossa.portfolio.core.presentation.theme.extraColor

@Composable
fun NavigationBarRailItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    imageVector: ImageVector,
    label: String,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(100.dp),
        color = if (selected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.surfaceContainerLowest,
    ){
        Row(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector,
                contentDescription = label,
                tint = if (selected) MaterialTheme.colorScheme.extraColor else MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = if (selected) MaterialTheme.colorScheme.extraColor else MaterialTheme.colorScheme.onSurface
            )

        }
    }
}