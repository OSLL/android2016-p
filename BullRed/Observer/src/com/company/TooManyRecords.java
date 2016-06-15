package com.company;

public class TooManyRecords extends RuntimeException
{
    private int maxRecords;

    public int getMaxRecords()
    {
        return maxRecords;
    }

    public TooManyRecords(String message, int maxRecords)
    {
        super(message);
        this.maxRecords = maxRecords;
    }
}
