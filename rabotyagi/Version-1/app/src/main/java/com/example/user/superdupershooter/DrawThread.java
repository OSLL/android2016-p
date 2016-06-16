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

    private int plength, pheight, spaceh, spacew;


    private ArrayList<Rect> platforms;
    private Bitmap player_pic;



    public DrawThread(Context context, SurfaceHolder surfaceHolder,  int width, int height, Activity activity, Bitmap player_pic) {
        this.surfaceHolder = surfaceHolder;
        this.width = width;
        this.height = height;
        this.player_pic = player_pic;
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
                    Draw(canvas);
                    Update();
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
        pheight = height / 40;
        plength = width / 8;
        spacew = width / 16;
        spaceh = height / 3;




        platforms.add(new Rect(width / 16, height /2 , width / 16 + width / 8, height / 2 + height / 40));

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
            platforms.get(i).left = platforms.get(i).left - 20;
            platforms.get(i).right = platforms.get(i).right - 20;
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

        //draw player
        Rect player_rect;
        player_rect = new Rect(width / 16, height/ 2 - width /10, width / 16 + width / 10, height / 2);
        canvas.drawBitmap(player_pic, null, player_rect, paint);

    }


}




