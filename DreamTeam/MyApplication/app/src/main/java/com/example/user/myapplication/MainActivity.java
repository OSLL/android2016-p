package com.example.user.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MotionEvent;


class MainActivity extends Activity {
    public static Context context;
    public static Bitmap backGround;
    DrawingView dView;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Resources res = getResources();
        //context = this;
        backGround = BitmapFactory.decodeResource(getResources(), R.drawable.back);
        dView = new DrawingView(this, backGround);
        setContentView(dView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dView.setEvent(event);
        return true;
    }
}
