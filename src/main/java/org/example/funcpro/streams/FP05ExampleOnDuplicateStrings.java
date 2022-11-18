package org.example.funcpro.streams;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP05ExampleOnDuplicateStrings {
    public static void main(String[] args) {
        List<String> strList = List.of("Java", "Ruby", "AWS","Docker",
                "Java", "Ruby", "Java");
        //Print the duplicate strings in the form of map. key as string and value as repeated count in descending order
        strList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1,v2)->v1, LinkedHashMap::new))
                .forEach((k,v)-> System.out.println(k + ":" + v));
        System.out.println("----------");
        /**
         Java:3
         Ruby:2
         Docker:1
         AWS:1
         */
    }
}
