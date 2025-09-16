package org.testarossa.portfolio.core.presentation.utils

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.util.DebugLogger
import coil3.util.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import okio.FileSystem
import org.testarossa.portfolio.app.Route

inline fun Modifier.conditional(
    condition: Boolean,
    ifTrue: Modifier.() -> Modifier,
    ifFalse: Modifier.() -> Modifier = { this },
): Modifier = if (condition) {
    then(ifTrue(this))
} else {
    then(ifFalse(this))
}

fun NavHostController.navigateToScreen(route: Route){
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            inclusive = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun <T> Flow<T>.stateWhileSubscribed(
    scope: CoroutineScope,
    initialValue: T
): StateFlow<T> {
    return stateIn(scope, SharingStarted.WhileSubscribed(5_000L), initialValue)
}

fun getAsyncImageLoader(context: PlatformContext)=
    ImageLoader.Builder(context)
        .memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(context, 0.25)
                .build()
        }
        .diskCache {
            DiskCache.Builder()
                .directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY)
                .maxSizePercent( 0.02)
                .build()
        }
        .apply {
            logger(DebugLogger(Logger.Level.Debug))
        }
        .build()