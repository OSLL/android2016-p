package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class LifeManager
{
    private LifeManager()
    {
    }

    public Rect lifeRect;
    private Paint paint;

    private static LifeManager instance;
    public static LifeManager getInstance()
    {
        if (instance == null)
        {
            instance = new LifeManager();
        }
        return instance;
    }

    private int lives;

    public int getLives()
    {
        return lives;
    }

    public void changeLives(int delta)
    {
        lives += delta;
    }

    public void Init(int startValue, Rect lifeRect)
    {
        this.lifeRect = lifeRect;
        paint = new Paint();
        lives = startValue;
    }

    public void Draw(Canvas canvas)
    {

        if ((canvas != null) && (MainActivity.numbers != null))
        {
            //Vector2 livesTextPosition = new Vector2(GameController.screenWidth, 0);
            int tmpLife = lives;
            int i = 1;
            while (tmpLife >= 0) {
                int number = tmpLife % 10;
                canvas.drawBitmap(MainActivity.numbers[number], null,
                        new Rect((int) GameController.screenWidth - i * lifeRect.width(), 0,
                                (int) GameController.screenWidth - (i - 1) * lifeRect.width(),
                                lifeRect.height()), paint);
                tmpLife /= 10;
                i++;

                if (tmpLife == 0) {
                    break;
                }
            }
            canvas.drawBitmap(MainActivity.bullets, null,
                    new Rect((int) GameController.screenWidth - (i - 1) * lifeRect.width() - lifeRect.width() * 3, 0,
                            (int) GameController.screenWidth - (i - 1) * lifeRect.width(),
                            lifeRect.height()), paint);
        }
    }
}
