package com.example.user.successapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
            try {
                SQLiteOpenHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getReadableDatabase();
                ContentValues value = new ContentValues();
                value.put("NAME", name.getText().toString());
                value.put("SCORE", 0);
                db.insert("PLAYERTABLE", null, value);
                db.close();
            } catch (SQLiteException e) {
                Toast toast = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
                toast.show();
            }
            Intent intent = new Intent(this, Name2Activity.class);
            startActivity(intent);
        } else {
            Toast t = Toast.makeText(this, "Вы забыли ввести имя", Toast.LENGTH_SHORT);
            t.show();
        }

    }
}
