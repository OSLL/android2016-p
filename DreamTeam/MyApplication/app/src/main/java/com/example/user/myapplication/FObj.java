package com.example.user.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class FObj {
    static final float TIME_FOR_ROTATE = 9000000f;
    final float rotateSpeed = 50;
    private Canvas c;
    float Center_x, Center_y, Width, Height;
    int id;
    float radius;
    Ball ball ;
    float  ring_wid;
    float where = 1;
    int color;


    void setColor(int color)
    {
        this.color = color;
    }

    float s;
    public FObj(int id, float x, float y, float w, float h, float s, Ball mBall) {
         Center_x = x;
        Center_y = y;
        Width = w;
         Height = h;
        this.id = id;
        this.s = s;
        radius =100*s;
        ring_wid = radius * 0.1f;
        ball = mBall;
    }
    public void draw(Canvas c, float time, int where)
    {
        this.where = where;
        Figurs f = new Figurs();
        c.save();
        float angle = rotateSpeed * time / TIME_FOR_ROTATE;
        c.rotate(angle * where, Center_x, Center_y);

        switch(id)
        {
            case 0:
                f.DrawKrug(c, s, Center_x, Center_y, true);
                break;
            case 1:
                f.DrawTriangle(c,(int)Center_x, (int)Center_y, 100, "","","");
                break;
            case 2:
                f.DrawSquare(c,(int)Center_x, (int)Center_y, 100);
                break;
            case 3:
                f.DrawRomb(c,(int)Center_x, (int)Center_y, 100);
                break;
            case 4:
                c.rotate(-angle * where, Center_x, Center_y);
                f.DrawBlock(c,(int)Center_x, (int)Center_y, color);
                break;
            case 5:
                f.DrawOval(c,(int)Center_x, (int)Center_y);
                break;
            case 6:
                f.DrawStar(c,(int)Center_x, (int)Center_y);
                break;
        }
        c.restore();

    }


    boolean under()
    {
        return  ball.pos.getY() > Center_y && Math.abs( ball.pos.getY() - Center_y) < ball.radius + radius && Math.abs(Center_y - ball.pos.getY()) > radius - ring_wid - ball.radius;
    }
    boolean inRing()
    {
        return Math.abs(Center_y - ball.pos.getY()) < radius - ring_wid - ball.radius;
    }
    boolean upper()
    {
        return ball.pos.getY() < Center_y && Math.abs( ball.pos.getY() - Center_y) < ball.radius + radius && Math.abs(Center_y - ball.pos.getY()) > radius - ring_wid - ball.radius;
    }

    boolean ballBetween(float left, float right)
    {
        return left + ball.radius < ball.pos.getX() && ball.pos.getX() < right - ball.radius;

    }

    float len()
    {
        return (float)Math.abs(Center_y - ball.pos.getY());
    }

        boolean update(Canvas canvas, float time)
        {
            Figurs f = new Figurs();
            int ball_color = ball.color;
            switch (id) {
                case 0:

                    String currentColor = "";

                    if (ball_color == f.int_colors.get("pink")) {
                        currentColor = "pink";
                    } else if (ball_color == f.int_colors.get("lblue")) {
                        currentColor = "lblue";
                    } else if (ball_color == f.int_colors.get("yellow")) {
                        currentColor = "yellow";
                    } else if (ball_color == f.int_colors.get("fiol")) {
                        currentColor = "fiol";
                    }

                    float angle = rotateSpeed * time / TIME_FOR_ROTATE;
                    angle %= 360;
                    angle = angle * (float) Math.PI / 180;

                    float sin = (float) Math.sin(angle);//* where;
                    float cos = (float) Math.cos(angle);

                    ArrayList<Vector2d> dots = new ArrayList<>();

                    dots.add(new Vector2d(Center_x + radius * cos, Center_y + 2 * radius));
                    dots.add(new Vector2d(Center_x - radius * sin, Center_y + 2 * radius));
                    dots.add(new Vector2d(Center_x - radius * cos, Center_y + 2 * radius));
                    dots.add(new Vector2d(Center_x + radius * sin, Center_y + 2 * radius));

                    HashMap<String, Pair> sectors = new HashMap<>();

                    sectors.put("fiol", new Pair(dots.get(0), dots.get(1)));
                    sectors.put("lblue", new Pair(dots.get(1), dots.get(2)));
                    sectors.put("yellow", new Pair(dots.get(2), dots.get(3)));
                    sectors.put("pink", new Pair(dots.get(3), dots.get(0)));

                    Paint p = new Paint();

                    p.setStrokeWidth(20);

                    // p.setColor(Color.RED);
                    float left = sectors.get(currentColor).elem1.getX();
                    float right = sectors.get(currentColor).elem2.getX();
                    //canvas.drawPoint(left,sectors.get(currentColor).elem1.getY(), p);
                    // p.setColor(Color.BLUE);
                    //canvas.drawPoint(right ,sectors.get(currentColor).elem2.getY(), p);


                    if (under()) {

                        if (!ballBetween(left, right))
                            return false;//ball.setY(canvas.getHeight() - ball.radius);
                    } else if (upper()) {
                        if (!ballBetween(right, left))
                            return false;//ball.setY(canvas.getHeight() - ball.radius);
                    } else if (inRing()) {
                        if (ball.pos.getY() >= Center_y) {
                            if (len() > radius - ring_wid - ball.radius && !ballBetween(left, right))
                                return false;//ball.setY(canvas.getHeight() - ball.radius);
                        } else if (len() > radius - ring_wid - ball.radius && !ballBetween(right, left))
                            return false;//ball.setY(canvas.getHeight() - ball.radius);
                    } else if (upper()) {
                        if (!ballBetween(right, left))
                            return false;//ball.setY(canvas.getHeight() - ball.radius);
                    }
                    break;
                case 4:
                    float h = canvas.getHeight() / 95;
                    float w = canvas.getWidth()/6;
                    Center_x += 5;
                    if(Center_x - canvas.getWidth() / 6 >= canvas.getWidth())
                        Center_x = -canvas.getWidth()/6;
                    if(ball_color == color)
                    {
                        if(len() < h/2 + ball.radius && !ballBetween(Center_x - w , Center_x + w))
                           return false;//ball.setY(canvas.getHeight() - ball.radius);

                    }
            }



            return true;
        }

}
