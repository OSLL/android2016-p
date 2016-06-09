package com.example.user.newshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

import java.util.ArrayList;

/**
 * Created by user on 6/8/2016.
 */
public class PlayerShip {
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



    // This the the constructor method
    // When we create an object from this class we will pass
    // in the screen width and height
    public PlayerShip(Context context, int screenX, int screenY){
        // Initialize a blank RectF
        rect = new RectF();
        width = screenX/5;
        height = screenY/10;
        // Start ship in roughly the screen centre
        x = screenX / 2;
        y = screenY;

        // Initialize the bitmap
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.playership);
        // stretch the bitmap to a size appropriate for the screen resolution
        bitmap = Bitmap.createScaledBitmap(bitmap,
                (int) (width),
                (int) (height),
                false);

        // How fast is the spaceship in pixels per second
        shipSpeed = 350;
        shipMoving = false;

        this.context = context;
    }

    public RectF getRect(){
        return rect;
    }

    // This is a getter method to make the rectangle that
    // defines our paddle available in BreakoutView class
    public Bitmap getBitmap(){
        return bitmap;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }

    public float getMovX() {
        return movX;
    }

    public void setMovX(float movX) {
        this.movX = movX;
    }

    public float getMovY() {
        return movY;
    }

    public void setMovY(float movY) {
        this.movY = movY;
    }

    public boolean isShipMoving() {
        return shipMoving;
    }

    public void setShipMoving(boolean shipMoving) {
        this.shipMoving = shipMoving;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    // This update method will be called from update in SpaceInvadersView
    // It determines if the player ship needs to move and changes the coordinates
    // contained in x if necessary
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

    public boolean shoot(ArrayList<Bullet> bullets){
        Bullet bullet = new Bullet(context, height, width);
        bullet.shoot(x+width/2 - 7,y,bullet.UP);
        bullets.add(bullet);
        return true;
    }

}
