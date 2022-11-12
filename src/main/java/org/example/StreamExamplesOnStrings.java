package org.example;

import java.util.Comparator;
import java.util.List;

public class StreamExamplesOnStrings {
    public static void main(String[] args) {
        List<String> courses = List.of("Java", "Spring Boot", "AWS Associate Architect",
                "Hibernate", "Database");

        //Sort the courses in natural order
        courses.stream().sorted().forEach(System.out::println);
        /**
         AWS Associate Architect
         Database
         Hibernate
         Java
         Spring Boot
         */

        //sort the courses in reverse order
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        /**
         Spring Boot
         Java
         Hibernate
         Database
         AWS Associate Architect
         */

        //sort the courses based on their length
        courses.stream().sorted(Comparator.comparing(s-> s.length())).forEach(System.out::println);
        /**
         Java
         Database
         Hibernate
         Spring Boot
         AWS Associate Architect
         */

        //sort the courses based on their length in descending order
        courses.stream().sorted(Comparator.comparing(s-> s.length(),Comparator.reverseOrder()))
                .forEach(System.out::println);
        /**
         AWS Associate Architect
         Spring Boot
         Hibernate
         Database
         Java
         */
    }
}
