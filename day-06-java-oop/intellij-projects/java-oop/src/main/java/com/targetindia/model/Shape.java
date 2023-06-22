package com.targetindia.model;

public abstract class Shape {
    public final String authorInfo(){
        return "Vinod Kumar Kayartaya (vinod@vinod.co)";
    }

    public abstract String shapeName();

    public abstract double getArea();
}
