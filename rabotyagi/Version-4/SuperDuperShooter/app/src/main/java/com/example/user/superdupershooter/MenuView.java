package com.example.user.superdupershooter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by user on 6/21/2016.
 */
public class MenuView extends SurfaceView implements SurfaceHolder.Callback {

    private int width;
    private int height;
    private Bitmap background, sound, records, info, home;
    private Canvas canvas;
    private Rect rect, rect_button1, rect_button2, rect_button3;
    private Paint paint;
    private Menu activity;
    private Activity activity2;
    private int view;


    public MenuView(Context context, Bitmap background, Bitmap button1, Bitmap button2, Bitmap button3, Menu activity) {
        super(context);
        getHolder().addCallback(this);
        this.background = background;
        sound = button1;
        records = button2;
        info = button3;
        this.activity = activity;
        SurfaceHolder surfaceHolder = getHolder();
        view = 1;


    }

    public MenuView(Context context, Activity activity2) {
        super(context);
        getHolder().addCallback(this);
        this.background = BitmapFactory.decodeResource(getResources(), R.drawable.info_text);
        this.activity2 = activity2;
        this.home = BitmapFactory.decodeResource(getResources(), R.drawable.home_pic);
        SurfaceHolder surfaceHolder = getHolder();
        view = 2;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.width = width;
        this.height = height;
        //this.background = background;

        rect = new Rect(0, 0, width, height);
        rect_button1 = new Rect(width / 20, 4 * height / 5, width / 20 + height / 7, 4 * height / 5 + height / 7);

        if (view == 1) {

            rect_button3 = new Rect(width - (width / 20 + height / 7), 4 * height / 5, width - width / 20, 4 * height / 5 + height / 7);
            rect_button2 = new Rect(width - 2 * (width / 20 + height / 7), 4 * height / 5, width - width / 10 - height / 7, 4 * height / 5 + height / 7);
        }


        canvas = null;
        try {
            canvas = holder.lockCanvas();
            if (view == 1) {

                canvas.drawBitmap(background, null, rect, paint);
                canvas.drawBitmap(info, null, rect_button1, paint);
                canvas.drawBitmap(records, null, rect_button3, paint);
                canvas.drawBitmap(sound, null, rect_button2, paint);
            } else if (view == 2) {
                canvas.drawBitmap(background, null, rect, paint);
                canvas.drawBitmap(home, null, rect_button1, paint);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }

            // canvas.drawBitmap(monster_pic, null, monsters.get(i), paint);

        }


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public boolean onTouchEvent(MotionEvent event) {
        if (view == 1) {
            if ((int) event.getX() >= width / 20 && (int) event.getX() <= width / 20 + height / 7
                    && (int) event.getY() >= 4 * height / 5 && (int) event.getY() <= 4 * height / 5 + height / 7) {
                activity.showinfo();

            } else {
                activity.startgame();
            }
        } else if (view == 2) {
            if ((int) event.getX() >= width / 20 && (int) event.getX() <= width / 20 + height / 7
                    && (int) event.getY() >= 4 * height / 5 && (int) event.getY() <= 4 * height / 5 + height / 7) {
                activity2.finish();
            }


        }
        return false;
    }
}