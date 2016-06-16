package ru.videniya239.simpleballistics;

//import javax.swing.*;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by user on 6/16/2016.
 */
public class Button
{
    public Collider collider;
    public ButtonName name;
    //public Bitmap image ;
    public Menu menu;
    public Button (float x1, float y1, float x2, float y2, ButtonName buttonName)
    {
        collider = new Collider(new RectF(x1, y1, x2, y2));
        name = buttonName;
    }
    public Button (Collider collider, ButtonName buttonName)
    {
        this.collider = collider;
        name = buttonName;
    }

    public void attach(Menu menu)
    {
        this.menu = menu;
    }
    public void Notify()
    {
        if(menu != null)
            menu.update(name);
    }
}
