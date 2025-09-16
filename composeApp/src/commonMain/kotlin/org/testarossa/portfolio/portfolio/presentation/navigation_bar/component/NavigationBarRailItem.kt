package org.testarossa.portfolio.portfolio.presentation.navigation_bar.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun NavigationBarRailItem(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    isSelected: Boolean,
    imageVector: ImageVector,
    label: String,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(100.dp),
        color = if (isSelected) MaterialTheme.colorScheme.tertiaryContainer else Color.Transparent,
    ) {
        if (isExpanded) {
            Row(
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector,
                    contentDescription = label,
                    tint = getColor(isSelected)
                )

                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    color = getColor(isSelected)
                )

            }
        } else {
            Column(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector,
                    contentDescription = label,
                    tint = getColor(isSelected)
                )

                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    color = getColor(isSelected)
                )
            }
        }
    }
}

@Composable
private fun getColor(isSelected: Boolean) =
    if (isSelected) MaterialTheme.colorScheme.onTertiaryContainer
    else MaterialTheme.colorScheme.onSurface