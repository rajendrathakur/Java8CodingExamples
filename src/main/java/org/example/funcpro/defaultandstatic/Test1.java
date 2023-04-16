package org.example.funcpro.defaultandstatic;

public class Test1  implements I1,I2{

    @Override
    public void add() {
        System.out.println("This is add() from Test1");
    }

    @Override
    public void multiply() {
        I2.super.multiply();
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.add();
        t1.multiply();
        t1.subtract();
        I1.print();
    }

    @Override
    public void subtract() {
        System.out.println("This is my subtract ");
    }
}
