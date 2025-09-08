package org.testarossa.portfolio

import androidx.compose.ui.window.ComposeUIViewController
import org.testarossa.portfolio.app.App
import org.testarossa.portfolio.di.initKoin

// old
//fun MainViewController() = ComposeUIViewController(
//    configure = {
//        initKoin()
//    }
//) { App() }

fun MainViewController() = ComposeUIViewController { App() }