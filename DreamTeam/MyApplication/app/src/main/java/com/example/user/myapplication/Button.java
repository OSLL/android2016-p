package com.example.user.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by user on 6/8/2016.
 */
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

public class Button{
    private Paint mPaint = new Paint();
    private Paint m1Paint = new Paint();
    private Rect mRect = new Rect();
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    Figurs fig = new Figurs();
    DrawingView dView;
    private Paint just4color;

    public Button(DrawingView dView) {
        mPaint = new Paint();
        m1Paint = new Paint();
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        just4color = new Paint();
        this.dView = dView;
    }

    public void DrawButton(float center_x, float center_y, float a, float b, Canvas c )
    {
        x1 = (int) (center_x - a/2f);
        y1 = (int) (center_y - b/2f);
        x2 = (int) (center_x + a/2f);
        y2 = (int) (center_y + b/2f);
        m1Paint.setColor(just4color.getColor());
        m1Paint.setAntiAlias(true);
        m1Paint.setTextSize(c.getWidth()/ 7);
        just4color.setColor(Color.parseColor("#FFF105"));
        m1Paint.setColor(just4color.getColor());

        //Paint paint = new Paint();
        Typeface tf =Typeface.createFromAsset(dView.getContext().getAssets(),"fonts/GS.ttf");
        m1Paint.setTypeface(tf);
        m1Paint.setColor(just4color.getColor());
        m1Paint.setTextSize(c.getWidth()/9);
        c.drawText("RAIN", center_x / 3.2f, center_y / 4, m1Paint);

        just4color.setColor(Color.parseColor("#964CE1"));
        m1Paint.setColor(just4color.getColor());
        c.drawText("  B", center_x * 0.85f , center_y / 4, m1Paint);

        fig.DrawKrug(c, 0.6f, center_x * 1.35f, center_y / 5.4f, true);

        c.drawText("       W", center_x * 0.85f, center_y / 4, m1Paint);
        just4color.setColor(Color.parseColor("#10E0BC"));
        m1Paint.setColor(just4color.getColor());
        c.drawText("  BALL  ", center_x / 2, center_y / 2.3f, m1Paint);
        c.save();
        c.rotate(-30, center_x, center_y);
       // mRect.set((int)(center_x-a/2f), (int)(center_y - b/2f), (int)(center_x + a/2f), (int)(center_y + b/2f));
        //mPaint.setStyle(Paint.Style.FILL);
        //c.drawRect(mRect, mPaint);

        fig.DrawKrug(c, 2.5f, center_x, center_y, true);
        fig.DrawTriangle(c,(int)center_x, (int)center_y, 170, "#E13D63", "#964CE1", "#10E0BC");

        c.restore();

    }

}





