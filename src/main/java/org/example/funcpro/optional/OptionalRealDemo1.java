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
        String str = null;
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

        Optional<String> opt = new OptionalRealDemo1().getOptionalResult();

        i = opt.map(s -> s.length()).orElse( "Default".length());
        System.out.println("int value is :" + i);






    }
}
