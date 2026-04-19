package com.ctb.main.di

import com.ctb.data.datasource.SampleRemoteDataSource
import com.ctb.data.repository.SampleRepositoryImpl
import com.ctb.data_remote.repository.SampleRemoteDataSourceImpl
import com.ctb.domain.repositories.SampleRepository
import org.koin.dsl.module

val dataModule = module {
    single<SampleRemoteDataSource> {
        SampleRemoteDataSourceImpl(get())
    }

    single<SampleRepository> {
        SampleRepositoryImpl(get())
    }
}
