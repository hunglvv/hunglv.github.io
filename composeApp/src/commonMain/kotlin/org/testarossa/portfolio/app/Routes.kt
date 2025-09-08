package org.testarossa.portfolio.app

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Portfolio : Route



}