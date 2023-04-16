package org.example.funcpro.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.IntFunction;

public class LambdaSupplier {

    public void supplyElements(DoubleSupplier supplier) {

            System.out.println(supplier.getAsDouble());

    }


    public static void main(String[] args) {

        LambdaSupplier lambdaSupplier = new LambdaSupplier();
        lambdaSupplier.supplyElements(() -> Math.random() );
    }
}
