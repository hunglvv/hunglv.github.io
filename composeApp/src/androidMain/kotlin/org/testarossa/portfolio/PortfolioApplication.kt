package org.testarossa.portfolio

import android.app.Application
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.util.DebugLogger
import coil3.util.Logger
import kotlinx.coroutines.Dispatchers
import okio.Path.Companion.toOkioPath
import org.koin.android.ext.koin.androidContext
import org.testarossa.portfolio.di.initKoin

class PortfolioApplication: Application(), SingletonImageLoader.Factory {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@PortfolioApplication)
        }
    }

    override fun newImageLoader(context: PlatformContext)= ImageLoader.Builder(context)
        .memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(context, COIL_MEMORY_CACHE_SIZE_PERCENT)
                .build()
        }
        .diskCache {
            DiskCache.Builder()
                .directory(filesDir.resolve(COIL_DISK_CACHE_DIRECTORY_NAME).toOkioPath())
                .maxSizePercent(COIL_DISK_CACHE_SIZE_PERCENT)
                .cleanupCoroutineContext(Dispatchers.IO)
                .build()
        }
        .apply {
//            if (BuildConfig.DEBUG) {
//                logger(DebugLogger(Logger.Level.Debug))
//            }
        }
        .build()

    companion object {
        private const val COIL_MEMORY_CACHE_SIZE_PERCENT = 0.25
        private const val COIL_DISK_CACHE_DIRECTORY_NAME = "PortfolioImageCache"
        private const val COIL_DISK_CACHE_SIZE_PERCENT = 0.02
    }
}