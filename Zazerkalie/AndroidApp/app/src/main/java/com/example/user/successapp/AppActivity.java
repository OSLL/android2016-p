package com.example.user.successapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.StringTokenizer;


public class AppActivity extends Activity {

    public static TextView q;
    private static String[] mas = new String[4];
    private static RadioButton rb1;
    private static RadioButton rb2;
    private static RadioButton rb3;
    private static RadioButton rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        q = (TextView) findViewById(R.id.question);
        rb1 = (RadioButton) findViewById(R.id.var_a);
        rb2 = (RadioButton) findViewById(R.id.var_b);
        rb3 = (RadioButton) findViewById(R.id.var_v);
        rb4 = (RadioButton) findViewById(R.id.var_g);

        try {
            SQLiteOpenHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("APPTABLE", new String[]{"QUES", "VARS"}, "STAT = ?", new String[] {Integer.toString(0)}, null, null, null);
            //  Работает по первому false, нужно добавить рандом
            if (cursor.moveToFirst()) {
                String quesText = cursor.getString(0);
                String ansText = cursor.getString(1);

                StringTokenizer st = new StringTokenizer(ansText, "#");
                int i=0;
                while(st.hasMoreTokens()){
                    mas[i] = st.nextToken().toString();
                    i++;
                }
                q.setText(quesText);
                rb1.setText(mas[0]);
                rb2.setText(mas[1]);
                rb3.setText(mas[2]);
                rb4.setText(mas[3]);

                ContentValues value = new ContentValues();
                value.put("STAT", 1);
                db.update("APPTABLE", value, "QUES=?", new String[] {quesText});
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
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void onDalee(View v) {
        String ansText = "";
        try {
            SQLiteOpenHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("APPTABLE", new String[]{"ANS"}, "QUES = ?", new String[] {q.getText().toString()}, null, null, null);
            if (cursor.moveToFirst()) {
                ansText = cursor.getString(0);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
            toast.show();
        }

        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group);
        int id = rg.getCheckedRadioButtonId();
        switch(id) {
            case R.id.var_a:
                if (ansText.equals("а")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.var_b:
                if (ansText.equals("б")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.var_v:
                if (ansText.equals("в")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.var_g:
                if (ansText.equals("г")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            default:
                    Toast t = Toast.makeText(this, "Вариант ответа не выбран", Toast.LENGTH_SHORT);
                    t.show();
        }
        Intent intent = new Intent(this, AppActivity.class);
        SystemClock.sleep(1500);
        startActivity(intent);
    }
}









