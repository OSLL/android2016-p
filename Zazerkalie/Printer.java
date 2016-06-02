/**
 * Created by user on 6/2/2016.
 */
public class Printer extends MainProgram {
    int[] array = new int[100];
    int max=5;
    int c;
    void display(int x) {
        System.out.println(x);
    }
    void add(int x) throws TooManyRecords{
        try {
            if (c == max)
                throw new TooManyRecords(max);
            array[c] = x;
            c++;
            display(x);
        }
        catch (TooManyRecords err) {
            throw new TooManyRecords(max);


        }

    }
}
