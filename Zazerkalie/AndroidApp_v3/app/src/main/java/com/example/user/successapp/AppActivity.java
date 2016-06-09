package com.example.user.successapp;
/*PlayerFragment frag1 = (PlayerFragment) getFragmentManager().findFragmentById(R.id.frag1);
        PlayerFragment frag2 = (PlayerFragment) getFragmentManager().findFragmentById(R.id.frag2);
        frag1.setInfo(1);
        frag2.setInfo(2);*/


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

    public static TextView ques1;
    public static TextView ques2;
    public static TextView name1;
    public static TextView name2;
    private static String[] mas_1 = new String[4];
    private static String[] mas_2 = new String[4];
    private static RadioButton rb1;
    private static RadioButton rb2;
    private static RadioButton rb3;
    private static RadioButton rb4;
    private static RadioButton rb1_2;
    private static RadioButton rb2_2;
    private static RadioButton rb3_2;
    private static RadioButton rb4_2;
    public static String name1String;
    public static String name2String;
    private static boolean next1=true;
    private static boolean next2=true;
    public static String str_q_1;
    public static String str_q_2;
    public static TextView score1_TV;
    public static TextView score2_TV;
    public static int score1=0;
    public static int score2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        ques1 = (TextView) findViewById(R.id.question_textview);
        ques2 = (TextView) findViewById(R.id.question2_textview);
        name1 = (TextView) findViewById(R.id.name_textview);
        name2 = (TextView) findViewById(R.id.name2_textview);
        rb1 = (RadioButton) findViewById(R.id.var_a);
        rb2 = (RadioButton) findViewById(R.id.var_b);
        rb3 = (RadioButton) findViewById(R.id.var_v);
        rb4 = (RadioButton) findViewById(R.id.var_g);
        rb1_2 = (RadioButton) findViewById(R.id.var_a_2);
        rb2_2 = (RadioButton) findViewById(R.id.var_b_2);
        rb3_2 = (RadioButton) findViewById(R.id.var_v_2);
        rb4_2 = (RadioButton) findViewById(R.id.var_g_2);
        score1_TV = (TextView) findViewById(R.id.cur_score1);
        score2_TV = (TextView) findViewById(R.id.cur_score2);

        // Перевуертыши
        ques2.setRotationX(180);
        ques2.setRotationY(180);
        score2_TV.setRotationX(180);
        score2_TV.setRotationY(180);
        findViewById(R.id.dalee2_button).setRotationX(180);
        findViewById(R.id.dalee2_button).setRotationY(180);
        findViewById(R.id.radioGroup).setRotationX(180);
        findViewById(R.id.radioGroup).setRotationY(180);
        name2.setRotationX(180);
        name2.setRotationY(180);
        name1.setText(name1String);
        name2.setText(name2String);

        if (next1) {
            try {
                SQLiteOpenHelper helper = new DBHelper(this);
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
                    Toast t = Toast.makeText(this, "База данных пуста", Toast.LENGTH_SHORT);
                    t.show();
                }

                cursor.close();
                db.close();
            } catch (SQLiteException e) {
                Toast toast = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
                toast.show();
            }
            next1 = false;
        }
        ques1.setText(str_q_1);
        rb1.setText(mas_1[0]);
        rb2.setText(mas_1[1]);
        rb3.setText(mas_1[2]);
        rb4.setText(mas_1[3]);

        if (next2) {
            try {
                SQLiteOpenHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getReadableDatabase();
                Cursor cursor = db.query("APPTABLE", new String[]{"QUES", "VARS"}, "STAT = ?", new String[]{Integer.toString(0)}, null, null, null);
                //  Работает по первому false, нужно добавить рандом
                if (cursor.moveToFirst()) {
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
                    Toast t = Toast.makeText(this, "База данных пуста", Toast.LENGTH_SHORT);
                    t.show();
                }

                cursor.close();
                db.close();
            } catch (SQLiteException e) {
                Toast toast = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
                toast.show();
            }
            next2 = false;
        }
        ques2.setText(str_q_2);
        rb1_2.setText(mas_2[0]);
        rb2_2.setText(mas_2[1]);
        rb3_2.setText(mas_2[2]);
        rb4_2.setText(mas_2[3]);
        score1_TV.setText(Integer.toString(score1));
        score2_TV.setText(Integer.toString(score2));
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
        next1 = true;
        String ansText = "";
        try {
            SQLiteOpenHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("APPTABLE", new String[]{"ANS"}, "QUES = ?", new String[] {ques1.getText().toString()}, null, null, null);
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
                    score1++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.var_b:
                if (ansText.equals("б")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score1++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.var_v:
                if (ansText.equals("в")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score1++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.var_g:
                if (ansText.equals("г")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score1++;
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
        SystemClock.sleep(500);
        startActivity(intent);
    }

    public void onDalee2(View v) {
        next2 = true;
        String ansText = "";
        try {
            SQLiteOpenHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("APPTABLE", new String[]{"ANS"}, "QUES = ?", new String[] {ques2.getText().toString()}, null, null, null);
            if (cursor.moveToFirst()) {
                ansText = cursor.getString(0);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
            toast.show();
        }

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        int id = rg.getCheckedRadioButtonId();
        switch(id) {
            case R.id.var_a_2:
                if (ansText.equals("а")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score2++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.var_b_2:
                if (ansText.equals("б")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score2++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.var_v_2:
                if (ansText.equals("в")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score2++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.var_g_2:
                if (ansText.equals("г")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score2++;
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
        SystemClock.sleep(500);
        startActivity(intent);
    }
}









