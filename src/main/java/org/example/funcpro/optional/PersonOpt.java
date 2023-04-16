package org.example.funcpro.optional;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class PersonOpt {
    private int age;
    private int salary;
    private AadharCardOpt aadharCard;

    public Optional<AadharCardOpt> getAadharCardOpt() {
        return Optional.ofNullable(aadharCard);
    }
}
