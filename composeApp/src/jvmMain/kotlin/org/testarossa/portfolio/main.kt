package org.testarossa.portfolio

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.testarossa.portfolio.app.App
import org.testarossa.portfolio.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "MyPortfolio",
        ) {
            App()
        }
    }
}