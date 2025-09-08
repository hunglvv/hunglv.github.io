package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import myportfolio.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import org.testarossa.portfolio.app.Route
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.component.BottomNavigationBarItem

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
        BottomNavigationBarItem(
            modifier = Modifier,
            selected = currentRoute == Route.Home,
            imageVector = Icons.Default.Home,
            label = stringResource(Res.string.home),
            onClick = { onNavigateTo(Route.Home) }
        )
    }
}