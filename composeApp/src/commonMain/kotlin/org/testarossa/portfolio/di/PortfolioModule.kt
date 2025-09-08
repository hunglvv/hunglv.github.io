package org.testarossa.portfolio.di

import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.testarossa.portfolio.portfolio.data.KtorPortfolioRepository
import org.testarossa.portfolio.portfolio.domain.PortfolioRepository
import org.testarossa.portfolio.portfolio.presentation.PortfolioViewModel

@Module
class PortfolioModule  {
    @Factory(binds = [PortfolioRepository::class])
    fun portfolioRepository(
        @AuthHttpClient httpClient: HttpClient
    )  = KtorPortfolioRepository(httpClient)

    @KoinViewModel
    fun portfolioViewModel(
        repository: PortfolioRepository
    ) = PortfolioViewModel(repository)
}