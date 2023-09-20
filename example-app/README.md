# Example

This is an example of a JS module consuming the JS package generated from Kotlin multi-platform.

To run it:

1. Build the Kotlin package to generate the npm package `./gradlew jsNodeRun`. This creates a package in the build folder that is ready to install from a JS project.
1. Do `yarn install` or `npm install`.
1. Run `yarn start` or `npm start`.
