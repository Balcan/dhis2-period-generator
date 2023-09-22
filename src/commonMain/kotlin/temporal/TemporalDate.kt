package temporal

import calendar.EthiopianCalendar
import calendar.NepaliCalendar

sealed class TemporalDate(val year: Int, val month: Int, val day: Int) {

    abstract fun toIso8601(): String

    abstract fun name(): String
    data class GregorianDate(
        private val gYear: Int,
        private val gMonth: Int,
        private val gDay: Int
    ) : TemporalDate(gYear, gMonth, gDay) {


        override fun name(): String {
            return "$year/$month/$day"
        }

        override fun toIso8601(): String {
            return "$year-$month-$day[u-ca=gregorian]"
        }
    }

    data class EthiopianDate(
        private val eYear: Int,
        private val eMonth: Int,
        private val eDay: Int
    ) : TemporalDate(eYear, eMonth, eDay) {

        override fun name(): String {
            return "${EthiopianCalendar.monthNames[month - 1]}, $day, $year"
        }

        override fun toIso8601(): String {
            return EthiopianCalendar.toGregorianDate(this).toIso8601()
        }
    }

    data class NepaliDate(
        private val eYear: Int,
        private val eMonth: Int,
        private val eDay: Int
    ) : TemporalDate(eYear, eMonth, eDay) {

        override fun name(): String {
            return "${NepaliCalendar.monthNames[month - 1]}, $day, $year"
        }

        override fun toIso8601(): String {
            return NepaliCalendar.toGregorianDate(this).toIso8601()
        }
    }
}