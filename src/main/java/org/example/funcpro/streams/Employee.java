package org.example.funcpro.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private int age;
    private int salary;
    private String department;

    public static List<Employee> createEmployeesList() {
        return List.of(
                new Employee("Rajendra", 42, 25000, "Development"),
                new Employee("Ashok", 22, 35000, "Development"),
                new Employee("Sravan", 32, 24000, "QA"),
                new Employee("Ashish", 32, 62000, "HR"),
                new Employee("Mohan", 34, 38000, "QA")
        );
    }
}
