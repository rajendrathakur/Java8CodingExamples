package org.example.funcpro.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private int age;
    private int salary;
    private AadharCard aadharCard;
}
