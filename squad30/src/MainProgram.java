/**
 * Created by user on 6/1/2016.
 */


public class MainProgram {
    public static void main(String[] args) {
        IntegerValue integerValue = new IntegerValue();
        Printer printer = new Printer(integerValue);
        integerValue.setValue(0);
        integerValue.setValue(1);
        integerValue.setValue(9);
    }
}

interface Observer {
    void update( int value );
}

interface Observable {
    void notifyObserver();
    void registerObserver(Observer o);
}


