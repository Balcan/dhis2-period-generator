package calendar

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.daysUntil
import kotlinx.datetime.plus
import temporal.TemporalDate

object GregorianCalendar : Calendar<TemporalDate.GregorianDate> {
    override fun toGregorianDate(localDate: TemporalDate.GregorianDate) = localDate

    override fun addDay(localDate: TemporalDate.GregorianDate): TemporalDate.GregorianDate {
        val date = LocalDate(localDate.year, localDate.month, localDate.day).plus(1, DateTimeUnit.DAY)
        return localDate.copy(gYear = date.year, gMonth = date.monthNumber, gDay = date.dayOfMonth)
    }

    override fun daysBetween(from: TemporalDate.GregorianDate, to: TemporalDate.GregorianDate): Int {
        val startDate = LocalDate(from.year, from.month, from.day)
        val endDate = LocalDate(to.year, to.month, to.day)
        return startDate.daysUntil(endDate)
    }

    override fun dailyPeriods(year: Int): List<TemporalDate.GregorianDate> {
        val startDate = TemporalDate.GregorianDate(year, 1, 1)
        val endDate = TemporalDate.GregorianDate(year, 12, 31)

        val days = mutableListOf(startDate)
        var nextDay = startDate

        for (day in 0..<daysBetween(startDate, endDate)) {
            nextDay = addDay(nextDay)
            days.add(nextDay)
        }
        return days
    }


}