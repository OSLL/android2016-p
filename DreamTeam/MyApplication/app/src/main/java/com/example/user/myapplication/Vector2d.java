package com.example.user.myapplication;

/**
 * Created by user on 6/3/2016.
 */
public class Vector2d {
    float x, y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    Vector2d(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }
}
