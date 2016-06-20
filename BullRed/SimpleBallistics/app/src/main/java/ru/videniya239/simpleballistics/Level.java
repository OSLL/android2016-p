package ru.videniya239.simpleballistics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import java.util.ArrayList;

public class Level implements Menu
{
    private Cannon cannon;
    private Bullet bullet;
    private Paint paint;
    private BackTexture background;
    private Bitmap levelMap;
    private Button shootButton;

    private final int checkAngle = 60;

    private boolean bulletFlying;
    private float windVelocity;

    public static ArrayList<Vector2> traectory;

    public void Init(Bitmap background, Bitmap levelMap, float windVelocity)
    {
        this.background = new BackTexture(background);
        this.levelMap = levelMap;

        this.windVelocity = windVelocity;
        traectory = new ArrayList<>();
        paint = new Paint();
        paint.setColor(Color.WHITE);

        cannon = new Cannon(45, new Vector2(130, GameController.screenHeight - 480),
                new Rect(0, (int)GameController.screenHeight - 600, 200, (int)GameController.screenHeight - 400));
    }
    public void Start()
    {
        shootButton = new Button(0, 0, 300, 300, ButtonName.ShootButton);
        shootButton.attach(this);
        cannon.Activate();
    }

    public void Shoot()
    {
        bullet = cannon.CreateBullet();
        bullet.modVw = windVelocity;
        bulletFlying = true;
    }

    public void Draw(Canvas canvas)
    {
        background.draw(canvas);
        if (bulletFlying)
        {
                paint.setColor(Color.WHITE);
                bullet.Draw(canvas);
           /* for (Vector2 position : traectory) {
                canvas.drawCircle(position.x, position.y, 15.0f, paint);
            }*/

        }
        cannon.Draw(canvas);
    }

    public void Update(float deltaT)
    {
        cannon.Update();
        if (bulletFlying)
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
        return new Vector2(bullet.posX + (float)Math.cos(angle * Math.PI / 180) * bullet.drawRadius,
                bullet.posY + (float)Math.sin(angle * Math.PI / 180) * bullet.drawRadius);
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
    }

    private void onTarget()
    {
        bulletFlying = false;
        cannon.Deactivate();
        Log.d("level", "" + LevelManager.GetInstance().GetCurrentLevelNumber());
        GameController.DetachButton(shootButton);
        GameController.setGamePhase(GameState.PHASE_END_LEVEL);
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

    @Override
    public void updateButtons(ButtonName b)
    {
        if (b == ButtonName.ShootButton)
        {
            if (!bulletFlying)
                Shoot();
        }
    }

    @Override
    public void show()
    {

    }
}
