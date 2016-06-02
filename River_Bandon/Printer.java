import java.util.ArrayList;

class Printer implements Updater{
    ArrayList<Integer> values = new ArrayList<Integer>();
    public void update(int val) throws TooManyRecords {
        if (values.size() == TooManyRecords.MX)
            throw new TooManyRecords();
        values.add(val);
        display(val);
    }
    public void display(int val) {
        System.out.println(val);
    }
}