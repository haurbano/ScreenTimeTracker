package com.haurbano.stt.extensions

fun Long.toReadableTime(): String{
    val second = this/1000
    if (second < 60) return "$second sg"

    val minutes = second/60
    if (minutes < 60) return "$minutes min"

    val hours = minutes/60
    return "$hours h"
}