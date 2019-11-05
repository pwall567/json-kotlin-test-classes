# json-kotlin-test-classes

Test classes for json-kotlin, json-ktor etc.

These are trivial test classes to aid in the testing of other projects.

It is necessary to place them in a separate repository because of the problem of compilation order - in many cases
there are Java classes that reference Kotlin classes and therefore must be compiled first, and _vice versa_.
This problem is avoided if the data classes are compiled independently.

No-one should imagine there is any great profundity in these classes; this repository is not intended to be useful
outside its original context.

Peter Wall
4 November 2019
