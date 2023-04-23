package org.example.funcpro.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class PersonOpt {
    private int age;
    private int salary;
    private AadharCardOpt aadharCard;

    public Optional<AadharCardOpt> getAadharCardOpt() {
        return Optional.ofNullable(aadharCard);
    }
}
