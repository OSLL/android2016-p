package com.example.user.superdupershooter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 6/16/2016.
 */
public class DrawThread extends Thread implements Runnable{

    private SurfaceHolder surfaceHolder;
    private volatile boolean running = true;//флаг для остановки потока
    private Paint paint = new Paint();

    private int width;
    private int height;

    final Random random = new Random();

    Rect player_rect;

    private int plength, pheight, spaceh, spacew;

    private int y, y0;
    private int a = 7;
    private int v;
    private int move;
    private float t;
    private  int k = 0;

    private Activity activity;

    private int flag;
    private boolean flag_ready = false;
    private int luft = height / 5;

    private int touch_x;

    private int bJ = 0;


    private ArrayList<Rect> platforms;
    private Bitmap player_pic;



    public DrawThread(Context context, SurfaceHolder surfaceHolder,  int width, int height, Activity activity, Bitmap player_pic) {
        this.surfaceHolder = surfaceHolder;
        this.width = width;
        this.height = height;
        this.player_pic = player_pic;
        this.activity = activity;
        y = height / 2;
        y0 = y;
        player_rect = new Rect(width / 16, height/ 2 - width /10, width / 16 + width / 10, height / 2);
    }


    public void requestStop() {
        running = false;
    }


    public void run() {
        MapCreate();
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {

                    Flying();
                    Landing();
                    Update();
                    Draw(canvas);


                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public void MapCreate(){
        platforms = new ArrayList<>();
        Rect rect;
        int randh, randznak;
        pheight = height / 20;
        plength = width / 5 ;
        spacew = width / 30;
        spaceh = height / 4;




        platforms.add(new Rect(width / 16, height /2 , width / 16 + width / 5, height / 2 + height / 20));

        for (int i = 1; i < 1500; i++)
        {
            randh = random.nextInt(spaceh);
            randznak = random.nextInt(2);
            if (randznak == 1) {
                if (platforms.get(i - 1).bottom + randh < 39 * height / 40) {
                    rect = new Rect(platforms.get(i - 1).right + spacew, platforms.get(i - 1).top + randh,
                            platforms.get(i - 1).right + spacew + plength, platforms.get(i - 1).top + randh + pheight);

                    platforms.add(rect);
                }
                else{
                    rect = new Rect(platforms.get(i - 1).right + spacew, 3 * height / 4,
                            platforms.get(i - 1).right + spacew + plength, 3 * height / 4 + pheight);

                    platforms.add(rect);

                }

            }
            else
            {
                if (platforms.get(i - 1).top - randh > height / 10) {
                    rect = new Rect(platforms.get(i - 1).right + spacew, platforms.get(i - 1).top - randh,
                            platforms.get(i - 1).right + spacew + plength, platforms.get(i - 1).top - randh + pheight);

                    platforms.add(rect);
                }
                else
                {
                    rect = new Rect(platforms.get(i - 1).right + spacew, height / 4,
                            platforms.get(i - 1).right + spacew + plength, height / 4 + pheight);

                    platforms.add(rect);
                }
            }

        }
    }

    public void Update()
    {
        for (int i = 0; i < platforms.size(); i++)
        {
            platforms.get(i).left = platforms.get(i).left - move;
            platforms.get(i).right = platforms.get(i).right - move;
        }

        k = 0;

        for (int i = 0; i < platforms.size(); i++)
        {
            if (platforms.get(i).left < 0)
                k += 1;
        }
    }


    public void Flying()
    {
        flag = 0;
        for (int i = 0; i < platforms.size(); i++)
        {
            if (platforms.get(i).top == y)
            {
                if (player_rect.left + width / 20 <= platforms.get(i).right && player_rect.left + width / 20 >= platforms.get(i).left)
                {
                    flag = 1;
                    t = 0;
                    y = platforms.get(i).top;
                    if (bJ == 1) {
                        y -= v;

                    }
                }
            }
        }

        if (flag != 1)
        {
            if (bJ != 0)
            {
                y = y - v;
            }
            t += 0.1;
            y = y + (int)Math.ceil(a * t * t / 2);
            player_rect.bottom = y;
            player_rect.top = y - width / 10;



        }

    }

    public void Landing()
    {
        if (flag == 0) {
            for (int i = 0; i < platforms.size(); i++)
            {
                if (platforms.get(i).top > player_rect.top && platforms.get(i).top < player_rect.bottom && player_rect.left + width / 20 <= platforms.get(i).right
                        && player_rect.left + width / 20 >= platforms.get(i).left  )
                {
                    if (y0 <= platforms.get(i).top)
                    {
                        if (bJ == 1)
                        {
                            y -=  v;

                        }
                        y = platforms.get(i).top;
                        player_rect.bottom = y;
                        player_rect.top = y - width / 10;
                        bJ = 0;
                        break;

                    }
                }
            }

        }
        Log.i("vars",  "y - y0 = " + (y - y0) + "  width = " + (width / 10 + height / 40));
        y0 = y;
    }


    public void Touch(int touch_x)
    {
        if (flag_ready == false)
        {
            flag_ready = true;
            a = 7;
            move = 7;
        }

        this.touch_x = touch_x;
        if (flag != 0) bJ = 1;
        if (touch_x < width / 2)
        {
            v = 11;
        }
        else
        {
            v = 20;
        }
    }

    public void Draw(Canvas canvas){

        //draw background
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, width, height, paint);




        //draw Map
        paint.setColor(Color.BLACK);
        for (int i = 0; i < platforms.size(); i++)
        {
            canvas.drawRect(platforms.get(i).left, platforms.get(i).top, platforms.get(i).right, platforms.get(i).bottom, paint);
        }

        //buttons
        paint.setTextSize(35.0f); // значение типа float
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(String.valueOf(k), 100, 100, paint);


        //draw player
        //player_rect = new Rect(width / 16, height/ 2 - width /10, width / 16 + width / 10, height / 2);
        canvas.drawBitmap(player_pic, null, player_rect, paint);

        if (y > height)
        {
            activity.finish();
        }

        //checking if ready
        if (flag_ready == false)
        {
            paint.setAntiAlias(true);
            paint.setTextSize(65.0f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(Color.MAGENTA);
            canvas.drawText("TAP IF YOU ARE READY", 250, 100, paint);

        }









    }


}




