/**
 * Created by user on 6/1/2016.
 */
public class IntegerValue implements Observable {
    private int value;
    private Observer observer;

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value=newValue;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observer = o;
    }

    @Override
    public void removeObserver(Observer o) {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        observer.update(value);
    }

}
