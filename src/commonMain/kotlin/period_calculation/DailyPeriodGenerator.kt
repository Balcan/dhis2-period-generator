package period_calculation

import kotlinx.datetime.*
import utils.isoFormat
import kotlin.js.ExperimentalJsExport

@OptIn(ExperimentalJsExport::class)
class DailyPeriodGenerator {
    fun getDailyPeriods(
        year: Int,
        calendar: String
    ): List<FixedPeriod> {
        val date = LocalDate(year, Month.JANUARY, 1)
        val endDate = LocalDate(year, Month.DECEMBER, 31)

        val days = mutableListOf<FixedPeriod>()
        for (day in 0..<date.daysUntil(endDate)) {
            val nextDay = date.plus(day, DateTimeUnit.DAY)
            val value = nextDay.isoFormat()
            days.add(
                FixedPeriod(
                    id = value,
                    iso = value,
                    name = nextDay.toString(),
                    startDate = nextDay.toString(),
                    endDate = nextDay.toString()
                )
            )
        }
        return days
    }
}