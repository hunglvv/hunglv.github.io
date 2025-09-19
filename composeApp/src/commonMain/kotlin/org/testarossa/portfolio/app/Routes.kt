package org.testarossa.portfolio.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object  Home: Route

    @Serializable
    data object About: Route

    @Serializable
    data object Resume: Route

    @Serializable
    data object Skills: Route

    @Serializable
    data object Settings: Route

}