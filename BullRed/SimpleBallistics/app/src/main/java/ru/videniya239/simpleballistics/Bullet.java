package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by user on 6/17/2016.
 */
public class Bullet
{
    private Body body;
    private Vector2 vector2;

    private Paint paint = new Paint();

    float w; //WINDOWWIDTH
    float h; //windowheight

    float w_m;//условные размеры экрана в метрах
    float h_m;

    float aX;//ускорение
    float aY;
    float vX;//скорость снаряд
    float vY;
    float vwX;//скорость ветра
    float vwY;
    float posX;//текущая координата снаряда
    float posY;
    float posX0;//начальная координата снаряда
    float posY0;

    float alpha;
    float modV;//модуль начальной скорости
    float modVw;//модуль скорости ветра


    float gX;//ускорение свободного падения
    float gY;


    float k;//коэффициенты их бы надо подоюрать
    float m;

    private float currentTime;



    public Body GetBody()
    {
        return body;
    }

    public Bullet()
    {
        paint.setColor(Color.WHITE);
        w = GameController.screenWidth; //получаем разрешение экранчика
        h = GameController.screenHeight;

        w_m = 2000;//условные размеры экрана в метрах
        h_m = w_m/w*h;
        gX = 0;
        gY = 10/w_m*w;

        //v [300, 400] м/с
        //вот эта параша должна вводиться
        modV = 250; //Скорость
        alpha = 60; //Угол
        //

        vX =  modV* (float)Math.cos(alpha*Math.PI/180)*w/w_m;
        vY = -modV* (float)Math.sin(alpha*Math.PI/180)*w/w_m;

        k = 100;//константы
        m = 1500;

        modVw = 10 ;//а вот эту парашу надо генерировать в каких-то границах
        vwY = 0;//вводим ветерок
        vwX = -modVw/w_m*w;


        posX = 20;//начальное положение снаряда
        posY = h - 20;
        posX0 = posX;
        posY0 = posY;

    }

    public void Update(float deltaT)
    {
        currentTime += deltaT;
        if (currentTime > 300) {
            LevelManager.GetInstance().GetCurrentLevel().traectory.add(new Vector2(posX, posY));
            currentTime = 0;
        }


        aX = (k / m) * (vX + (-vwX));//находим значение ускорения в данный момент времени
        aY = -gY + (k / m) * vY;

        vX = vX - (deltaT/1000) * aX;//находим значение скорости в данный момент времени
        vY = vY - (deltaT/1000) * aY;
        Log.d("delta", "" + deltaT);
        posX = posX + (deltaT/1000) * vX;//считая, что движение равномерное на deltaT находим новое положение снаряда
        posY = posY + (deltaT/1000) * vY;
    }

    public void Draw(Canvas canvas)
    {

        if ((posX<=posX0) && (posY<=posY0)) {
            canvas.drawCircle(posX, posY, 15.0f, paint);
            Log.d("Bullet", "" + posX + " " + posY);
        }
    }


}
