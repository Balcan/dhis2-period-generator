package calendar

import temporal.TemporalDate

/**
 * todo simplify converters
 */

/**
 * convert nepali date into english date
 *
 * @param nepYY `int` year of nepali date [1970-2090]
 * @param nepMM `int` month of nepali date [1-12]
 * @param nepDD `int` day of a nepali date [1-32]
 * @return [Calendar] object with the converted value from nepali to english
 */

object NepaliDateConverter {
    internal fun toGregorianDate(
        nepaliDate: TemporalDate.NepaliDate,
    ): TemporalDate.GregorianDate {
        val nepYY = nepaliDate.year
        val nepMM = nepaliDate.month
        val nepDD = nepaliDate.day

        val startingEngYear = 1913
        val startingEngMonth = 4
        val startingEngDay = 13
        val startingDayOfWeek = 1 // 1970/1/1 is Sunday /// based on www.ashesh.com.np/neplai-date-converter
        val startingNepYear = 1970
        val startingNepMonth = 1
        val startingNepDay = 1
        var engMM: Int
        var engDD: Int
        var totalNepDaysCount: Long = 0

        //*count total no of days in nepali year from our starting range*//
        for (i in startingNepYear..<nepYY) {
            for (j in 1..12) {
                totalNepDaysCount += NepaliCalendar.monthDays(i, j)
            }
        }
        /*count total days in terms of month*/
        for (j in startingNepMonth..<nepMM) {
            totalNepDaysCount += NepaliCalendar.monthDays(nepYY, j)
        }
        /*count total days in terms of date*/
        totalNepDaysCount += (nepDD - startingNepDay - 7).toLong()
        val daysInMonth = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val daysInMonthOfLeapYear = intArrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        var engYY: Int = startingEngYear
        engMM = startingEngMonth
        engDD = startingEngDay
        var endDayOfMonth: Int
        var dayOfWeek = startingDayOfWeek
        var engDate = TemporalDate.GregorianDate(startingEngYear, startingEngMonth, startingEngDay)
        while (totalNepDaysCount != 0L) {
            engDate = GregorianCalendar.addDay(engDate)
            totalNepDaysCount--
        }
        return engDate
    }


    /**
     * convert english date into nepali date
     *
     * @param engYY `int` year of nepali date [1944-2033]
     * @param engMM `int` month of nepali date [1-12]
     * @param engDD `int` day of a nepali date [1-31]
     * @return return nepali date as a [NepaliDate] object converted from english to nepali
     */
    internal fun toNepaliDate(
        gregorianDate: TemporalDate.GregorianDate
    ): TemporalDate.NepaliDate {
        val engYY = gregorianDate.year
        val engMM = gregorianDate.month
        val engDD = gregorianDate.day

        val startingEngYear = 1913
        val startingEngMonth = 4
        val startingEngDay = 13
        val startingDayOfWeek = 1 // 1913/4/13 is a Sunday
        val startingNepYear = 1970
        val startingNepMonth = 1
        val startingNepDay = 1
        var dayOfWeek = startingDayOfWeek


        /*calculate the days between two english date*/
        val base =
            TemporalDate.GregorianDate(startingEngYear, startingEngMonth, startingEngDay) // June 20th, 2010
        val newDate = TemporalDate.GregorianDate(engYY, engMM, engDD) // July 24th
        var totalEngDaysCount = GregorianCalendar.daysBetween(base, newDate) + 7
        var nepDate = TemporalDate.NepaliDate(startingNepYear, startingNepMonth, startingNepDay)
        while (totalEngDaysCount != 0) {
            nepDate = NepaliCalendar.addDay(nepDate)
            totalEngDaysCount--
        }
        return nepDate.copy(eDay = nepDate.day)
    }
}
private fun isEngLeapYear(year: Int): Boolean {
    return GregorianCalendar.isLeapYear(year)
}