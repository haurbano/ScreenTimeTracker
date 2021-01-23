package com.haurbano.stt

import android.util.Log
import com.haurbano.stt.reporter.Reporter
import com.haurbano.stt.tracker.Tracker

object ScreenTimeTracker {
    private const val TAG = "STT"

    private val trackers: ArrayList<Tracker> = arrayListOf()
    private val reporters: ArrayList<Reporter> = arrayListOf()

    fun initialize(): Boolean {

        if (reporters.isEmpty()){
            Log.e(TAG, "There is not reporter added, try ScreenTimeTracker.addReporter(<reporter>)")
            return false
        }

        if (trackers.isEmpty()){
            Log.e(TAG, "There is not trackers added, try ScreenTimeTracker.addTracker(<tracker>)")
            return false
        }

        trackers.forEach { it.initialize(reporters) }
        return true
    }

    fun addTracker(tracker: Tracker){
        trackers.add(tracker)
    }

    fun addReporter(reporter: Reporter) {
        reporters.add(reporter)
    }
}