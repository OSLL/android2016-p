package com.company;

public class Main {

    public static void main(String[] args) {

        IntegerValue integerValue = new IntegerValue();
        Printer printer = new Printer(integerValue);
        integerValue.setValue(1);
        integerValue.setValue(1);
        integerValue.setValue(3);
        integerValue.setValue(7);
    }
}
