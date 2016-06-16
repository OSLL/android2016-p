package com.company;

import static com.company.ButtonName.*;
import static com.company.ButtonName.Play;

/**
 * Created by user on 6/16/2016.
 */
interface Menu
{
    void update(ButtonName b);
}

enum ButtonName
{
    // you should enumerate button names here
    Play;
}



public class StartMenu implements Menu
{
    @Override
    public void update(ButtonName buttonName)
    {
        //case of your buttonEvents
        switch(buttonName)
        {
            case Play:
                playButtonTapped();
                break;
        }
    }
    public void createButtons()
    {
        //create your buttons here
        Button playButton = new Button(0, 0, 100, 100, Play);
        playButton.attach(this);
    }

    private  void  playButtonTapped()
    {

    }

}
