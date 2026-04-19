package com.ctb.main.di

import com.ctb.common.rest.ApiServiceFactory
import com.ctb.data_remote.api.SampleApi
import org.koin.dsl.module

val dataRemoteModule = module {
    single {
        ApiServiceFactory.create(
            baseUrl = "https://api.example.com",
            serviceClass = SampleApi::class.java,
            client = get()
        )
    }
}
