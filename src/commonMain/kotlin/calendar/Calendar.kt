package calendar

import temporal.TemporalDate
import kotlin.js.ExperimentalJsExport

@OptIn(ExperimentalJsExport::class)
interface Calendar<T : TemporalDate> {

    fun toGregorianDate(localDate: T): TemporalDate.GregorianDate

    fun daysBetween(from: T, to: T): Int
    fun addDay(localDate: T): T

    fun isLeapYear(year: Int): Boolean = false

    fun dailyPeriods(year:Int): List<T>

}