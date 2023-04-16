package org.example.funcpro.optional;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        Optional abc = Optional.empty();
        System.out.println("Empty optional" + abc.orElseGet(() -> "Default Value"));
        //abc.get();

        Optional<String> hello = Optional.of("Hello");
        System.out.println(hello);

        //Optional<String> hello1 = Optional.of(null);

        Optional<String> obj = Optional.ofNullable("One");
        //System.out.println(obj.get());

        if (obj.isPresent()) {
            System.out.println(obj.get());
        } else {
            System.out.println("Not available");
        }

        obj.ifPresent((s) -> System.out.println(s.toUpperCase()));

        System.out.println(obj.filter(s-> s.startsWith("N")).orElse("Shyam"));

        System.out.println(obj.map(s-> s.toLowerCase()).orElse("Prabhas"));

        Address address = new Address("RP road","Hyderabad", 500080);
        AadharCardOpt aadharCardOpt = new AadharCardOpt(123456781234L, address);
        PersonOpt person = new PersonOpt(23,25000, aadharCardOpt);


        Optional<PersonOpt> personOptional = Optional.of(person);
        System.out.println(personOptional.map(p -> p.getAadharCardOpt()).get().get().getNumber());
        System.out.println(personOptional.flatMap(p -> p.getAadharCardOpt()).get().getNumber());


    }
}
