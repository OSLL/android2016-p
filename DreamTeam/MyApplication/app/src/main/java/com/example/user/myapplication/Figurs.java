package com.example.user.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by user on 6/3/2016.
 */
public class Figurs {
    private Paint just4color;

    // float s = 2.5f;

    public Figurs() {
        just4color = new Paint();
        just4color.setColor(Color.BLUE);
    }

    protected void Draw1F4(float Radius, Canvas canvas, float center_x, float center_y) {
        Path path = new Path();
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

    public void DrawKrug(Canvas canvas, float s, float center_x, float center_y, boolean haveBlackR) {
        float radius = 100 * s;
        //отрисовка круга из блоков
        just4color.setColor(Color.parseColor("#F99B15"));
        Draw1F4(100*s, canvas, center_x, center_y);
        canvas.rotate(90, center_x, center_y);
        just4color.setColor(Color.parseColor("#F60E65"));
        Draw1F4(100*s,  canvas, center_x, center_y);
        canvas.rotate(90, center_x, center_y);
        just4color.setColor(Color.parseColor("#0B0C93"));
        Draw1F4(100*s, canvas, center_x, center_y);
        canvas.rotate(90, center_x, center_y);
        just4color.setColor(Color.parseColor("#0BE51F"));
        Draw1F4(100*s, canvas, center_x, center_y);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK); // установим цвет
        paint.setStyle(Paint.Style.FILL);
        if(haveBlackR)
            canvas.drawCircle(center_x, center_y, radius * 0.9f, paint);
        canvas.rotate(90, center_x, center_y);
        //конец отрисовки круга из блоков
    }


    public void DrawBlock(Canvas canvas, int center_x, int center_y, String Colour) {
        int a = 0, b = 0;
        boolean fl1 = false;
        if (!fl1) {
            a = canvas.getWidth()/3;
            b = canvas.getHeight()/ 95;
            fl1 = true;
        }
        // первый прямоугольник
        Rect myRect = new Rect();
        myRect.set(center_x - a/2, center_y - b/2, center_x + a/2,  center_y + b/2);
        Paint paint = new Paint();
        just4color.setColor(Color.parseColor(Colour));
        paint.setColor(just4color.getColor());
        paint.setStyle(Paint.Style.FILL); // заливаем
        canvas.drawRect(myRect, paint);
        //второй прямоугольник
       /* just4color.setColor(Color.parseColor("#F60E65"));
        paint.setColor(just4color.getColor());
        paint.setStyle(Paint.Style.FILL);
        myRect.set(w, center_y - h / 2, 2 * w, h + center_y);
        canvas.drawRect(myRect, paint);
        //третий прямоугольник
        just4color.setColor(Color.parseColor("#0B0C93"));
        paint.setColor(just4color.getColor());
        paint.setStyle(Paint.Style.FILL);
        myRect.set(2 * w, center_y - h / 2, 3 * w, h + center_y );
        canvas.drawRect(myRect, paint);
        //четвертый прямоугольник
        just4color.setColor(Color.parseColor("#0BE51F"));
        paint.setColor(just4color.getColor());
        paint.setStyle(Paint.Style.FILL);
        myRect.set(3 * w, center_y - h / 2, 4 * w, h + center_y);
        canvas.drawRect(myRect, paint);*/
    }

    public void DrawTriangle(Canvas canvas,int center_x, int center_y, float R, String Colour1, String Colour2, String Colour3) {
        int w = 0, h = 0;

        boolean fl1 = false;
        if (!fl1) {
            w = canvas.getWidth()/ 4;
            h = canvas.getHeight()/ 60;
            fl1 = true;
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(R/10f);
        just4color.setColor(Color.parseColor(Colour1));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x-R*0.86f, center_y + R/2f, center_x, center_y -R, paint);
        just4color.setColor(Color.parseColor(Colour2));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x, center_y -R, center_x+R*0.866f, center_y + R/2f, paint);

