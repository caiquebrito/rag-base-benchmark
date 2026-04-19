package com.ctb.main.di

import com.ctb.presentation.sample.SampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        SampleViewModel(
            getSampleDataUseCase = get()
        )
    }
}
