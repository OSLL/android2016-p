/**
 * Created by user on 6/2/2016.
 */
public class ToManyRecords extends Throwable {
    String error = "";


    ToManyRecords(String error){
        this.error = error;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Error: " + error);
    }

}
