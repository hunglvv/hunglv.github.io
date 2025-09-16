package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import org.testarossa.portfolio.app.Route

sealed interface AppAction {
    data class OnRouteChange(val route: Route) : AppAction
    data class OnDarkModeChange(val isDarkMode: Boolean) : AppAction
    data class OnLanguageChange(val language: String) : AppAction

}