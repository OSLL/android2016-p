package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Cannon
{
    private Body body;
    private Slider velocitySlider;
    private Slider angleSlider;

    public Body GetBody()
    {
        return body;
    }

    public Cannon()
    {
        Rect velocitySliderRect = new Rect(100, 400, 1000, 500);
        Rect velocityCursorRect = new Rect(velocitySliderRect.left - 50, velocitySliderRect.top - 50,
                velocitySliderRect.left + 50, velocitySliderRect.bottom + 50);
        velocitySlider = new Slider(velocitySliderRect, velocityCursorRect, 0, 300, 230, true);

    }

    public void Activate()
    {
        GameController.AttachSlider(velocitySlider);
    }

    public void Deactivate()
    {
        GameController.AttachSlider(velocitySlider);
    }

    public Bullet CreateBullet()
    {
        //return new Bullet(velocitySlider.getValue(), angleSlider.getValue());
        return new Bullet(velocitySlider.getValue(), 60);
    }

    public void Update()
    {

    }

    public void Draw(Canvas canvas)
    {
        velocitySlider.draw(canvas);
    }
}
