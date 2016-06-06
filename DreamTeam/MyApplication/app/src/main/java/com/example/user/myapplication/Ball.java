package com.example.user.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

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

    void setA(int a)
    {
        up = true;
    }
}
