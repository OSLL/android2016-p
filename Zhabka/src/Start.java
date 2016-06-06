import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {

        Value value = new Value();
        Printer currentDisplay = new Printer(value);
        try{
            value.setValue(13);
            value.setValue(55);
            value.setValue(12);
            value.setValue(15);
            value.setValue(14);
        } catch (TooManyRecords e){
            System.out.println("Пойман");
        }
        finally{
            System.out.println("Программа завершена");
        }
    }
}

interface Observer {
    void check(int temperature) throws TooManyRecords;
}

interface Observable {
    void notifyObservers() throws TooManyRecords;
    void registerObserver(Observer o);
}

class Value implements Observable {
    private Observer observer;
    private int value;

    @Override
    public void registerObserver(Observer o) {
        observer = o;
    }
    @Override
    public void notifyObservers() throws TooManyRecords {
        observer.check(value);
    }

    public void setValue(int temperature) throws TooManyRecords {
        this.value = temperature;
        notifyObservers();
    }
}

class Printer implements Observer {
    int max = 4;
    ArrayList<Integer> allValue = new ArrayList<>();
    private int value;
    private Value value;

    public Printer(Value value) {
        this.value = value;
        value.registerObserver(this);
    }
    @Override
    public void check(int val) throws TooManyRecords {
        if (this.value != val) {
            this.value = val;
            if (allValue.size() > max - 1 ) {
                System.out.println(allValue);
                throw new TooManyRecords(max);
            }
            allValue.add(val);
            System.out.println(allValue);
            System.out.println(allValue.size());
            display();
        }
    }

    public void display() {
        System.out.println("Значение изменилось " + value);
    }


}
class TooManyRecords extends Exception {
    int max;

    public TooManyRecords(int m) {
        max = m;
        System.out.println("Переполнение, максимальное кол-во элементов - " + max);
    }
}

