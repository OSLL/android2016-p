package com.riverbandon.com.wifichat;


import android.content.*;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.*;

public class ChatActivity extends AppCompatActivity {

    @Override
    public void onBackPressed()
    {
        openQuitDialog();
    }
    private void openQuitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Вы уверены, что хотите выйти?");
        builder.setNegativeButton("Да", new DialogInterface.OnClickListener() { // Кнопка ОК
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                finish();
                System.runFinalizersOnExit(true);
                System.exit(0);
            }
        });
        builder.setPositiveButton("Нет", new DialogInterface.OnClickListener() { // Кнопка ОК
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }
    public void onDestroy() {
        super.onDestroy();

        System.runFinalizersOnExit(true);
        System.exit(0);
    }
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
            }
        });

    }

}

