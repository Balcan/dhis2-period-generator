import {Greetings} from "dhis2-period-generator";
import {PeriodGenerator} from "dhis2-period-generator";
import {PeriodType} from "dhis2-period-generator";

console.log((new Greetings()).greet());
console.log((new PeriodGenerator).generatePeriod(2023,PeriodType.DAILY))
