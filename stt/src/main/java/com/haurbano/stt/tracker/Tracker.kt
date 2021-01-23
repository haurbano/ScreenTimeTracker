package com.haurbano.stt.tracker

import com.haurbano.stt.reporter.Reporter

interface Tracker {
    fun initialize(reporters: List<Reporter>)
}