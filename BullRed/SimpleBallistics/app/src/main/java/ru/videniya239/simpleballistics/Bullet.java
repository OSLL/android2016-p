package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

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

    float Ro;//плотность среды у воздуха 1.225 кг/м^3
    float Cf;
    float S; //площадь сечения ядра
    float d;//диаметр ядра
    float m;//масса ядра

    int drawRadius = 3; //метры


    //F = (Cf/2)*Ro*V^2*S -сила трения
    //Ro - плотность среды, V - скорость в среде, Cf - аэродинамический коэффициент сопротивления, для сферы 0.47

    private float currentTime;


    public Bullet(float velocity, float angle)
    {
        modV = velocity;
        alpha = angle;
        Init();
    }

    public Body GetBody()
    {
        return body;
    }

    public void Init()
    {
        paint.setColor(Color.WHITE);
        w = GameController.screenWidth; //получаем разрешение экранчика
        h = GameController.screenHeight;




        w_m = 300;//условные размеры экрана в метрах
        h_m = w_m/w*h;
        gX = 0;
        //gY = 10f/w_m*w;
        gY = 10;
        drawRadius  = (int)(drawRadius * w / w_m);
        //v [300, 400] м/с
        //вот эта параша должна вводиться
        //modV = 164; //Скорость
        //alpha = 45; //Угол
        //

       // vX =  modV* (float)Math.cos(alpha*Math.PI/180)*w/w_m;
       // vY = -modV* (float)Math.sin(alpha*Math.PI/180)*w/w_m;


        vX =  modV * (float)Math.cos(alpha*Math.PI/180);
        vY = -modV * (float)Math.sin(alpha*Math.PI/180);

        //КОНСТАНТЫ
        Ro = 1.225f;//кг/м^3
        Cf = 0.47f;

        //Возможные ядра------------------------------
        //m=1.4кг d=76мм
        //m=2кг d=88мм
        //m=2.9кг d=96мм
        //m=4кг d=108мм
        //yj это маленькие слишком нам нужно побольше
        //d = 122мм 	m = 5,9кг   modV = 126  modV1000 =
        //d = 133мм 	m = 7,9кг   modV = 117  modV1000 = 164
        //d = 137мм	m = 8,8кг       modV = 113  modV1000 = 159
        //d = 152мм 	m = 11,9кг  modV = 108  modV1000 = 152
        //d = 164мм	m = 15,4кг      modV = 103  modV1000 = 144
        //d = 172мм	m = 18,5кг      modV = 99   modV1000 = 139

        //d = 196мм 	m = 26,2кг - самое то  modV = 96
        //d = 214мм	m = 26,2кг  modV = 103
        //m = (2п)32.76кг	d = 245мм    modV = 105
        //m = (3п)49.14кг	d = 273мм    modV = 97
        //m = (5п)81.9 кг	d = 333мм    modV = 93

        m = 32.76f;//кг
        d = 0.245f;//м - диаметр ядра
        //--------------------------------------------

        S  = (float)(Math.PI * d * d /4);

        //modVw = 0 ;//а вот эту парашу надо генерировать в каких-то границах
        vwY = 0;//вводим ветерок
        //vwX = -modVw/w_m*w;

        vwX = -modVw;

       // posX = 20;//начальное положение снаряда
       // posY = h - 20;
        posX = 100;
        posY = h - 100;

        posX0 = posX;
        posY0 = posY;

    }

    public void Update(float deltaT)
    {
       /* currentTime += deltaT;
        if (currentTime > 300)
        {
            LevelManager.GetInstance().GetCurrentLevel().traectory.add(new Vector2(posX, posY));
            currentTime = 0;
        }*/


        aX = -Math.signum(vX)*(Cf*Ro*S* (vX + (-vwX))*(vX + (-vwX)) /2)/m;//находим значение ускорения в данный момент времени
        aY = gY + (-Math.signum(vY))*(Cf*Ro*S*vY*vY/2)/m;

        vX = vX + (deltaT/1000) * aX;//находим значение скорости в данный момент времени
        vY = vY + (deltaT/1000) * aY;

        Log.d("delta", "" + deltaT);

        posX = posX + (deltaT/1000) * vX /w_m*w;//считая, что движение равномерное на deltaT находим новое положение снаряда
        posY = posY + (deltaT/1000) * vY /w_m*w;
    }

    public void Draw(Canvas canvas)
    {
        paint.setColor(Color.WHITE);
            canvas.drawCircle(posX, posY, drawRadius, paint);
            Log.d("Bullet", "" + posX + " " + posY);
    }


}
