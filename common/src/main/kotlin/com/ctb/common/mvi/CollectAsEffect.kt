package com.ctb.common.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun <E : UIEffect> CollectAsEffect(
    effect: SharedFlow<E>,
    onEffect: suspend (effect: E) -> Unit
) {
    LaunchedEffect(effect) {
        effect.collect { effect ->
            onEffect(effect)
        }
    }
}
