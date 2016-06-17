package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 6/17/2016.
 */
public class PlayGameState implements IGameState
{
    private LevelManager levelManager;
    private Paint paint;


    @Override
    public void Update(float deltaT)
    {
//        Log.d("bull", "" + bullet.toString());
        levelManager.GetCurrentLevel().Update(deltaT);

    }

    @Override
    public void Draw(Canvas canvas)
    {
        Log.d("paint", "" + paint.getColor());
        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);
        levelManager.GetCurrentLevel().Draw(canvas);
    }

    public PlayGameState()
    {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        levelManager = LevelManager.GetInstance();
        levelManager.AddLevel(new Level());
    }

    @Override
    public void InvokeState()
    {
        levelManager.MoveNext();
    }
}
