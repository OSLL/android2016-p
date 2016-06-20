package ru.videniya239.simpleballistics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Cannon
{
    private Slider velocitySlider;
    private float currentAngle;
    private Bitmap cannonImage;
    private Vector2 centre;
    private Rect cannonRect;
    private Paint paint;

    public Cannon(float currentAngle, Vector2 centre, Rect cannonRect)
    {
        Rect velocitySliderRect = new Rect(100, 400, 1000, 500);
        Rect velocityCursorRect = new Rect(velocitySliderRect.left - 50, velocitySliderRect.top - 50,
                velocitySliderRect.left + 50, velocitySliderRect.bottom + 50);
        velocitySlider = new Slider(velocitySliderRect, velocityCursorRect, 0, 90, 75, true);
        cannonImage = MainActivity.cannon;
        this.cannonRect = cannonRect;
        this.centre = centre;
        this.currentAngle = currentAngle;
        paint = new Paint();
    }

    public void Activate()
    {
        GameController.AttachSlider(velocitySlider);
    }

    public void Deactivate()
    {
        GameController.AttachSlider(velocitySlider);
    }

    public void rotate(float angle)
    {
        currentAngle += angle;
    }

    public Bullet CreateBullet()
    {
        return new Bullet(velocitySlider.getValue(), currentAngle, centre);
    }

    public void Update()
    {
        currentAngle = velocitySlider.getValue();
    }

    public void Draw(Canvas canvas)
    {
        velocitySlider.draw(canvas);
        canvas.save();
        {
            canvas.rotate(-currentAngle + 27, centre.x, centre.y);
            canvas.drawBitmap(cannonImage, null, cannonRect, paint);
        }
        canvas.restore();
    }
}
