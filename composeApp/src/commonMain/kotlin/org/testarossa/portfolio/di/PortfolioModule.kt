package org.testarossa.portfolio.di

import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Module
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.AppViewModel

@Module
class PortfolioModule  {

    @KoinViewModel
    fun appViewModel() = AppViewModel()

}