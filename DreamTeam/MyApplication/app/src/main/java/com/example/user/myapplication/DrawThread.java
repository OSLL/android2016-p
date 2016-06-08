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
    private Bitmap canvasState;
    private float x=100, y=100;
    Resources res;
    public DrawThread(SurfaceHolder surfaceHolder, DrawingView dView, Bitmap res){
        this.surfaceHolder = surfaceHolder;
        this.dView = dView;
        dView.setDrawingCacheEnabled(true);
        //this.res = res;
        picture = res;//BitmapFactory.decodeResource(res, R.drawable.back);
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


                synchronized (surfaceHolder)
                {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                    //canvas.setBitmap(MainActivity.backGround);
                    if(!ifmore)
                    {
                        mBall = new Ball(new Vector2d((float)canvas.getHeight()/2, (float)400), Color.RED);
                        mBall.pos = new Vector2d(canvas.getWidth()/2, 0);
                        ifmore = true;
                    }



                   /* mBall.drawBall(canvas, getCurrentTime(time));
                    mBall.update(figurses);
                    Paint paint = new Paint();
                    paint.setColor(Color.RED);
                    canvas.drawPoint(100, 100, paint);





                    dView.buildDrawingCache();
                    Log.d("COLOR", ""+dView.getDrawingCache().getPixel(100,100));

*/         Paint p = new Paint();

                    canvas.drawBitmap(picture, 0, 0, p );
                    p.setColor(Color.BLUE);
                    canvas.drawPoint(100, 100, p);
                    Log.d("COLOR", "Current: " + picture.getPixel(100, 100) + " by func: " + mBall.getNearColor());


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
