package org.khyzhun.sunshine.utils

import kotlinx.datetime.*

object DateUtils {

    fun getDayOfWeek(date: String): String {
        val (day, month, year) = date.split("-").map { it.toInt() }
        val localDate = LocalDate(year, Month(month), day)
        val dayOfWeek = localDate.dayOfWeek
        return dayOfWeek.name.lowercase().replaceFirstChar {
            if (it.isLowerCase()) it.titlecase() else it.toString()
        }
    }

}