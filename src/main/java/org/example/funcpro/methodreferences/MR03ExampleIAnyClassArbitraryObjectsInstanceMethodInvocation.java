package org.example.funcpro.methodreferences;

import org.example.funcpro.streams.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MR03ExampleIAnyClassArbitraryObjectsInstanceMethodInvocation {
    public static void main(String[] args) {
        List<String> courses = List.of("Java","Ruby","Python","Groovy");

        /**
         * map() looks Function which has apply(T t, R r)
         * map(s-> s.toUpperCase())
         * forEach() looks for Consumer which has void accept(T t)
         * forEach(s-> System.out.println())
         */
        courses.stream().map(s-> s.toUpperCase())
                .collect(Collectors.toList())
                .forEach(s-> System.out.println());
        /**
         * JAVA
         * RUBY
         * PYTHON
         * GROOVY
         */
        System.out.println("-----------");

        /**
         * map() looks Function which has apply(T t, R r)
         * map(s-> s.toUpperCase()) can be written as map(String::toUpperCase)
         * forEach(s-> System.out.println()) can be written as forEach(System.out::println)
         * Applicable to implementation has argument type's method invocation only such as s-> s.toUpperCase()         *
         */
        courses.stream().map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        /**
         * JAVA
         * RUBY
         * PYTHON
         * GROOVY
         */
        System.out.println("-----------");

        /**
         * s-> s.length() can be written as String::length
         */
        courses.stream().map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("-----------");

        List<Employee> empList =  Employee.createEmployeesList();

        /**
         * Convert List to Map with key as age and value as salary
         * e-> e.getAge() can be written as Employee::getAge
         * e-> e.getSalary() can be written as Employee::getSalary
         */

        empList.stream().collect(Collectors.toMap(Employee::getAge,Employee::getSalary))
                .forEach((k,v)-> System.out.println(k + ":" + v));
        System.out.println("----------");
        /**
         32:24000
         34:38000
         22:35000
         38:62000
         42:25000
         */
    }
}
