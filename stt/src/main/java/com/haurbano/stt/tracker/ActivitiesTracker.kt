package com.haurbano.stt.tracker

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.haurbano.stt.model.Report
import com.haurbano.stt.model.Screen
import com.haurbano.stt.reporter.Reporter

class ActivitiesTracker(private val app: Application): Tracker {

    private lateinit var reporters: List<Reporter>
    private val sessions: HashMap<String, Long> = hashMapOf()

    override fun initialize(reporters: List<Reporter>) {
        this.reporters = reporters
        setupActivityTracker()
    }

    private fun setupActivityTracker() {

        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {}

            override fun onActivityStarted(activity: Activity) {
                sessions[activity.localClassName] = System.currentTimeMillis()
            }

            override fun onActivityResumed(p0: Activity) {}

            override fun onActivityPaused(p0: Activity) {}

            override fun onActivityStopped(activity: Activity) {
                if (sessions.containsKey(activity.localClassName)) {
                    val totalTime = System.currentTimeMillis() - sessions[activity.localClassName]!!
                    val screen = Screen(activity.localClassName, activity.localClassName)
                    val report = Report(totalTime, screen)
                    reporters.forEach { it.report(report) }
                }
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}

            override fun onActivityDestroyed(p0: Activity) {}
        })
    }

}