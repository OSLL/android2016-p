package com.example.user.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;


class MainActivity extends Activity {

    DrawingView dView;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dView = new DrawingView(this);
        setContentView(dView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dView.setEvent(event);
        return true;
    }
}
