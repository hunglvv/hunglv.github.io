package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.testarossa.portfolio.app.Route
import org.testarossa.portfolio.core.presentation.rememberStrings
import org.testarossa.portfolio.portfolio.domain.AppDestinations
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.component.BottomNavigationBarItem

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentRoute: Route,
    onNavigateTo: (Route) -> Unit
) {

    val localString = rememberStrings()
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
                label = localString.get(destination.label),
                onClick = { onNavigateTo(destination.route) }
            )
        }
    }
}

