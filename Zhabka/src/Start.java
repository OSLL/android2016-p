/**
 * Created by user on 6/2/2016.
 */
public class Start {
    public static void main(String[] args) {

        Value value = new Value();
        Printer currentDisplay = new Printer(value);
        value.setMeasurements(13);
        value.setMeasurements(55);
        value.setMeasurements(55);
        value.setMeasurements(44);
        value.setMeasurements(44);
    }
}

interface Observer {
    void check(int temperature);
}

interface Observable {
    void notifyObservers();
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
    public void notifyObservers() {
        observer.check(temperature);
    }

    public void setMeasurements(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

class Printer implements Observer {
    private int temperature;
    private Value value;

    public Printer(Value value) {
        this.value = value;
        value.registerObserver(this);
    }
    @Override
    public void check(int temperature) {
        if (this.temperature != temperature) {
            this.temperature = temperature;
            display();
        }
    }

    public void display() {
        System.out.println("Значение изменилось " + temperature);
    }


}