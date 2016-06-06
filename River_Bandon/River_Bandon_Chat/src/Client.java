import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    String message;

    Client(String ip, int port) {
        Scanner scan = new Scanner(System.in);
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Enter your nickname:");
            out.println(scan.nextLine());

            Resender resend = new Resender();
            resend.start();

            String msg = "";
            while (!msg.equals("exit")) {
                msg = scan.nextLine();
                out.println(msg);
            }
            resend.Stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Resender extends Thread {
        private boolean running = true;
        public void Stop() {
            running = false;
        }
        public void run() {
            while (running) {
                try {
                    message = in.readLine();
                    System.out.println(message);
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}

