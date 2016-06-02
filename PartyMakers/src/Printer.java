/**
 * Created by user on 6/1/2016.
 */
public class Printer implements Observer{
    private int value;
    private IntegerValue OldValue;
    public static int CONST = 1;
    int[] a = new int[CONST];
    int i = 0, i1 = 0;

    public Printer(IntegerValue value) {
        OldValue = value;
        value.registerObserver(this);
    }

    @Override
      public void update(int value) {
        try {
            if (i >= CONST)
                throw new TooManyRecords();
            this.value = value;
            a[i] = value;
            if (i == 0 || a[i] != a[i - 1]) {
                display();
                i1++;
            }
            i++;
        } catch (TooManyRecords er) {
            er.printf(i1);
        }
        finally {
            System.out.println("А я всё равно напечатался ");
        }
    }

    public void display(){
        System.out.println("value = "+a[i]);
    }
}
