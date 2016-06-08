package com.riverbandon.com.wifichat;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**************************************************/

        /*Загрузка TAB HOST*/
        TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.Client);
        spec.setIndicator("Клиент");

        TabHost.TabSpec spec1 = tabHost.newTabSpec("tab2");
        spec1.setContent(R.id.Seerver);
        spec1.setIndicator("Сервер");

        tabHost.addTab(spec);
        tabHost.addTab(spec1);


        final EditText nick = (EditText)findViewById(R.id.UserName);
        final EditText ServerIP = (EditText)findViewById(R.id.ClientIp);
        final EditText ServerPort = (EditText)findViewById(R.id.ServerPort);
        final EditText ClientPort = (EditText)findViewById(R.id.ClientPort);
        final EditText ServerName = (EditText)findViewById(R.id.ServerNickName);

        Button startServer = (Button)findViewById(R.id.StartServerButton);
        startServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatData.UserName = ServerName.getText().toString() + ": ";
                ChatData.ClientIP = ChatData.ServerIP = ServerIP.getText().toString();
                ChatData.ServerPort = Integer.parseInt(ServerPort.getText().toString());
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        Button connectButton = (Button)findViewById(R.id.ConnectoToServer);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatData.ClientIP = ChatData.ServerIP = ServerIP.getText().toString();
                ChatData.ClientPort = Integer.parseInt(ClientPort.getText().toString());
                ChatData.UserName = nick.getText().toString() + ": ";
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }

}
