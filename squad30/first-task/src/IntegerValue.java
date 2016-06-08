/**
 * Created by user on 6/1/2016.
 */

public class IntegerValue implements Observable {

    private Observer observer;

    private int value;

    public void setValue( int val ) throws TooManyRecords
    {
        value = val;
        notifyObserver();
    }

    public int getValue ()
    {
        return value;
    }

    @Override
    public void notifyObserver() throws TooManyRecords {
        observer.update(this.getValue());
    }

    @Override
    public void registerObserver(Observer o)
    {
        observer = o;
    }
}
