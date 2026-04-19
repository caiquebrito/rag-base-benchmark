package com.ctb.common.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class ViewModel<S : UIState, E : UIEffect>(
    initialState: S
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<E>(replay = 0)
    val effect: SharedFlow<E> = _effect.asSharedFlow()

    protected fun setState(reducer: (S) -> S) {
        _state.value = reducer(_state.value)
    }

    protected suspend fun emitEffect(effect: E) {
        _effect.emit(effect)
    }
}
