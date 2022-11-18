package org.example.funcpro.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FP07ExampleOnListToMap {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>(List.of(
                new Employee("Rajendra", 42, 25000, "Development"),
                new Employee("Ashok", 22, 35000, "Development"),
                new Employee("Sravan", 32, 24000, "QA"),
                new Employee("Ashish", 38, 62000, "HR"),
                new Employee("Mohan", 34, 38000, "QA")
        ));
        //Convert List to Map with key as age and value as salary
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

        // Add new emplyee of duplicate age to empList
        empList.add(new Employee("Rama", 34, 44000, "QA"));
        // Try to convert List to Map once again with duplicate age of 34
        /*empList.stream().collect(Collectors.toMap(Employee::getAge,Employee::getSalary))
                .forEach((k,v)-> System.out.println(k + ":" + v));*/
        /**
         * While converting to map, ambiguity came to choose which entry out of 2 duplicate ages 34
         *  Exception in thread "main" java.lang.IllegalStateException: Duplicate key 34 (attempted merging values 38000 and 44000)
         */

        // To resolve this issue, we need to consider either one of the entry out of 2 duplicate ages 34
        empList.stream().collect(Collectors.toMap(Employee::getAge,Employee::getSalary, (oldEntry,newEntry) -> oldEntry))
                .forEach((k,v)-> System.out.println(k + ":" + v));
        System.out.println("----------");
        /**
         32:24000
         34:38000 <--- Age of old employee
         38:62000
         22:35000
         42:25000
         */
        // We can consider newly added employee's entry too like below
        empList.stream().collect(Collectors.toMap(Employee::getAge,Employee::getSalary, (oldEntry,newEntry) -> newEntry))
                .forEach((k,v)-> System.out.println(k + ":" + v));
        System.out.println("----------");
        /**
         32:24000
         34:44000  <--- Age of newly added employee
         38:62000
         22:35000
         42:25000
         */

        /**
         * Now Sort the list based on employee's salary and then try to convert to map
         * Consider LinkedHashMap to consider the sorted order
          */
        empList.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .collect(Collectors.toMap(Employee::getAge,Employee::getSalary, (oldEntry,newEntry) -> newEntry,
                        LinkedHashMap::new))
                .forEach((k,v)-> System.out.println(k + ":" + v));
        /**
         38:62000
         34:38000  <--- Post sorting, 34: 44000 is old entry and 34: 38000 is new entry. As per the logic, new entry is considered.
         22:35000
         42:25000
         32:24000
         */
    }
}
