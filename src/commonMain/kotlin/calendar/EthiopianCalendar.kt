package calendar

object EthiopianCalendar {

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

    fun isLeapYear(year: Int): Boolean {
        return year % 4 == 0
    }

}