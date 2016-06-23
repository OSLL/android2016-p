package ru.videniya239.simpleballistics;

import android.graphics.Rect;

public class Button implements ITappable
{
    public Collider collider;
    public ButtonName name;
    private Menu menu;

    public Button (float x1, float y1, float x2, float y2, ButtonName buttonName)
    {
        collider = new Collider(new Rect((int)x1, (int)y1, (int)x2, (int)y2));
        name = buttonName;
        GameController.AttachButton(this);
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
            menu.updateButtons(name);
    }

    @Override
    public boolean onTap(Vector2 position)
    {
        if (collider.intersectsP((int)position.x, (int)position.y))
        {
            Notify();
            return true;
        }
        return false;
    }
}
