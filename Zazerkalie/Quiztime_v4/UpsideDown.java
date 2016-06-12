package com.example.weller.successapp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class UpsideDown extends View {

    public UpsideDown(Context context) {
        super(context);
    }

    public UpsideDown(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public UpsideDown(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.rotate(5, 0, 0);
        super.onDraw(canvas);
        canvas.restore();
    }
}