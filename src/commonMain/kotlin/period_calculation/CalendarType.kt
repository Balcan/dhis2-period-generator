package period_calculation


import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@ExperimentalJsExport
@JsExport
sealed class CalendarType(open val name: String) {
    data class Gregorian(override val name:String="gregorian") : CalendarType(name)
    data class Ethiopian(override val name:String="gregorian") : CalendarType(name)
    data class Nepali(override val name:String="gregorian") : CalendarType(name)
}
