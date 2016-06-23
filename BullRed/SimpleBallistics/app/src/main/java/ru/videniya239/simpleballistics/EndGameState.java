package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Paint;

public class EndGameState implements IGameState, Menu
{
    private Button exitButton;
    private Button restartButton;
    private Button menuButton;
    private BackTexture win;
    private BackTexture lose;
    private Paint paint;

    @Override
    public void Update(float deltaT) {

    }

    @Override
    public void Draw(Canvas canvas)
    {
        if (!LevelManager.GetInstance().lose)
            win.draw(canvas, paint);
        else
            lose.draw(canvas, paint);
    }


    @Override
    public void InvokeState()
    {
        restartButton = new Button(GameController.screenWidth*(22f/1280f),
                GameController.screenHeight*(470f/628f),
                GameController.screenWidth*(164f/1280f),
                GameController.screenHeight*(611f/628f), ButtonName.RestartButton);
        restartButton.attach(this);
        menuButton = new Button(GameController.screenWidth*(1113f/1280f),
                GameController.screenHeight*(470f/628f),
                GameController.screenWidth*(1258f/1280f),
                GameController.screenHeight*(611f/628f), ButtonName.MenuButton);
        menuButton.attach(this);
        win = new BackTexture(MainActivity.win);
        lose = new BackTexture(MainActivity.lose);
    }

    @Override
    public void EndState() {

    }

    private void ExitGame()
    {
        GameController.stopGame();
    }

    private void RestartGame()
    {
        close();
        LevelManager.GetInstance().Reset();
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
