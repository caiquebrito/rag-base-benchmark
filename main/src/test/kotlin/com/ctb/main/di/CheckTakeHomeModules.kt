package com.ctb.main.di

import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class CheckTakeHomeModules : KoinTest {
    @Test
    fun checkAllModules() {
        startKoin {
            modules(
                commonModule,
                dataRemoteModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }

        try {
            TakeHomeModule.getAllModules().forEach { it.verify() }
        } finally {
            stopKoin()
        }
    }
}
