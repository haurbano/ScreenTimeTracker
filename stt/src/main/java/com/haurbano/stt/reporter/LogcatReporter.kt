package com.haurbano.stt.reporter

import android.util.Log
import com.haurbano.stt.extensions.toReadableTime
import com.haurbano.stt.model.Report

class LogcatReporter: Reporter {
    companion object {
        private const val TAG = "LogcatReporter"
    }
    override fun report(report: Report) {
        with(report) {
            Log.i(TAG, "Screen: ${screen.name} -> Time: ${time.toReadableTime()}")
        }
    }
}