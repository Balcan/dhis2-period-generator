package calendar

import temporal.TemporalDate

object EthiopianCalendar : Calendar<TemporalDate.EthiopianDate> {

    val monthNames = listOf(
        "መስከረም",
        "ጥቅምት",
        "ኅዳር",
        "ታኅሣሥ",
        "ጥር",
        "የካቲት",
        "መጋቢት",
        "ሚያዝያ",
        "ግንቦት",
        "ሰኔ",
        "ሐምሌ",
        "ነሐሴ",
        "ጳጐሜን/ጳጉሜ",
    )
    val monthsInYear = monthNames.size


    fun monthDays(year: Int, monthIndex: Int) = when {
        (monthIndex in 1..12) -> 30
        isLeapYear(year) -> 6
        else -> 5
    }

    override fun daysBetween(from: TemporalDate.EthiopianDate, to: TemporalDate.EthiopianDate): Int {
        var date = from
        var countDate = 0
        while (date != to) {
            date = addDay(date)
            countDate++
        }

        return countDate
    }

    override fun isLeapYear(year: Int): Boolean {
        return year % 4 == 0
    }

    override fun dailyPeriods(year: Int): List<TemporalDate.EthiopianDate> {
        val startDate = TemporalDate.EthiopianDate(year, 1, 1)
        val endDate = TemporalDate.EthiopianDate(year, 13, monthDays(year, 13))

        val days = mutableListOf(startDate)
        var nextDay = startDate

        for (day in 0..<daysBetween(startDate, endDate)) {
            nextDay = addDay(nextDay)
            days.add(nextDay)
        }
        return days
    }

    override fun toGregorianDate(localDate: TemporalDate.EthiopianDate): TemporalDate.GregorianDate {
        return EthiopianDateConverter.toGregorianDate(localDate)
    }

    override fun addDay(localDate: TemporalDate.EthiopianDate): TemporalDate.EthiopianDate {
        return with(localDate) {
            val maxDayInMonth = monthDays(year, month)
            when {
                day + 1 <= maxDayInMonth -> copy(eDay = day + 1)
                month + 1 <= monthsInYear -> copy(eMonth = month + 1, eDay = 1)
                else -> copy(eYear = year + 1, eMonth = 1, eDay = 1)
            }
        }
    }

}