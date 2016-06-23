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
    public Rect cannonRect;
    private Paint paint;
    public Rect carriageRect;
    public Rect cannonRectPattern;
    public Rect carriageRectPattern;
    public Vector2 nailPattern;
    public Vector2 displacing;

    public Cannon(float currentAngle, Vector2 translation)
    {
        InitialazeRect();
        cannonImage = MainActivity.cannon;
        carriageImage = MainActivity.carriageImage;
        cannonRect = new Rect(cannonRectPattern.left + (int)translation.x,
                cannonRectPattern.top + (int)translation.y,
                cannonRectPattern.right + (int)translation.x,
                cannonRectPattern.bottom + (int)translation.y);
        carriageRect = new Rect(carriageRectPattern.left + (int)translation.x,
                carriageRectPattern.top + (int)translation.y,
                carriageRectPattern.right + (int)translation.x,
                carriageRectPattern.bottom + (int)translation.y);
        nailPos = new Vector2(nailPattern.x + translation.x, nailPattern.y + translation.y);
        this.currentAngle = currentAngle;
        paint = new Paint();

        int offsetY = (int)GameController.screenHeight / 40;
        int offsetX = (int)GameController.screenWidth * 3 / 7;
        int radiusSliderX = cannonRect.width() * 5 / 7;
        //radiusSliderX = 0;
        Rect velocitySliderRect = new Rect((int) nailPos.x + radiusSliderX , (int) nailPos.y - offsetY, (int) nailPos.x + offsetX, (int) nailPos.y + offsetY);


        velocitySlider = new Slider(velocitySliderRect, 20, 120, 60, 0, nailPos, new Vector2(nailPos.x + radiusSliderX, nailPos.y), new Vector2(radiusSliderX, 0));
    }

    private void InitialazeRect()
    {
        cannonRectPattern = new Rect(0, 0, (int)(GameController.screenWidth*62f/700f), (int)(GameController.screenHeight*33f/349f));
        carriageRectPattern = new Rect(0, 0, (int)(GameController.screenWidth*59f/700f), (int)(GameController.screenHeight*36f/349f));
        displacing = new Vector2(-GameController.screenWidth*5f/700f, GameController.screenHeight*(14f)/349);
        carriageRectPattern.bottom += displacing.y;
        carriageRectPattern.top += displacing.y;
        carriageRectPattern.left += displacing.x;
        carriageRectPattern.right += displacing.x;
        nailPattern = new Vector2(GameController.screenWidth*35f/700f, GameController.screenHeight*17f/349);
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

        float deltaL = (cannonRect.right - nailPos.x) * 1f;
        float bulletPosX = deltaL * (float)Math.cos(currentAngle * Math.PI / 180) + nailPos.x;
        float bulletPosY = deltaL * (float)Math.sin(currentAngle * Math.PI / 180) + nailPos.y;
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
