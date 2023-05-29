package com.targetindia.model;

public class Test {
    public static int num;
    public static final int number;

    static {
        num = 123;
        number = 90909;
    }

    public Test() {
        num = 1000;
        // number = 123456;
    }

    public Test(int n) {
        num = n;
    }

}
