import {PeriodGenerator, PeriodType} from "dhis2-period-generator";

const result = new PeriodGenerator().generatePeriod({
    year: 2022,
    periodType: PeriodType.DAILY
})[0]

console.log(result)
