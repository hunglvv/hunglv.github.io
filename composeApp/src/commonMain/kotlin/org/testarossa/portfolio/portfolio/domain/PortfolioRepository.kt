package org.testarossa.portfolio.portfolio.domain

interface PortfolioRepository {
    suspend fun getProjects(): List<String>
}