import java.util.ArrayList;

interface Observer{
    final int maxCount = 4;
    ArrayList<Integer> count = new ArrayList<>();
    void update(int value) throws ToManyRecords;
}

interface Observerable{
    void addPrinter(Printer p);
    void notifyData() throws ToManyRecords;
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
                    try {
                        value.setValue();
                    } catch (ToManyRecords toManyRecords) {
                        toManyRecords.printStackTrace();
                    }
                    finally {
                        System.out.println("Printer saved "+printer.getSize()+ " values");
                    }
                    break;
                case 2:
                    run = false;
                    System.out.print("Finished");
            }
        }
    }
}
