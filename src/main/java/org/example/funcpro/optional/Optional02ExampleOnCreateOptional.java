package org.example.funcpro.optional;

import java.util.Optional;

public class Optional02ExampleOnCreateOptional {
    public static void main(String[] args) {
        /**
         * There are 2 ways to create Optional
         * 1. Optional.of(). If we pass null, it throws NullPointerException. To avoid npe, we need to pass valid value
         * 2. Optional.ofNullable(). If we pass null, NPE is not thrown, instead it creates empty Optional.
         */
        Region region = null;
        // Optional<Region> regionEmptyOptional = Optional.of(region); //NPE is thrown here.

        //Usage of Optional.of(), throws NPE in below line
        //Optional<Region> regionOptional = Optional.of(region);
        //Exception in thread "main" java.lang.NullPointerException

        //Usage of Optional.ofNullable() with null
        Optional<Region> regionEmptyOptional = Optional.ofNullable(region); //No NPE is thrown
        System.out.println(regionEmptyOptional); //Optional.empty
        System.out.println(regionEmptyOptional.isEmpty()); //true
        System.out.println("-----------");

        ////Usage of Optional.ofNullable() with valid value
        region = new Region("us-east-1", Optional.of(new AvailabilityZone("us-east-1a", Optional.of(new DataCenter("DC-A", 24)))));
        Optional<Region> regionOptional = Optional.ofNullable(region);
        System.out.println(regionOptional);
        //Optional[Region(name=us-east-1, availabilityZone=Optional[AvailabilityZone(name=us-east-1a, dataCenter=Optional[DataCenter(name=DC-A, ec2InstancesCount=24)])])]
        System.out.println("-----------");

        /**
         * isPresent() is used to check whether regionOptional has null or valid value. If null, returns false otherwise true
         * if isPresent() returns true, then fetch the value using get()
         */
        if (regionOptional.isPresent()) {
            region = regionOptional.get();
            System.out.println(region);
            System.out.println("-----------");
            //Region(name=us-east-1, availabilityZone=Optional[AvailabilityZone(name=us-east-1a, dataCenter=Optional[DataCenter(name=DC-A, ec2InstancesCount=24)])])
        }

        /**
         * ifPresent() is used to do some task if Optional has valid value
         * ifPresent() accepts a consumer
         */
        regionOptional.ifPresent(reg -> System.out.println(reg.getName())); //us-east-1
    }
}
