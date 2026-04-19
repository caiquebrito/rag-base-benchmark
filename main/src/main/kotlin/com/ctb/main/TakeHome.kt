package com.ctb.main

import com.ctb.main.di.commonModule
import com.ctb.main.di.dataRemoteModule
import com.ctb.main.di.dataModule
import com.ctb.main.di.domainModule
import com.ctb.main.di.presentationModule
import org.koin.core.context.startKoin

object TakeHome {
    fun init() {
        startKoin {
            modules(
                commonModule,
                dataRemoteModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }

    fun loadFeature(featureModules: List<org.koin.core.module.Module>) {
        org.koin.core.context.GlobalContext.get().loadModules(featureModules)
    }
}
