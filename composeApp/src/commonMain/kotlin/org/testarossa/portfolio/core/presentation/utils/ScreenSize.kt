package org.testarossa.portfolio.core.presentation.utils

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

@Composable
fun isDesktopSize(): Boolean {
    return currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED
}

@Composable
fun isCompactWidth(): Boolean {
    return currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT
}

@Composable
fun isCompactHeight(): Boolean {
    return currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.COMPACT
}


/**
 * Build adaptive content based on the window size class.
 * @param expandContent Content to be displayed in expanded width size class.
 * @param mediumContent Content to be displayed in medium width size class.
 * @param compactContent Content to be displayed in compact width size class.
 * */
@Composable
fun BuildAdaptiveContent(
    expandContent: @Composable () -> Unit,
    mediumContent: @Composable () -> Unit,
    compactContent: @Composable () -> Unit
) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val widthSizeClass = windowSizeClass.windowWidthSizeClass

    when (widthSizeClass) {
        WindowWidthSizeClass.COMPACT -> compactContent()
        WindowWidthSizeClass.MEDIUM -> mediumContent()
        WindowWidthSizeClass.EXPANDED -> expandContent()
    }
}

enum class DeviceConfiguration {
    MOBILE_PORTRAIT, //bottom navigation
    MOBILE_LANDSCAPE,
    TABLET_PORTRAIT,
    TABLET_LANDSCAPE,
    DESKTOP;

    companion object {
        fun fromWindowSizeClass(windowSizeClass: WindowSizeClass): DeviceConfiguration {
            val widthClass = windowSizeClass.windowWidthSizeClass
            val heightClass = windowSizeClass.windowHeightSizeClass

            return when {
                widthClass == WindowWidthSizeClass.COMPACT &&
                        heightClass == WindowHeightSizeClass.MEDIUM -> MOBILE_PORTRAIT

                widthClass == WindowWidthSizeClass.COMPACT &&
                        heightClass == WindowHeightSizeClass.EXPANDED -> MOBILE_PORTRAIT

                widthClass == WindowWidthSizeClass.MEDIUM &&
                        heightClass == WindowHeightSizeClass.EXPANDED -> TABLET_PORTRAIT

                widthClass == WindowWidthSizeClass.EXPANDED &&
                        heightClass == WindowHeightSizeClass.COMPACT -> MOBILE_LANDSCAPE

                widthClass == WindowWidthSizeClass.EXPANDED &&
                        heightClass == WindowHeightSizeClass.MEDIUM -> TABLET_LANDSCAPE

                else -> DESKTOP
            }
        }
    }
}