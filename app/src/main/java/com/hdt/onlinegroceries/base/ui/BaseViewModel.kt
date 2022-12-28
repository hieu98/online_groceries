package com.hdt.onlinegroceries.base.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hdt.onlinegroceries.utils.SingleLiveEvent
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel(open val app: Application) : AndroidViewModel(app) {

    val onError = SingleLiveEvent<Throwable>()
    val isLoading = MutableLiveData(false)
    val isUpdateSuccess = MutableLiveData(false)

    var jobCall: Job? = null

    protected fun launchJob(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job = viewModelScope.launch(context + createErrorHandler(), start, block)

    protected fun launchLoadingJob(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job = viewModelScope.launch(context + createErrorHandler(), start) {
        isLoading.postValue(true)
        try {
            block()
        } finally {
            isLoading.postValue(false)
        }
    }

    private fun createErrorHandler() = CoroutineExceptionHandler { _, throwable ->
        if (throwable !is CancellationException) {
            onError.postCall(throwable)
        }
    }

    override fun onCleared() {
        super.onCleared()
        jobCall?.cancel()
    }
}