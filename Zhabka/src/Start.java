import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {

        Value value = new Value();
        Printer currentDisplay = new Printer(value);
        try{
            value.setMeasurements(13);
            value.setMeasurements(55);
            value.setMeasurements(12);
            value.setMeasurements(15);
            value.setMeasurements(14);
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
    private int temperature;

    @Override
    public void registerObserver(Observer o) {
        observer = o;
    }
    @Override
    public void notifyObservers() throws TooManyRecords {
        observer.check(temperature);
    }

    public void setMeasurements(int temperature) throws TooManyRecords {
        this.temperature = temperature;
        notifyObservers();
    }
}

class Printer implements Observer {
    int max = 4;
    ArrayList<Integer> allValue = new ArrayList<>();
    private int temperature;
    private Value value;

    public Printer(Value value) {
        this.value = value;
        value.registerObserver(this);
    }
    @Override
    public void check(int temperature) throws TooManyRecords {
        if (this.temperature != temperature) {
            this.temperature = temperature;
            if (allValue.size() > max - 1 ) {
                System.out.println(allValue);
                throw new TooManyRecords(max);
            }
            allValue.add(temperature);
            System.out.println(allValue);
            System.out.println(allValue.size());
            display();
        }
    }

    public void display() {
        System.out.println("Значение изменилось " + temperature);
    }


}
class TooManyRecords extends Exception {
    int max;

    public TooManyRecords(int m) {
        max = m;
        System.out.println("Переполнение, максимальное кол-во элементов - " + max);
    }
}

