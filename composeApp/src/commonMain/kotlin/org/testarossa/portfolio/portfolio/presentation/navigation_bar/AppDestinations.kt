package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import org.testarossa.portfolio.app.Route

enum class AppDestinations(
    val route: Route,
    val label: String,
    val icon: ImageVector,
) {
    Home(Route.Home, "home", Icons.Default.Home),
    About(Route.About,"about", Icons.Default.Person),
    Resume(Route.Resume,"resume", Icons.AutoMirrored.Default.Article),
    Skills(Route.Skills,"skill", Icons.Default.DesignServices),
    Settings(Route.Settings,"settings", Icons.Default.Settings),
}