package com.targetindia.programs;

import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> nums = new TreeSet<>();// new HashSet(); // new LinkedHashSet();
        nums.add(123);
        nums.add(22);
        nums.add(4585);
        nums.add(22);
        nums.add(45);
        nums.add(22);
        nums.add(22);
        nums.add(566);
        System.out.println(nums);

        Set<String> names = new TreeSet<>();
        names.add("Vinod");
        names.add("Kishore");
        names.add("Harish");
        names.add("Kiran");
        names.add("Harish");
        names.add("Kiran");
        names.add("Kiran");
        names.add("Vinod");
        names.add("Vinod");
        names.add("Vinod");
        names.add("Surya");
        names.add("Harish");
        names.add("Suhas");
        System.out.println(names);
    }
}
