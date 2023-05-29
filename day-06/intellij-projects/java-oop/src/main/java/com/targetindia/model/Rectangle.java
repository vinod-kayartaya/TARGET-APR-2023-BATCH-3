package com.targetindia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle extends Shape {
    private double length;
    private double width;

    @Override
    public String shapeName() {
        return "Rectangle";
    }

    @Override
    public double getArea() {
        return length * width;
    }

    public double getRectanglePerimeter(){
        return 2 * length * width;
    }

//    this method in the superclass has been marked as 'final' and cannot be overridden
//    @Override
//    public String authorInfo() {
//        return "John doe (jhondoe@xmpl.com)";
//    }
}
