package org.example.funcpro.streams;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class FP13ExampleOnMinvsMax {
    public static void main(String[] args) {
        List<Integer> numList = List.of(5,3,1,9,2,8,10);

        //Find the max number
        System.out.println(numList.stream().max(Comparator.comparing(Integer::valueOf))
                .orElseThrow(NoSuchElementException::new));
        System.out.println("-------------");
        /**
         * Here we prepared Comparator on Integer values only
         * bosing & Unboxing operations will be invoked
         * Performance is low
         10
         */

        //Other approach to find max number
        System.out.println(numList.stream().mapToInt(n->n).max().orElseThrow(NoSuchElementException::new));
        /**
         * Converted Stream<Integer> to IntStream of primitives with mapToInt()
         * By this way, we can avoid boxing & unboxing operations
         * Performance will be improved
         10
         */
        System.out.println("-------------");

        //Find the min number
        System.out.println(numList.stream().min(Comparator.comparing(Integer::valueOf))
                .orElseThrow(NoSuchElementException::new));
        System.out.println("-------------");
        /**
         * Here we prepared Comparator on Integer values only
         * bosing & Unboxing operations will be invoked
         * Performance is low
         1
         */

        //Other approach to find min number
        System.out.println(numList.stream().mapToInt(n->n).min().orElseThrow(NoSuchElementException::new));
        /**
         * Converted Stream<Integer> to IntStream of primitives with mapToInt()
         * By this way, we can avoid boxing & unboxing operations
         * Performance will be improved
         1
         */
        System.out.println("-------------");

        List<Employee> empList = Employee.createEmployeesList();
        //Find max age of employees
        System.out.println(empList.stream().max(Comparator.comparing(Employee::getAge))
                .orElseThrow(NoSuchElementException::new).getAge());
        System.out.println("-------------");
        /**
         42
         */

        //Another approach with maToInt()
        empList.stream().mapToInt(Employee::getAge)
                .max().ifPresent(System.out::println);
        /**
         42
         */
    }
}
