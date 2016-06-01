/**
 * Created by user on 6/1/2016.
 */

public class Printer implements Observer {
    private int val;
    private IntegerValue integerValue;
    public Printer(IntegerValue obj)
    {
        integerValue = obj;
        obj.registerObserver(this);
    }

    @Override
    public void update(int value) {
        this.val = value;
        display();
    }

    public void display() {
        System.out.println("Current value: " + val);
    }
}
