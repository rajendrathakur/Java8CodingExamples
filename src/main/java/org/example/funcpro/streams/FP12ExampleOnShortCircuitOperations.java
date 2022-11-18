package org.example.funcpro.streams;

import java.util.List;

public class FP12ExampleOnShortCircuitOperations {
    public static void main(String[] args) {
        List<String> items = List.of("Mobile", "Laptop", "Mouse");

        //Usage of limit()
        items.stream().limit(1).forEach(System.out::println);
        System.out.println("---------");
        /**
         Mobile
         */

        //Usage of findFirst()
        items.stream().filter(s-> s.startsWith("M"))
                .findFirst().ifPresent(System.out::println);
        System.out.println("---------");
        /**
         Mobile
         */

        //Usage of findAny()
        items.stream().filter(s-> s.startsWith("M"))
                .findAny().ifPresent(System.out::println);//Return any matched value
        System.out.println("---------");
        /**
         Mobile
         */

        //Usage of anyMatch()
        System.out.println(items.stream().anyMatch(s-> s.startsWith("M")));
        System.out.println("---------");
        /**
         true
         */

        //Usage of noneMatch()
        System.out.println(items.stream().noneMatch(s-> s.startsWith("A")));
        /**
         true
         */

    }
}