        just4color.setColor(Color.parseColor(Colour3));
        paint.setColor(just4color.getColor());
        canvas.drawLine( center_x+R*0.866f, center_y + R/2f,center_x-R*0.86f, center_y + R/2f, paint);
        //красивые кружки
        DrawKrug(canvas, R/800f, center_x-R*0.86f, center_y + R/2f, false);
        DrawKrug(canvas, R/800f, center_x, center_y -R, false);
        DrawKrug(canvas, R/800f, center_x+R*0.866f, center_y + R/2f, false);

    }


    public void DrawSquare(Canvas canvas, int center_x, int center_y, float R ) {
        int w = 0, h = 0;

        boolean fl1 = false;
        if (!fl1) {
            w = canvas.getWidth()/ 4;
            h = canvas.getHeight()/ 60;
            fl1 = true;
        }
        //canvas.scale(1.5f, 1.5f);
        Paint paint = new Paint();
        paint.setStrokeWidth(R/10f);
        just4color.setColor(Color.parseColor("#F99B15"));
        paint.setColor(just4color.getColor());
        paint.setStyle(Paint.Style.FILL); // заливаем
        canvas.drawLine(center_x - 1.414f*R/2f, center_y + 1.414f*R/2f,center_x - 1.414f*R/2f, center_y - 1.414f*R/2f, paint);
        just4color.setColor(Color.parseColor("#0B0C93"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x - 1.414f*R/2f, center_y - 1.414f*R/2f,center_x + 1.414f*R/2f, center_y - 1.414f*R/2f, paint);
        just4color.setColor(Color.parseColor("#0BE51F"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x + 1.414f*R/2f, center_y - 1.414f*R/2f,center_x + 1.414f*R/2f, center_y + 1.414f*R/2f, paint);
        just4color.setColor(Color.parseColor("#F60E65"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x + 1.414f*R/2f, center_y + 1.414f*R/2f,center_x - 1.414f*R/2f, center_y + 1.414f*R/2f, paint);
        //красивые кружки
        DrawKrug(canvas, R/800f,center_x - 1.414f*R/2f, center_y + 1.414f*R/2f, false);
        DrawKrug(canvas, R/800f,center_x - 1.414f*R/2f, center_y - 1.414f*R/2f, false);
        DrawKrug(canvas, R/800f,center_x + 1.414f*R/2f, center_y + 1.414f*R/2f, false);
        DrawKrug(canvas, R/800f,center_x + 1.414f*R/2f, center_y - 1.414f*R/2f, false);
    }


    public void DrawOval(Canvas canvas, int center_x, int center_y) {
        int w = 0, h = 0;

        boolean fl1 = false;
        if (!fl1) {
            w = canvas.getWidth()/ 4;
            h = canvas.getHeight()/ 60;
            fl1 = true;
        }
        Paint paint = new Paint();
        //первый розовый
        just4color.setColor(Color.parseColor("#FFFFFF"));
        canvas.rotate(90, center_x, center_y);
        RectF oval3 = new RectF(w, center_y - h,  center_x, center_y);
        just4color.setColor(Color.parseColor("#F60E65"));
        paint.setColor(just4color.getColor());
        canvas.drawOval(oval3, paint);
        canvas.rotate(90, center_x, center_y);
        //второй синий
        just4color.setColor(Color.parseColor("#0B0C93"));
        paint.setColor(just4color.getColor());
        canvas.drawOval(oval3, paint);
        canvas.rotate(90, center_x, center_y);
        //третий зеленый
        just4color.setColor(Color.parseColor("#0BE51F"));
        paint.setColor(just4color.getColor());

        canvas.drawOval(oval3, paint);
        canvas.rotate(90, center_x, center_y);
        //четвертый розовый
        just4color.setColor(Color.parseColor("#F99B15"));

        paint.setColor(just4color.getColor());
        canvas.drawOval(oval3, paint);
        canvas.rotate(90, center_x, center_y);
        //красивый кружок
        DrawKrug(canvas, 0.5f, center_x, center_y, false);
    }
    public void DrawRomb(Canvas canvas, int center_x, int center_y, float R) {

        Paint paint = new Paint();
        paint.setStrokeWidth(R/10f);

        just4color.setColor(Color.parseColor("#F99B15"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x - 1.73f*R, center_y, center_x, center_y - R, paint);
        just4color.setColor(Color.parseColor("#0B0C93"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x, center_y -R, center_x + 1.73f*R, center_y, paint);
        just4color.setColor(Color.parseColor("#0BE51F"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x + 1.73f*R, center_y, center_x,center_y + R, paint);
        just4color.setColor(Color.parseColor("#F60E65"));
        paint.setColor(just4color.getColor());
        canvas.drawLine( center_x,center_y + R,center_x - 1.73f*R, center_y, paint);

        //красивые кружки
        DrawKrug(canvas, R/800f, center_x - 1.73f*R, center_y, false);
        DrawKrug(canvas, R/800f,center_x, center_y - R, false);
        DrawKrug(canvas, R/800f, center_x + 1.73f*R, center_y, false);
        DrawKrug(canvas, R/800f, center_x,center_y + R, false);

    }
    public void DrawStar(Canvas canvas, int center_x, int center_y) {
        int w = 0, h = 0;
        boolean fl1 = false;
        if (!fl1) {
            w = canvas.getWidth()/ 32;
            h = canvas.getHeight()/ 480;
            fl1 = true;
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        just4color.setColor(Color.parseColor("WHITE"));
        paint.setColor(just4color.getColor());
        paint.setStyle(Paint.Style.FILL); // заливаем
        canvas.drawLine(15*w, center_y + w / 1.73205f, 16*w, center_y - 2 * w / 1.73f, paint);

        paint.setColor(just4color.getColor());
        canvas.drawLine(16 * w, center_y - 2 * w / 1.73f, 17 * w, center_y + w / 1.73205f, paint);

        paint.setColor(just4color.getColor());
        canvas.drawLine( 17 * w, center_y + w / 1.73205f, 15 * w, center_y-4*h , paint);


       canvas.drawLine(15 * w, center_y-4*h , 17 * w,center_y-4*h, paint);
        canvas.drawLine(17 * w,center_y-4*h, 15 * w, center_y+ w / 1.73205f, paint);
    }
}
