package com.company;

//import javax.swing.*;

/**
 * Created by user on 6/16/2016.
 */
public class Button
{
    public Collider collider;
    public ButtonName name;
    //public Bitmap image ;
    public Menu menu;
    public Button (double x1, double y1, double x2, double y2, ButtonName buttonName)
    {
        collider = new Collider(x1, y1, x2, y2);
        name = buttonName;
    }
    public Button (Collider collider, ButtonName buttonName)
    {
        this.collider = collider;
        name = buttonName;
    }
    public Button (Vector2 vector1, Vector2 vector2, ButtonName buttonName)
    {
        collider = new Collider(vector1, vector2);
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
