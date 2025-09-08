package org.testarossa.portfolio.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowWidthSizeClass
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.testarossa.portfolio.core.presentation.theme.PortfolioTheme
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.BottomNavigationBar

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
@Preview
fun App() {
    val darkTheme by rememberSaveable {
        mutableStateOf(false)
    }

    PortfolioTheme(darkTheme = darkTheme) {

        val navController = rememberNavController()
        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
        val widthClass = windowSizeClass.windowWidthSizeClass

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                AnimatedVisibility(visible = widthClass == WindowWidthSizeClass.COMPACT) {
                    BottomNavigationBar(
                        modifier = Modifier.fillMaxWidth(),
                        onNavigateTo = { route ->
                            navController.navigate(route){
                                popUpTo(navController.graph.findStartDestination().id){
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
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(
                    horizontal = 16.dp,
                    vertical = 24.dp
                )
                .consumeWindowInsets(WindowInsets.navigationBars)

            when (widthClass) {
                WindowWidthSizeClass.COMPACT -> {

                }

                WindowWidthSizeClass.MEDIUM -> {

                }

                WindowWidthSizeClass.EXPANDED -> {

                }
            }

            SharedTransitionLayout(modifier = rootModifier) {

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