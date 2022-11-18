package org.example.funcpro.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Optional;
@Data
@AllArgsConstructor
public class AvailabilityZone {
    private String name;
    private Optional<DataCenter> dataCenter;
}
