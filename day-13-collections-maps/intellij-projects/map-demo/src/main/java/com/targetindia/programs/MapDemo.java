package com.targetindia.programs;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.Entry;
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("kayartaya.vinod@gmail.com", "Vinod Kumar K, Bangalore, 9731424784");
        map.put("vinod@vinod.co", "Vinod Kumar K, Bangalore, 9731424784");
        map.put("vinod@vinod.co", "Vinod Kumar K, Bangalore, 9731424784");
        map.put("vinod@vinod.co", "Vinod Kumar K, Bangalore, 9731424784");
        map.put("vinod@knowledgeworksindia.com", "Vinod Kumar K, Bangalore, 9731424784");
        map.put("vinod@vinod.co", "Vinod Kumar Kayartaya, Bengaluru, 9731424784/9844083934");
        map.put("arun@xmpl.com", "Arun Kumar, Mysore");
        System.out.printf("friendsInfo contains %d key/value pairs%n", map.size());

        // since Map is not an Iterable, we have to find other ways to loop over the elements
        // 1. get the keys, and for each key, get the value
        for (String key : map.keySet()) {
            String info = map.get(key);
            System.out.printf("%s --> %s%n", key, info);
        }
        System.out.println("------------------------------------------------------------------------------------");

        // 2. Get all the values alone, and loop over that collection
        for(String info: map.values()){
            System.out.println(info);
        }
        System.out.println("------------------------------------------------------------------------------------");

        // 3. Get the Set of Entry objects (each Entry object has a key and a value)
        for(Entry<String, String> entry: map.entrySet()){
            System.out.printf("%s --> %s%n",
                    entry.getKey(),
                    entry.getValue());
        }
    }
}
