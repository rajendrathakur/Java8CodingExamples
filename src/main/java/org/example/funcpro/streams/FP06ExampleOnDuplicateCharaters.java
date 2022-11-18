package org.example.funcpro.streams;

import java.util.stream.Collectors;

public class FP06ExampleOnDuplicateCharaters {
    public static void main(String[] args) {
        String str = "Rajendra";
        //print the count of duplicate characters in the form of map
        str.chars().mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .forEach((k,v)-> System.out.println(k + ";" + v));
        /**
         a;2
         r;1
         R;1
         d;1
         e;1
         j;1
         n;1
         */

        //convert the string to lowercase and find the duplicate characters.
        str.chars().mapToObj(c-> (char)c)
                .map(c-> Character.toLowerCase(c))
                .collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .forEach((k,v)-> System.out.println(k + ";" + v));
        /**
         a;2
         r;2
         d;1
         e;1
         j;1
         n;1
         */
    }
}
