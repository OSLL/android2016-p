package com.example.user.newshooter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        TextView tw = (TextView) findViewById(R.id.textView);
        tw.setText("           "+SpaceShooterView.score);
    }
}
