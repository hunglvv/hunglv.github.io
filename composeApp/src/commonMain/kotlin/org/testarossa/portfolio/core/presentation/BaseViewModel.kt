package org.testarossa.portfolio.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {
    private var job : Job? = null
    private var debounceJob: Job? = null

    fun onDebounceTask(delayMs: Long = DEFAULT_DELAY_INTERVAL, task: suspend () -> Unit) {
        debounceJob?.cancel()
        debounceJob = viewModelScope.launch {
            delay(delayMs)
            task()
        }
    }

    fun <E> Channel<E>.sendAction(action: E) {
        viewModelScope.launch {
            send(action)
        }
    }

    fun onLaunchJob(task: Job) {
        job?.cancel()
        job = task
    }

    fun onCancelJob() {
        job?.cancel()
    }

    override fun onCleared() {
        job?.cancel()
        debounceJob?.cancel()
        super.onCleared()
    }

    companion object {
        private const val DEFAULT_DELAY_INTERVAL = 350L
    }
}