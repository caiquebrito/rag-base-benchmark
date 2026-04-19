package com.ctb.takehome

import android.app.Application
import com.ctb.main.TakeHome

class TakeHomeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        TakeHome.init()
    }
}
