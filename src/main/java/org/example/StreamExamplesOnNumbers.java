package org.example;

import java.util.List;

public class StreamExamplesOnNumbers {
    public static void main(String[] args) {
        //print the numbers using foreach
        List<Integer> numbers = List.of(12, 4,7,5,9,10,14,1);
        numbers.stream().forEach(System.out::println);
        System.out.println("----------------");
        /**
         12
         4
         7
         5
         9
         10
         14
         1
         */

        //filter only even numbers
        numbers.stream().filter((n)->n%2==0).forEach(System.out::println);
        System.out.println("----------------");
        /**
         12
         4
         10
         14
         */

        //Find the sum of square of even numbers
        int sum = numbers.stream().filter((n)->n%2==0)
                .map(x-> x*x)
                .reduce(0,Integer::sum);
        System.out.println(sum);
        /**
         456
         */




    }
}