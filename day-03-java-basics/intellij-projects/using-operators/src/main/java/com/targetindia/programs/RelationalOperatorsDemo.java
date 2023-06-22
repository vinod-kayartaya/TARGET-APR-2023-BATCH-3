package com.targetindia.programs;

public class RelationalOperatorsDemo {

    public static void main(String[] args) {

        int n1 = 220;
        int n2 = 220;

        System.out.printf("%d < %d is %s%n", n1, n2, n1 < n2);
        System.out.printf("%d > %d is %s%n", n1, n2, n1 > n2);
        System.out.printf("%d <= %d is %s%n", n1, n2, n1 <= n2);
        System.out.printf("%d >= %d is %s%n", n1, n2, n1 >= n2);
        System.out.printf("%d == %d is %s%n", n1, n2, n1 == n2);
        System.out.printf("%d != %d is %s%n", n1, n2, n1 != n2);
        System.out.printf("!(%d != %d) is %s%n", n1, n2, !(n1 != n2));
    }
}
