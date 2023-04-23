package org.example.funcpro.optional;

import java.util.Optional;

public class OptionalRealDemo2 {

    int getResultWithoutOptional(Person person){
        if(person != null) {
            AadharCard aadharCard = person.getAadharCard();
            if(aadharCard != null) {
                Address address = aadharCard.getAddress();
                if(address != null) {
                    return address.getPincode();
                }
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        Address address = new Address("RP road","Hyderabad", 500080);
        AadharCard aadharCard = new AadharCard(123456781234L, address);
        Person person = new Person(23,25000, aadharCard);

        OptionalRealDemo2 optionalRealDemo2 = new OptionalRealDemo2();
        System.out.println(optionalRealDemo2.getResultWithoutOptional(person));


        AadharCardOpt aadharCardOpt = new AadharCardOpt(123456781234L, address);
        PersonOpt personOpt = new PersonOpt(23,25000, null);

        Optional<PersonOpt> personOptOptional = Optional.of(personOpt);
        System.out.println(optionalRealDemo2.getResultWithOptional(personOptOptional));







    }

    private int getResultWithOptional(Optional<PersonOpt> personOptOptional) {
        return personOptOptional.flatMap(personOpt -> personOpt.getAadharCardOpt())
                .flatMap(aadharCardOpt -> aadharCardOpt.getAddressOpt())
                .map(address -> address.getPincode())
                .orElse(500090);

    }


}
