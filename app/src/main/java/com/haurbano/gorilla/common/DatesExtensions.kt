package com.haurbano.gorilla.common

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

fun Instant.formatted(): String {
    return try {
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
            .withLocale(Locale.US)
            .withZone(ZoneId.systemDefault())
        return formatter.format(this)
    } catch (e: Exception) {
        "Invalid date"
    }
}