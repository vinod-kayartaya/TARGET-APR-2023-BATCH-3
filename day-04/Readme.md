# `for loop` and logging

### `for` loop

- use this when you know the number of iterations
- this is like the while loop, except the `for` loop header has everything the loop definition needs

Syntax:

```java
for(expr1; expr2; expr3){
    statement1;
    statement2;
    //...
    statementN;
}
```

- `expr1` is supposed to be a variable declaration and initialization (loop variable)
  - the loop variable is accessible only inside the loop
- `expr2` is expected to be a `boolean` expression
  - cannot use `zero` and `non-zero` for false and true (like in C or C++)
- the loop body is executed only if the expr2 evaluates to true
- after the loop body is executed, then the expr3 is executed, which typically is the loop variable controller (increments or decrements the loop variable)
- after the execution of `expr3`, `expr2` is evaluated again, and if it results in `true`, then the loop body is executed.
- this process is repeated, until expr2 results in `false`

For example,

```java
for(int i=0; i<5; i++){
    Systm.out.println("value of i is " +i);
}
```

The output of the above:

```
value of i is 0
value of i is 1
value of i is 2
value of i is 3
value of i is 4
```

## Logging in Java

- recording of information during the execution of an application
  - intermediary values of variables
  - debug messages
  - information about the client (browser agent, location, timezone, etc.)
- these can be of great use for analytical purposes
  - which is what is done using big data processing (read about Hadoop)

### different APIs for Java

1. log4j
1. logback
1. java util logging (JUL) (only in JDK 1.4+)

We can use a common API called SLF4J (Simple Logging Facade for Java), that can make use of the above logging API. This API provides methods to log, but the actual logging is done by the underlying logging API (such as log4j)

Most of the logging APIs provide different log levels, which indicate the severity of the messages being logged.

SLF4j provides a common interface for these levels and maps them to the underlying implementation's log levels.

- TRACE
  - most detailed log level. used for very fine grained messages.
  - method entry/exit, variable values, loop progress, copying values from one variable to another
  - mostly used for debug during development
- DEBUG
  - additional details about application's internal workings
  - state changes, information useful for diagnosing issues during development and troubleshooting
- INFO
  - informational messages
  - may highlight the progress or major milestones of applications
  - may be used for communicating important events during the execution of the program to the administrators or users
- WARN
  - some potential problems, or an unexpected error during the runtime of the application, but non-fatal (mostly handled)
- ERROR
  - severe errors that occurred during runtime, but could not be handled
- OFF
  - no log messages