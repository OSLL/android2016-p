package com.riverbandon.com.wifichat;

import android.app.Activity;
import android.widget.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server extends Thread{

    private ServerSocket _server;
    private ArrayList<Connection> connections = new ArrayList<>();
    private String nick;
    private AutoCompleteTextView messages;
    Server(int port){
        try {
            _server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {

                Socket socket = _server.accept();

                Connection con = new Connection(socket);
                connections.add(con);
                con.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private class Connection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;

        Connection(Socket sock) {
            socket = sock;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void run(){
            try {
                nick = in.readLine();

                for (Connection c : connections) {
                    c.out.println(nick + " cames now");
                }

                String message = "";
                while (true) {
                    message = in.readLine();
                    if (message.equals("exit"))
                        break;
                    for (Connection c : connections) {
                        c.out.println(nick + ": " + message);
                    }
                }

                for (Connection c : connections) {
                    c.out.println(nick + " has left.");
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

        public void close() {
            try {
                in.close();
                out.close();
                socket.close();

                connections.remove(this);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
