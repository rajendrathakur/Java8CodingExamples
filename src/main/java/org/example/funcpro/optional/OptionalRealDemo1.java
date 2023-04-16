package org.example.funcpro.optional;

import java.util.Optional;

public class OptionalRealDemo1 {

    String getResult() {
        String str = "Four";
        //some business logic
        // str = "Ramesh";
        return str;
    }

    Optional<String> getOptionalResult() {
        String str = "Seven";
        //some business logic
        // str = "Ramesh";
        return Optional.ofNullable(str);
    }


    public static void main(String[] args) {
        String s1 = new OptionalRealDemo1().getResult();

        //Prior to Java8 Approach
        int i = 0;
        if (s1 != null) {
            i = s1.length();
        } else {
            i = "Default".length();
        }
        System.out.println("int value is :" + i);

        //Java8 Approach
        Optional<String> result = new OptionalRealDemo1().getOptionalResult();

        i = result.map(s -> s.length()).orElse("Default".length());
        System.out.println("int value new Optional is :" + i);

    }
}
