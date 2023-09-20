import {PeriodGenerator, PeriodType} from "dhis2-period-generator";

console.log((new PeriodGenerator()).generatePeriod({
    year: 2022,
    periodType: PeriodType.DAILY
}))
