package org.example.funcpro.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

public class LambdaConsumer {

    public void acceptElements(List<Integer> list, IntConsumer consumer) {
        for(int i : list) {
            consumer.accept(i);
        }
    }


    public static void main(String[] args) {
        int k = 10;
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        LambdaConsumer lambdaConsumer = new LambdaConsumer();
        lambdaConsumer.acceptElements(list, t -> {

            System.out.println(t + k);
        } );
    }
}
