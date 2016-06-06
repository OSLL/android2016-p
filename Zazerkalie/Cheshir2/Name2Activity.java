package com.example.user.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Name2Activity extends AppCompatActivity {
    public static Button Vvod2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name2);
        Vvod2 = (Button) findViewById(R.id.vvod2);
    }

    public void onMyButtonClick(View view) {

        Intent intent = new Intent(this, AppActivity.class);
        startActivity(intent);
    }
}

