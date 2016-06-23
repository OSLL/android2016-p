package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Paint;

public class InfoState implements IGameState, Menu
{
    private Button menuButton;
    private BackTexture tutorial;
    private Paint paint;

    @Override
    public void show() {

    }

    @Override
    public void updateButtons(ButtonName buttonName)
    {
        switch(buttonName) {
            case MenuButton:
                menuButtonTapped();
                break;
        }
    }

    @Override
    public void InvokeState()
    {
        menuButton = new Button(GameController.screenWidth*(15f/1280f), GameController.screenHeight*(500f/628f),
                GameController.screenWidth*(124f/1280f), GameController.screenHeight*(613f/628f), ButtonName.MenuButton);

        paint = new Paint();
        menuButton.attach(this);
        tutorial = new BackTexture(MainActivity.tutorial);
    }

    @Override
    public void Update(float deltaT)
    {

    }

    @Override
    public void Draw(Canvas canvas) {
        tutorial.draw(canvas, paint);
    }

    @Override
    public void EndState() {

    }

    private void menuButtonTapped()
    {
        GameController.DetachButton(menuButton);
        GameController.setGamePhase(GameState.PHASE_NEW_GAME);
    }
}
