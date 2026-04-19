package com.ctb.main.di

import com.ctb.domain.usecase.GetSampleDataUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetSampleDataUseCase(
            repository = get(),
            dispatcher = Dispatchers.IO
        )
    }
}
