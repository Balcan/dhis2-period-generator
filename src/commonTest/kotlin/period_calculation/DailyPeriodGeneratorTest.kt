package period_calculation

import calendar.EthiopianDateConverter
import calendar.NepaliDateConverter
import temporal.TemporalDate
import kotlin.js.ExperimentalJsExport
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalJsExport::class)
class DailyPeriodGeneratorTest {
    private val generator = PeriodGenerator()

    @Test
    fun shouldReturnGregorianDailyPeriod() {
        val periodOptions = PeriodOptions(
            year = 2020,
            periodType = PeriodType.DAILY,
            calendar = CalendarType.Gregorian()
        )
        val result = generator.generatePeriod(periodOptions)

        assertTrue(result.size == 366)
        assertTrue(result.first().id == "20200101")
        assertTrue(result.last().id == "20201231")
        assertTrue(result.find { it.id == "20200229" } != null)

    }

    @Test
    fun shouldReturnEthiopianDailyPeriod() {
        val periodOptions = PeriodOptions(
            year = 2015,
            periodType = PeriodType.DAILY,
            calendar = CalendarType.Ethiopian()
        )
        val result = generator.generatePeriod(periodOptions)

        assertTrue(result.size == 365)
        assertTrue(result.first().id == "20150101")
        assertTrue(result.last().id == "20151305")
    }

    @Test
    fun shouldReturnNepaliDailyPeriod() {
        val periodOptions = PeriodOptions(
            year = 2015,
            periodType = PeriodType.DAILY,
            calendar = CalendarType.Nepali()
        )
        val result = generator.generatePeriod(periodOptions)

        assertTrue(result.size == 365)
        assertTrue(result.first().id == "20150101")
        assertTrue(result.last().id == "20151230")
    }

    @Test
    fun ethiopianToGregorianConverter() {
        val results = listOf(
            EthiopianDateConverter.toGregorianDate(TemporalDate.EthiopianDate(2015, 1, 1)),
            EthiopianDateConverter.toGregorianDate(TemporalDate.EthiopianDate(2006, 5, 17)),
            EthiopianDateConverter.toGregorianDate(TemporalDate.EthiopianDate(2078, 11, 29)),
            EthiopianDateConverter.toGregorianDate(TemporalDate.EthiopianDate(2001, 13, 4)),
        )

        val expected = listOf(
            TemporalDate.GregorianDate(2022, 9, 11),
            TemporalDate.GregorianDate(2014, 1, 25),
            TemporalDate.GregorianDate(2086, 8, 5),
            TemporalDate.GregorianDate(2009, 9, 9),
        )

        assertEquals(results, expected)
    }

    @Test
    fun gregorianToEthiopianConverter() {

        val results = listOf(
            EthiopianDateConverter.toEthiopianDate(TemporalDate.GregorianDate(2022, 9, 11)),
            EthiopianDateConverter.toEthiopianDate(TemporalDate.GregorianDate(2014, 1, 25)),
            EthiopianDateConverter.toEthiopianDate(TemporalDate.GregorianDate(2086, 8, 5)),
            EthiopianDateConverter.toEthiopianDate(TemporalDate.GregorianDate(2009, 9, 9)),
        )

        val expected = listOf(
            TemporalDate.EthiopianDate(2015, 1, 1),
            TemporalDate.EthiopianDate(2006, 5, 17),
            TemporalDate.EthiopianDate(2078, 11, 29),
            TemporalDate.EthiopianDate(2001, 13, 4),
        )

        assertEquals(results, expected)
    }

    @Test
    fun nepaliToGregorianConverter() {

        val results = listOf(
            NepaliDateConverter.toGregorianDate(TemporalDate.NepaliDate(2079, 5, 26)),
            NepaliDateConverter.toGregorianDate(TemporalDate.NepaliDate(2070, 10, 11)),
            NepaliDateConverter.toGregorianDate(TemporalDate.NepaliDate(2080, 4, 20)),
            NepaliDateConverter.toGregorianDate(TemporalDate.NepaliDate(2066, 5, 24)),
        )

        val expected = listOf(
            TemporalDate.GregorianDate(2022, 9, 11),
            TemporalDate.GregorianDate(2014, 1, 25),
            TemporalDate.GregorianDate(2023, 8, 5),
            TemporalDate.GregorianDate(2009, 9, 9),
        )

        assertEquals(expected, results)
    }

    @Test
    fun gregorianToNepaliConverter() {

        val results = listOf(
            NepaliDateConverter.toNepaliDate(TemporalDate.GregorianDate(2022, 9, 11)),
            NepaliDateConverter.toNepaliDate(TemporalDate.GregorianDate(2014, 1, 25)),
            NepaliDateConverter.toNepaliDate(TemporalDate.GregorianDate(2023, 8, 5)),
            NepaliDateConverter.toNepaliDate(TemporalDate.GregorianDate(2009, 9, 9)),
        )

        val expected = listOf(
            TemporalDate.NepaliDate(2079, 5, 26),
            TemporalDate.NepaliDate(2070, 10, 11),
            TemporalDate.NepaliDate(2080, 4, 20),
            TemporalDate.NepaliDate(2066, 5, 24),
        )

        assertEquals(expected, results)
    }
}