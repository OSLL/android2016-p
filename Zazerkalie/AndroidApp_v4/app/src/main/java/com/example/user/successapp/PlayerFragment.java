package com.example.user.successapp;


import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.StringTokenizer;

public class PlayerFragment extends Fragment {
    public static TextView name;
    public static TextView ques;
    public static TextView scoreBoard;
    public static RadioButton rb1;
    public static RadioButton rb2;
    public static RadioButton rb3;
    public static RadioButton rb4;
    public static String[] mas_1 = new String[4];
    public static String str_q_1;
    public static boolean result = false;

    public PlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    public void setInfo() {
        name = (TextView) getView().findViewById(R.id.textView3);
        ques = (TextView) getView().findViewById(R.id.question);
        scoreBoard = (TextView) getView().findViewById(R.id.cur_score);
        rb1 = (RadioButton) getView().findViewById(R.id.var_a);
        rb2 = (RadioButton) getView().findViewById(R.id.var_b);
        rb3 = (RadioButton) getView().findViewById(R.id.var_v);
        rb4 = (RadioButton) getView().findViewById(R.id.var_g);

            name.setText(AppActivity.name1String);

            try {
                SQLiteOpenHelper helper = new DBHelper(getView().getContext());
                SQLiteDatabase db = helper.getReadableDatabase();
                Cursor cursor = db.query("APPTABLE", new String[]{"QUES", "VARS"}, "STAT = ?", new String[]{Integer.toString(0)}, null, null, null);
                //  Работает по первому false, нужно добавить рандом
                if (cursor.moveToFirst()) {
                    str_q_1 = cursor.getString(0);
                    String ansText = cursor.getString(1);

                    StringTokenizer st = new StringTokenizer(ansText, "#");
                    int i = 0;
                    while (st.hasMoreTokens()) {
                        mas_1[i] = st.nextToken().toString();
                        i++;
                    }

                    ContentValues value = new ContentValues();
                    value.put("STAT", 1);
                    db.update("APPTABLE", value, "QUES=?", new String[]{str_q_1});
                } else {
                    Toast t = Toast.makeText(getView().getContext(), "База данных пуста", Toast.LENGTH_SHORT);
                    t.show();
                }

                cursor.close();
                db.close();
            } catch (SQLiteException e) {
                Toast toast = Toast.makeText(getView().getContext(), "База данных не доступна", Toast.LENGTH_SHORT);
                toast.show();
            }
            ques.setText(str_q_1);
            rb1.setText(mas_1[0]);
            rb2.setText(mas_1[1]);
            rb3.setText(mas_1[2]);
            rb4.setText(mas_1[3]);
            scoreBoard.setText(AppActivity.cur1+"/"+AppActivity.total);
            getView().setRotationX(180);
            getView().setRotationY(180);

    }

}
