import {PeriodGenerator, PeriodType, CalendarType} from "dhis2-period-generator";

const result = new PeriodGenerator().generatePeriod({
    year: 2022,
    periodType: PeriodType.DAILY,
    calendar: new CalendarType.Ethiopian()
})[0]

console.log(result)
