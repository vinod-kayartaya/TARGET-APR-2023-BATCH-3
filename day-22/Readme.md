# Unit testing in Java

- "unit" of code in the programming world is a "function" or "method"
- "unit testing" is a way of automating the testing of the function
- apart from unit testing there are other types of testing as well
  - performance test
  - load testing
  - quality testing
  - integration testing
  - user acceptance testing
  - and many more
- we know in advance what is the expected result for a given set of inputs
  - but does the function return the expected result or not?

# JUnit

- most popular unit testing framework for Java
  - Cucumber, TestNG and few others are also there
- the current version is 5
  - versions 4 and 5 use annotation based approach
  - version 3 uses coding convention to define test cases
- a class that contains test cases is called as a test suite
  - a function that tests another function is a test case
  - @Test (version 4/5)
  - public void testXyz(){}
- Most of the IDEs are equipped with JUnit plugins that allow you to run/ execute test cases
- However, during development, we generally use the maven lifecycle goal `test` to run the unit tests

# JUnit 5 components

- JUnit 5 platform (interprets the test cases)
- JUnit Jupiter (new annotations)
- JUnit Vintage (support for older JUnit APIs)

# JUnit test suite lifecycle hooks

Methods can be decorated with the following annotations, and they will be automatically called by JUnit platform, depending on their name

- @BeforeEach
  - the method will be called just before a test case method is being executed
- @AfterEach
  - the method will be called just after a test case method is executed
- @BeforeAll
  - must be applied on a static method, and will be called when the class is loaded, only once
- @AfterAll
  - executed after all the test cases and the lifecycle hooks are finished
