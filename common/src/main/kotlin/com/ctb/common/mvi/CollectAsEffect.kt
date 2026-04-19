package com.ctb.common.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.SharedFlow

@Composable
inline fun <reified E : UIEffect> CollectAsEffect(
    effect: SharedFlow<E>,
    crossinline onEffect: suspend (effect: E) -> Unit
) {
    LaunchedEffect(effect) {
        effect.collect { effect ->
            onEffect(effect)
        }
    }
}
