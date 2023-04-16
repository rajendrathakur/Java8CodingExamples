package org.example.funcpro.methodreferences;

import org.example.funcpro.streams.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MR03ExampleIAnyClassArbitraryObjectsInstanceMethodInvocation {
    public static void main(String[] args) {
        Greeting greeting = null;
        // Invoking toUpperCase() on instance reference of type String
        greeting = (s) -> s.toUpperCase();
        System.out.println(greeting.greetUser("Lambda Expression Rajendra"));
        System.out.println("------------------------");

        greeting = String::toUpperCase;
        System.out.println(greeting.greetUser("Method Reference Rajendra"));
        System.out.println("------------------------");

        List<Integer> courses = Arrays.asList(24,12,6,10);
        courses.sort((i1,i2)-> i1.compareTo(i2)) ;
        System.out.println("Lambda Expression " + courses);

        System.out.println("------------------------");

        courses.sort(Integer::compareTo) ;
        System.out.println("Method Reference " + courses);
        System.out.println("------------------------");

        List<String> numbers = List.of("One", "Two", "Three");

        /**
         * s-> s.length() can be written as String::length
         */
        numbers.stream().map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("------------------------");

        List<Employee> empList =  Employee.createEmployeesList();

       empList.stream().map(employee -> employee.getName()).forEach(System.out::println);;
        System.out.println("------------------------");

       empList.stream().map(Employee::getName).forEach(System.out::println);;
    }
}
