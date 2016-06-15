package com.company;

import java.util.ArrayList;

public class Printer implements IPrintable
{
    private int value;
    String outputText = "";
    boolean firstCall = true;

    private final int maxRecords = 3;
    private ArrayList<String> recordMessages = new ArrayList<>();
    private ArrayList<Integer> recordValues = new ArrayList<>();

    @Override
    public void Update(IIntValue integerValue) throws TooManyRecords
    {
        if (recordValues.size() == maxRecords) {
            throw new TooManyRecords("Превышено допустимое количество записей.",
                     maxRecords);
        }

        int newValue = integerValue.getValue();
        if ((value != newValue) || firstCall)
        {
            outputText = "Введено новое значение: ";
            value = newValue;
            firstCall = false;
        }
        else
        {
            outputText = "Повторный ввод числа: ";
        }

        recordMessages.add(outputText);
        recordValues.add(newValue);
        PrintValue(newValue);
    }

    private void PrintValue(int newValue)
    {
        System.out.println(outputText + newValue);
    }
}
