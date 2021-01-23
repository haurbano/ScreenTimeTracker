package com.haurbano.stt

import android.app.Application
import com.haurbano.stt.reporter.LogcatReporter
import com.haurbano.stt.tracker.ActivitiesTracker

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        ScreenTimeTracker.apply {
            addReporter(LogcatReporter())
            addTracker(ActivitiesTracker(this@App))
            initialize()
        }
    }
}