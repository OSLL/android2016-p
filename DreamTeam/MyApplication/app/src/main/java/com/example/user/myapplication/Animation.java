package com.example.user.myapplication;

import android.graphics.Canvas;

/**
 * Created by user on 6/6/2016.
 */
public class Animation {
    static final float TIME_FOR_ROTATE = 9000000f;
    public static void drawRotatedKrug(Canvas canvas, float time, Figurs figurs)
    {
        canvas.save();

        canvas.rotate(time / TIME_FOR_ROTATE, canvas.getWidth()/2, canvas.getHeight()/2);
        //figurs.DrawKrug(canvas);
        canvas.restore();
    }

}
