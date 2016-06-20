package ru.videniya239.simpleballistics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Cannon
{
    public Slider velocitySlider;
    private float currentAngle;
    private Bitmap cannonImage;
    private Bitmap carriageImage;
    private Vector2 centre;
    private Rect cannonRect;
    private Paint paint;
    private Rect carriageRect;

    public Cannon(float currentAngle, Vector2 centre, Rect cannonRect, Rect carriageRect)
    {
        cannonImage = MainActivity.cannon;
        carriageImage = MainActivity.carriageImage;
        this.cannonRect = cannonRect;
        this.carriageRect = carriageRect;
        this.centre = centre;
        this.currentAngle = currentAngle;
        paint = new Paint();
    }

    public void Activate()
    {
        int offsetY = (int)GameController.screenHeight / 40;
        int offsetX = (int)GameController.screenWidth * 3 / 7;
        int radiusSliderX = cannonRect.width() * 5 / 7;
        Rect velocitySliderRect = new Rect((int)centre.x + radiusSliderX , (int)centre.y - offsetY, (int)centre.x + offsetX, (int)centre.y + offsetY);
        Rect velocityCursorRect = new Rect(velocitySliderRect.left - 50, velocitySliderRect.top - 50,
                velocitySliderRect.left + 50, velocitySliderRect.bottom + 50);
        velocitySlider = new Slider(velocitySliderRect, velocityCursorRect, 20, 120, 60, 0, centre, new Vector2(centre.x + radiusSliderX, centre.y), new Vector2(radiusSliderX, 0));
        GameController.AttachSlider(velocitySlider);
        velocitySlider.Activate();
    }

    public void Deactivate()
    {
        Log.d("slider", "deactivate");
        GameController.DetachSlider(velocitySlider);
    }

    /*public void rotate(float angle)
    {
        currentAngle += angle;
    }*/

    public Bullet CreateBullet(float windVelocity)
    {
        return new Bullet(velocitySlider.getValue(), -currentAngle, centre, windVelocity);
    }

    public void Update()
    {
        currentAngle = velocitySlider.angle;
    }

    public void DrawCannon(Canvas canvas)
    {

        canvas.save();
        {
            canvas.rotate(currentAngle, centre.x, centre.y);
            canvas.drawBitmap(cannonImage, null, cannonRect, paint);
        }
        canvas.restore();
        canvas.drawBitmap(carriageImage, null, carriageRect, paint);
    }

    public void Draw(Canvas canvas)
    {

        velocitySlider.draw(canvas);
    }
}
