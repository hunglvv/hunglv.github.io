package org.testarossa.portfolio.core.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

inline fun Modifier.conditional(
    condition: Boolean,
    ifTrue: Modifier.() -> Modifier,
    ifFalse: Modifier.() -> Modifier = { this },
): Modifier = if (condition) {
    then(ifTrue(this))
} else {
    then(ifFalse(this))
}