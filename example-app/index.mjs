import {PeriodGenerator, PeriodType, CalendarType} from "dhis2-period-generator";

const gregorianResult = new PeriodGenerator().generatePeriod({
    year: 2022,
    periodType: PeriodType.DAILY,
    calendar: new CalendarType.Gregorian()
})[0]

const ethiopianResult = new PeriodGenerator().generatePeriod({
    year: 2015,
    periodType: PeriodType.DAILY,
    calendar: new CalendarType.Ethiopian()
})[0]

console.log(gregorianResult)
console.log(ethiopianResult)
