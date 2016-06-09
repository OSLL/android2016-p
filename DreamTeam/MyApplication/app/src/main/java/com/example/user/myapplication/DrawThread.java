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
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by user on 6/3/2016.
 */
class DrawThread extends Thread implements View.OnTouchListener{
    private boolean       runFlag = false;
    double                speed_a = 0.1;
    private SurfaceHolder surfaceHolder;
    private Bitmap        picture;
    private Matrix        matrix;
    private long          prevTime;
    private DrawingView   dView;
    private float         x=100, y=100;
    private Ball          mBall;
    FObj                  ring1 = null,
                          ring2 = null,
                          block1 = null,
                          block2 = null,
                          block3 = null,
                          block4 = null;
    Canvas                canvas = null;
    boolean               ifmore = false;
    boolean               play = false;
    Button                b;

    public DrawThread(SurfaceHolder surfaceHolder, DrawingView dView){
        this.surfaceHolder = surfaceHolder;
        this.dView = dView;
        dView.setOnTouchListener(this);
    }


    public void setRunning(boolean run) {
        runFlag = run;
    }
    public void sendEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
           mBall.speed = -12;
            mBall.up = true;
        }
    }
    float getCurrentTime(float lastTime)
    {
        return (System.nanoTime() - lastTime) / 100f;
    }


    void processObj(ArrayList<FObj> obj, Canvas canvas, float time)
    {
        for (FObj f: obj
             ) {
            f.draw(canvas, time, -1);
            if(!f.update(canvas, time))
            {
                ifmore = false;
                play = false;
            }
        }
    }

   void scrollObj(ArrayList<FObj> obj)
    {
        for (FObj f: obj
             ) {
            f.Center_y += 3;

            canvas.translate(0, 2);
        }
    }

    boolean ballInSomth(ArrayList<FObj> objs)
    {
        for (FObj f: objs
             ) {
            if(f.inRing())
                return true;

        }
        return false;
    }


    @Override
    public void run() {

        float startTime = System.nanoTime();
        Figurs f = new Figurs();
        ArrayList<FObj> objs = new ArrayList<>();
        b = new Button(dView);
        while (runFlag) {
            try {
                float time = System.nanoTime();
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder)
                {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                    if(!play)
                    {
                        b.DrawButton(canvas.getWidth()/2, canvas.getHeight()/ 2, 200 * 2.5f, 200*2.5f, canvas);
                    }
                    else {

                        if(!ifmore)
                        {
                            mBall = new Ball(new Vector2d((float)canvas.getWidth()/2, canvas.getHeight()* 0.9f), Color.parseColor(f.colors.get("yellow")));
                            mBall.pos = new Vector2d(canvas.getWidth()/2,canvas.getHeight()* 0.9f);
                            ifmore = true;
                            ring1 = new FObj(0, canvas.getWidth() / 2, 0, 0, 0, 1.8f, mBall);
                            ring2 = new FObj(0, canvas.getWidth() / 2, 600, 0, 0, 2f, mBall);
                            float block_y = canvas.getHeight() * 0.7f;
                            float len = canvas.getWidth() / 3;

                            block1 = new FObj(4, len / 2, block_y, 0,0,0, mBall);
                            block2 = new FObj(4, len + len / 2, block_y, 0,0,0, mBall);
                            block3 = new FObj(4, 2 * len + len / 2, block_y, 0,0,0, mBall);
                            block4 = new FObj(4, 3 * len + len / 2, block_y, 0,0,0, mBall);

                            block1.setColor(f.int_colors.get("pink"));
                            block3.setColor(f.int_colors.get("yellow"));
                            block2.setColor(f.int_colors.get("fiol"));
                            block4.setColor(f.int_colors.get("lblue"));


                           objs.add(ring1);
                            objs.add(ring2);

                            objs.add(block1);
                            objs.add(block2);
                            objs.add(block3);
                            objs.add(block4);
                        }
                        else {


                             processObj(objs, canvas, getCurrentTime(startTime));



                            if(mBall.pos.getY() < canvas.getHeight() * 0.4)
                               scrollObj(objs);
                            mBall.drawBall(canvas, (getCurrentTime(time)));
                        }
                }}
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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getX() > b.x1 && event.getX() < b.x2 && event.getY() > b.y1 && event.getY() < b.y2) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: // нажатие
                    play = true;

                    break;
                default:
                    break;
            }
            return true;
        } else {
            return false;
        }
    }
}
