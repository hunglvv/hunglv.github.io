package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.about
import myportfolio.composeapp.generated.resources.home
import myportfolio.composeapp.generated.resources.resume
import myportfolio.composeapp.generated.resources.settings
import myportfolio.composeapp.generated.resources.skill
import org.jetbrains.compose.resources.StringResource
import org.testarossa.portfolio.app.Route

enum class AppDestinations(
    val route: Route,
    val label: StringResource,
    val icon: ImageVector,
) {
    Home(Route.Home, Res.string.home, Icons.Default.Home),
    About(Route.About,Res.string.about, Icons.Default.Person),
    Resume(Route.Resume,Res.string.resume, Icons.AutoMirrored.Default.Article),
    Skills(Route.Skills,Res.string.skill, Icons.Default.DesignServices),
    Settings(Route.Settings,Res.string.settings, Icons.Default.Settings),
}