package org.testarossa.portfolio.portfolio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.testarossa.portfolio.portfolio.domain.PortfolioRepository

class PortfolioViewModel(
    private val repository: PortfolioRepository
) : ViewModel(){

    private val _state = MutableStateFlow(emptyList<String>())
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            val projects = repository.getProjects()
            _state.update { projects }
        }
    }
}