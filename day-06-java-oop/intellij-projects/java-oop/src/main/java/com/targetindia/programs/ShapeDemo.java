package com.targetindia.programs;

import com.targetindia.model.Circle;
import com.targetindia.model.Rectangle;
import com.targetindia.model.Shape;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShapeDemo {

    // polymorphic method
    static void printShapeDetails(Shape shape){
        log.trace("Shape name = {}", shape.shapeName());
        log.trace("Developed by {}", shape.authorInfo());
        log.trace("Area of this shape is {} sq.units", shape.getArea());
        // log.trace("Perimeter of this shape is {}", shape.getPerimeter()); // error; Shape does not define getPerimeter() method

        // according to the S.O.L.I.D principles the following is a violation
        if(shape instanceof Circle){
            // now let's refer to that object using a reference of Circle
            Circle c1 = (Circle) shape; // down-casting; must be done explicitly
            log.trace("Perimeter of this shape is {}", c1.getPerimeter());
        }
        else if(shape instanceof Rectangle){
            // now let's refer to that object using a reference of Circle
            Rectangle r1 = (Rectangle) shape; // down-casting; must be done explicitly
            log.trace("Perimeter of this shape is {}", r1.getRectanglePerimeter());
        }

        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {

        Shape s1; // just a reference variable
        // s1 = new Shape(); // error - Shape is abstract

        Circle c1 = new Circle(12.34); // instanceof : Circle, Shape, Object

        Rectangle r1 = new Rectangle(); // an instanceof Rectangle, Shape, Object
        r1.setLength(234.55);
        r1.setWidth(653.32);

        printShapeDetails(c1); // c1 will be cast to Shape; up-casting; up-casting is implicitly done
        printShapeDetails(r1); // r1 will be cast to Shape; up-casting; up-casting is implicitly done
    }
}
