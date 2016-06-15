package com.company;

import java.util.ArrayList;

/**
 * Created by user on 6/14/2016.
 */
public class Printer implements Observer{
    private int value;
    private IntegerValue integerValue;

    public Printer(IntegerValue integerValue) {
        this.integerValue = integerValue;
        integerValue.registerObserver(this);
    }


    @Override
    public void update(Integer last) {
        display(last);
    }

    public void display(Integer last){
        if (last != value) {
            System.out.println(last);
        }
        value = last;
    }

}
