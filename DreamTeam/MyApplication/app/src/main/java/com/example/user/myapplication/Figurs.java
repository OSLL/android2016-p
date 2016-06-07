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

    private void Draw1F4(float Radius, Canvas canvas, float center_x, float center_y) {
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

    public void DrawKrug(Canvas canvas, float s, float center_x, float center_y) {

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

        canvas.drawCircle(center_x, center_y, 85 * s, paint);
        canvas.rotate(90, center_x, center_y);
        //конец отрисовки круга из блоков
    }


    public void DrawBlock(Canvas canvas, int center_x, int center_y) {
        int w = 0, h = 0;
        boolean fl1 = false;
        if (!fl1) {
            w = canvas.getWidth()/3;
            h = canvas.getHeight()/ 95;
            fl1 = true;
        }
        // первый прямоугольник
        Rect myRect = new Rect();
        myRect.set(0, center_y - h / 2, w, h + center_y);
        Paint paint = new Paint();
        just4color.setColor(Color.parseColor("#F99B15"));
        paint.setColor(just4color.getColor());
        paint.setStyle(Paint.Style.FILL); // заливаем
        canvas.drawRect(myRect, paint);
        //второй прямоугольник
        just4color.setColor(Color.parseColor("#F60E65"));
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
        canvas.drawRect(myRect, paint);
    }

    public void DrawTriangle(Canvas canvas,int center_x, int center_y, float R) {
        int w = 0, h = 0;

        boolean fl1 = false;

        Paint paint = new Paint();
        paint.setStrokeWidth(40);
        just4color.setColor(Color.parseColor("#F99B15"));
        paint.setColor(just4color.getColor());
        //paint.setStyle(Paint.Style.FILL); // заливаем
        canvas.drawLine(center_x-R * 0.866f, center_y - R/2f, center_x, center_y - R, paint);
        just4color.setColor(Color.parseColor("#0B0C93"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x, center_y - R,center_x + R * 0.866f, center_y + R/2f, paint);
        just4color.setColor(Color.parseColor("#0BE51F"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x + R * 0.866f, center_y + R/2f, center_x-R * 0.866f, center_y - R/2f, paint);
    }

    public void DrawSquare(Canvas canvas, int center_x, int center_y ) {
        int w = 0, h = 0;

        boolean fl1 = false;
        if (!fl1) {
            w = canvas.getWidth()/ 2;
            h = canvas.getHeight()/ 30;
            fl1 = true;
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(40);
        just4color.setColor(Color.parseColor("#F99B15"));
        paint.setColor(just4color.getColor());
        paint.setStyle(Paint.Style.FILL); // заливаем
        canvas.drawLine(w, center_y + w / 1.73205f, w, center_y - 2 * w / 1.73f, paint);
        just4color.setColor(Color.parseColor("#0B0C93"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(3 * w, center_y - 2 * w / 1.73f, 3 * w, center_y + w / 1.73205f, paint);
        just4color.setColor(Color.parseColor("#0BE51F"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(w, center_y + w / 1.73205f, 3 * w, center_y + w / 1.73205f, paint);
        just4color.setColor(Color.parseColor("#F60E65"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(w, center_y - 2 * w / 1.73f, 3 * w, center_y - 2 * w / 1.73f, paint);
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
        //первый
        //canvas.rotate(90, center_x, center_y);
        RectF oval3 = new RectF(w, center_y - h,  center_x, center_y);
        just4color.setColor(Color.parseColor("#F99B15"));
        paint.setColor(just4color.getColor());
        canvas.drawOval(oval3, paint);
        canvas.rotate(90, center_x, center_y);
        //второй
        just4color.setColor(Color.parseColor("#0B0C93"));
        paint.setColor(just4color.getColor());
        canvas.drawOval(oval3, paint);
        canvas.rotate(90, center_x, center_y);
        //третий
        just4color.setColor(Color.parseColor("#0BE51F"));
        paint.setColor(just4color.getColor());

        canvas.drawOval(oval3, paint);
        canvas.rotate(90, center_x, center_y);
        //четвертый
        just4color.setColor(Color.parseColor("#F60E65"));
        paint.setColor(just4color.getColor());
        canvas.drawOval(oval3, paint);
        canvas.rotate(90, center_x, center_y);
    }
    public void DrawRomb(Canvas canvas, int center_x, int center_y) {
        int w = 0, h = 0;

        boolean fl1 = false;
        {
        w = canvas.getWidth()/ 4;
        h = canvas.getHeight()/ 60;
            fl1 = true;
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(40);
        canvas.translate(0, -w/1.73205f);
        just4color.setColor(Color.parseColor("#F99B15"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(w, center_y + w / 1.73205f, center_x, center_y - 2 * w / 1.73f, paint);

        just4color.setColor(Color.parseColor("#0B0C93"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x, center_y - 2 * w / 1.73f, 3 * w, center_y + w / 1.73205f, paint);
        canvas.translate(0, 2*w/1.73205f);
        canvas.rotate(180, center_x, center_y);
        just4color.setColor(Color.parseColor("#0BE51F"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(w, center_y + w / 1.73205f, center_x, center_y - 2 * w / 1.73f, paint);

        just4color.setColor(Color.parseColor("#F60E65"));
        paint.setColor(just4color.getColor());
        canvas.drawLine(center_x, center_y - 2 * w / 1.73f, 3 * w, center_y + w / 1.73205f, paint);

    }
}