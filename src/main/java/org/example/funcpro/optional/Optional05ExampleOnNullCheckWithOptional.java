package org.example.funcpro.optional;

import java.util.Optional;

public class Optional05ExampleOnNullCheckWithOptional {
    public int getEc2InstancesCount(Optional<Region> regionOptional) {
        return regionOptional.flatMap(Region::getAvailabilityZone)
                .flatMap(AvailabilityZone::getDataCenter)
                .map(DataCenter::getEc2InstancesCount).orElse(0);
    }

    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter("DC-A", 24);
        AvailabilityZone availabilityZone = new AvailabilityZone("US-east-1a", Optional.of(dataCenter));
        Region region = new Region("US-east-1", Optional.of(availabilityZone));
        Optional05ExampleOnNullCheckWithOptional obj = new Optional05ExampleOnNullCheckWithOptional();
        System.out.println(obj.getEc2InstancesCount(Optional.of(region)));
        //24
    }
}
