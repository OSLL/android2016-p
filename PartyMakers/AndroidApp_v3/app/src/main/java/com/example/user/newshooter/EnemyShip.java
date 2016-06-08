package com.example.user.newshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

import java.util.ArrayList;

/**
 * Created by user on 6/8/2016.
 */
public class EnemyShip {
    RectF rect;

    // The player ship will be represented by a Bitmap
    private Bitmap bitmap;

    Context context;

    // How long and high our paddle will be
    private float width;
    private float height;

    // X is the far left of the rectangle which forms our paddle
    private float x;

    // Y is the top coordinate
    private float y;

    // This will hold the pixels per second speedthat the paddle will move
    private float shipSpeed;

    private boolean shipMoving;

    private float movX;
    private float movY;

    private boolean isVisible;

    public EnemyShip(Context context, int screenX, int screenY){
        // Initialize a blank RectF
        rect = new RectF();
        width = screenX/8;
        height = screenY/3;
        // Start ship in roughly the screen centre
        x = screenX / 2;
        y = screenY;

        // Initialize the bitmap
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        // stretch the bitmap to a size appropriate for the screen resolution
        bitmap = Bitmap.createScaledBitmap(bitmap,
                (int) (width),
                (int) (height),
                false);

        // How fast is the spaceship in pixels per second
        shipSpeed = 350;
        shipMoving = false;

        isVisible = true;
        
        this.context = context;
    }


    public void update(long fps){
        if(shipMoving){
            if(x < movX)
                x = x + shipSpeed / fps;
            else
                x = x - shipSpeed / fps;

            if(y < movY)
                y = y + shipSpeed / fps;
            else
                y = y - shipSpeed / fps;
        }

        // Update rect which is used to detect hits
        rect.top = y;
        rect.bottom = y + height;
        rect.left = x;
        rect.right = x + width;

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public RectF getRect() {
        return rect;
    }
}
