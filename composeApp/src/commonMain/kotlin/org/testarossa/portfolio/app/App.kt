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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.testarossa.portfolio.core.presentation.theme.PortfolioTheme
import org.testarossa.portfolio.core.presentation.utils.isDesktopSize
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

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                AnimatedVisibility(visible = !isDesktopSize()) {
                    BottomNavigationBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min),
                        currentRoute = Route.Home,
                        onNavigateTo = { route ->
                            navController.navigate(route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }

            },
            contentWindowInsets = WindowInsets.statusBars
        ) { innerPadding ->
            val rootModifier = Modifier
                .fillMaxSize()
                .padding(if (!isDesktopSize()) innerPadding.calculateBottomPadding() else 0.dp)
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .consumeWindowInsets(WindowInsets.navigationBars)


            SharedTransitionLayout(modifier = rootModifier) {
                if (isDesktopSize()) {
                    Row(
                        modifier = rootModifier,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        NavigationBarRail(
                            modifier = Modifier.fillMaxWidth(1 / 6f).fillMaxHeight(),
                            currentRoute = Route.Home,
                            onNavigateTo = { route ->
                                navController.navigate(route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        inclusive = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                        Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Gray)) {
                            Text("Content")
                        }
                    }
                } else {
                    Box(modifier = rootModifier) {
                        Text("Content")
                    }
                }
            }

        }
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