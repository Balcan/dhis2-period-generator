package period_calculation

import calendar.EthiopianCalendar
import calendar.GregorianCalendar
import calendar.NepaliCalendar
import temporal.TemporalDate
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsName

@OptIn(ExperimentalJsExport::class)
class DailyPeriodGenerator {
    @JsName("generateDailyPeriod")
    fun getDailyPeriods(
        year: Int,
        calendarType: CalendarType
    ): List<FixedPeriod> {
        val dates: List<TemporalDate> = when (calendarType) {
            is CalendarType.Ethiopian -> EthiopianCalendar.dailyPeriods(year)
            is CalendarType.Nepali -> NepaliCalendar.dailyPeriods(year)
            else -> GregorianCalendar.dailyPeriods(year)
        }

        return dates.map { date ->
            val id = buildId(date)
            val iso = date.toIso8601()
            FixedPeriod(
                id = id,
                iso = id,
                name = date.name(),
                startDate = iso,
                endDate = iso
            )
        }
    }

    private fun buildId(temporalDate: TemporalDate) =
        with(temporalDate) {
            "${year}${month.toString().padStart(2, '0')}${day.toString().padStart(2, '0')}"
        }
}