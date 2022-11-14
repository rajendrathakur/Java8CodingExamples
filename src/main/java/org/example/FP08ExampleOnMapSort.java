package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FP08ExampleOnMapSort {
    public static void main(String[] args) {
        Map<Integer, String> unsortMap = new HashMap<>();
        unsortMap.put(1, "Banana");
        unsortMap.put(2, "Apple");
        unsortMap.put(3, "Mango");
        unsortMap.put(4, "Grape");
        unsortMap.put(5, "Lemon");

        //Print the unsortMap
        unsortMap.forEach((k,v)-> System.out.println(k + ";" + v));
        System.out.println("--------------");
        /** (Ordr is unpredictable)
         1;Banana
         2;Apple
         3;Mango
         4;Grape
         5;Lemon
         */

        //Sort the map by keys
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldEntry,newEntry)->oldEntry, LinkedHashMap::new))
                .forEach((k,v)-> System.out.println(k + ";" + v));
        System.out.println("--------------");
        /**
         * while sorting, we shouldn't write Map.Entry::comparingByKey
         * Because, comparingByKey is a static method.
         * Method reference can be used only on custom class or predefined class instance methods
         * We can write Map.Entry::getKey
         */
        /**
         1;Banana
         2;Apple
         3;Mango
         4;Grape
         5;Lemon
         */
        //sort the map by values in natural order
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldEntry,newEntry)->oldEntry, LinkedHashMap::new))
                .forEach((k,v)-> System.out.println(k + ";" + v));
        System.out.println("--------------");
        /**
         2;Apple
         1;Banana
         4;Grape
         5;Lemon
         3;Mango
         */

        //sort the map by values in descending order
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldEntry,newEntry)->oldEntry, LinkedHashMap::new))
                .forEach((k,v)-> System.out.println(k + ";" + v));
        /**
         3;Mango
         5;Lemon
         4;Grape
         1;Banana
         2;Apple
         */

    }
}
