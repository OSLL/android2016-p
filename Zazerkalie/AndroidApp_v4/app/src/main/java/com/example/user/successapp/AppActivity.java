package com.example.user.successapp;



        import android.app.Activity;
        import android.app.FragmentTransaction;
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

    public static String name1String;
    public static String name2String;
    public static int score1=0;
    public static int score2=0;
    public static int cur1=1;
    public static int cur2=1;
    public static int total =3;
    public static PlayerFragment frag1;
    public static Player2Fragment frag2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        frag1 = (PlayerFragment) getFragmentManager().findFragmentById(R.id.frag1);
        frag1.setInfo();
        frag2 = (Player2Fragment) getFragmentManager().findFragmentById(R.id.frag2);
        frag2.setInfo();
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
            Cursor cursor = db.query("APPTABLE", new String[]{"ANS"}, "QUES = ?", new String[] {PlayerFragment.str_q_1}, null, null, null);
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
                cur1++;
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
                cur1++;
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
                cur1++;
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
                cur1++;
                break;
            default:
                Toast t = Toast.makeText(this, "Вариант ответа не выбран", Toast.LENGTH_SHORT);
                t.show();
        }
        SystemClock.sleep(500);
        if (cur1 == total+1) {
            result();
        } else {
            frag1.setInfo();
        }
    }

    public void onDalee2(View v) {
        String ansText = "";
        try {
            SQLiteOpenHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("APPTABLE", new String[]{"ANS"}, "QUES = ?", new String[] {Player2Fragment.str_q_2}, null, null, null);
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
                    score2++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                cur2++;
                break;
            case R.id.var_b:
                if (ansText.equals("б")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score2++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                cur2++;
                break;
            case R.id.var_v:
                if (ansText.equals("в")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score2++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                cur2++;
                break;
            case R.id.var_g:
                if (ansText.equals("г")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score2++;
                    t.show();
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                }
                cur2++;
                break;
            default:
                Toast t = Toast.makeText(this, "Вариант ответа не выбран", Toast.LENGTH_SHORT);
                t.show();
        }
        SystemClock.sleep(500);

        if (cur2 == total+1) {
            result2();
        } else {
            frag2.setInfo();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }


    public void result() {
        PlayerFragment.ques.setText("Тест завершен!");
        PlayerFragment.rb1.setClickable(false);
        PlayerFragment.rb2.setClickable(false);
        PlayerFragment.rb3.setClickable(false);
        PlayerFragment.rb4.setClickable(false);
        PlayerFragment.rb1.setText("");
        PlayerFragment.rb2.setText("");
        PlayerFragment.rb3.setText("");
        PlayerFragment.rb4.setText("");
        PlayerFragment.rb1.setChecked(false);
        PlayerFragment.rb2.setChecked(false);
        PlayerFragment.rb3.setChecked(false);
        PlayerFragment.rb4.setChecked(false);
        PlayerFragment.scoreBoard.setText(AppActivity.total+"/"+AppActivity.total);
        PlayerFragment.result = true;

        if (PlayerFragment.result && Player2Fragment.result) {
            Intent intent = new Intent(this, NumActivity.class);
            intent.putExtra("two", true);
            startActivity(intent);
        }
    }

    public void result2() {
        Player2Fragment.ques.setText("Тест завершен!");
        Player2Fragment.rb1.setClickable(false);
        Player2Fragment.rb2.setClickable(false);
        Player2Fragment.rb3.setClickable(false);
        Player2Fragment.rb4.setClickable(false);
        Player2Fragment.rb1.setText("");
        Player2Fragment.rb2.setText("");
        Player2Fragment.rb3.setText("");
        Player2Fragment.rb4.setText("");
        Player2Fragment.rb1.setChecked(false);
        Player2Fragment.rb2.setChecked(false);
        Player2Fragment.rb3.setChecked(false);
        Player2Fragment.rb4.setChecked(false);
        Player2Fragment.scoreBoard.setText(AppActivity.total+"/"+AppActivity.total);
        Player2Fragment.result = true;

        if (PlayerFragment.result && Player2Fragment.result) {
            Intent intent = new Intent(this, NumActivity.class);
            intent.putExtra("two", true);
            startActivity(intent);
        }
    }
}









