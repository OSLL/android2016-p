package com.example.user.myapplication;

import android.app.ListActivity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.util.ArrayList;

/**
 * Created by user on 6/3/2016.
 */
class DrawThread extends Thread{
    private boolean runFlag = false;
    double speed_a = 0.1;
    private SurfaceHolder surfaceHolder;
    private Bitmap picture;
    private Matrix matrix;
    private long prevTime;
    private DrawingView dView;
    private float x=100, y=100;
    public DrawThread(SurfaceHolder surfaceHolder, DrawingView dView){
        this.surfaceHolder = surfaceHolder;
        this.dView = dView;
    }

    Ball mBall;

    public void setRunning(boolean run) {
        runFlag = run;
    }
    public void sendEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
           mBall.speed = -15;
        }
    }

    float getCurrentTime(float lastTime)
    {
        return (System.nanoTime() - lastTime) / 100f;
    }


    @Override
    public void run() {
        Canvas canvas = null;
        boolean ifmore = false;


        while (runFlag) {
            try {
                ArrayList<Figurs> figurses = new ArrayList<>();
                float time = System.nanoTime();
                canvas = surfaceHolder.lockCanvas(null);
                //DrawingView.currentDrawingView.


                synchronized (surfaceHolder)
                {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                    time = System.nanoTime();
                    if(!ifmore)
                    {
                        mBall = new Ball(new Vector2d((float)canvas.getHeight()/2, (float)400), Color.RED);
                        mBall.pos = new Vector2d(canvas.getWidth()/2, 0);
                        ifmore = true;
                    }

                    FObj krug = new FObj(0, 300, 300, 0, 0, 1.5f);
                    krug.draw(canvas, getCurrentTime(time));



                }
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            finally {
                if(canvas != null)
                {
                  surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

        }
    }
}
