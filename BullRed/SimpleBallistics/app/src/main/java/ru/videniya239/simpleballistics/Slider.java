package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;



public class Slider
{
    private Rect sliderRect;
    private Rect cursorRect;
    private int maxValue;
    private int minValue;
    private Paint paint;
    private boolean horz;
    private int value;
    private Collider sliderCollider;
    private int offsetX;
    private int offsetY;

    //private Button cursorButton;


    public Slider(Rect sliderRect, Rect cursorRect, int minValue, int maxValue, int startValue, boolean horz)
    {
        this.sliderRect = sliderRect;
        this.cursorRect = cursorRect;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.horz = horz;
        paint = new Paint();

        this.value = startValue;

        sliderCollider = new Collider(sliderRect);
        offsetX = cursorRect.centerX() - cursorRect.left;
        offsetY = cursorRect.centerY() - cursorRect.top;

        if (horz)
        {
            sliderCollider = new Collider(new Rect(sliderRect.left + offsetX / 2, sliderRect.top - offsetY,
                    sliderRect.right - offsetX / 2, sliderRect.bottom + offsetY));
        }

        updateCursorRect();
    }


    private void updateCursorRect()
    {
        if (horz)
        {
            float newCenter = sliderCollider.rect.left * (maxValue - value) / (maxValue - minValue) +
                    sliderCollider.rect.right * (value - minValue) / (maxValue - minValue);
            cursorRect.set((int)newCenter - offsetX, cursorRect.top, (int)newCenter + offsetX, cursorRect.bottom);
        }
        else
        {
            float newCenter = sliderRect.top * (maxValue - value) / (maxValue - minValue) +
                    sliderRect.bottom * (value - minValue) / (maxValue - minValue);
            cursorRect.set(cursorRect.left, (int)newCenter - offsetY, cursorRect.right, (int)newCenter + offsetY);
        }
    }

    public void draw(Canvas canvas)
    {
        paint.setColor(Color.YELLOW);
        canvas.drawRect(sliderRect, paint);

        //paint.setColor(Color.BLUE);
        /*canvas.drawLine(sliderCollider.rect.right, sliderCollider.rect.top,
                sliderCollider.rect.right, sliderCollider.rect.bottom, paint);*/
        //canvas.drawRect(sliderCollider.rect, paint);
        paint.setColor(Color.MAGENTA);
        canvas.drawRect(cursorRect, paint);
    }

    public int getValue()
    {
        return value;
    }



    public boolean update(Vector2 movePosition)
    {
        //получить value из координат cursorRect и оповестить подписчиков
        if (sliderCollider.intersectsP(movePosition.x, movePosition.y))
        {
            if (horz)
            {
                value = (int)((movePosition.x - sliderCollider.rect.left) * (maxValue - minValue) /
                        (sliderCollider.rect.right - sliderCollider.rect.left));
                updateCursorRect();
            }
            return true;
        }
        return false;
    }
}
