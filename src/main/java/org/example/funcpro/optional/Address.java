package org.example.funcpro.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Address {
    private String streetName;
    private String city;
    private int pincode;
}
