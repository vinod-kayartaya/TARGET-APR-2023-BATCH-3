package com.targetindia.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Circle extends Shape {
    private double radius;

    @Override
    public String getShapeName() {
        return "circle with radius of " + this.radius + " units";
    }

    @Override
    public double getShapreArea() {
        return Math.PI * this.radius * this.radius;
    }
}
