package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class Level {
    private Cannon cannon;
    private Bullet bullet;
    private Paint paint;

    public static ArrayList<Vector2> traectory;

    public void Start() {
        traectory = new ArrayList<>();
        //levelManager.Initialize();
        paint = new Paint();
        paint.setColor(Color.WHITE);
        bullet = new Bullet();
        cannon = new Cannon();
    }

    public void Draw(Canvas canvas)
    {
        if (bullet != null) {
            paint.setColor(Color.BLACK);
            bullet.Draw(canvas);
            for (Vector2 position : traectory) {
                canvas.drawCircle(position.x, position.y, 15.0f, paint);
            }
        }
    }

    public void Update(float deltaT)
    {
        if (bullet != null)
        {
            bullet.Update(deltaT);
        }
    }
}
