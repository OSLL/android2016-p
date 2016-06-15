package com.company;

import java.util.ArrayList;

/**
 * Created by user on 6/14/2016.
 */
public class Printer implements Observer {
    private int value;
    private int[] diference;
    private int index;
    private IntegerValue integerValue;

    public Printer(IntegerValue integerValue) {
        this.integerValue = integerValue;
        integerValue.registerObserver(this);
        diference = new int[4];
        index = 0;
    }


    public void setIndex(int yolli){
        index = yolli;
    }

    @Override
    public void update(Integer last) {
        display(last);
    }

    public void display(Integer last) {
        if (last != value) {
            System.out.println(last);
        }
        if (index >= 4) throw new TooManyRecords(4);

        value = last;
        diference[index] = value;
        index++;
    }

}
