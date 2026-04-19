package com.ctb.presentation.sample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ctb.common.mvi.CollectAsEffect
import io.insert_koin.androidx.compose.koinViewModel

@Composable
fun SampleScreen(
    viewModel: SampleViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsState().value

    CollectAsEffect(viewModel.effect) { effect ->
        when (effect) {
            is SampleEffect.ShowError -> {}
            SampleEffect.DataLoaded -> {}
        }
    }

    SampleContent(state)
}
