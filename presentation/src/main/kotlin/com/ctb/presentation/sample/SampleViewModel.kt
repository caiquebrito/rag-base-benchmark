package com.ctb.presentation.sample

import androidx.lifecycle.viewModelScope
import com.ctb.common.mvi.ViewModel
import com.ctb.commonkotlin.result.Result
import com.ctb.domain.usecase.GetSampleDataUseCase
import kotlinx.coroutines.launch

class SampleViewModel(
    private val getSampleDataUseCase: GetSampleDataUseCase
) : ViewModel<SampleState, SampleEffect>(SampleState()) {

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            setState { it.copy(isLoading = true, error = null) }
            getSampleDataUseCase(Unit).collect { result ->
                when (result) {
                    is Result.Success -> {
                        setState { it.copy(items = result.data, isLoading = false) }
                        emitEffect(SampleEffect.DataLoaded)
                    }
                    is Result.Failure -> {
                        setState { it.copy(isLoading = false, error = result.error.message) }
                        emitEffect(SampleEffect.ShowError(result.error.message ?: "Unknown error"))
                    }
                }
            }
        }
    }
}
