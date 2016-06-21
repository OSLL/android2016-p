package ru.videniya239.simpleballistics;

import android.graphics.Canvas;

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
        startMenu.show();

        GameController.InitNewGame();
    }

    @Override
    public void EndState() {
        startMenu.close();
    }
}
