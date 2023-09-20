package period_calculation

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@ExperimentalJsExport
@JsExport
data class FixedPeriod(
    val id: String,
    val iso: String,
    val name: String,
    val startDate: String,
    val endDate: String
)
