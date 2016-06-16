package com.company;

/**
 * Created by user on 6/15/2016.
 */
public class TooManyRecords extends NullPointerException{
    private int maxValue;

    public TooManyRecords(int maxValue){
        this.maxValue = maxValue;
    }

    public void setMaxValue(int maxValue){
        this.maxValue = maxValue;
    }

    public int getMaxValue(){
        return maxValue;
    }



}
