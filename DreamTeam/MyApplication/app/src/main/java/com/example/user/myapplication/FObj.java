package com.example.user.myapplication;

import android.graphics.Canvas;

/**
 * Created by user on 6/7/2016.
 */
public class FObj {
    private Canvas c;
    float Center_x, Center_y, Width, Height;
    int id;

    float s;
    public FObj(int id, float x, float y, float w, float h, float s) {
         Center_x = x;
        Center_y = y;
        Width = w;
         Height = h;
        this.id = id;
        this.s = s;

    }
    public void draw(Canvas c, float Time)
    {
        Figurs f = new Figurs();
        c.save();

        switch(id)
        {
            case 0:
                f.DrawKrug(c, s, Center_x, Center_y);
                break;
            case 1:
                f.DrawTriangle(c,(int)Center_x, (int)Center_y);
                break;
            case 2:
                f.DrawSquare(c,(int)Center_x, (int)Center_y);
                break;
            case 3:
                f.DrawRomb(c,(int)Center_x, (int)Center_y);
                break;
            case 4:
                f.DrawBlock(c,(int)Center_x, (int)Center_y);
                break;
            case 5:
                f.DrawOval(c,(int)Center_x, (int)Center_y);
                break;
            /*case 6:
                f.DrawStar(c,(int)Center_x, (int)Center_y);
                break;*/
        }

    }

}
