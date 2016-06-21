package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

interface Menu
{
    void updateButtons(ButtonName b);
    void show();
}

enum ButtonName
{
    // you should enumerate button names here
    PlayButton, ExitButton, InfoButton, SettingsButton, ShootButton, SliderButton, RestartButton, MenuButton;
}



public class StartMenu implements Menu
{
    private BackTexture backTexture;
    private Paint paint;

    public StartMenu()
    {
        backTexture = new BackTexture(MainActivity.startMenuImage);
    }



    public void close()
    {
        GameController.DetachButton(playButton);
        GameController.DetachButton(infoButton);
        GameController.DetachButton(exitButton);
        GameController.DetachButton(settingsButton);

    }

    @Override
    public void updateButtons(ButtonName buttonName)
    {
        //Log.d("ttt", "" + buttonName);
        switch(buttonName)
        {
            case PlayButton:
                playButtonTapped();
                break;
            case ExitButton:
                exitButtonTapped();
                break;
            case InfoButton:
                infoButtonTapped();
                break;
            case SettingsButton:
                settingsButtonTapped();
                break;
        }
    }

    @Override
    public void show()
    {
        createButtons();
    }

    public void Draw(Canvas canvas)
    {
        backTexture.draw(canvas, paint);
    }

    Button playButton;
    Button exitButton;
    Button infoButton;
    Button settingsButton;

    public void createButtons()
    {
        playButton = new Button(GameController.screenWidth*(1033f/1785f), GameController.screenHeight*(515f/1000f),
                GameController.screenWidth*(1243f/1785f), GameController.screenHeight*(734f/1000f), ButtonName.PlayButton);
        playButton.attach(this);
        infoButton = new Button(GameController.screenWidth*(1265f/1785f), GameController.screenHeight*(841f/1000f),
                GameController.screenWidth*(1419f/1785f), GameController.screenHeight*(987f/1000f), ButtonName.InfoButton);
        infoButton.attach(this);
        settingsButton = new Button(GameController.screenWidth*(1445f/1785f), GameController.screenHeight*(841f/1000f),
                GameController.screenWidth*(1603f/1785f), GameController.screenHeight*(987f/1000f), ButtonName.SettingsButton);
        settingsButton.attach(this);
        exitButton = new Button(GameController.screenWidth*(1620f/1785f), GameController.screenHeight*(841f/1000f),
                GameController.screenWidth*(1764f/1785f), GameController.screenHeight*(987f/1000f), ButtonName.ExitButton);
        exitButton.attach(this);

    }

    private void playButtonTapped()
    {
        GameController.setGamePhase(GameState.PHASE_PLAY);
    }

    private void exitButtonTapped()
    {
        GameController.stopGame();
    }
    private void infoButtonTapped()
    {

    }
    private void settingsButtonTapped()
    {
        GameController.setGamePhase(GameState.PHASE_SETTINGS);
    }

}
