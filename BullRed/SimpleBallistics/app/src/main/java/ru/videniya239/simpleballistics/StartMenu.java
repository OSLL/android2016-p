package ru.videniya239.simpleballistics;

//import static com.company.ButtonName.*;
//import static com.company.ButtonName.Play;

import android.app.Application;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Debug;
import android.util.Log;
import android.widget.ImageView;

import junit.framework.Assert;


/**
 * Created by user on 6/16/2016.
 */
interface Menu
{
    void update(ButtonName b);
    void invoke();
}

enum ButtonName
{
    // you should enumerate button names here
    PlayButton, ExitButton, InfoButton, SettingsButton;
}



public class StartMenu implements Menu
{
    private BackTexture backTexture;
    private Paint paint;

    public StartMenu()
    {
        backTexture = new BackTexture(MainActivity.startMenuImage);
        createButtons();
    }

    public void invoke()
    {

        //backTexture.draw(Canvas canvas, Paint paint);
    }

    @Override
    public void update(ButtonName buttonName)
    {
        //case of your buttonEvents
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

    public void Draw(Canvas canvas)
    {
        backTexture.draw(canvas, paint);
        //canvas.drawBitmap(backTexture.image, 0, 0, new Paint());
    }


    public void createButtons()
    {
        //create your buttons here
        Log.d("Screen", GameController.screenWidth + " " + (1033f/1785f) );
        Button playButton = new Button(GameController.screenWidth*(1033f/1785f), GameController.screenHeight*(515f/1000f),
                GameController.screenWidth*(1243f/1785f), GameController.screenHeight*(734f/1000f), ButtonName.PlayButton);
        playButton.attach(this);
        Button exitButton = new Button(GameController.screenWidth*(1265/1785), GameController.screenHeight*(841/1000), GameController.screenWidth*(1419/1785), GameController.screenHeight*(987/1000), ButtonName.ExitButton);
        exitButton.attach(this);
        Button infoButton = new Button(GameController.screenWidth*(1445/1785), GameController.screenHeight*(841/1000), GameController.screenWidth*(1603/1785), GameController.screenHeight*(987/1000), ButtonName.InfoButton);
        infoButton.attach(this);
        Button settingsButton = new Button(GameController.screenWidth*(1620/1785), GameController.screenHeight*(841/1000), GameController.screenWidth*(1764/1785), GameController.screenHeight*(987/1000), ButtonName.SettingsButton);
        settingsButton.attach(this);

    }

    private void  playButtonTapped()
    {
        GameController.GetInstance().setGamePhase(GameState.PHASE_PLAY);
    }

    private  void  exitButtonTapped()
    {

    }
    private  void  infoButtonTapped()
    {

    }
    private  void  settingsButtonTapped()
    {

    }

}
