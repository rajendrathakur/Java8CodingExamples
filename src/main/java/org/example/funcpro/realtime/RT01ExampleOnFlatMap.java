package org.example.funcpro.realtime;

import org.example.funcpro.streams.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RT01ExampleOnFlatMap {
    public static void main(String[] args) {
        Map<String, List<Employee>> departments = new HashMap<>();
        departments.put("QA", List.of(
                new Employee("Rajendra", 42, 120000, "QA"),
                new Employee("Ashok", 22, 95000, "QA")
                ));
        departments.put("HR", List.of(
                new Employee("nikitha", 84000, 120000, "HR"),
                new Employee("Kalpana", 140000, 95000, "HR")
        ));
        departments.put("Dev", List.of(
                new Employee("Santhosh", 42, 110000, "Dev"),
                new Employee("Ashish", 22, 92000, "Dev")
        ));

        //Print the list of employee names whose salary is greater thatn 1 lakh
        departments.values().stream().flatMap(List::stream)
                .filter(employee -> employee.getSalary() > 100000)
                .map(Employee::getName)
                .forEach(System.out::println);
        /**
         Rajendra
         Santhosh
         nikitha
         */
    }
}
