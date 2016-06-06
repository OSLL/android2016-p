package com.example.user.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NameActivity extends Activity {
    public static Button Vvod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Vvod = (Button) findViewById(R.id.vvod);

    }
    /*public static editText Text;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String Text = reader.readLine();*/

    public void onMyButtonClick(View view) {

        Intent intent = new Intent(this, Name2Activity.class);
        startActivity(intent);
}}
