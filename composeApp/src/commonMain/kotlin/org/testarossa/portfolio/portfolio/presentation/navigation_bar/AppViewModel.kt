package org.testarossa.portfolio.portfolio.presentation.navigation_bar

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.testarossa.portfolio.core.presentation.BaseViewModel
import org.testarossa.portfolio.core.presentation.LocalizationManager
import org.testarossa.portfolio.core.presentation.utils.stateWhileSubscribed


class AppViewModel (): BaseViewModel(){

    private val _state = MutableStateFlow(AppState())
    val state = _state
        .onStart {
            observeLanguage()
        }.stateWhileSubscribed(viewModelScope, _state.value)

    init {
        viewModelScope.launch {
            LocalizationManager.load()
        }
    }

    fun onAction(action: AppAction) {
        onDebounceTask {
            when(action){
                is AppAction.OnDarkModeChange -> _state.update { it.copy(isDarkMode = action.isDarkMode) }
                is AppAction.OnLanguageChange -> _state.update { it.copy(currentLanguage = action.language) }
                is AppAction.OnRouteChange -> _state.update { it.copy(currentRoute = action.route) }
            }
        }
    }

    private fun observeLanguage(){
        state
            .map { it.currentLanguage }
            .distinctUntilChanged()
            .onEach { language ->
                LocalizationManager.changeLocale(language)
            }.launchIn(viewModelScope)
    }
}