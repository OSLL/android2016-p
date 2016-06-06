/**
 * Created by user on 6/1/2016.
 */

public class Printer implements Observer {
    private int val;
    private IntegerValue integerValue;
    public static int[] arr = new int[10];
    public static int i = 0;

    public Printer(IntegerValue obj)
    {
        integerValue = obj;
        obj.registerObserver(this);
    }

    @Override
    public void update(int value) throws TooManyRecords {
            arr[i] = value;
            i++;
            if(i > 9)
                throw new TooManyRecords("Array overflow");
            this.val = value;
            display();

    }

    public void display() {

        System.out.println("Current value: " + val);
    }
}
