package org.testarossa.portfolio.portfolio.data

import io.ktor.client.HttpClient
import org.testarossa.portfolio.portfolio.domain.PortfolioRepository

class KtorPortfolioRepository(
    private val httpClient: HttpClient
): PortfolioRepository {

    override suspend fun getProjects(): List<String> {
        return listOf("Project 1", "Project 2", "Project 3")
    }
}