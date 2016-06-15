package com.example.user.successapp;

import android.app.Fragment;
import android.content.ContentValues;
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

public class Player2Fragment extends Fragment {
    public static TextView name;
    public static TextView ques;
    public static TextView scoreBoard;
    public  static RadioButton rb1;
    public  static RadioButton rb2;
    public  static RadioButton rb3;
    public  static RadioButton rb4;
    public static String[] mas_2 = new String[4];
    public static String str_q_2;
    public static boolean result = false;
    private static int countRandom = 1;


    public Player2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player2, container, false);
    }

    public void setInfo() {
        name = (TextView) getView().findViewById(R.id.textView3_2);
        ques = (TextView) getView().findViewById(R.id.question_2);
        scoreBoard = (TextView) getView().findViewById(R.id.cur_score_2);
        rb1 = (RadioButton) getView().findViewById(R.id.var_a_2);
        rb2 = (RadioButton) getView().findViewById(R.id.var_b_2);
        rb3 = (RadioButton) getView().findViewById(R.id.var_v_2);
        rb4 = (RadioButton) getView().findViewById(R.id.var_g_2);

            name.setText(AppActivity.name2String);

            try {
                SQLiteOpenHelper helper = new DBHelper(getView().getContext());
                SQLiteDatabase db = helper.getReadableDatabase();
                Cursor cursor1 = db.query("APPTABLE", new String[]{"COUNT(_id) AS countOfQ"}, "STAT = ? AND THEME = ?", new String[] {Integer.toString(0), Integer.toString(MainActivity.tema)}, null, null, null);
                if (cursor1.moveToFirst())
                    countRandom = cursor1.getInt(0);
                Cursor cursor = db.query("APPTABLE", new String[]{"QUES", "VARS"}, "STAT = ? AND THEME = ?", new String[] {Integer.toString(0), Integer.toString(MainActivity.tema)}, null, null, null);
                Random random = new Random();
                if (cursor.moveToPosition(random.nextInt(countRandom))) {
                    str_q_2 = cursor.getString(0);
                    String ansText = cursor.getString(1);

                    StringTokenizer st = new StringTokenizer(ansText, "#");
                    int i = 0;
                    while (st.hasMoreTokens()) {
                        mas_2[i] = st.nextToken().toString();
                        i++;
                    }

                    ContentValues value = new ContentValues();
                    value.put("STAT", 1);
                    db.update("APPTABLE", value, "QUES=?", new String[]{str_q_2});
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
            ques.setText(str_q_2);
            rb1.setText(mas_2[0]);
            rb2.setText(mas_2[1]);
            rb3.setText(mas_2[2]);
            rb4.setText(mas_2[3]);
            rb1.setChecked(false);
            rb2.setChecked(false);
            rb3.setChecked(false);
            rb4.setChecked(false);
            scoreBoard.setText(AppActivity.cur2+"/"+AppActivity.total);
    }

}
