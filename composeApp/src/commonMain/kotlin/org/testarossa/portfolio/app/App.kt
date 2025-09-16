package org.testarossa.portfolio.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.testarossa.portfolio.core.presentation.theme.CompactPadding
import org.testarossa.portfolio.core.presentation.theme.PortfolioTheme
import org.testarossa.portfolio.core.presentation.utils.BuildAdaptiveContent
import org.testarossa.portfolio.core.presentation.utils.isCompactHeight
import org.testarossa.portfolio.core.presentation.utils.isCompactWidth
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.BottomNavigationBar
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.NavigationBarRail

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
@Preview
fun App() {
    val darkTheme by rememberSaveable {
        mutableStateOf(false)
    }

    PortfolioTheme(darkTheme = darkTheme) {

        val navController = rememberNavController()
        var currentRoute: Route by remember {
            mutableStateOf(Route.Home)
        }
        Scaffold(
            bottomBar = {
                AnimatedVisibility(visible = isCompactWidth()) {
                    BottomNavigationBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .background(MaterialTheme.colorScheme.surfaceContainer)
                            .padding(horizontal = CompactPadding),
                        currentRoute = currentRoute,
                        onNavigateTo = { route ->
                            currentRoute = route
                            /*navController.navigate(route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }*/
                        })
                }

            },
            contentWindowInsets = WindowInsets.statusBars
        ) { innerPadding ->
            val rootModifier = Modifier
                .fillMaxSize()
                .then(
                    if (!isCompactWidth()) Modifier.padding(0.dp)
                    else Modifier.padding(paddingValues = innerPadding)
                )
                .background(MaterialTheme.colorScheme.background)
                .consumeWindowInsets(WindowInsets.navigationBars)

            SharedTransitionLayout {
                BuildAdaptiveContent(
                    expandContent = {
                        NavigationRailContent(
                            modifier = rootModifier.then(
                                if (isCompactHeight()) Modifier.windowInsetsPadding(WindowInsets.displayCutout)
                                else Modifier
                            ),
                            expand = true,
                            currentRoute = currentRoute,
                            onNavigateTo = { route ->
                                currentRoute = route
                            }
                        )
                    },
                    mediumContent = {
                        NavigationRailContent(
                            modifier = rootModifier,
                            expand = false,
                            currentRoute = currentRoute,
                            onNavigateTo = { route ->
                                currentRoute = route
                            }
                        )
                    },
                    compactContent = {
                        Content(
                            modifier = rootModifier
                        )
                    }
                )
            }

        }
    }
}

@Composable
private fun NavigationRailContent(
    modifier: Modifier = Modifier,
    expand: Boolean,
    currentRoute: Route,
    onNavigateTo: (Route) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        NavigationBarRail(
            modifier = Modifier
                .then(
                    if (expand) {
                        Modifier.width(240.dp)
                    } else {
                        Modifier.width(IntrinsicSize.Min)
                    }
                )
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.surfaceContainer),
            expandSize = expand,
            currentRoute = currentRoute,
            onNavigateTo = onNavigateTo
        )
        Content(
            modifier = Modifier.weight(1f).fillMaxHeight()
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier
) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val widthSizeClass = windowSizeClass.windowWidthSizeClass
    val heightSizeClass = windowSizeClass.windowHeightSizeClass
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Content : $widthSizeClass - $heightSizeClass")
    }
}

//when(deviceConfiguration) {
//                DeviceConfiguration.TABLET_PORTRAIT,
//                DeviceConfiguration.MOBILE_PORTRAIT -> {
//                    Column(
//                        modifier = rootModifier,
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.spacedBy(32.dp)
//                    ) {
//
//                    }
//                }
//                DeviceConfiguration.MOBILE_LANDSCAPE -> {
//                    Row(
//                        modifier = rootModifier
//                            .windowInsetsPadding(WindowInsets.displayCutout)
//                            .padding(
//                                horizontal = 32.dp
//                            ),
//                        horizontalArrangement = Arrangement.spacedBy(32.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//
//                    }
//                }
//                DeviceConfiguration.TABLET_LANDSCAPE,
//                DeviceConfiguration.DESKTOP -> {
//                    Column(
//                        modifier = rootModifier
//                            .verticalScroll(rememberScrollState())
//                            .padding(top = 48.dp),
//                        verticalArrangement = Arrangement.spacedBy(32.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//
//                    }
//                }
//            }