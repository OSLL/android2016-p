package com.example.user.superdupershooter;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void oClickLevels(View view) {
        startActivity(new
                Intent(Menu.this, Levels.class));
    }

    public void oClickSurvival (View view) {
        startActivity(new
                Intent(Menu.this, Survival.class));
    }
}
