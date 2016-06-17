package com.zazerk.lie.successapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        if (MainActivity.kolvoIgrokov == 2) {
            RadioButton rb2 = (RadioButton) findViewById(R.id.rb_2);
            rb2.setChecked(true);
        } else {
            RadioButton rb1 = (RadioButton) findViewById(R.id.rb_1);
            rb1.setChecked(true);
        }
        if (MainActivity.tema == 1) {
            RadioButton vse = (RadioButton) findViewById(R.id.alisa);
            vse.setChecked(true);
        }
        if (MainActivity.tema == 2) {
            RadioButton vse = (RadioButton) findViewById(R.id.kotiki);
            vse.setChecked(true);
        }
        if (MainActivity.tema == 3) {
            RadioButton vse = (RadioButton) findViewById(R.id.vse);
            vse.setChecked(true);
        }

    }

    public void onSaveClick(View v) {
        // Количесвто играков
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
        int id1 = rg1.getCheckedRadioButtonId();
        switch(id1) {
            case R.id.rb_1:
                MainActivity.kolvoIgrokov = 1;
                break;
            case R.id.rb_2:
                MainActivity.kolvoIgrokov = 2;
                break;
        }
        // Тема
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.rg3);
        int id3 = rg3.getCheckedRadioButtonId();
        switch(id3) {
            case R.id.alisa:
                MainActivity.tema = 1;
                break;
            case R.id.kotiki:
                MainActivity.tema = 2;
                break;
            case R.id.vse:
                MainActivity.tema = 3;
                break;
        }
        Toast t = Toast.makeText(this, "Параметры сохранены", Toast.LENGTH_SHORT);
        t.show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
