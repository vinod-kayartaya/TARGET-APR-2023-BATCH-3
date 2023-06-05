package com.targetindia.programs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {

    public static void main(String[] args) {
        Collection<String> names = Arrays.asList("Vinod", "Shyam", "Harish", "Nagesh");

        // Collection IS-A Iterable (because of inheritance), and Iterable can produce an Iterator
        Iterator<String> it = names.iterator();
        while(it.hasNext()){
            String name = it.next();
            System.out.println(name);
        }

        System.out.println();

        // using the enhanced for loop (for-each loop)
        for(String name: names){
            System.out.println(name);
        }

        System.out.printf("There are %d names%n", names.size());
    }
}
