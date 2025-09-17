package org.testarossa.portfolio.portfolio.presentation.setting.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun DarkModeSwitch(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val paddingStart by animateDpAsState(
        targetValue = if (isChecked) 20.dp else 3.5.dp,
        label = "",
        animationSpec = tween(200)
    )
    val color by animateColorAsState(
        targetValue = if (isChecked) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurface,
        label = "",
        animationSpec = tween(200)
    )
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(28.dp))
            .background(color)
            .padding(vertical = 3.5.dp)
            .clickable(onClick = { onCheckedChange(!isChecked) })
    ) {
        Box(
            modifier = Modifier
                .padding(start = paddingStart)
                .size(21.dp)
                .background(MaterialTheme.colorScheme.onPrimary, CircleShape)
        )
    }
}