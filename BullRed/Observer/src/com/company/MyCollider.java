package com.company;

/**
 * Created by user on 6/16/2016.
 */
public class MyCollider
{
    public Vector2 point1;
    public Vector2 point2;
    public MyCollider (double x1, double y1, double x2, double y2)
    {
        point1 = new Vector2(x1, y1);
        point2 = new Vector2(x2, y2);
    }
    public MyCollider (Vector2 vector1, Vector2 vector2)
    {
        point1 = vector1;
        point2 = vector2;
    }
}
