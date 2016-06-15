package com.company;

import java.util.ArrayList;

public class IntegerValue implements IIntValue
{
    private int value;

    private ArrayList<IPrintable> printers = new ArrayList<>();

    public IntegerValue(int value) throws TooManyRecords
    {
        setValue(value);
    }

    public  IntegerValue()
    {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) throws TooManyRecords
    {
        this.value = value;
        Notify();
    }

    public void  Attach(IPrintable observer)
    {
        printers.add(observer);
    }

    public  void  Detach(IPrintable observer)
    {
        printers.remove(observer);
    }

    public void  Notify() throws TooManyRecords
    {
        for (IPrintable observer : printers)
        {
            observer.Update(this);
        }
    }
}
