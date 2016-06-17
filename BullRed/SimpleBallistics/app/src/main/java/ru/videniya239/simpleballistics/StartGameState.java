package ru.videniya239.simpleballistics;

import android.graphics.Canvas;

/**
 * Created by user on 6/17/2016.
 */
public class StartGameState implements IGameState
{
    private StartMenu startMenu;

    @Override
    public void Update(float deltaT)
    {
    }

    @Override
    public void Draw(Canvas canvas)
    {
        startMenu.Draw(canvas);
    }

    @Override
    public void InvokeState()
    {
        startMenu = new StartMenu();
        startMenu.invoke();
    }
}
