package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.about
import myportfolio.composeapp.generated.resources.home
import myportfolio.composeapp.generated.resources.resume
import myportfolio.composeapp.generated.resources.settings
import myportfolio.composeapp.generated.resources.skill
import org.jetbrains.compose.resources.stringResource
import org.testarossa.portfolio.app.Route
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.component.NavigationBarRailItem

@Composable
fun NavigationBarRail(
    modifier: Modifier = Modifier,
    currentRoute: Route,
    onNavigateTo: (Route) -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        NavigationBarRailItem(
            modifier = Modifier.fillMaxWidth(),
            selected = currentRoute == Route.Home,
            imageVector = Icons.Default.Home,
            label = stringResource(Res.string.home),
            onClick = { onNavigateTo(Route.Home) }
        )
        NavigationBarRailItem(
            modifier = Modifier.fillMaxWidth(),
            selected = currentRoute == Route.About,
            imageVector = Icons.Default.Person,
            label = stringResource(Res.string.about),
            onClick = { onNavigateTo(Route.About) }
        )
        NavigationBarRailItem(
            modifier = Modifier.fillMaxWidth(),
            selected = currentRoute == Route.Resume,
            imageVector = Icons.AutoMirrored.Default.Article,
            label = stringResource(Res.string.resume),
            onClick = { onNavigateTo(Route.Resume) }
        )
        NavigationBarRailItem(
            modifier = Modifier.fillMaxWidth(),
            selected = currentRoute == Route.Skills,
            imageVector = Icons.Default.DesignServices,
            label = stringResource(Res.string.skill),
            onClick = { onNavigateTo(Route.Skills) }
        )
        NavigationBarRailItem(
            modifier = Modifier.fillMaxWidth(),
            selected = currentRoute == Route.Settings,
            imageVector = Icons.Default.Settings,
            label = stringResource(Res.string.settings),
            onClick = { onNavigateTo(Route.Settings) }
        )
    }
}