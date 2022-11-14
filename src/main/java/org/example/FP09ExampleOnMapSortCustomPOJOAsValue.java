package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FP09ExampleOnMapSortCustomPOJOAsValue {
    public static void main(String[] args) {
        Map<Integer, Employee> empMap = new HashMap<>();
        empMap.put(1,  new Employee("Rajendra", 42, 25000, "Development"));
        empMap.put(2,  new Employee("Mahesh", 22, 55000, "QA"));
        empMap.put(3,  new Employee("Krishna", 44, 45000, "Development"));
        empMap.put(4,  new Employee("Samantha", 46, 35000, "QA"));
        empMap.put(5,  new Employee("Nikitha", 48, 62000, "HR"));

        //Sort the empMap by keys
        empMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldEntry,newEntry)-> oldEntry, LinkedHashMap::new))
        .forEach((k,v)-> System.out.println(k+";" + v));
        System.out.println("-------------------");
        /**
         1;Employee(name=Rajendra, age=42, salary=25000, department=Development)
         2;Employee(name=Mahesh, age=22, salary=55000, department=QA)
         3;Employee(name=Krishna, age=44, salary=45000, department=Development)
         4;Employee(name=Samantha, age=46, salary=35000, department=QA)
         5;Employee(name=Nikitha, age=48, salary=62000, department=HR)
         */

        //sort the map by values specific to employee's age
        empMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Employee::getAge)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldEntry,newEntry)-> oldEntry, LinkedHashMap::new))
                .forEach((k,v)-> System.out.println(k+";" + v));
        /**
         2;Employee(name=Mahesh, age=22, salary=55000, department=QA)
         1;Employee(name=Rajendra, age=42, salary=25000, department=Development)
         3;Employee(name=Krishna, age=44, salary=45000, department=Development)
         4;Employee(name=Samantha, age=46, salary=35000, department=QA)
         5;Employee(name=Nikitha, age=48, salary=62000, department=HR)
         */
        }
}
