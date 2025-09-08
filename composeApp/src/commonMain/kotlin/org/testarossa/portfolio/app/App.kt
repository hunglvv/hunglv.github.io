package org.testarossa.portfolio.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.testarossa.portfolio.core.presentation.theme.PortfolioTheme
import org.testarossa.portfolio.portfolio.presentation.PortfolioScreen

@Composable
@Preview
fun App(){
    PortfolioTheme {
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier.fillMaxSize()
        ){ innerPadding ->
            PortfolioScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}