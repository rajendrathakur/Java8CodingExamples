package org.example.funcpro.streams;

import java.util.Comparator;
import java.util.List;

public class FP02ExampleOnStrings {
    public static void main(String[] args) {
        List<String> courses = List.of("Java", "Spring Boot", "Python","Docker","Ruby",
                "Hibernate", "Database");

        //Sort the courses in natural order
        courses.stream().sorted().forEach(System.out::println);
        System.out.println("--------");
        /**
         Database
         Docker
         Hibernate
         Java
         Python
         Ruby
         Spring Boot
         */

        //sort the courses in reverse order
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("--------");
        /**
         Spring Boot
         Ruby
         Python
         Java
         Hibernate
         Docker
         Database
         */

        //sort the courses based on their length
       // courses.stream().sorted(Comparator.comparing(s-> s.length())).forEach(System.out::println);
        // For better performance, we can use comparingInt(s->s.length)
        courses.stream().sorted(Comparator.comparingInt(s-> s.length())).forEach(System.out::println);
        System.out.println("--------");
        /**
         Java
         Ruby
         Python
         Docker
         Database
         Hibernate
         Spring Boot
         */

        //sort the courses based on their length in descending order
        courses.stream().sorted(Comparator.comparing(s-> s.length(),Comparator.reverseOrder()))
                .forEach(System.out::println);
        System.out.println("--------");
        /**
         Spring Boot
         Hibernate
         Database
         Python
         Docker
         Java
         Ruby
         */

        //sort the courses based on their length in natural order
        courses.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
        System.out.println("--------");
        /**
         Java
         Ruby
         Docker
         Python
         Database
         Hibernate
         Spring Boot
         */

        //sort the courses based on their length in descending order
        courses.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.reverseOrder()))
                .forEach(System.out::println);
        System.out.println("--------");
        /**
         Ruby
         Java
         Python
         Docker
         Database
         Hibernate
         Spring Boot
         */
    }
}
