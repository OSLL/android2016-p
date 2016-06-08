package com.example.user.successapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Name2Activity extends Activity {
    public static Button Vvod2;
    public static EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name2);
        Vvod2 = (Button) findViewById(R.id.vvod2);
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
            Intent intent = new Intent(this,AppActivity.class);
            startActivity(intent);
        } else {
            Toast t = Toast.makeText(this, "Вы забыли ввести имя", Toast.LENGTH_SHORT);
            t.show();
        }

    }
}

