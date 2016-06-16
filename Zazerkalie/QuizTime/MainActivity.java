package com.zazerk.lie.successapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {
    public static Button myButton;
    public static ImageView image;

    public static int kolvoIgrokov = 2;
    public static int tema = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.my_button);
        image = (ImageView) findViewById(R.id.imageView);

        try {
                SQLiteOpenHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getReadableDatabase();
                ContentValues value = new ContentValues();
                value.put("STAT", 0);
                db.update("APPTABLE", value, null, null);
                db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
            toast.show();
        }
        OneActivity.count = 1;
        OneActivity.curScore = 0;
        AppActivity.score1=0;
        AppActivity.score2=0;
        AppActivity.cur1=1;
        AppActivity.cur2=1;
    }


    public void onMyButtonClick(View view) {
        if (kolvoIgrokov == 2) {
            Intent intent = new Intent(this, NameActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, Name0Activity.class);
            startActivity(intent);
        }
    }

    public void onSettingsButtonClick(View view) {
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }

}
