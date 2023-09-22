package calendar

import temporal.TemporalDate
import temporal.TemporalDate.EthiopianDate

object EthiopianDateConverter {
    private const val JDOFFSET = 1723856
    @Throws(Exception::class)
    fun toEthiopianDate(localDate: TemporalDate.GregorianDate): EthiopianDate {
        val jdn = toJDN(localDate)
        return toEthiopianDate(jdn)
    }

    private fun toJDN(localDate: TemporalDate.GregorianDate): Int {
        val a: Int = (14 - localDate.month) / 12
        val y: Int = localDate.year + 4800 - a
        val m: Int = localDate.month + 12 * a - 3
        return localDate.day + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32045
    }

    @Throws(Exception::class)
    private fun toEthiopianDate(jdn: Int): EthiopianDate {
        //Formula from Dr. Berhanu Beyene and Manfred Kudlek
        val year: Int
        val month: Int
        val day: Int
        val r: Int = (jdn - JDOFFSET) % 1461
        val n: Int = r % 365 + 365 * (r / 1460)
        year = 4 * ((jdn - JDOFFSET) / 1461) + r / 365 - r / 1460
        month = n / 30 + 1
        day = n % 30 + 1
        return EthiopianDate(year, month, day)
    }

    @Throws(Exception::class)
    fun toGregorianDate(year: Int, month: Int, day: Int): TemporalDate.GregorianDate {
        validate(year, month, day)
        val jdn = fromEthiopianDateToJDN(year, month, day)
        return toGregorianDate(jdn)
    }

    @Throws(Exception::class)
    fun toGregorianDate(localDate: EthiopianDate): TemporalDate.GregorianDate {
        val year = localDate.year
        val month = localDate.month
        val day = localDate.day
        validate(year, month, day)
        val jdn = fromEthiopianDateToJDN(year, month, day)
        return toGregorianDate(jdn)
    }

    private fun toGregorianDate(jdn: Int): TemporalDate.GregorianDate {
        var year: Int
        var month: Int
        val day: Int
        var r = jdn + 68569
        val n = 4 * r / 146097
        r -= (146097 * n + 3) / 4
        year = 4000 * (r + 1) / 1461001
        r = r - 1461 * year / 4 + 31
        month = 80 * r / 2447
        day = r - 2447 * month / 80
        r = month / 11
        month = month + 2 - 12 * r
        year += 100 * (n - 49) + r
        return TemporalDate.GregorianDate(year, month, day)
    }

    @Throws(Exception::class)
    private fun validate(year: Int, month: Int, day: Int) {
        if (month < 1 || month > 13 || month == 13 && year % 4 == 3 && day > 6 || month == 13 && year % 4 != 3 && day > 5 || day < 1 || day > 30) {
            throw Exception("Year, Month, and Day parameters describe an un-representable EthiopianDateTime.")
        }
    }

    private fun fromEthiopianDateToJDN(year: Int, month: Int, day: Int): Int {
        return JDOFFSET + 365 + 365 * (year - 1) + year / 4 + 30 * month + day - 31
    }
}