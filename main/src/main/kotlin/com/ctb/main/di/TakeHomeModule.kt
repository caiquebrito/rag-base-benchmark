package com.ctb.main.di

import org.koin.core.module.Module

object TakeHomeModule {
    private val baseModules: List<Module> = listOf(
        commonModule,
        dataRemoteModule,
        dataModule,
        domainModule,
        presentationModule
    )

    fun getAllModules(): List<Module> = baseModules

    fun getFeatureModules(): List<Module> = emptyList()
}
