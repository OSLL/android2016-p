package ru.videniya239.simpleballistics;

import android.graphics.Canvas;

/**
 * Created by user on 6/17/2016.
 */
public class PlayGameState implements IGameState
{
    private LevelManager levelManager;
    private Cannon cannon;
    private Bullet bullet;

    @Override
    public void Update(float deltaT) {

    }

    @Override
    public void Draw(Canvas canvas) {

    }

    @Override
    public void InvokeState()
    {
        levelManager = LevelManager.GetInstance();
        //levelManager.Initialize();

        bullet = new Bullet();
        cannon = new Cannon();
    }
}
