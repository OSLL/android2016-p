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
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class NumActivity extends Activity {
    private static TextView tvView;
    private static TextView tvView2;
    private static TextView tvView3;
    private static TextView tvView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num);
        tvView = (TextView) findViewById(R.id.tvtvtv);
        tvView2 = (TextView) findViewById(R.id.textView2);
        tvView3 = (TextView) findViewById(R.id.textView4);
        tvView4 = (TextView) findViewById(R.id.textView10);

        if (!getIntent().getBooleanExtra("two", false)) {

            try {
                SQLiteOpenHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getReadableDatabase();
                ContentValues value = new ContentValues();
                value.put("NAME", OneActivity.name);
                value.put("SCORE", OneActivity.curScore);
                db.insert("PLAYERTABLE", null, value);
                db.close();
            } catch (SQLiteException e) {
                Toast toast = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
                toast.show();
            }
            tvView.setText(Integer.toString(OneActivity.curScore));

            String fulling1 = "";
            String fulling2 = "";
            try {
                SQLiteOpenHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getReadableDatabase();
                Cursor cursor = db.query("PLAYERTABLE", new String[]{"NAME", "SCORE"}, null, null, null, null, "SCORE DESC");
                //  Работает по первому false, нужно добавить рандом
                if (cursor.moveToFirst()) {
                    String nameTable = cursor.getString(0);
                    int scoreTable = cursor.getInt(1);
                    fulling1 += nameTable + " " + "\n";
                    fulling2 += Integer.toString(scoreTable) + " " + "\n";
                    while (cursor.moveToNext()) {
                        nameTable = cursor.getString(0);
                        scoreTable = cursor.getInt(1);
                        fulling1 += nameTable + " " + "\n";
                        fulling2 += Integer.toString(scoreTable) + " " + "\n";
                    }
                } else {
                    Toast t = Toast.makeText(this, "База данных пуста", Toast.LENGTH_SHORT);
                    t.show();
                }

                cursor.close();
                db.close();
            } catch (SQLiteException e) {
                Toast toast = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
                toast.show();
            }
            tvView2.setText(fulling1);
            tvView3.setText(fulling2);
        } else {
            if (AppActivity.score1 > AppActivity.score2) {
                tvView4.setText("Победа за тобой, "+AppActivity.name1String+"!");
                tvView.setText(Integer.toString(AppActivity.score1));
            }
            if (AppActivity.score2 > AppActivity.score1) {
                tvView4.setText("Победа за тобой, "+AppActivity.name2String+"!");
                tvView.setText(Integer.toString(AppActivity.score2));
            }
            if (AppActivity.score1 == AppActivity.score2) {
                tvView4.setText("Ничья!");
                tvView.setText(Integer.toString(AppActivity.score1));
            }

            String fulling1 = "";
            String fulling2 = "";
            try {
                SQLiteOpenHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getReadableDatabase();
                Cursor cursor = db.query("PLAYERTABLE", new String[]{"NAME", "SCORE"}, null, null, null, null, "SCORE DESC");
                //  Работает по первому false, нужно добавить рандом
                if (cursor.moveToFirst()) {
                    String nameTable = cursor.getString(0);
                    int scoreTable = cursor.getInt(1);
                    fulling1 += nameTable + " " + "\n";
                    fulling2 += Integer.toString(scoreTable) + " " + "\n";
                    while (cursor.moveToNext()) {
                        nameTable = cursor.getString(0);
                        scoreTable = cursor.getInt(1);
                        fulling1 += nameTable + " " + "\n";
                        fulling2 += Integer.toString(scoreTable) + " " + "\n";
                    }
                } else {
                    Toast t = Toast.makeText(this, "База данных пуста", Toast.LENGTH_SHORT);
                    t.show();
                }
                cursor.close();
                db.close();
            } catch (SQLiteException e) {
                Toast toast = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
                toast.show();
            }
            tvView2.setText(fulling1);
            tvView3.setText(fulling2);
        }
    }

    public void onMenuButtonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
