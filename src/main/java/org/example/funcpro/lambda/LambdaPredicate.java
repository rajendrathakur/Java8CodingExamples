package org.example.funcpro.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class LambdaPredicate {

    public void filterElements(List<Integer> list, IntPredicate predicate) {
        for(int i : list) {
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        LambdaPredicate lambdaPredicate = new LambdaPredicate();
        lambdaPredicate.filterElements(list, t -> t%2 ==0 );
    }
}
