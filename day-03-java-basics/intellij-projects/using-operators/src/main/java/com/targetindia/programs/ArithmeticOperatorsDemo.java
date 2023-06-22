package com.targetindia.programs;

public class ArithmeticOperatorsDemo {

    public static void main(String[] args) {
        int n1 = 234;
        int n2 = 221;

        System.out.printf("%d + %d = %d%n", n1, n2, n1 + n2);
        System.out.printf("%d - %d = %d%n", n1, n2, n1 - n2);
        System.out.printf("%d * %d = %d%n", n1, n2, n1 * n2);
        System.out.printf("%d / %d = %d%n", n1, n2, n1 / n2);
        System.out.printf("%d %% %d = %d%n", n1, n2, n1 % n2);

        FunctionDemo.welcome();

        FunctionDemo fd = new FunctionDemo();
        fd.hello();
    }
}
