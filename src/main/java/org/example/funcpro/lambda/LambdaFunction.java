package org.example.funcpro.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

public class LambdaFunction {

    public void mapElements(List<Integer> list, IntFunction function) {
        for(int i : list) {
            System.out.println(function.apply(i));
        }
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        LambdaFunction lambdaFunction = new LambdaFunction();
        lambdaFunction.mapElements(list, t -> t*t );
    }

}
