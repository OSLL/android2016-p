package com.example.user.myapplication;


import android.content.Context;
import android.util.EventLog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawingView extends SurfaceView implements SurfaceHolder.Callback {


    MotionEvent event = null;

    void setEvent(MotionEvent event)
    {
        this.event = event;
        drawThread.sendEvent(event);
    }

    DrawThread drawThread;
     public DrawingView(Context context) {
         super(context);
         getHolder().addCallback(this);
     }

     @Override
     public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

     }

     @Override
     public void surfaceCreated(SurfaceHolder holder) {
         drawThread = new DrawThread(getHolder(), this);
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