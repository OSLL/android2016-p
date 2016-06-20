package ru.videniya239.simpleballistics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import java.util.ArrayList;

public class Level //implements Menu
{
    private Cannon cannon;
    private Bullet bullet;
    private Paint paint;
    private BackTexture background;
    private Bitmap levelMap;
    //private Button shootButton;

    private final int checkAngle = 60;



    private boolean bulletFlying;
    private float windVelocity;

    public static ArrayList<Vector2> traectory;

    public void Init(Bitmap background, Bitmap levelMap, float windVelocity, Rect carriageRect, Rect cannonRect)
    {
        this.background = new BackTexture(background);
        this.levelMap = levelMap;

        this.windVelocity = windVelocity;
        traectory = new ArrayList<>();
        paint = new Paint();
        paint.setColor(Color.WHITE);

        cannon = new Cannon(45, new Vector2(GameController.screenWidth * 54f / 700f,
                GameController.screenHeight * 256f / 349f), cannonRect, carriageRect);
    }
    public void Start()
    {
        cannon.Activate();
    }

    public void Shoot()
    {

        if (!bulletFlying)
        {
            bullet = cannon.CreateBullet(windVelocity);
            bulletFlying = true;
        }
    }

    public void Draw(Canvas canvas)
    {
        background.draw(canvas);
        cannon.DrawCannon(canvas);
        if (!bulletFlying) {
            cannon.Draw(canvas);
        }
        if (bulletFlying)
        {
                paint.setColor(Color.WHITE);
                bullet.Draw(canvas);
            for (Vector2 position : traectory) {
                paint.setColor(Color.BLACK);
                canvas.drawCircle(position.x, position.y, bullet.drawRadius, paint);
            }
        }

    }

    public void Update(float deltaT)
    {
        if (!bulletFlying)
        {
            cannon.Update();
        }
        else
        {
            for (int i = 0; i < 360 / checkAngle; i++)
            {
                Vector2 checkPoint = getCheckCoord(checkAngle * i);
                if (insideScreen(checkPoint.x, checkPoint.y))
                {
                    if (!CheckColor(checkPoint))
                    {
                        bullet.Update(deltaT);
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    miss();
                }
            }
        }
    }

    private Vector2 getCheckCoord(int angle)
    {
        return new Vector2(bullet.getPosX() + (float)Math.cos(angle * Math.PI / 180) * bullet.drawRadius,
                bullet.getPosY() + (float)Math.sin(angle * Math.PI / 180) * bullet.drawRadius);
    }

    private boolean CheckColor(Vector2 pos)
    {
        if (Color.red(getMapPixel((int)pos.x, (int)pos.y)) >= 250) {
            onTarget();
            return true;
        }
        if (Color.green(getMapPixel((int)pos.x, (int)pos.y)) <= 250) {
            return false;
        }
        else
        {
            miss();
            return true;
        }
    }

    private void miss()
    {
        bulletFlying = false;
        traectory.clear();
    }

    private void onTarget()
    {
        bulletFlying = false;
        traectory.clear();
        cannon.Deactivate();
        Log.d("level", "level finished: " + LevelManager.GetInstance().GetCurrentLevelNumber());
        //GameController.DetachButton(shootButton);
        GameController.DetachSlider(cannon.velocitySlider);
        GameController.setGamePhase(GameState.PHASE_RESULT);
    }

    private boolean insideScreen(float posX, float posY)
    {
        return ((posX > 0) && (posX < GameController.screenWidth) &&
                (posY > 0) && (posY < GameController.screenHeight));
    }

    private int getMapPixel(int x, int y)
    {
        return levelMap.getPixel(x * levelMap.getWidth() / (int)GameController.screenWidth,
                                 y * levelMap.getHeight() / (int)GameController.screenHeight);
    }

    /*@Override
    public void updateButtons(ButtonName b)
    {
        if (b == ButtonName.ShootButton)
        {
            if (!bulletFlying) //&& !cannon.velocitySlider.tapped)
                Shoot();
        }
    }

    @Override
    public void show()
    {

    }*/
}
