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
    public float delta = 0;
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
        if(up)
        {

            speed += acs*time;
            delta = speed;
            pos.setY(pos.getY()+speed);
            if(pos.getY() - radius > canvas.getHeight())
            {
                pos.setY(canvas.getHeight() - radius);
                up = false;
            }
        }
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




    void setA(int a)
    {
        up = true;
    }
}
