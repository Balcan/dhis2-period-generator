package utils

import kotlinx.datetime.LocalDate

actual fun LocalDate.isoFormat(): String {
    return "%d%02d%02d".format(year, monthNumber, dayOfMonth)
}