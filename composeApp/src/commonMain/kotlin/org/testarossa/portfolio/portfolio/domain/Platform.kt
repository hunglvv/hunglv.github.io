package org.testarossa.portfolio.portfolio.domain


enum class Platform {
    MOBILE, DESKTOP, WASM
}

expect fun getPlatform(): Platform