package com.targetindia.programs;

import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
//        Stream.of(109, 29, 48, 90, 22, 485, 38, 18, 374, 575, 662)
//                .forEach(n -> StreamDemo2.printSquare(n));

        Stream.of(109, 29, 48, 90, 22, 485, 38, 18, 374, 575, 662)
                .forEach(StreamDemo2::printSquare);
    }

    static void printSquare(int num){
        System.out.printf("square of %d is %d%n", num, num * num);
    }
}
