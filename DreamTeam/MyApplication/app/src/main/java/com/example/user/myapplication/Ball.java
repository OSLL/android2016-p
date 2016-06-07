package com.example.user.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by user on 6/3/2016.
 */
public class Ball {
    float speed = 0;
    int radius = 20;
    Vector2d pos;
    int color;
    boolean up = false;
    float acs = 0.0000045f;

    Ball(Vector2d pos, int color)
    {
        this.pos = pos;
        this.color = color;
    }


    public void drawBall(Canvas canvas, float time)
    {

        speed += acs*time;
        pos.setY(pos.getY()+speed);
        if(pos.getY() - radius > canvas.getHeight())
            pos.setY(canvas.getHeight() - radius);
        Paint p = new Paint();
        p.setColor(color);
        canvas.drawCircle(pos.getX(), pos.getY(), radius, p);
    }

    void setY(float y)
    {
        Log.d("ADD", pos.toString());
        pos.setY(y);
        Log.d("ADD", pos.toString());
        Log.d("ADD", y+"");
    }

    void update(ArrayList<Figurs> figurses)
    {
        ;
    }

    public static Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
    }

    int getNearColor()
    {
        DrawingView.getCurrentDrawingView().buildDrawingCache();
        return DrawingView.getCurrentDrawingView().getDrawingCache().getPixel(100, 100);

        //DrawingView.currentDrawingView.buildDrawingCache();
        //return DrawingView.currentDrawingView.getDrawingCache(true).getPixel(100, 140);
    }

    void setA(int a)
    {
        up = true;
    }
}
