package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.my_name
import org.jetbrains.compose.resources.stringResource
import org.testarossa.portfolio.app.Route
import org.testarossa.portfolio.core.presentation.theme.ExpandPadding
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.utils.isCompactHeight
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.component.NavigationBarRailItem
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.component.SocialButtons

@Composable
fun NavigationBarRail(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    currentRoute: Route,
    onNavigateTo: (Route) -> Unit
) {
    Column(
        modifier = if (isCompactHeight()) modifier.verticalScroll(rememberScrollState()) else modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isExpanded) {
            Text(
                text = stringResource(Res.string.my_name),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = ExpandPadding).align(Alignment.CenterHorizontally)
            )
            SocialButtons(
                modifier = Modifier.padding(top = ExpandPadding).align(Alignment.CenterHorizontally)
            )
            HorizontalDivider(
                modifier = Modifier.padding(top = ExpandPadding).fillMaxWidth(),
                thickness = 1.0.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }
        Spacer(modifier = Modifier.height(ExpandPadding))

        AppDestinations.entries.forEach { destination ->
            NavigationBarRailItem(
                modifier = Modifier.padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                isExpanded = isExpanded,
                isSelected = currentRoute == destination.route,
                imageVector = destination.icon,
                label = stringResource(destination.label),
                onClick = { onNavigateTo(destination.route) }
            )
        }
    }
}
