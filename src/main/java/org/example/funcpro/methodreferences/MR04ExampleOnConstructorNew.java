package org.example.funcpro.methodreferences;

import org.example.funcpro.streams.Employee;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface EmployeeInterface01 {
    Employee createEmployee();
}
@FunctionalInterface
interface EmployeeInterface02 {
    Employee createEmployee(String name);
}
@FunctionalInterface
interface EmployeeInterface03 {
    Employee createEmployee(String name, int age);
}
public class MR04ExampleOnConstructorNew {
    public static void main(String[] args) {
        EmployeeInterface01 employeeInterface01 = () -> new Employee("Rajendra", 42, 25000, "Development");
        System.out.println(employeeInterface01.createEmployee().getName());
        //Rajendra

        //Employee createEmployee(); ersembles get() of Supplier<Employee>
        Supplier<Employee> supplier = () -> new Employee("Rajendra", 42, 25000, "Development");
        System.out.println(employeeInterface01.createEmployee().getName());
        //Rajendra

        EmployeeInterface02 employeeInterface02 = name -> new Employee(name, 42, 25000, "Development");
        System.out.println(employeeInterface02.createEmployee("Mahesh").getName());
        //Mahesh

        //Employee createEmployee(); ersembles get() of Supplier<Employee>
        Function<String, Employee> function = name -> new Employee(name, 42, 25000, "Development");
        System.out.println(employeeInterface02.createEmployee("Mahesh").getName());
        //Mahesh

        EmployeeInterface03 employeeInterface03 = (name,age) -> new Employee(name, age, 25000, "Development");
        System.out.println(employeeInterface03.createEmployee("Nikitha", 24).getName());
        //Mahesh

        //Employee createEmployee(); ersembles get() of Supplier<Employee>
        BiFunction<String,Integer,Employee> biFunction = (name,age) -> new Employee(name, 42, 25000, "Development");
        System.out.println(employeeInterface03.createEmployee("Nikitha", 26).getName());
        //Nikitha
    }
}
