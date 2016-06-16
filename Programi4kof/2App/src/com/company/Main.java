package com.company;

public class Main {

    public static void main(String[] args) {

        IntegerValue integerValue = new IntegerValue();
        Printer printer = new Printer(integerValue);
        try{
        integerValue.setValue(1);
        integerValue.setValue(1);
        integerValue.setValue(3);
        integerValue.setValue(7);
        integerValue.setValue(7);
        integerValue.setValue(32);

        } catch (TooManyRecords e){
            System.out.println("hsdkjihfes");
            System.out.println("Максимальное количество изменений " + e.getMaxValue());
            printer.setIndex(0);
        }
        //integerValue.setValue(4);

    }
}
