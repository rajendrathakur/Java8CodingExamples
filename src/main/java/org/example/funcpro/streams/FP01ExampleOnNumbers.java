package org.example.funcpro.streams;

import java.util.Comparator;
import java.util.List;

public class FP01ExampleOnNumbers {
    public static void main(String[] args) {
        //print the numbers using foreach
        List<Integer> numbers = List.of(2,4,7,5,9,1);
        numbers.stream().forEach(System.out::println);
        System.out.println("----------------");
        /**
         2
         4
         7
         5
         9
         1
         */

        //filter only even numbers
        numbers.stream().filter(n->n%2==0).forEach(System.out::println);
        System.out.println("----------------");
        /**
         2
         4
         */

        //Find the sum of square of even numbers
        int sum = numbers.stream().filter(n->n%2==0)
                .map(x-> x*x)
                .reduce(0,Integer::sum);
        System.out.println(sum);
        System.out.println("----------------");
        /**
         20
         */

        //sort the numbers in natural order
        numbers.stream().sorted().forEach(System.out::println);
        System.out.println("----------------");
        /**
         1
         2
         4
         5
         7
         9
         */

        //sort the numbers in descending order
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("----------------");
        /**
         9
         7
         5
         4
         2
         1
         */
    }
}