package com.ctb.presentation.sample

import com.ctb.common.mvi.UIEffect
import com.ctb.common.mvi.UIState
import com.ctb.domain.models.SampleEntity

data class SampleState(
    val items: List<SampleEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) : UIState

sealed class SampleEffect : UIEffect {
    data class ShowError(val message: String) : SampleEffect()
    object DataLoaded : SampleEffect()
}
