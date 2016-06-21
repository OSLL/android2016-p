package com.example.user.superdupershooter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by user on 6/21/2016.
 */
public class InfoClass extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
       // Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.info_text);
        setContentView(new MenuView(this, this));
    }
}
