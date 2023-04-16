package org.example.funcpro.streams;

import java.util.*;
import java.util.stream.Collectors;

public class FP03ExampleOnCustomPOJO {
    public static void main(String[] args) {
        List<Employee> empList = Employee.createEmployeesList();

        //Print the employee names hose salary is greater than 30000
        empList.stream().filter(e -> e.getSalary() > 30000)
                .map(e-> e.getName()).forEach(System.out::println);
        System.out.println("---------");
        /**
         Ashok
         Ashish
         Mohan
         */

        //Sort the employees based on their age. If ages are equal, then sort based on their salary
        System.out.println(empList.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getSalary))
                .collect(Collectors.toList()));
        System.out.println("--- ------");
        /**
         [Employee(name=Ashok, age=22, salary=35000, department=Development),
         Employee(name=Sravan, age=32, salary=24000, department=QA),
         Employee(name=Ashish, age=32, salary=62000, department=HR),
         Employee(name=Mohan, age=34, salary=38000, department=QA),
         Employee(name=Rajendra, age=42, salary=25000, department=Development)]
         */

        //Sort the employees based on their age. If ages are equal, then sort based on their salary in descending order
        System.out.println(empList.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getSalary, Comparator.reverseOrder()))
                .collect(Collectors.toList()));
        System.out.println("---------");
        /**
         [Employee(name=Ashok, age=22, salary=35000, department=Development),
         Employee(name=Ashish, age=32, salary=62000, department=HR),
         Employee(name=Sravan, age=32, salary=24000, department=QA),
         Employee(name=Mohan, age=34, salary=38000, department=QA),
         Employee(name=Rajendra, age=42, salary=25000, department=Development)]
         */

        //Print the count of employees for each department wise in the form of Map.
        empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((k, v) -> System.out.println((k + ":" + v)));
        System.out.println("---------");
        /**
         QA:2
         Development:2
         HR:1
         */

        //Print the employee with max salary for each department wise in the form of Map.
        empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .forEach((k, v) -> System.out.println((k + ":" + v)));
        System.out.println("---------");
        /**
         QA:Optional[Employee(name=Mohan, age=34, salary=38000, department=QA)]
         Development:Optional[Employee(name=Ashok, age=22, salary=35000, department=Development)]
         HR:Optional[Employee(name=Ashish, age=32, salary=62000, department=HR)]
         */

        //Print the max salary of employees for each department wise in the form of Map.
        empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet().stream().collect(Collectors.toMap(k->k.getKey(), v->v.getValue().get().getSalary()))
                .forEach((k, v) -> System.out.println((k + ":" + v)));
        System.out.println("---------");
        /**
         QA:38000
         Development:35000
         HR:62000
         */

        //print the employees list whose salary > 20000 for each department
        empList.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()
                        .stream().filter(emp -> emp.getSalary()>20000).collect(Collectors.toList())))
                .forEach((k,v)-> System.out.println(k + ":" + v));
        /**
         QA:[Employee(name=Sravan, age=32, salary=24000, department=QA), Employee(name=Mohan, age=34, salary=38000, department=QA)]
         Development:[Employee(name=Rajendra, age=42, salary=25000, department=Development), Employee(name=Ashok, age=22, salary=35000, department=Development)]
         HR:[Employee(name=Ashish, age=32, salary=62000, department=HR)]
         */

    }
}
