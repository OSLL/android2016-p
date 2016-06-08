package com.example.user.myapplication;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.EventLog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class DrawingView extends SurfaceView implements SurfaceHolder.Callback {

    public static View currentDrawingView;
    MotionEvent event = null;
    Bitmap res;

    void setEvent(MotionEvent event)
    {
        this.event = event;
        drawThread.sendEvent(event);
    }

    DrawThread drawThread;
     public DrawingView(Context context, Bitmap res) {
         super(context);
         this.setDrawingCacheEnabled(true);
         getHolder().addCallback(this);
         currentDrawingView = this;
         this.res = res;
     }

     @Override
     public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

     }

    public static View getCurrentDrawingView()
    {
        return currentDrawingView;
    }


     @Override
     public void surfaceCreated(SurfaceHolder holder) {
         currentDrawingView = this;

         drawThread = new DrawThread(getHolder(), this, res);
         drawThread.setRunning(true);
         drawThread.start();
     }

     @Override
     public void surfaceDestroyed(SurfaceHolder holder) {
         boolean retry = true;
         drawThread.setRunning(false);
         while (retry) {
             try {
                 drawThread.join();
                 retry = false;
             } catch (InterruptedException e) {
                    e.printStackTrace();
             }
         }

     }
 }