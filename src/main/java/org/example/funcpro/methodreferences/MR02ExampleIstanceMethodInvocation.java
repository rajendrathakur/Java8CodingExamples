package org.example.funcpro.methodreferences;

import java.time.LocalDateTime;

public class MR02ExampleIstanceMethodInvocation {
    public String greetUser(String userName) {
        int hour = LocalDateTime.now().getHour();
        if (hour < 13 && hour > 6) {
            return "Good Morning "+ userName;
        } else if (hour > 13 && hour > 18) {
            return "Good Evening "+ userName;
        } else {
            return "GoodNight "+ userName;
        }
    }
    public static void main(String[] args) {
        MR02ExampleIstanceMethodInvocation obj = new MR02ExampleIstanceMethodInvocation();
        Greeting greeting = obj::greetUser;
        System.out.println(greeting.greetUser("Rajendra"));
        //Good Morning Rajendra
    }
}
