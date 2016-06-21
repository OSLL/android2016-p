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

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outHeight = 10;
        options.outWidth = 10;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.player,options);
        Bitmap picc = BitmapFactory.decodeResource(getResources(), R.drawable.monster,options);
        Bitmap background_game1 = BitmapFactory.decodeResource(getResources(), R.drawable.background_game1);
        Bitmap background_game2 = BitmapFactory.decodeResource(getResources(), R.drawable.background_game2);
        Bitmap background_game3 = BitmapFactory.decodeResource(getResources(), R.drawable.background_game3);
        Bitmap background_game4 = BitmapFactory.decodeResource(getResources(), R.drawable.background_game4);
        Bitmap background_game5 = BitmapFactory.decodeResource(getResources(), R.drawable.background_game5);
        setContentView(new DrawView(this, this , pic, picc, background_game1,background_game2,background_game3,background_game4,background_game5));
    }
}
