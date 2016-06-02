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
        System.out.println("Printers count " + printers.size());
    }
    @Override
    public void notifyData() throws ToManyRecords{
        for (Observer p: printers)
        {
            try{
                p.update(readValue());
            } catch (ToManyRecords toManyRecords) {
                throw  toManyRecords;
            }
        }
    }
    void setValue() throws ToManyRecords {
        System.out.print("Input value: ");
        value = readInt();
        try {
            notifyData();
        } catch (ToManyRecords toManyRecords) {
            throw toManyRecords;
        }
    }

    int readValue()
    {
        return value;
    }

    static int readInt()
    {
        return new Scanner(System.in).nextInt();
    }
}