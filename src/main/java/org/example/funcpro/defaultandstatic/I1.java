package org.example.funcpro.defaultandstatic;

public interface I1 {
    void add();

    default void multiply() {
        System.out.println("This is default multiply from i1");
    }

    static void print() {
        System.out.println("This is print from I1");
    }



}
