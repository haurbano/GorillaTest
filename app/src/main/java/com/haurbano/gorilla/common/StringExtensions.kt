package com.haurbano.gorilla.common

import android.content.Context
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*


fun String.timeStampToDisplayDate(context: Context): String {
    return try {
        val dateString: String = DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(this.toLong()))
        val date: Instant = Instant.parse(dateString)
        return date.formatted()
    } catch (e: Exception) {
        "Invalid date"
    }
}