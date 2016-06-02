/**
 * Created by user on 6/1/2016.
 */
public class Printer implements Observer{
    private int value;
    private IntegerValue OldValue;

    public Printer(IntegerValue value) {
        OldValue = value;
        value.registerObserver(this);
    }
    @Override
    public void update(int value) {
        this.value = value;
        display();
    }

    public void display(){
        System.out.println("value = "+value);
    }
}
