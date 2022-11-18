package org.example.funcpro.optional;

import java.util.Optional;

public class Optional03ExampleOnFiltervsMapvsFlatMap {
    public static void main(String[] args) {
        /**
         * Like how we do filter on streams, we can also do filter even in Optional too
         */
        DataCenter dataCenter = new DataCenter("DC-A", 24);
        Optional<DataCenter> dataCenterOptional = Optional.ofNullable(dataCenter);
        if (dataCenterOptional.isPresent()) {
            //Usage of filter
            dataCenterOptional.filter(dc -> dc.getEc2InstancesCount() < 30)
                    .filter(dc -> dc.getEc2InstancesCount() > 20)
                    .ifPresent(dc -> System.out.println(dc.getEc2InstancesCount()));
            System.out.println("---------");

            //Usage of map
            System.out.println(dataCenterOptional.map(DataCenter::getEc2InstancesCount).orElse(0));
        }

        AvailabilityZone availabilityZone = new AvailabilityZone("US-east-1a", dataCenterOptional);
        Optional<AvailabilityZone> availabilityZoneOptional = Optional.ofNullable(availabilityZone);
        if (availabilityZoneOptional.isPresent()) {
            // If we use map here, then it will return Optional<Optional<DataCenter>>
            Optional<Optional<DataCenter>> optionalDataCenter = availabilityZoneOptional.map(AvailabilityZone::getDataCenter);
            System.out.println(optionalDataCenter);
            System.out.println("-------------");

            //But we want only Optional<DataCenter> right. Use flatMap
            Optional<DataCenter> dataCenterOptional1 = availabilityZoneOptional.flatMap(AvailabilityZone::getDataCenter);
            System.out.println(dataCenterOptional1);
            System.out.println("-------------");
        }
    }
}
