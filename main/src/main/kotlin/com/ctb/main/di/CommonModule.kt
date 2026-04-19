package com.ctb.main.di

import com.ctb.common.rest.ApiServiceFactory
import com.ctb.common.rest.OkHttpClientFactory
import org.koin.dsl.module

val commonModule = module {
    single {
        OkHttpClientFactory.createOkHttpClient(
            enableLogging = true
        )
    }
}
