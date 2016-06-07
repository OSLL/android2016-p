package com.example.user.shooter;

/**
 * Created by user on 6/7/2016.
 */
public class Enemy {
    private float x;
    private float y;
    private static float w=50.0f;
    private static float h=50.0f;

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getW() {
        return w;
    }

    public float getH() {
        return h;
    }
}

