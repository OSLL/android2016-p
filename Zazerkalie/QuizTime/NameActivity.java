package com.zazerk.lie.successapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends Activity {
    public static Button Vvod;
    public static EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Vvod = (Button) findViewById(R.id.vvod);
        name = (EditText) findViewById(R.id.editText);
    }

    public void onMyButtonClick(View view) {
        if (!name.getText().toString().equals("")) {
            AppActivity.name1String = name.getText().toString();
            Intent intent = new Intent(this, Name2Activity.class);
            startActivity(intent);
        } else {
            Toast t = Toast.makeText(this, "Вы забыли ввести имя", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
