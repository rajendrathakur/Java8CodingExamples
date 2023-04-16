package org.example.funcpro.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name = "Mahesh";
    private int age = 40;
    private int salary = 24000;
    private String department = "Development";

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
