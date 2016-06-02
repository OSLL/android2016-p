/**
 * Created by artem on 02.06.16.
 */

public class TooManyRecords extends Exception {
    private String errmsg;
    public int max = 10;

    public TooManyRecords(String msg)
    {
        errmsg = msg;
    }

    public String getErrMsg()
    {
        return errmsg;
    }
}
