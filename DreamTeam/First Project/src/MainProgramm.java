

interface Observer{
    void update(int value);
}

interface Observerable{
    void addPrinter(Printer p);
    void notifyData();
}

public class MainProgramm {


    public static void main(String argv[])
    {
        IntegerValue value = new IntegerValue();
        Printer printer = new Printer();
        value.addPrinter(printer);
        boolean run = true;
            while (run)
            {
                System.out.println("1->New Value");
                System.out.println("2->Exit");
                int select = IntegerValue.readInt();
            switch (select)
            {
                case 1:
                    value.setValue();
                    break;
                case 2:
                    run = false;
                    System.out.print("Finished");
            }
        }
    }
}
