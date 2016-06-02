import java.util.Scanner;

/**
 * Created by user on 6/1/2016.
 */
public class MainProgram {

    public static void main(String[] args) {
        IntegerValue value = new IntegerValue();
        Printer printer = new Printer(value);
        value.setValue(5);
        value.setValue(10);
    }
}
