package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class WinGameState implements IGameState, Menu
{
    private Button exitButton;
    private Button restartButton;
    private Button menuButton;
    private BackTexture win;
    private Paint paint;

    @Override
    public void Update(float deltaT) {

    }

    @Override
    public void Draw(Canvas canvas)
    {
        win.draw(canvas, paint);
    }


    @Override
    public void InvokeState()
    {
        // exitButton = new Button(0, 0, 300, 300, ButtonName.ExitButton);
        //exitButton.attach(this);
        restartButton = new Button(GameController.screenWidth*(42f/850f), GameController.screenHeight*(388f/501f),
                GameController.screenWidth*(135f/850f), GameController.screenHeight*(477f/501f), ButtonName.RestartButton);
        restartButton.attach(this);
        menuButton = new Button(GameController.screenWidth*(717f/850f), GameController.screenHeight*(388f/501f),
                GameController.screenWidth*(812f/850f), GameController.screenHeight*(477f/501f), ButtonName.MenuButton);
        menuButton.attach(this);
        win = new BackTexture(MainActivity.win);
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
        close();
        Log.d("button", "restart");
        LevelManager.GetInstance().Reset();
        //GameController.InitNewGame();
        GameController.setGamePhase(GameState.PHASE_PLAY);
    }

    private void close()
    {
        GameController.DetachButton(menuButton);
        GameController.DetachButton(restartButton);
    }

    @Override
    public void updateButtons(ButtonName buttonName)
    {
        switch(buttonName)
        {
            case MenuButton:
                menuButtonTapped();
                break;

            case RestartButton:
                restartButtonTapped();
                break;
        }
    }

    private void menuButtonTapped()
    {
        close();
        //RestartGame();
        LevelManager.GetInstance().Reset();
        GameController.InitNewGame();
        GameController.setGamePhase(GameState.PHASE_NEW_GAME);
    }
    private void restartButtonTapped()
    {
        RestartGame();
    }

    @Override
    public void show()
    {
    }
}
