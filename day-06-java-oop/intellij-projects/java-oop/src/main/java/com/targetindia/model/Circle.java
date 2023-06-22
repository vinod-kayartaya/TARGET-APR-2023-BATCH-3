package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        // for an object, constructor is called only once, and hence this is not a problem.
        // if you call the constructor (using new) another time, it is a different object
        this.radius = radius;
    }

//    the field "radius" is final, and hence cannot be changed using a setter.
//    public void setRadius(double radius){
//        this.radius = radius;
//    }
    @Override
    public String shapeName() { // hides the visibility of the superclass method
        return "Circle";
    }


    @Override
    public double getArea() {
        final double PI = 3.14159265358979323846;
        return PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
