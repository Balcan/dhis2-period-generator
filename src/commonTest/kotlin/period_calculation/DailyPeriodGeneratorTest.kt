package period_calculation

import kotlin.js.ExperimentalJsExport
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalJsExport::class)
class DailyPeriodGeneratorTest{
    val generator = PeriodGenerator()
    @Test
    fun shouldReturnGregorianDailyPeriod(){
        val periodOptions = PeriodOptions(
            year = 2020,
            periodType = PeriodType.DAILY,
            calendar = CalendarType.Gregorian()
        )
        val result = generator.generatePeriod(periodOptions)

        assertTrue(result.size == 366)
        assertTrue(result.first().id == "20200101")
        assertTrue(result.last().id == "20201231")
        assertTrue(result.find { it.id == "20200229"}!=null)

    }

    @Test
    fun shouldReturnEthiopianDailyPeriod(){
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
}