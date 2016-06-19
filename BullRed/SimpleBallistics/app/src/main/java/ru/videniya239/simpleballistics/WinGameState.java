package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.util.Log;

public class WinGameState implements IGameState, Menu
{
    private Button exitButton;

    @Override
    public void Update(float deltaT) {

    }

    @Override
    public void Draw(Canvas canvas) {

    }

    @Override
    public void InvokeState()
    {
        exitButton = new Button(0, 0, 300, 300, ButtonName.ExitButton);
        exitButton.attach(this);
        //Log.d("Exit1", "stop");
    }

    @Override
    public void EndState() {

    }

    private void ExitGame()
    {
        //Log.d("Exit", "stop game");
        GameController.stopGame();
    }

    private void RestartGame()
    {
        LevelManager.GetInstance().Reset();
    }

    @Override
    public void updateButtons(ButtonName b)
    {
        //Log.d("button", "" + b);
        if (b == ButtonName.ExitButton)
        {
            ExitGame();
        }
    }

    @Override
    public void show()
    {
    }
}
