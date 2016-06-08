/**
 * Created by user on 6/1/2016.
 */


public class MainProgram {
    public static void main(String[] args) {
        IntegerValue integerValue = new IntegerValue();
        Printer printer = new Printer(integerValue);
        try {
            for(int k = 0; k < 15; k++)
                integerValue.setValue(k);
        } catch (TooManyRecords e) {
            for(printer.i = 0; printer.i < e.max; printer.i++)
                printer.arr[printer.i] = 0;
            printer.i = 0;
            System.out.println("Exception: " + e.getErrMsg());
        } finally {
            System.out.println("Finally block");
        }
    }
}

interface Observer {
    void update( int value ) throws TooManyRecords ;
}

interface Observable {
    void notifyObserver() throws TooManyRecords ;
    void registerObserver(Observer o);
}


