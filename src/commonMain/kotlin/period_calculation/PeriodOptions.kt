package period_calculation

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@ExperimentalJsExport
@JsExport
data class PeriodOptions(
    val year: Int,
    val periodType: PeriodType,
    val calendar: CalendarType = CalendarType.GREGORIAN,
    val locale: String = "en",
    val startingDay: Int = 1, // 1 is Monday
    val yearsCount: Int = 10,
    val offset: Int = 0
)
