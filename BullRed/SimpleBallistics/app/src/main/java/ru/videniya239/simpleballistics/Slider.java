package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;


public class Slider
{
    public Rect sliderRect;
    private Rect cursorRect;
    private int maxValue;
    private int minValue;
    private Paint paint;
    private boolean horz;
    private int value;
    private Collider sliderCollider;
    private int offsetX;
    private int offsetY;

    private Vector2 centre;
    public float angle;

    public boolean firstUp;

    //private Button cursorButton;

    public boolean tapped;
    private float velocityKoeff;

    private Vector2 tapPosition;
    private Vector2 startPoint;
    private Vector2 radiusSlider;

    public Slider(Rect sliderRect, int minValue, int maxValue, int startValue, int startAngle,
                  Vector2 centre, Vector2 startPoint, Vector2 radiusSlider)
    {
        this.sliderRect = sliderRect;

        this.minValue = minValue;
        this.maxValue = maxValue;

        paint = new Paint();
        this.centre = centre;
        this.startPoint = startPoint;
        this.value = startValue;
        this.angle = startAngle;


        //firstUp = true;

        this.radiusSlider = radiusSlider;

        sliderCollider = new Collider(sliderRect);
// offsetX = cursorRect.centerX() - cursorRect.left;
        // offsetY = cursorRect.centerY() - cursorRect.top;

        velocityKoeff = GameController.screenWidth / 150000;


        tapPosition = centre;
 /*if (horz)
 {
 sliderCollider = new Collider(new Rect(sliderRect.left + offsetX / 2, sliderRect.top - offsetY,
 sliderRect.right - offsetX / 2, sliderRect.bottom + offsetY));
 }*/

        //GameController.AttachSlider(this);

        //updateCursorRect();
    }

    private void updateCursorRect()
    {
        /*if (horz)
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
        }*/

    }

    public void draw(Canvas canvas)
    {
        if ((canvas != null) && (MainActivity.arrow != null))
        {
            paint.setColor(Color.BLACK);
            //canvas.drawRect(sliderRect, paint);

            //paint.setColor(Color.BLUE);
        /*canvas.drawLine(sliderCollider.rect.right, sliderCollider.rect.top,
                sliderCollider.rect.right, sliderCollider.rect.bottom, paint);*/
            //canvas.drawRect(sliderCollider.rect, paint);
            //paint.setColor(Color.MAGENTA);
            //canvas.drawRect(cursorRect, paint);

            canvas.save();
            // Log.d("slider", "" + value);
            canvas.rotate(angle, centre.x, centre.y);
            canvas.scale(value / (float) maxValue, 1, startPoint.x, startPoint.y);
            canvas.drawBitmap(MainActivity.arrow, null, sliderRect, paint);
            //canvas.drawLine(centre.x, centre.y, tapPosition.x, tapPosition.y, paint);
            canvas.restore();
        }

    }

    public void Activate()
    {

        //firstUp = true;
    }

    public int getValue()
    {
        return value;
    }

    public void onUp()
    {
        if (firstUp)
        {
            firstUp = false;
        }
        else
        {
            LevelManager.GetInstance().GetCurrentLevel().Shoot();
        }
    }

    public boolean update(Vector2 movePosition)
    {
        //получить value из координат cursorRect и оповестить подписчиков
        //if (sliderCollider.intersectsP(movePosition.x, movePosition.y))
        {
            tapped = true;
            //if (horz)
            {
                /*value = (int)((movePosition.x - sliderCollider.rect.left) * (maxValue - minValue) /
                        (sliderCollider.rect.right - sliderCollider.rect.left));*/
                Vector2 direction = movePosition.minus(centre);
                //value = (int)(direction.len() / sliderRect.width() * maxValue);
                value = (int)((direction.len() - radiusSlider.x)/ sliderRect.width() * maxValue);

                if (value > maxValue)
                {
                    value = maxValue;
                }

                if (value < minValue)
                {
                    value = minValue;
                }

                angle = (float)Math.toDegrees(Math.atan2(direction.y, direction.x));

                if (angle < -80)
                {
                    angle = -80;
                }
                if (angle > 0)
                {
                    angle = 0;
                }

                tapPosition = movePosition;
                updateCursorRect();
            }
            return true;
        }
        //return false;
    }
}
