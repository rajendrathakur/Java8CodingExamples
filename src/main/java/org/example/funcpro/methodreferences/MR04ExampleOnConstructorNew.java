package org.example.funcpro.methodreferences;

import org.example.funcpro.streams.Employee;

@FunctionalInterface
interface EmployeeInterface01 {
    Employee createEmployee();
}
@FunctionalInterface
interface EmployeeInterface02 {
    Employee createEmployee(String name, int age, int salary, String department);
}

public class MR04ExampleOnConstructorNew {
    public static void main(String[] args) {
        EmployeeInterface01 employeeInterface01 = null;
        EmployeeInterface02 employeeInterface02 = null;

        employeeInterface01 = () -> new Employee();
        System.out.println(employeeInterface01.createEmployee().getName());
        //Mahesh

        employeeInterface01 =  Employee::new;
        System.out.println(employeeInterface01.createEmployee().getName());
        //Mahesh

        employeeInterface02 = (name,age,salary,department) -> new Employee(name, age,salary,department);
        System.out.println(employeeInterface02.createEmployee("Mohan", 25, 35000, "QA").getName());
        //Mohan

        employeeInterface02 =  Employee::new;
        System.out.println(employeeInterface02.createEmployee("Mohan", 25, 35000, "QA").getName());
        //Mohan


    }
}
