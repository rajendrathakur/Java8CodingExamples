package org.example.funcpro.lambda;

public class LambdaTest {
    public static void main(String[] args) {
        //Using Anonymous Inner Class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(" This is run method");
            }
        };
        new Thread(runnable).start();

        //Uiing Lambda Expression
        Runnable runnable1 = () -> {
            System.out.println(" This is run method from Lambda");
        };
        new Thread(runnable1).start();


    }
}
