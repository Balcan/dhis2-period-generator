package calendar

object NepaliCalendar {

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

    fun monthDays(year: Int, monthIndex: Int) = NEPALI_CALENDAR_DATA[year]?.let {yearInfo->
        yearInfo[monthIndex]
    } ?: 0

}