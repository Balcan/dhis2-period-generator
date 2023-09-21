package period_calculation

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.js.JsName

@ExperimentalJsExport
@JsExport
class PeriodGenerator {
    private val dailyPeriodGenerator by lazy { DailyPeriodGenerator() }
    @JsName("generatePeriod")
    fun generatePeriod(periodOptions: PeriodOptions): Array<FixedPeriod> {
        val periodType = periodOptions.periodType
        val year = periodOptions.year
        val calendar = periodOptions.calendar

        return when (periodType) {
            PeriodType.DAILY -> {
                dailyPeriodGenerator.getDailyPeriods(year, calendar)
            }

            PeriodType.WEEKLY,
            PeriodType.WEEKLYWED,
            PeriodType.WEEKLYTHU,
            PeriodType.WEEKLYSAT,
            PeriodType.WEEKLYSUN,
            PeriodType.BIWEEKLY -> {
                emptyList()
            }

            PeriodType.MONTHLY,
            PeriodType.BIMONTHLY,
            PeriodType.QUARTERLY,
            PeriodType.QUARTERLYNOV,
            PeriodType.SIXMONTHLY,
            PeriodType.SIXMONTHLYAPR,
            PeriodType.SIXMONTHLYNOV -> {
                emptyList()
            }

            PeriodType.YEARLY,
            PeriodType.FYNOV,
            PeriodType.FYOCT,
            PeriodType.FYJUL,
            PeriodType.FYAPR -> {
                emptyList()
            }
        }.toTypedArray()
    }
}