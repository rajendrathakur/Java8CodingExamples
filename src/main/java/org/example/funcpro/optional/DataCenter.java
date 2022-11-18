package org.example.funcpro.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataCenter {
    private String name;
    private int ec2InstancesCount;
}
