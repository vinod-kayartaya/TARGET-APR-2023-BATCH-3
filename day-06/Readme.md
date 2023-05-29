# Java Classes and Objects

## Constructor

- a function like block inside a class
- has the same name as the class
- cannot be invoked using a reference of the class
  ```java
  Person p1 = new Person(); // this is how/when a constructor is invoked
  p1.Person(); // not allowed
  ```
- used for initializing the data members of a class

## Inheritance

- use the keyword `extends` to inherit from another class
- where a class derives from another class (super class or parent class or base class)
- all members of the super class are inherited to the sub class (child class or derived class)
- whether or not the inherited members are accessible using an object depends on the access modifiers used for those members
- only public inherited members are accessible using an object
  - package level members can be accessed only inside the same package
- the private inherited members are not visible even to the members (methods) in the sub class

## The `abstract` keyword

- can be used on a class
  - an object of such a class cannot be created
- can be used on a method
  - the method has no body
  - the declaring class must be declared as abstract as well
  - when a class inherits from an abstract class, all the members including the abstract members become part of your class, which means that even the subclass becomes an abstract class.

## The `final` keyword

- When used on a method:

  - the subclass cannot override this method

- When used on a class:

  - the inheritance hierarchy stops
  - no more subclasses
  - this final class cannot be a superclass for any other classes

- When used on a variable:

  - can be applied on a local or a member variable or static variable
  - value for the variable can be assigned only once
  - doesn't have to be at the time of declaration

  ```java
    public class Test {
        final String name;

        public Test(String name){
            this.name = name;
        }
    }
  ```

## The `static` keyword

- can be applied on a class, a method or a variable (inside a class only, and not for a local variable)
- a static variable:
  - it is not part of the object's heap
  - it is part of the class's memory, created when the class is loaded to the VM, by default with a value of `0` for numbers, `null` for references, `false` for boolean and `'\0'` for char
  - accessed using the name of the class (or using the reference of the class, (not advised))
  ```java
    Math.PI
    Math.E
    System.out
    System.in
    System.err
  ```
  - static variable can also be a final variable. Ensure that the initialization is done either during variable declaration or in a static block (and not in a constructor)
    - if a variable is static and final, then it has to be initialized either with the declaration or in a static block, and NEVER in a constructor
      - you may not call the constructor before the use of static variable
      - you may call the constructor multiple times, which is not allowed for a final variable
