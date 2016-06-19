package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import junit.framework.Assert;

import java.util.ArrayList;

public class PlayGameState implements IGameState
{
    private LevelManager levelManager;
    private Paint paint;


    @Override
    public void Update(float deltaT)
    {
        levelManager.GetCurrentLevel().Update(deltaT);
    }

    @Override
    public void Draw(Canvas canvas)
    {
        levelManager.GetCurrentLevel().Draw(canvas);
    }

    public PlayGameState()
    {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        levelManager = LevelManager.GetInstance();
    }

    @Override
    public void InvokeState()
    {
        if (levelManager.GetCurrentLevelNumber() < levelManager.GetLevelCount())
        {
            levelManager.MoveNext();
        }
        else
        {
            GameController.setGamePhase(GameState.PHASE_RESULT);
        }
    }

    @Override
    public void EndState()
    {

    }
}
