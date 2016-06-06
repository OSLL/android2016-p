package com.example.user.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

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
           mBall.setA(1);
        }
    }


    @Override
    public void run() {
        Canvas canvas = null;
        boolean ifmore = false;

        while (runFlag) {
            try {
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder)
                {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    if(!ifmore)
                    {
                        mBall = new Ball(new Vector2d((float)canvas.getHeight()/2, (float)400), Color.RED);
                        ifmore = true;
                    }
                    if(mBall.pos.getY() > canvas.getHeight() * 0.9)
                    {
                        mBall.pos.setY((float)(canvas.getHeight() * 0.9));
                    }

                    mBall.drawBall(canvas);

                    Figurs f = new Figurs();
                    f.DrawKrug(canvas);
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
