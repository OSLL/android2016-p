package com.riverbandon.com.wifichat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Client client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /********************************************/

        final EditText port = (EditText)findViewById(R.id.Port);
        final EditText ip = (EditText) findViewById(R.id.IP);
        final EditText msg = (EditText) findViewById(R.id.UserMessage);
        final Button StartServerButton = (Button)findViewById(R.id.StartServerButton);
        StartServerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Server server = new Server(Integer.parseInt(String.valueOf(port.getText())));
                server.start();
            }
        });

        final Button StartClientButton = (Button)findViewById(R.id.StartClientButton);
        StartClientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client = new Client(ip.getText().toString(), Integer.parseInt(String.valueOf(port.getText())));
            }
        });
        final Button SendButton = (Button)findViewById(R.id.SendButton);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client.sendMessage(msg.getText().toString());
            }
        });
    }

}
