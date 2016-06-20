package com.example.user.superdupershooter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by user on 6/16/2016.
 */
public class Survival extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        Bitmap picc = BitmapFactory.decodeResource(getResources(), R.drawable.monster);
        setContentView(new DrawView(this, this , pic, picc));
    }
}
