package calendar

import temporal.TemporalDate

object NepaliCalendar : Calendar<TemporalDate.NepaliDate> {

    private val initialGregorianYear =
        1943 // The first year of the Bikram Sambat calendar corresponds to 1943 in the Gregorian calendar

    val monthNames = listOf(
        "बैशाख",
        "जेठ",
        "असार",
        "साउन",
        "भदौ",
        "असोज",
        "कार्तिक",
        "मंसिर",
        "पौष",
        "माघ",
        "फागुन",
        "चैत",
    )

    fun monthsInYear(year: Int) = NEPALI_CALENDAR_DATA[year]?.let { yearInfo ->
        yearInfo.size - 1
    } ?: 0

    fun monthDays(year: Int, monthIndex: Int) = NEPALI_CALENDAR_DATA[year]?.let { yearInfo ->
        yearInfo[monthIndex]
    } ?: 0

    override fun toGregorianDate(localDate: TemporalDate.NepaliDate): TemporalDate.GregorianDate {
        return NepaliDateConverter.toGregorianDate(localDate)
    }

    override fun addDay(localDate: TemporalDate.NepaliDate): TemporalDate.NepaliDate {
        val maxDayInMonth = monthDays(localDate.year, localDate.month)
        return when {
            localDate.day + 1 <= maxDayInMonth ->
                localDate.copy(
                    eDay = localDate.day + 1
                )

            localDate.month + 1 <= monthsInYear(localDate.year) ->
                localDate.copy(
                    eMonth = localDate.month + 1,
                    eDay = 1
                )

            else -> localDate.copy(
                eYear = localDate.year + 1,
                eMonth = 1,
                eDay = 1
            )
        }
    }

    override fun daysBetween(from: TemporalDate.NepaliDate, to: TemporalDate.NepaliDate): Int {
        var date = from
        var countDate = 0
        while (date != to) {
            date = addDay(date)
            countDate++
        }

        return countDate
    }

    override fun dailyPeriods(year: Int): List<TemporalDate.NepaliDate> {
        val lastMonth = monthsInYear(year)
        val lastMonthDay = monthDays(year, lastMonth - 1)
        val startDate = TemporalDate.NepaliDate(year, 1, 1)
        val endDate = TemporalDate.NepaliDate(year, lastMonth, lastMonthDay)

        val days = mutableListOf(startDate)
        var nextDay = startDate

        for (day in 0..<daysBetween(startDate, endDate)) {
            nextDay = addDay(nextDay)
            days.add(nextDay)
        }
        return days
    }

}