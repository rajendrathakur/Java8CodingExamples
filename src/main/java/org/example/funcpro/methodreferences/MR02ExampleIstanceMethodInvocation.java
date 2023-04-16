package org.example.funcpro.methodreferences;

import java.time.LocalDateTime;

public class MR02ExampleIstanceMethodInvocation {
    public String greetUser(String userName) {
        int hour = LocalDateTime.now().getHour();
        if (hour > 6  && hour < 13) {
            return "Good Morning "+ userName;
        } else if (hour > 13 && hour < 18) {
            return "Good Evening "+ userName;
        } else {
            return "GoodNight "+ userName;
        }
    }

    public String greetMe() {
        String userName = "Rajendra";
        int hour = LocalDateTime.now().getHour();
        if (hour > 6  && hour < 13) {
            return "Good Morning "+ userName;
        } else if (hour > 13 && hour < 18) {
            return "Good Evening "+ userName;
        } else {
            return "GoodNight "+ userName;
        }
    }
    public static void main(String[] args) {
        MR02ExampleIstanceMethodInvocation obj = new MR02ExampleIstanceMethodInvocation();
        Greeting greeting = null;
        //using Lambda Expression
        greeting = userName -> obj.greetUser(userName);
        System.out.println(greeting.greetUser("Lambda"));

       //Using Method Lambda
        greeting = obj::greetUser;
        System.out.println(greeting.greetUser("Method Reference"));
        //Good Morning Method Reference

        greeting = userName -> obj.greetMe();
        System.out.println(greeting.greetUser("Lambda"));
        //Using Method Rajendra

        /*greeting = obj::greetMe;
        System.out.println(greeting.greetUser("Method Reference"));*/
    }


}
