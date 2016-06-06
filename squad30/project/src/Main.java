/**
 * Created by user on 6/3/2016.
 */

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://pictaculous.com/api/1.0/");
        } catch(MalformedURLException exc) {
            ;

        }
        String hexcol;
        Utils u = new Utils();
        hexcol = u.inputColor();
        Color col = u.hex2Rgb(hexcol);
        System.out.println("R: " + col.R + ", G: " + col.G + ", B: " + col.B);
        System.out.println("Suggested colors: " + (int)((double)col.R/255*80) + " " + (int)((double)col.G/255*80) + " " + (int)((double)col.B/255*80) + ", " + (int)((double)col.R/255*120) + " " + (int)((double)col.G/255*120) + " " + (int)((double)col.B/255*120));

    }


}
