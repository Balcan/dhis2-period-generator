# Multi-Platform Period Generator

## Why?

DRY.

Right now, we have Period generation logic scattered in different layers of DHIS2 stack, i.e. the FrontEnd has an implimentation in JavaScript, the Backend has an implementation in Java, and the mobile app has implementation in Kotlin.

Even across a single layer, there are multiple implementations. We are trying to consolidate these in FE libraries (like analytics and multi-calendar-dates), and by rethinking and refactoring the date and periods' handling in the API.

With Kotlin Multi-Platform, we can go a step further to consolidate these differences across all DHIS2 layers.

This is also important to ensure that some concepts that are crucial in DHIS2 such as Period IDs are consistent across the board. It becomes even more crucial in the context of supporting multiple calendrical systems, especially with non-deterministic calendars like lunar calendars, where there is a higher chance of one implementation differing from another one.

## Integration Examples

- JavaScript integration example: https://github.com/dhis2/multi-calendar-dates/pull/26
