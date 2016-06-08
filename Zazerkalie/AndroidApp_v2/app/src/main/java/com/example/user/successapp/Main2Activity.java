package com.example.user.successapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);}

    public void onMyButtonClick(View view) {
        Intent intent = new Intent(this, Name0Activity.class);
        startActivity(intent);}

        public void onMyButtonClick2(View view) {
            Intent intent1 = new Intent(this, NameActivity.class);
            startActivity(intent1);
        }
    }


