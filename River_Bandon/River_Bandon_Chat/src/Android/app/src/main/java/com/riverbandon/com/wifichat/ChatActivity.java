package com.riverbandon.com.wifichat;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.*;

public class ChatActivity extends AppCompatActivity {
    ArrayList<String> test = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        Button sendButton = (Button)findViewById(R.id.SendButton);
        final ListView listView = (ListView)findViewById(R.id.MessageList);
        final EditText userText = (EditText)findViewById(R.id.UserMessage);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.message_list, test);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ChatData.UserName.equals(": ")&&!userText.getText().toString().equals("")) {
                    test.add(ChatData.UserName + userText.getText().toString());
                    userText.setText("");
                    listView.setAdapter(adapter);
                }
                else {
                    Toast toast =  Toast.makeText(getApplicationContext(), "NickName или сообщение пустое!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}

