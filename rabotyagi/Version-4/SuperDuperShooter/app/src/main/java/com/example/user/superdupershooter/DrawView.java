package com.example.user.superdupershooter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by user on 6/16/2016.
 */
public class DrawView  extends SurfaceView implements SurfaceHolder.Callback {

    private int width;
    private int height;
    private DrawThread drawThread;
    private Activity activity;
    private Bitmap player_pic, monster_pic,background_game1,background_game2,background_game3,background_game4,background_game5;


    public DrawView(Context context, Activity activity, Bitmap player_pic, Bitmap monster_pic,
                    Bitmap background_game1,Bitmap background_game2,Bitmap  background_game3,Bitmap  background_game4, Bitmap background_game5){
        super(context);
        getHolder().addCallback(this);
        this.activity = activity;
        this.player_pic = player_pic;
        this.monster_pic = monster_pic;
        this.background_game1 = background_game1;
        this.background_game2 = background_game2;
        this.background_game3 = background_game3;
        this.background_game4 = background_game4;
        this.background_game5 = background_game5;

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.width = width;
        this.height = height;
        drawThread = new DrawThread(getContext(), getHolder(), width, height, activity, player_pic, monster_pic,
                background_game1,background_game2,background_game3,background_game4,background_game5);
        drawThread.start();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawThread.requestStop();
        boolean retry = true;
        while (retry)
        {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e){

            }
        }

    }

    public boolean onTouchEvent(MotionEvent event) {
        drawThread.Touch((int)event.getX());
        return false;
    }

}
