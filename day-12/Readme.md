# Functional programming in Java

- allows a function to be passed as argument to another function
- a method can return a function as a return value
- For this to be possible in Java, we may have to keep that function in an interface as the only abstract method in that interface
  - such an interface (with exactly 1 abstract method) is called as a Functional interface
  - may optionally be marked with @FunctionalInterface
- a variable of functional interface can be assigned with a function (in the form of an arrow function a.k.a lambda expression), which is the implementation of the only abstract method in that interface

For example, `java.util.Comparator` has exactly one abstract method `public int compare(T t1, T t2)`. A variable of this interface, say `cmp` can be assigned with an arrow function, instead of an anonymous object

Using anonymous object:

```java
    Comparator<Person> cmp = new Comparator<Person>(){
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };
```

Using arrow function:

```java
    // step 1: anonymous object
    Comparator<Person> cmp = new Comparator<Person>(){
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };
    // step 2: remove the class definition and keep only the function
    // the function does not have the access modifier, return type, and the name.
    // add an arrow between the parameter list and the body
    Comparator<Person> cmp = (Person p1, Person p2) -> {
        return p1.getName().compareTo(p2.getName());
    };

    // step 3: remove the data types for the parameters (as they are optional)
    Comparator<Person> cmp = (p1, p2) -> {
        return p1.getName().compareTo(p2.getName());
    };

    // step 4: if the body of the arrow function has only one statement, then remove the curly braces, and the return keyword
    Comparator<Person> cmp = (p1, p2) -> p1.getName().compareTo(p2.getName());

    // since this is a simple expression, we can use it directly where it is required
    // for example,
    Set<Person> persons = new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));
```
