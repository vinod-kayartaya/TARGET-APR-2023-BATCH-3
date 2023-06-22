# Operators, Control structure

## Operators

- work on operands
- depending on the number of operands, they can be categorised into:
  - arithmetic unary
    - `+ and -`
      - indicate the sign of value
      - for example, `+10` or `-10` or `-n`
    - `++ and --`
      - increment and decrement
      - for example, `n++` (post increment) or `++n` (pre increment)
      - `n--` (post decrement) or `--n` (pre decrement)
      - post and pre matter only if the operation is used in an other expression
  - arithmetic binary
    - `+` for addition
    - `-` for subtraction
    - `*` for multiplication
    - `/` for division
    - `%` for modulus
    - for example, `10+20` or `n%3`
    - `+=` for `increment by`
      - for example,
      ```java
          int n = 12;
          n += 10; // same as `n = n + 10` and makes n as 22
      ```
    - `-=` decrement by
    - `*=` multiplied by
    - `/=` divided by
    - `%=` store the remainder in the LHS
      - for example,
      ```java
          int n = 123;
          n %= 10; // same as n = n%10, which is 3
      ```
  - relational unary
    - `!` to negate the current boolean value
    - for example, if the variable `isMarried` is `true`, then `!isMarried` is `false` and vice versa
  - relational binary
    - `<` or `<=` or `>` or `>=` or `==` or `!=`
    - result of any expression using these operators will always be boolean (i.e, `true` or `false`)
    - `&&` and `||` for combining two conditions together
      - `&&` means both conditions must be true in order for the entire expression to be true
      - `||` means any of the two conditions can be true, if the entire expression needs to be true
  - relational ternary
    - `expr1 ? expr2 : expr3`
    - expr1 must be a boolean
    - expr2 and expr3 depends on the LHS
    - for example, `int result = a>b ? a: b`
      - `a>b` always results in boolean, and in this case `a` and `b` are considered to be `int` because, they are assigned conditionally to `int result`
  - bitwise unary
    - (self study)
  - bitwise binary
    - (self study)

## Program control flow structures

- sequence
  - execution of the lines of code in your program
    - top to bottom
    - left to right
  - can be alter by calling functions/ methods (which is a named group of statements)
  - a static function can only call other static functions of the class
    - a non-static function must be called using an object of the class
    - a static function of a different class can be called by using the class-name as prefix
      - For example, `KeyboardUtil.getString("...");`
    - Java 7 introduced the concept of `static imports`
      - a static member of another class can be imported directly into your class
      - `import static java.lang.Math.*`
      - now, all static members of the class `java.lang.Math` can be used as if they belong to our class
- selection
  - execute a piece of code, based on the result of a condition (criteria)
  - if-else
  - switch-case
- iteration
  - aka loops
  - 3 types:
    - while
      - use this loop, when we do not know the number of iterations
    - do-while
      - use this loop, when we need the statement/s to be executed at lease once, and the termination of the loop is decided during the loop execution
    - for
      - use this loop when we know the number of iterations in advance
      - Java 5 introduced `enhanced for loop` (aka for-each loop)
