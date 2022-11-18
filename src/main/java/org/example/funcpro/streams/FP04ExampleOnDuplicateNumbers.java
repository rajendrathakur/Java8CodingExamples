package org.example.funcpro.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP04ExampleOnDuplicateNumbers {
    public static void main(String[] args) {
        List<Integer> numList = List.of(2,4,5,6,2,4,8,2,5);

        //Print the Duplicate numbers
        //Approach - 1
        Set<Integer> numSet = new HashSet<>();
        numList.stream().filter(n-> !numSet.add(n))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("----------");
        /**
         2
         4
         5
         */

        //Approach - 2
        numList.stream().filter(n-> Collections.frequency(numList,n) > 1)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("----------");
        /**
         2
         4
         5
         */

        //print the numbers which are repeated more than 2 times
        numList.stream().filter(n-> Collections.frequency(numList,n) > 2)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("----------");
        /**
         2
         */

        //Approach - 3
        numList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e-> e.getValue()>1)
                .map(e->e.getKey())
                .forEach(System.out::println);
        System.out.println("----------");
        /**
         2
         4
         5
         */

        //Print the duplicate numbers in the form of map. key as number and value as repeated count in descending order
        numList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1,v2)->v1, LinkedHashMap::new))
                .forEach((k,v)-> System.out.println(k + ":" + v));
        System.out.println("----------");
        /**
         2:3
         4:2
         5:2
         6:1
         8:1
         */
    }
}
