



package com.example.user.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<prod> prodlist = new ArrayList<>();
        final prod list = new  prod();
        prodlist.add(list);
        list.num= true;
        final ImageButton b3 = (ImageButton)findViewById(R.id.imageButton);
        final Switch switch1 = (Switch)findViewById(R.id.switch1);
        final EditText editText = (EditText)findViewById(R.id.editText);
        final Button b1 = (Button)findViewById(R.id.b1);
        editText.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.INVISIBLE);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();
                switch (v.getId())
                {

                    case R.id.imageButton:
                        Toast.makeText(MainActivity.this, "Добавление", Toast.LENGTH_SHORT).show();
                        editText.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.VISIBLE);
                        case R.id.b1:
                            list.str = editText.getText().toString();
                            Toast.makeText(MainActivity.this, String.valueOf(list.str ), Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.switch1:
                        list.num = !list.num;
                        Toast.makeText(MainActivity.this, String.valueOf(list.num ), Toast.LENGTH_SHORT).show();
                }
            }
        };


        b3.setOnClickListener(listener);
        switch1.setOnClickListener(listener);
        b1.setOnClickListener(listener);

    }
}
