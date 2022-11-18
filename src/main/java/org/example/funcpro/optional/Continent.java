package org.example.funcpro.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Continent {
    private String name;
    private Country country;
}
