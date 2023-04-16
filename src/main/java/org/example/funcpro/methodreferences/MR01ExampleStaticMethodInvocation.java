package org.example.funcpro.methodreferences;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class MR01ExampleStaticMethodInvocation {
    public static void main(String[] args) {
        Greeting greeting = null;

        //Greeting Implementation with Anonymous inner class
        greeting = new Greeting() {
            @Override
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
        };
        System.out.println(greeting.greetUser("Rajendra"));
        //Good Morning Rajendra
        System.out.println("-----------");

        //Greeting Implementation with Lambda Expression in simplified way
        greeting = userName -> {
            int hour = LocalDateTime.now().getHour();
            if (hour > 6  && hour < 13) {
                return "Good Morning "+ userName;
            } else if (hour > 13 && hour < 18) {
                return "Good Evening "+ userName;
            } else {
                return "GoodNight "+ userName;
            }
        };
        System.out.println(greeting.greetUser("Rajendra"));
        //Good Morning Rajendra
        System.out.println("-----------");

        /**
         * Greeting Implementation with Lambda Expression even more simplified way
         * Move the implementation logic to separate static method
         */
        greeting = userName -> MR01ExampleStaticMethodInvocation.greetUser(userName);
        System.out.println(greeting.greetUser("Rajendra"));
        //Good Morning Rajendra
        System.out.println("-----------");

        /**
         * Greeting Implementation with Method References even more simplified way
         * MethodName can be anything.
         * However argument types and number of arguments and return type should match with SAM of your functional interface.
         * SAM public String greetUser(String userName); matches with public static String greetUser(String userName) {
         */
        greeting = MR01ExampleStaticMethodInvocation::greetUser;
        System.out.println(greeting.greetUser("Rajendra"));
        //Good Morning Rajendra
        System.out.println("-------------");

        /**
         *Now i considered wish method which has same argument type and number of arguments and return type
         * SAM public String greetUser(String userName); matches with public static String wish(String name) {
         */
        greeting = MR01ExampleStaticMethodInvocation::wish;
        System.out.println(greeting.greetUser("Rajendra"));
        //Hello Rajendra

        greeting = userName -> MR01ExampleStaticMethodInvocation.greetMe();
        System.out.println(greeting.greetUser("Rajendra"));

        /*greeting = MR01ExampleStaticMethodInvocation::greetMe;
        System.out.println(greeting.greetUser("Rajendra"));*/

        List<Integer> list = Arrays.asList(25,16,4,144);
        list.stream().map(i -> Math.sqrt(i)).forEach(System.out::println);
        System.out.println("-------------");

        list.stream().map(Math::sqrt).forEach(System.out::println);


    }



    public static String greetUser(String userName) {
        int hour = LocalDateTime.now().getHour();
        if (hour > 6  && hour < 13) {
            return "Good Morning "+ userName;
        } else if (hour > 13 && hour < 18) {
            return "Good Evening "+ userName;
        } else {
            return "GoodNight "+ userName;
        }
    }

    public static String greetMe() {
        String userName = "Mahesh";
        int hour = LocalDateTime.now().getHour();
        if (hour > 6  && hour < 13) {
            return "Good Morning "+ userName;
        } else if (hour > 13 && hour < 18) {
            return "Good Evening "+ userName;
        } else {
            return "GoodNight "+ userName;
        }
    }

    public static String wish(String name){
        return "Hello "+ name;
    }
}
