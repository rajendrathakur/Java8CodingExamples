package org.example.funcpro.optional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class AadharCardOpt {
    private long number;
    private Address address;

    public Optional<Address> getAddressOpt() {
        return Optional.ofNullable(address);
    }
}
