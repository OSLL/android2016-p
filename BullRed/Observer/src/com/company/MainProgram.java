package com.company;

import java.util.Scanner;

interface IPrintable
{
    void  Update(IIntValue intValue) throws TooManyRecords;
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

        try
        {
            while (true)
            {
                String currentString = scanner.next();
                if (!currentString.equals("exit"))
                {
                    integerValue.setValue(Integer.parseInt(currentString));
                } else
                {
                    break;
                }
            }
        }
        catch (TooManyRecords error)
        {
            System.out.println(error.getMessage());
            System.out.println("Максимальное количество: " + error.getMaxRecords());
        }
        finally
        {
            System.out.println("Программа успешна завершена.");
        }
    }
}
