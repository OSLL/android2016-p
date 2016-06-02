import java.util.ArrayList;
import java.util.Scanner;

class  IntegerValue implements Observerable
{
    ArrayList<Observer> printers = new ArrayList<>();
    private int value = 0;
    @Override
    public void addPrinter(Printer p)
    {
        printers.add(p);
    }
    @Override
    public void notifyData(){
        for (Observer p: printers)
        {
            p.update(readValue());
        }
    }
    void setValue()
    {
        System.out.print("Input value: ");
        value = readInt();
        notifyData();

    }

    int readValue()
    {
        return value;
    }

    static int readInt()
    {
        //return new Scanner(System.in).nextInt();
        Scanner c = new Scanner(System.in);
        int d = c.nextInt();
        return d;
    }
}