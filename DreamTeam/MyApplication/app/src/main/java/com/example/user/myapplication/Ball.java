package com.example.user.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by user on 6/3/2016.
 */
public class Ball {
    float speed = 10;
    int radius = 20;
    Vector2d pos;
    int color;
    boolean up = false;
    float a = 10f;

    Ball(Vector2d pos, int color)
    {
        this.pos = pos;
        this.color = color;
    }

    public void drawBall(Canvas canvas)
    {
        Log.d("DRAW", up+"");
        if(up)
        {
            if(speed < 0)
            {
                up = false;
            }
            else {
                speed -= 10 * a;
                pos.setY(pos.getY() + speed);
            }
        }
        else{
            if(speed != 10)
                speed += a;
            pos.setY(pos.getY() + speed);


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
