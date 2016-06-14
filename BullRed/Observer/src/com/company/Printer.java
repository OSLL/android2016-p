package com.company;

public class Printer implements IPrintable
{
    private int value;
    String outputText = "";
    boolean firstCall = true;

    @Override
    public void Update(IIntValue integerValue)
    {
        int newValue = integerValue.getValue();
        if ((value != newValue) || firstCall)
        {
            outputText = "Введено новое значение: ";
            value = newValue;
            firstCall = false;
        }
        else
        {
            outputText = "Повторный ввод числа ";
        }
        PrintValue(integerValue.getValue());
    }

    private void PrintValue(int newValue)
    {
        System.out.println(outputText + newValue);
    }
}
