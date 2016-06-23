package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Paint;

public class SettingsGameState implements IGameState, Menu {
    private Button menuButton;
    private BackTexture settings;
    private Paint paint;
    @Override
    public void show()
    {

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
        menuButton = new Button(GameController.screenWidth*(587f/1280f), GameController.screenHeight*(483f/628f),
            GameController.screenWidth*(710f/1280f), GameController.screenHeight*(600f/628f), ButtonName.MenuButton);
        menuButton.attach(this);
        paint = new Paint();
        settings = new BackTexture(MainActivity.settings);
    }

    @Override
    public void Update(float deltaT)
    {

    }

    @Override
    public void Draw(Canvas canvas) {
        settings.draw(canvas, paint);
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
