public class TooManyRecords extends Throwable {
    public static int MX = 100;
    void print() {
        System.out.println("Too many records. Max value = " + Integer.toString(MX));
    }
}
