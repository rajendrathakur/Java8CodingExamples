package org.example.funcpro.optional;

import java.util.Optional;

public class Optional01ExampleOnEmptyOptional {
    public static void main(String[] args) {
        //Optional is a container which holds either object or null
        Optional<Region> regionEmptyOptional = Optional.empty();
        Region region = null;

        /**
         * We use get() to fetch a value from Optional container
         * Since it is empty optional, throws NoSuchElementException
         * Exception in thread "main" java.util.NoSuchElementException: No value present
         */
        //Region region = regionEmptyOptional.get();

        /**
         * To overcome this problem, we need to use below methods
         * orElse() is used with default value
         * orElseGet() is also used with Supplier as default value
         * orElseThrow() is used to throw either custom exception or IllegalArgumentException
         * Java11 introduced orElsThrow() with no arguments. However it throws NoSuchElementException
         */

        //Usage of orElse()
        region = regionEmptyOptional.orElse(new Region("us-east-1", Optional.of(new AvailabilityZone("us-east-1a", Optional.of(new DataCenter("DC-A", 24))))));
        System.out.println(region);
        System.out.println("-----------");
        //Region(name=us-east-1, availabilityZone=Optional[AvailabilityZone(name=us-east-1a, dataCenter=Optional[DataCenter(name=DC-A, ec2InstancesCount=24)])])

        //Usage of orElseGet()
        region = regionEmptyOptional.orElse(new Region("us-east-1", Optional.of(new AvailabilityZone("us-east-1a", Optional.of(new DataCenter("DC-A", 24))))));
        System.out.println(region);
        //Region(name=us-east-1, availabilityZone=Optional[AvailabilityZone(name=us-east-1a, dataCenter=Optional[DataCenter(name=DC-A, ec2InstancesCount=24)])])
        System.out.println("-----------");

        //Usage of orElseThrow()
        try {
            region = regionEmptyOptional.orElseThrow();
        } catch (Exception exception) {
            System.out.println("NoSuchElementException has been thrown");
        }
        //NoSuchElementException has been thrown
        System.out.println("-----------");
    }
}
