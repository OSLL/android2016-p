package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by user on 6/20/2016.
 */
public class SettingsGameState implements IGameState, Menu {
    private Button menuButton;
    private BackTexture settings;
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
        menuButton = new Button(GameController.screenWidth*(366f/850f), GameController.screenHeight*(391f/501f),
                GameController.screenWidth*(464f/850f), GameController.screenHeight*(488f/501f), ButtonName.MenuButton);
        menuButton.attach(this);
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
        GameController.setGamePhase(GameState.PHASE_NEW_GAME);
    }
}
