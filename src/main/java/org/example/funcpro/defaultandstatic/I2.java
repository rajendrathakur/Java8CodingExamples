package org.example.funcpro.defaultandstatic;

public interface I2 {

    void subtract();

    default void multiply() {
        System.out.println("This is default multiply from i2");
    }
}
