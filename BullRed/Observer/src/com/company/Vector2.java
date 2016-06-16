package com.company;

/**
 * Created by user on 6/16/2016.
 */
public class Vector2
{
    public double x;
    public double y;
    public Vector2(double x1, double y1)
    {
        x = x1;
        y = y1;
    }

    public double length()
    {
        return(Math.sqrt(x * x + y * y));
    }

}
