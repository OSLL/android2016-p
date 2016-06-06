package com.example.user.myapplication;

import android.graphics.Canvas;

/**
 * Created by user on 6/6/2016.
 */
public class Animation {
    static final float TIME_FOR_ROTATE = 9000000f;
    public static void drawRotatedKrug(Canvas canvas, float time, Figurs figurs, float s, float x, float y, int where)
    {
        canvas.save();

        canvas.rotate(where * time / TIME_FOR_ROTATE, x, y);
        figurs.DrawKrug(canvas, s, x, y);
        canvas.restore();
    }

}
