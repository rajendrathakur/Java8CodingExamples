package org.example.funcpro.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AadharCard {
    private long number;
    private Address address;
}
