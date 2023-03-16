- Make sure all tests are fully automatic and that they check their own results
- A suite of tests is a powerful bug detector that decapitates the time it takes to find bugs

## JUnit Testing Framework
- Any class that contains tests must subclass the test-case class from the testing framework
- The framework uses the composite pattern that allows you to group tests into suites
- When you get a bug report, start by writting a unit test that exposes the bug

## Adding More Tests
- Look at all the things class should do and test each one of them for any conditions that<br>
  might cause the class to fail
- It is better to write and run incomplete tests than not to run complete tests
- Think of the boundary conditions under which things might go wrong and concentrate your tests there
- When write test, try actively thinking about how can we break it. This state of mind to be both <br>
  productive and fun
- Don't forget to test that exceptions are raised when things are expected to go wrong
- Writting tests help to think about error conditions and boundary conditions
- Don't let the fear that testing can't catch all bugs stop you from writting the tests that will <br>
  catch most bugs