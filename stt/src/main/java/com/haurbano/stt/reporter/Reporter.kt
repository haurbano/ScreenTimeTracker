package com.haurbano.stt.reporter

import com.haurbano.stt.model.Report

interface Reporter {
    fun report(report: Report)
}