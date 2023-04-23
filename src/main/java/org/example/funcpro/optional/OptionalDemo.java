package org.example.funcpro.optional;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) throws Throwable {

        Optional<String> emptyOptional = Optional.empty();
        //System.out.println(emptyOptional.orElseThrow(() -> new IllegalArgumentException("There is no valid value")));

        Optional<String> obj = Optional.of("Test");
        System.out.println(obj.get());

        Optional<String> obj1 = Optional.ofNullable("Rajendra");
        //System.out.println(obj1.get());

        if(obj1.isPresent()) {
            System.out.println("Value is available");
        } else {
            System.out.println("not available");
        }

        obj1.ifPresent(s -> System.out.println(s.toUpperCase()));

        System.out.println(obj1.filter(s-> s.startsWith("R")).orElse("Mohan"));

        System.out.println(obj1.map(s-> s.length()).orElse(10));

        Address address = new Address("RP road","Hyderabad", 500080);
        AadharCardOpt aadharCardOpt = new AadharCardOpt(123456781234L, address);
        PersonOpt personOpt = new PersonOpt(23,25000, aadharCardOpt);

        Optional<PersonOpt> personOptOptional = Optional.of(personOpt);
        System.out.println(personOptOptional.map(personOpt1 -> personOpt1.getAadharCardOpt()).get());

        System.out.println(personOptOptional.flatMap(personOpt1 -> personOpt1.getAadharCardOpt()));







    }
}
