package com.company;

import java.util.Scanner;

interface IPrintable
{
    void  Update(IIntValue intValue);
}

interface IIntValue
{
    int getValue();
}

public class MainProgram
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();

        System.out.println("Введите 'exit' для выхода.");
        IntegerValue integerValue = new IntegerValue();
        integerValue.Attach(printer);
        while (true)
        {
            String currentString = scanner.next();
            if (!currentString.equals("exit"))
            {
                integerValue.setValue(Integer.parseInt(currentString));
            }
            else
            {
                break;
            }
        }
    }
}
