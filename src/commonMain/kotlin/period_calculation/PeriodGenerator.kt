package period_calculation

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@ExperimentalJsExport
@JsExport
class PeriodGenerator {
    private val dailyPeriodGenerator by lazy { DailyPeriodGenerator() }
    fun generatePeriod(year: Int, periodType: PeriodType) =
        when (periodType) {
            PeriodType.DAILY -> {
                dailyPeriodGenerator.getDailyPeriods(year, "")
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