package com.example.user.successapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
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
        if (MainActivity.rezhim == 2) {
            RadioButton nv = (RadioButton) findViewById(R.id.navremya);
            nv.setChecked(true);
        } else {
            RadioButton obich = (RadioButton) findViewById(R.id.obich);
            obich.setChecked(true);
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
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg1);
        int id = rg.getCheckedRadioButtonId();
        switch(id) {
            case R.id.rb_1:
                MainActivity.kolvoIgrokov = 1;
                break;
            case R.id.rb_2:
                MainActivity.kolvoIgrokov = 2;
                break;
        }
        // Режим
        rg = (RadioGroup) findViewById(R.id.rg2);
        id = rg.getCheckedRadioButtonId();
        switch(id) {
            case R.id.obich:
                MainActivity.rezhim = 1;
                break;
            case R.id.navremya:
                MainActivity.rezhim = 2;
                break;
        }
        // Тема
        rg = (RadioGroup) findViewById(R.id.rg3);
        id = rg.getCheckedRadioButtonId();
        switch(id) {
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
