package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArraysDemo {
    static int[] nums;
    static int num;

    static int[] a, b, c; // all of a, b and c are array references
    static int x, y, z[]; // x and y are int, z is an array reference

    public static void main(String[] args) {
        log.trace("nums contains {}", nums);
        log.trace("num contains {}", num);

        log.trace("a, b, c are {}, {}, {}", a, b, c);
        log.trace("x, y, z are {}, {}, {}", x, y, z);

        int[] numArray1 = {19, 20, 30, 50, 60};
        log.trace("numArray1 = {}", numArray1);

        int[] numArray2 = new int[5]; // 5 integers in the heap, heap is always zero filled
        numArray2[0] = 200;
        numArray2[4] = 293;
        log.trace("numArray2 = {}", numArray2);

        int[] numArray3;
        numArray3 = new int[]{19, 0, 0, 0, 384, 289, 49, 44};

        log.trace("length of numArray1, numArray2, and numArray3 are {}, {}, {} respectively",
                numArray1.length, numArray2.length, numArray3.length);
    }
}
