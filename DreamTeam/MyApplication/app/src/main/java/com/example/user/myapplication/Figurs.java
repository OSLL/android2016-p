package com.example.user.myapplication;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;


public class Figurs {
    private Paint just4color;
    float center_x, center_y;
    float s = 1.5f;

    public Figurs() {
        just4color = new Paint();
        just4color.setColor(Color.BLUE);
    }

    public void Draw1F4(float Radius, float Weight, float Height, Canvas canvas)
    {
        Path path = new Path();
        path.addCircle(Weight, Height, Radius, Path.Direction.CW);
        Paint paint = new Paint();

        paint.setColor(just4color.getColor()); // установим белый цвет
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL); // заливаем
        paint.setAntiAlias(true);
        final RectF oval = new RectF();
        oval.set(center_x - Radius, center_y - Radius, center_x + Radius,
                center_y + Radius);
        canvas.drawArc(oval, 45, 90, true, paint);
    }
    public void DrawKrug(Canvas canvas)
    {
        boolean fl = false;
        if(!fl)
        {
            center_x= canvas.getWidth()/2;
            center_y= canvas.getHeight()/2;
            fl = true;
        }
        //отрисовка круга из блоков
        just4color.setColor(Color.parseColor("#F9EE43"));
        Draw1F4(100*s, 300*s, 400*s, canvas);
        canvas.rotate(90, center_x, center_y);
        just4color.setColor(Color.parseColor("#43F947"));
        Draw1F4(100*s, 300*s, 400*s, canvas);
        canvas.rotate(90, center_x, center_y);
        just4color.setColor(Color.parseColor("#4355F9"));
        Draw1F4(100*s, 300*s, 400*s, canvas);
        canvas.rotate(90, center_x, center_y);
        just4color.setColor(Color.parseColor("#F943F8"));
        Draw1F4(100*s, 300*s, 400*s, canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK); // установим цвет
        paint.setStyle(Paint.Style.FILL);

        canvas.drawCircle( center_x, center_y, 70*s, paint);
        canvas.rotate(90, center_x, center_y);
        //конец отрисовки круга из блоков
    }


    public void DrawBlock(Canvas canvas)
    {
        int w = 0, h = 0;
        boolean fl1 = false;
        if(!fl1)
        {
            w = canvas.getWidth()/4;
            h = canvas.getHeight()/50;
            fl1 = true;
        }
        // создаем пустой прямоугольник и задаем координаты верхней левой и нижней правой точек
        Rect myRect = new Rect();
        myRect.set(0, canvas.getHeight()/2, h, w);
        Paint paint = new Paint();
        just4color.setColor(Color.parseColor("#4355F9"));
        paint.setColor(just4color.getColor());
        paint.setStyle(Paint.Style.FILL); // заливаем

        // кисть
        //Paint greenPaint = new Paint();
        // цвет кисти - зеленый
        //greenPaint.setColor(Color.GREEN);
        // тип - заливка
        //greenPaint.setStyle(Paint.Style.FILL);
        // закрашиваем зелёным прямоугольником вторую половину экрана
        canvas.drawRect(myRect, paint);

    }}