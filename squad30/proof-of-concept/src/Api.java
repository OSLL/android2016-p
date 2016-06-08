/**
 * Created by user on 6/6/2016.
 */

import java.net.*;
import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Api {
    public static void main(String[] args) {
        HttpURLConnection connection = null;
        try {
            //Create connection
            URL url = new URL(" http://pictaculous.com/api/1.0/");
            byte[] file = readFile("C:/Users/user/Downloads/blue-02.jpg");
            File temp_file = new File("C:/Users/user/Downloads/blue-02.jpg");
            String data = new String(file, "UTF-8");
            String crlf = "\r\n";
            String twoHyphens = "--";
            String boundary =  "*****";
            String attachmentName = "image";
            String attachmentFileName = "blue-02.jpg";

            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + boundary);

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            System.out.println(data);

            wr.writeBytes(twoHyphens + boundary + twoHyphens);
            wr.writeBytes(crlf);
            wr.flush();
            wr.writeBytes("Content-Disposition: form-data; name=\"" +
                    attachmentName + "\"" + crlf);
            wr.writeBytes(crlf);
            wr.flush();
            wr.write(file);
            wr.writeBytes(crlf);
            wr.writeBytes(twoHyphens + boundary +
                    twoHyphens + crlf);
            wr.flush();


            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if not Java 5+
            String line;
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    static public byte[] readFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllBytes(path);
    }
}
