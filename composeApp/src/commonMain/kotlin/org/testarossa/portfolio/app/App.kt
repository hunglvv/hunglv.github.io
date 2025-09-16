package org.testarossa.portfolio.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.setSingletonImageLoaderFactory
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.testarossa.portfolio.core.presentation.theme.MediumPadding
import org.testarossa.portfolio.core.presentation.theme.PortfolioTheme
import org.testarossa.portfolio.core.presentation.utils.BuildAdaptiveContent
import org.testarossa.portfolio.core.presentation.utils.getAsyncImageLoader
import org.testarossa.portfolio.core.presentation.utils.isCompactHeight
import org.testarossa.portfolio.core.presentation.utils.isCompactWidth
import org.testarossa.portfolio.core.presentation.utils.navigateToScreen
import org.testarossa.portfolio.portfolio.presentation.home.HomeScreenRoot
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.AppAction
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.AppViewModel
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.BottomNavigationBar
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.NavigationBarRail

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
@Preview
fun App(
    appViewModel: AppViewModel = koinViewModel()
) {
    val navController = rememberNavController()
    val state by appViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.currentRoute) {
        state.currentRoute?.let { route ->
            navController.navigateToScreen(route)
        }
    }

    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }

    PortfolioTheme(darkTheme = state.isDarkMode) {
        val currentRoute =  state.currentRoute ?: Route.Home
        Scaffold(
            bottomBar = {
                AnimatedVisibility(visible = isCompactWidth()) {
                    BottomNavigationBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .background(MaterialTheme.colorScheme.surfaceContainer)
                            .padding(horizontal = MediumPadding),
                        currentRoute = currentRoute,
                        onNavigateTo = { route ->
                            appViewModel.onAction(AppAction.OnRouteChange(route))
                        }
                    )
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


            BuildAdaptiveContent(
                expandContent = {
                    NavigationRailContent(
                        modifier = rootModifier.then(
                            if (isCompactHeight()) Modifier.windowInsetsPadding(WindowInsets.displayCutout)
                            else Modifier
                        ),
                        isExpanded = true,
                        currentRoute = currentRoute,
                        onNavigateTo = { route ->
                            appViewModel.onAction(AppAction.OnRouteChange(route))
                        }
                    ) {
                        Content(
                            modifier = Modifier.weight(1f).fillMaxHeight(),
                            navController = navController
                        )
                    }
                },
                mediumContent = {
                    NavigationRailContent(
                        modifier = rootModifier,
                        isExpanded = false,
                        currentRoute = currentRoute,
                        onNavigateTo = { route ->
                            appViewModel.onAction(AppAction.OnRouteChange(route))
                        }
                    ) {
                        Content(
                            modifier = Modifier.weight(1f).fillMaxHeight(),
                            navController = navController
                        )
                    }
                },
                compactContent = {
                    Content(
                        modifier = rootModifier,
                        navController = navController
                    )
                }
            )

        }
    }
}

@Composable
private fun NavigationRailContent(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    currentRoute: Route,
    onNavigateTo: (Route) -> Unit,
    content: @Composable RowScope.() -> Unit
) {


    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        NavigationBarRail(
            modifier = Modifier
                .then(
                    if (isExpanded) {
                        Modifier.width(240.dp)
                    } else {
                        Modifier.width(IntrinsicSize.Min)
                    }
                )
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.surfaceContainer),
            isExpanded = isExpanded,
            currentRoute = currentRoute,
            onNavigateTo = onNavigateTo
        )
        content()
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreenRoot()
        }
        composable<Route.About> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("About")
            }
        }
        composable<Route.Resume> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Resume")
            }
        }
        composable<Route.Skills> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Skills")
            }
        }
        composable<Route.Settings> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Settings")
            }
        }
    }
}
