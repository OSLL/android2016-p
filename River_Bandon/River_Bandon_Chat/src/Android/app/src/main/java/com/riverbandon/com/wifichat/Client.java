package com.riverbandon.com.wifichat;

import android.app.Activity;
import android.widget.*;
import java.io.*;
import java.net.*;

public class Client extends Activity{
    private String _ip;
    private int _port;
    private Socket _socket;
    private BufferedWriter out;
    private BufferedReader in;
    private String message;
    private AutoCompleteTextView messages;
    private boolean running;

    Client(String ip, int port){
        try {
            _ip = ip;
            _port = port;
            _socket = new Socket(_ip, _port);
            in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream(), "UTF-8"));
            messages = (AutoCompleteTextView)findViewById(R.id.MessagesList);
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void run(){
        while (running){
            try {
                message = in.readLine();
                System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"+message);
                messages.append(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void sendMessage(String msg){
        try {
            msg +="\n";
            out.write(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stop(){
        try {
            //out.println("User logout");
            running = false;
            in.close();
            out.close();

            _socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
