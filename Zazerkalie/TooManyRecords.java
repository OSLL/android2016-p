/**
 * Created by user on 6/2/2016.
 */
public class TooManyRecords extends Throwable{
    public static int MX;

    public TooManyRecords(int tu){
        MX=tu;

    }

    void error() {
        System.out.println("Error! "+MX);
            }
}
