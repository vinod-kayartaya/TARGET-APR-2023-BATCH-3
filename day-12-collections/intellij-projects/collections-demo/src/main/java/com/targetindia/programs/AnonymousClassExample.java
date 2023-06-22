package com.targetindia.programs;

import com.targetindia.entity.Circle;
import com.targetindia.entity.Shape;

public class AnonymousClassExample {

    static void processShape(Shape shape){
        System.out.printf("Area of %s is %.2f sq.units%n", shape.getShapeName(), shape.getShapreArea());
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(2.4);

        processShape(c1);
        processShape(new Circle(2.2));
        processShape(new Shape(){
            @Override
            public String getShapeName() {
                return "square with a side of 5.5 units";
            }

            @Override
            public double getShapreArea() {
                return 5.5*5.5;
            }
        }); // new Shape(){} is object of an anonymous class that derives from Shape

    }
}
