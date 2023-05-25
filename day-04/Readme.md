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

## Loggin in Java
