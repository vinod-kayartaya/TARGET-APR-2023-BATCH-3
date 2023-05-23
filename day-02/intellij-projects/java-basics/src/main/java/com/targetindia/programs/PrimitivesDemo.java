package com.targetindia.programs;

public class PrimitivesDemo {

    static void bar(){
        int x = 123;
        foo();
    }
    static void foo(){
        double f = 1.2;
        // System.out.printf("num = %d%n", num);
    }
    public static void main(String[] args) {
        int num = 2099;

        foo();
        System.out.printf("num = %d%n", num);
        bar();
    }
}
