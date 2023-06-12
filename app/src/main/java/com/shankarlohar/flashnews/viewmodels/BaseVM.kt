package com.shankarlohar.flashnews.viewmodels

import androidx.lifecycle.ViewModel
import com.shankarlohar.flashnews.states.BaseState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.updateAndGet

open class BaseVM<STATE : BaseState>(initialState: STATE) : ViewModel() {
    private val _state = MutableStateFlow(initialState)

    val state = _state.asStateFlow()

    val currentState: STATE get() = state.value

    fun setState(update: STATE.() -> STATE) = _state.updateAndGet(update)
}