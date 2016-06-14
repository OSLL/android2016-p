package com.example.user.newshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.util.Log;

/**
 * Created by user on 6/8/2016.
 */
public class Bullet {
    private float x;
    private float y;

    private Bitmap bitmap;

    private RectF rect;

    private boolean isVisible;

    // Which way is it shooting
    public final int UP = 0;
    //public final int DOWN = 1;

    // Going nowhere
    int heading = -1;

    float speed = 3000;

    private int width;
    private int height;

    private boolean isActive;

    public Bullet(Context context, float shipHeigth, float shipWidth) {
        height = (int) (shipHeigth/5);
        width = (int) (shipWidth/10);

        isActive = false;
        rect = new RectF();

        isVisible = true;

        // Initialize the bitmap
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet);
        // stretch the bitmap to a size appropriate for the screen resolution
        bitmap = Bitmap.createScaledBitmap(bitmap,
                (int) (width),
                (int) (height),
                false);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public RectF getRect(){
        return  rect;
    }

    public boolean getStatus(){
        return isActive;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public float getY() {
        return y;
    }

    public boolean shoot(float startX, float startY, int direction) {
        if (!isActive) {
            x = startX;
            y = startY;
            //Log.d("inB","fds");
            heading = direction;
            isActive = true;
            //return true;
        }
        // Bullet already active
        //return false;
        return true;
    }

    public void update(long fps){

        // Just move up or down
        if(heading == UP){
            y = y - speed / fps;
        }
        else{
            y = y + speed / fps;
        }

        // Update rect
        rect.left = x;
        rect.right = x + width;
        rect.top = y;
        rect.bottom = y + height;
    }
}
