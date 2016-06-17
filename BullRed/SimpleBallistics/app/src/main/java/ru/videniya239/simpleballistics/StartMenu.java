package ru.videniya239.simpleballistics;

//import static com.company.ButtonName.*;
//import static com.company.ButtonName.Play;

import android.graphics.Canvas;
<<<<<<< HEAD
import android.widget.ImageView;
=======
>>>>>>> a63745b251695aba2198eb116b70b1d3221999ba

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
    public StartMenu()
    {
        BackTexture backTexture = new BackTexture(MainActivity.startMenuImage);
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

    }

    @Override
    public void invoke()
    {

    }

    public void createButtons()
    {
        //create your buttons here
        Button playButton = new Button(0, 0, 100, 100, ButtonName.PlayButton);
        playButton.attach(this);
        Button exitButton = new Button(100, 0, 200, 100, ButtonName.ExitButton);
        exitButton.attach(this);
        Button infoButton = new Button(200, 0, 300, 100, ButtonName.InfoButton);
        infoButton.attach(this);
        Button settingsButton = new Button(300, 0, 400, 100, ButtonName.SettingsButton);
        settingsButton.attach(this);

    }

    private  void  playButtonTapped()
    {

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
