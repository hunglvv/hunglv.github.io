package org.testarossa.portfolio

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.testarossa.portfolio.app.App
import org.testarossa.portfolio.di.initKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    document.title = "Hung's Portfolio"
    initKoin()
    ComposeViewport(document.body!!) {
        App()
    }
}