package org.testarossa.portfolio.portfolio.domain

import okhttp3.internal.platform.AndroidPlatform


actual fun getPlatform(): Platform {
   return Platform.MOBILE
}