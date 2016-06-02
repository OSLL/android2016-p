/**
 * Created by user on 6/2/2016.
 */
public class IntValue{
    int data;
    Printer printer;

    void registerObserver(Printer p) {
        printer = p;
    }

    void notifyObserver() {
        printer.display(getValue());
    }

    IntValue() {
        Printer p = new Printer();
        registerObserver(p);
    }

    void setValue(int val) {
        data = val;
        notifyObserver();
}

    int getValue() {
        return data;
    }
}
