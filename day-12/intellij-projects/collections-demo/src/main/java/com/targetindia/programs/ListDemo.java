package com.targetindia.programs;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List data = new ArrayList();
        data.add("Vinod");
        data.add(new Date());
        data.add(false);
        data.add(49);
        data.add(5.8);

        System.out.println(data);

        List<String> names = new Stack<>(); // new ArrayList(); // new Vector(); // new LinkedList();
        names.add("Vinod");
        names.add("Kishore");
        names.add("Kiran");
        names.add("Surya");

        names.add(0, "Anil");
        names.add(names.size(), "Sita"); // no need to do like this, just call .add()
        names.add(names.size(), "Amar");
        names.add(names.size(), "Ramesh");
        names.add("Harish");
        names.add("Suhas");

        names.set(1, "Vinod Kumar");

        String searchName = "Amar";
        if (names.contains(searchName)) {
            int index = names.indexOf(searchName);
            names.set(index, searchName + " Rao");
        }

        searchName = "Sita";
        int index = names.indexOf(searchName);
        if (index != -1) {
            names.set(index, searchName + " Kumari");
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
