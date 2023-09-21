package period_calculation

import calendar.EthiopianCalendar
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