package period_calculation

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@ExperimentalJsExport
@JsExport
enum class PeriodType {
    DAILY,
    WEEKLY,
    WEEKLYWED,
    WEEKLYTHU,
    WEEKLYSAT,
    WEEKLYSUN,
    BIWEEKLY,
    MONTHLY,
    BIMONTHLY,
    QUARTERLY,
    QUARTERLYNOV, // used in Ethiopia
    SIXMONTHLY,
    SIXMONTHLYAPR,
    SIXMONTHLYNOV, // used in Ethiopia
    YEARLY,
    FYNOV,
    FYOCT,
    FYJUL,
    FYAPR,
}