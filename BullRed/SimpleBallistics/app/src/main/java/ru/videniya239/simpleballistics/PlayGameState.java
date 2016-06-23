package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import junit.framework.Assert;

import java.util.ArrayList;

public class PlayGameState implements IGameState
{
    private LevelManager levelManager;
    private Paint paint;

    private int deltaLives = 3;
    private int startLives = 5;


    @Override
    public void Update(float deltaT)
    {
        if (levelManager.GetCurrentLevelNumber() >= 1)
        {
            levelManager.GetCurrentLevel().Update(deltaT);
        }
    }

    @Override
    public void Draw(Canvas canvas)
    {
        if (levelManager.GetCurrentLevelNumber() > 0)
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
         Log.d("levelmanager", "" + levelManager.GetCurrentLevelNumber() + " " + levelManager.GetLevelCount());

        if (levelManager.GetCurrentLevelNumber() < levelManager.GetLevelCount())
        {
            if (levelManager.GetCurrentLevelNumber() == 0)
            {
                LifeManager.getInstance().Init(startLives, new Rect(0, 0, (int) (GameController.screenWidth * 48f / 1280f),
                        (int) (GameController.screenHeight * 76f / 628f)));
            }
            else {
                LifeManager.getInstance().changeLives(deltaLives);
            }
            levelManager.MoveNext();
            Log.d("levelmanager", "" + levelManager.GetCurrentLevelNumber());
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
