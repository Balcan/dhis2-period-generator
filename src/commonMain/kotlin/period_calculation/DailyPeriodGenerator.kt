package period_calculation

import calendar.EthiopianCalendar
import calendar.NepaliCalendar
import temporal.TemporalDate
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.js.JsName

@OptIn(ExperimentalJsExport::class)
class DailyPeriodGenerator {
    @JsName("generateDailyPeriod")
    fun getDailyPeriods(
        year: Int,
        calendar: CalendarType
    ): List<FixedPeriod> {
        val (date: TemporalDate, endDate: TemporalDate) = when(calendar)  {
            is CalendarType.Ethiopian -> {
                Pair(
                    TemporalDate.EthiopianDate(year, 1, 1),
                    TemporalDate.EthiopianDate(year, 13, EthiopianCalendar.monthDays(year, 13))
                )
            }

            is CalendarType.Nepali -> {
                val lastMonth = NepaliCalendar.monthsInYear(year)
                val lastMonthDay = NepaliCalendar.monthDays(year, lastMonth-1)
                Pair(
                    TemporalDate.NepaliDate(year, 1, 1),
                    TemporalDate.NepaliDate(year, lastMonth, lastMonthDay)
                )
            }

            else -> {
                Pair(
                    TemporalDate.GregorianDate(year, 1, 1),
                    TemporalDate.GregorianDate(year, 12, 31)
                )
            }
        }

        val days = mutableListOf(date.toFixedPeriod())
        var nextDay: TemporalDate = date
        for (day in 0..<date.daysBetween(endDate)) {
            nextDay = nextDay.addDay()
            days.add(nextDay.toFixedPeriod())
        }
        return days
    }
}