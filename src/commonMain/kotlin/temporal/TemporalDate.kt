package temporal

import calendar.EthiopianCalendar
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.daysUntil
import kotlinx.datetime.plus
import period_calculation.FixedPeriod
import kotlin.js.ExperimentalJsExport

sealed class TemporalDate(val year: Int, val month: Int, val day: Int) {

    fun id() =
        "${year}${month.toString().padStart(2,'0')}${day.toString().padStart(2,'0')}"

    @OptIn(ExperimentalJsExport::class)
    fun toFixedPeriod() = FixedPeriod(
        id(),
        iso = id(),
        name = name(),
        startDate = toString(),
        endDate = toString()
    )
    abstract fun daysBetween(other:TemporalDate):Int
    abstract fun addDay():TemporalDate

    abstract fun name():String
    data class GregorianDate(
        private val gYear: Int,
        private val gMonth: Int,
        private val gDay: Int
    ) : TemporalDate(gYear, gMonth, gDay) {
        override fun daysBetween(other: TemporalDate): Int {
            val startDate = LocalDate(gYear, gMonth, gDay)
            val endDate = LocalDate(other.year, other.month, other.day)
            return startDate.daysUntil(endDate)
        }

        override fun addDay(): GregorianDate {
            val date = LocalDate(gYear, gMonth, gDay).plus(1,DateTimeUnit.DAY)
            return copy(gYear = date.year, gMonth = date.monthNumber, gDay = date.dayOfMonth)
        }

        override fun name(): String {
            return "$year/$month/$day"
        }
    }

    data class EthiopianDate(
        private val eYear: Int,
        private val eMonth: Int,
        private val eDay: Int
    ) : TemporalDate(eYear, eMonth, eDay){
        override fun daysBetween(other: TemporalDate): Int {
            var date = this
            var countDate = 0
            while (date != other) {
                date = date.addDay()
                countDate++
            }

            return countDate
        }

        override fun addDay(): EthiopianDate {
            val maxDayInMonth = EthiopianCalendar.monthDays(year, month)
            return when {
                day + 1 <= maxDayInMonth -> copy(eDay = day + 1)
                month + 1 <= EthiopianCalendar.monthsInYear -> copy(eMonth = month + 1, eDay = 1)
                else -> copy(eYear = year + 1, eMonth = 1, eDay = 1)
            }
        }

        override fun name(): String {
            return "${EthiopianCalendar.monthNames[month-1]}, $day, $year"
        }
    }

}