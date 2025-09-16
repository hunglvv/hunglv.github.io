package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.about
import myportfolio.composeapp.generated.resources.home
import myportfolio.composeapp.generated.resources.resume
import myportfolio.composeapp.generated.resources.settings
import myportfolio.composeapp.generated.resources.skill
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.testarossa.portfolio.app.Route
import org.testarossa.portfolio.core.presentation.theme.PortfolioTheme
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.component.BottomNavigationBarItem
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.component.NavigationBarRailItem

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentRoute: Route,
    onNavigateTo: (Route) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AppDestinations.entries.forEach { destination ->
            BottomNavigationBarItem(
                modifier = Modifier.fillMaxHeight().weight(1f),
                selected = currentRoute == destination.route,
                imageVector = destination.icon,
                label = stringResource(destination.label),
                onClick = { onNavigateTo(destination.route) }
            )
        }
    }
}

