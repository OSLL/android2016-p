package com.example.user.successapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    public static Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.my_button);
        System.out.println(myButton.getText());


    }

    public void onMyButtonClick(View view) {


        Intent intent = new Intent(this, NameActivity.class);
        startActivity(intent);
    }

}
