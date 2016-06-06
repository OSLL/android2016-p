/**
 * Created by user on 6/3/2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;




public class Utils {

    public String inputColor()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input color in hex: ");
        try {
            return br.readLine();
        } catch(IOException exc) {
            return "FFFFFF";
        }


    }

    public Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
                Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
                Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
    }
}