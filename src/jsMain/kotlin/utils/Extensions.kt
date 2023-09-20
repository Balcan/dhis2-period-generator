package utils

import kotlinx.datetime.LocalDate

actual fun LocalDate.isoFormat():String {
    return "$year${monthNumber.toString().padStart(2,'0')}${dayOfMonth.toString().padStart(2,'0')}"
}