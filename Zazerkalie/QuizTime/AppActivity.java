package com.zazerk.lie.successapp;



        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteException;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.os.Bundle;
        import android.os.SystemClock;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioGroup;
        import android.widget.Toast;

public class AppActivity extends Activity {

    public static String name1String;
    public static String name2String;
    public static int score1=0;
    public static int score2=0;
    public static int cur1=1;
    public static int cur2=1;
    public static int total = 10;
    public static PlayerFragment frag1;
    public static Player2Fragment frag2;
    public static boolean running;
    public static int seconds;
    public static Context context;
    public static int maxSeconds = 30;
    public static Button but2;
    public static Button but1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        but2 = (Button) findViewById(R.id.button_dalee_2);
        but1 = (Button) findViewById(R.id.button_dalee);
        context = this;
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
        boolean netOtveta = false;
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
            Toast t = Toast.makeText(this, "База данных не доступна", Toast.LENGTH_SHORT);
            t.show();
            t.getView().setRotationX(180);
            t.getView().setRotationY(180);
            t.setGravity(0,-0,-630);
        }

        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group);
        int id = rg.getCheckedRadioButtonId();
        switch(id) {
            case R.id.var_a:
                if (ansText.equals("а")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score1++;
                    t.show();
                    t.getView().setRotationX(180);
                    t.getView().setRotationY(180);
                    t.setGravity(0,-0,-630);
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                    t.getView().setRotationX(180);
                    t.getView().setRotationY(180);
                    t.setGravity(0,-0,-630);
                }
                cur1++;
                break;
            case R.id.var_b:
                if (ansText.equals("б")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score1++;
                    t.show();
                    t.getView().setRotationX(180);
                    t.getView().setRotationY(180);
                    t.setGravity(0,-0,-630);
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                    t.getView().setRotationX(180);
                    t.getView().setRotationY(180);
                    t.setGravity(0,-0,-630);
                }
                cur1++;
                break;
            case R.id.var_v:
                if (ansText.equals("в")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score1++;
                    t.show();
                    t.getView().setRotationX(180);
                    t.getView().setRotationY(180);
                    t.setGravity(0,-0,-630);
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                    t.getView().setRotationX(180);
                    t.getView().setRotationY(180);
                    t.setGravity(0,-0,-630);
                }
                cur1++;
                break;
            case R.id.var_g:
                if (ansText.equals("г")){
                    Toast t = Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT);
                    score1++;
                    t.show();
                    t.getView().setRotationX(180);
                    t.getView().setRotationY(180);
                    t.setGravity(0,-0,-630);
                } else {
                    Toast t = Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT);
                    t.show();
                    t.getView().setRotationX(180);
                    t.getView().setRotationY(180);
                    t.setGravity(0,-0,-630);
                }
                cur1++;
                break;
            default:
                Toast t = Toast.makeText(this, "Вариант ответа не выбран", Toast.LENGTH_SHORT);
                t.show();
                t.getView().setRotationX(180);
                t.getView().setRotationY(180);
                t.setGravity(0,-0,-630);
                netOtveta = true;
        }
        SystemClock.sleep(500);
        if (!netOtveta) {
            if (cur1 == total + 1) {
                result();
            } else {
                frag1.setInfo();
            }
        }
    }

    public void onDalee2(View v) {
        boolean netOtveta = false;
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

        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group_2);
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
                cur2++;
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
                cur2++;
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
                cur2++;
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
                cur2++;
                break;
            default:
                Toast t = Toast.makeText(this, "Вариант ответа не выбран", Toast.LENGTH_SHORT);
                t.show();
                netOtveta = true;
        }
        SystemClock.sleep(500);
        if (!netOtveta) {
            if (cur2 == total + 1) {
                result2();
            } else {
                frag2.setInfo();
            }
        }
   }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }


    public void result() {
        Button but = (Button) findViewById(R.id.button_dalee);
        but.setClickable(false);
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
        Button but = (Button) findViewById(R.id.button_dalee_2);
        but.setClickable(false);
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









