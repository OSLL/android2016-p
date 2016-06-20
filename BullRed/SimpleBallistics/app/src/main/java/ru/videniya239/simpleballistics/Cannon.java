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
    private Vector2 nailPos;
    private Rect cannonRect;
    private Paint paint;
    private Rect carriageRect;


    public Cannon(float currentAngle, Vector2 nailPos, Rect cannonRect, Rect carriageRect)
    {
        cannonImage = MainActivity.cannon;
        carriageImage = MainActivity.carriageImage;
        this.cannonRect = cannonRect;
        this.carriageRect = carriageRect;
        this.nailPos = nailPos;
        this.currentAngle = currentAngle;
        paint = new Paint();

        int offsetY = (int)GameController.screenHeight / 40;
        int offsetX = (int)GameController.screenWidth * 3 / 7;
        int radiusSliderX = cannonRect.width() * 5 / 7;
        Rect velocitySliderRect = new Rect((int) nailPos.x + radiusSliderX , (int) nailPos.y - offsetY, (int) nailPos.x + offsetX, (int) nailPos.y + offsetY);
        Rect velocityCursorRect = new Rect(velocitySliderRect.left - 50, velocitySliderRect.top - 50,
                velocitySliderRect.left + 50, velocitySliderRect.bottom + 50);
        velocitySlider = new Slider(velocitySliderRect, velocityCursorRect, 20, 120, 60, 0, nailPos, new Vector2(nailPos.x + radiusSliderX, nailPos.y), new Vector2(radiusSliderX, 0));
    }

    public void Activate()
    {


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

        float deltaL = cannonRect.right - nailPos.x;
        float bulletPosX = deltaL * (float)Math.cos(-currentAngle) + nailPos.x;
        float bulletPosY = -deltaL * (float)Math.sin(currentAngle) + nailPos.y;
        Vector2 bulletStartPos = new Vector2(bulletPosX, bulletPosY);

        return new Bullet(velocitySlider.getValue(), -currentAngle, bulletStartPos, windVelocity);
    }

    public void Update()
    {
        currentAngle = velocitySlider.angle;
    }

    public void DrawCannon(Canvas canvas)
    {

        canvas.save();
        {
            canvas.rotate(currentAngle, nailPos.x, nailPos.y);
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
