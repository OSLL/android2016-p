package com.example.user.superdupershooter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 6/16/2016.
 */
public class DrawThread extends Thread implements Runnable{

    private SurfaceHolder surfaceHolder;
    private volatile boolean running = true;//флаг для остановки потока
    private Paint paint = new Paint();

    private int width;
    private int height;

    final Random random = new Random();

    Rect player_rect;


    private int plength, pheight, spaceh, spacew;

    private int y, y0;
    private int a = 7;
    private int v;
    private int move;
    private float t;
    private int platform_time = 1;
    private  int k = 0;

    private Activity activity;

    private int flag;
    private int flag_ready = 0;
    private int luft = height / 5;

    private int touch_x;

    private int bJ = 0, bM;


    private ArrayList<Rect> platforms;
    private ArrayList<Rect> monsters;
    private ArrayList<Bullet> bullets;
    private Bitmap player_pic, monster_pic;



    public DrawThread(Context context, SurfaceHolder surfaceHolder,  int width, int height, Activity activity, Bitmap player_pic, Bitmap monster_pic) {
        this.surfaceHolder = surfaceHolder;
        this.width = width;
        this.height = height;
        this.player_pic = player_pic;
        this.monster_pic = monster_pic;
        this.activity = activity;
        bullets = new ArrayList<>();
        y = height / 2;
        y0 = y;
        player_rect = new Rect(width / 16, height/ 2 - width /10, width / 16 + width / 10, height / 2);
    }


    public void requestStop() {
        running = false;
    }


    public void run() {
        MapCreate();
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {

                    Flying();
                    Landing();
                    Update();
                    Draw(canvas);


                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public void MapCreate(){
        platforms = new ArrayList<>();
        monsters = new ArrayList<>();
        Rect rect, rect_monster;
        int randh, randznak, randmonster;
        pheight = height / 20;
        plength = width / 5 ;
        spacew = width / 15;
        spaceh = height / 4;




        platforms.add(new Rect(width / 16, height /2 , width / 16 + width / 5, height / 2 + height / 20));

        for (int i = 1; i < 1500; i++)
        {

            randmonster = random.nextInt(5);
            Log.i("vars",  "randmonster = " + randmonster);
            randh = random.nextInt(spaceh);
            randznak = random.nextInt(2);
            if (randznak == 1) {
                if (platforms.get(i - 1).bottom + randh < 39 * height / 40) {
                    rect = new Rect(platforms.get(i - 1).right + spacew, platforms.get(i - 1).top + randh,
                            platforms.get(i - 1).right + spacew + plength, platforms.get(i - 1).top + randh + pheight);

                    platforms.add(rect);
                }
                else{
                    rect = new Rect(platforms.get(i - 1).right + spacew, 3 * height / 4,
                            platforms.get(i - 1).right + spacew + plength, 3 * height / 4 + pheight);

                    platforms.add(rect);

                }


            }
            else
            {
                if (platforms.get(i - 1).top - randh > height / 10) {
                    rect = new Rect(platforms.get(i - 1).right + spacew, platforms.get(i - 1).top - randh,
                            platforms.get(i - 1).right + spacew + plength, platforms.get(i - 1).top - randh + pheight);

                    platforms.add(rect);
                }
                else
                {
                    rect = new Rect(platforms.get(i - 1).right + spacew, height / 4,
                            platforms.get(i - 1).right + spacew + plength, height / 4 + pheight);

                    platforms.add(rect);
                }

            }



            if (randmonster == 1)
            {
                Log.d("Monst","fdsf");
                int aa = platforms.get(i).top - width / 10;
                int bb = platforms.get(i).left;
                int cc = platforms.get(i).top;
                int kk =  platforms.get(i).right;
                rect_monster = new Rect(bb,aa, kk, cc );
               System.out.println(aa + " " + bb + " " + cc + " " + kk);


                monsters.add(rect_monster);

            }

        }
    }

    public void Update()
    {

        //platforms
        platform_time += 1;

        if (platform_time > 300)
        {
            platform_time = 0;
            move += 1;
        }

        for (int i = 0; i < platforms.size(); i++)
        {
            platforms.get(i).left = platforms.get(i).left - move;
            platforms.get(i).right = platforms.get(i).right - move;
        }

        for (int i = 0; i < monsters.size(); i++)
        {
            monsters.get(i).left = monsters.get(i).left - move;
            monsters.get(i).right = monsters.get(i).right - move;
        }


        //bullets update
        for(int i = 0; i < bullets.size(); i++)
        {
            bullets.get(i).x += bullets.get(i).vx;
            bullets.get(i).y += bullets.get(i).vy;

            if (bullets.get(i).x >= bullets.get(i).x_end) {
                monsters.remove(bullets.get(i).j);
                bullets.remove(i);
            }

        }


        //score
        k = 0;

        for (int i = 0; i < platforms.size(); i++)
        {
            if (platforms.get(i).left < 0)
                k += 1;
        }
    }


    public void Flying()
    {
        flag = 0;
        for (int i = 0; i < platforms.size(); i++)
        {
            if (platforms.get(i).top == y)
            {
                if (player_rect.left + width / 20 <= platforms.get(i).right && player_rect.left + width / 20 >= platforms.get(i).left)
                {
                    flag = 1;
                    t = 0;
                    y = platforms.get(i).top;
                    if (bJ == 1) {
                        y -= v;

                    }
                }
            }
        }

        if (flag != 1)
        {
            if (bJ != 0)
            {
                y = y - v;
            }
            t += 0.1;
            y = y + (int)Math.ceil(a * t * t / 2);
            player_rect.bottom = y;
            player_rect.top = y - width / 10;



        }

    }

    public void Landing()
    {
        if (flag == 0) {
            for (int i = 0; i < platforms.size(); i++)
            {
                if (platforms.get(i).top > player_rect.top && platforms.get(i).top < player_rect.bottom && player_rect.left + width / 20 <= platforms.get(i).right
                        && player_rect.left + width / 20 >= platforms.get(i).left  )
                {
                    if (y0 <= platforms.get(i).top)
                    {
                        if (bJ == 1)
                        {
                            y -=  v;

                        }
                        y = platforms.get(i).top;
                        player_rect.bottom = y;
                        player_rect.top = y - width / 10;
                        bJ = 0;
                        break;

                    }
                }
            }

        }

        y0 = y;
    }


    public void MonsterKilling()
    {
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).right - player_rect.left <= width)
            {
                //vx = (monsters.get(i).left - player_rect.right - move * 30) / 30;
                Bullet bullet = new Bullet(monsters.get(i), player_rect, move, i );
                bullets.add(bullet);
                break;

            }
        }
    }


    public void Touch(int touch_x) {




        this.touch_x = touch_x;



        if (bJ == 1 && flag_ready != 0) {
            if (touch_x < width / 2) {
                v = 18;
                System.out.println("HERE");

            }
        }

        if (touch_x > width / 2)
        {
            MonsterKilling();
        }

        if (touch_x < width / 2) {
            if (flag != 0) bJ = 1;
        }

        if (flag_ready == 0) {
            flag_ready = 1;
            a = 7;
            move = 7;
        }



    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void Draw(Canvas canvas){

        //draw background
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, width, height, paint);




        //draw Map
        paint.setColor(Color.BLACK);
        for (int i = 0; i < platforms.size(); i++)
        {
            canvas.drawRect(platforms.get(i).left, platforms.get(i).top, platforms.get(i).right, platforms.get(i).bottom, paint);
        }

        //check intersections with monsters
        for(int i = 0; i < monsters.size(); i++)
        {
            if (player_rect.intersect(monsters.get(i)))
            {
                activity.finish();

            }
        }

        //draw monsters
        for (int i = 0; i < monsters.size(); i++)
        {
            canvas.drawBitmap(monster_pic, null, monsters.get(i), paint);
            //canvas.drawRect(monsters.get(i),paint);
        }

        //draw bullets
        for (int i = 0; i < bullets.size(); i++)
        {
            canvas.drawOval(bullets.get(i).x,bullets.get(i).y,bullets.get(i).x + width / 60, bullets.get(i).y + width / 60, paint );

        }



        //buttons
        paint.setTextSize(35.0f); // значение типа float
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(String.valueOf(k), 100, 100, paint);


        //draw player
        //player_rect = new Rect(width / 16, height/ 2 - width /10, width / 16 + width / 10, height / 2);
        canvas.drawBitmap(player_pic, null, player_rect, paint);

        if (y > height)
        {
            activity.finish();
        }

        //checking if ready
        if (flag_ready == 0)
        {
            paint.setAntiAlias(true);
            paint.setTextSize(65.0f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(Color.MAGENTA);
            canvas.drawText("TAP IF YOU ARE READY", 250, 100, paint);

        }
    }


}


class Bullet
{
    int vx, vy, x, y, x_end, j;

   public Bullet(Rect monster_rect, Rect player_rect, int move, int j){
       this.j = j;
       vx = (monster_rect.left - player_rect.right - move * 30) / 30;
       //vy = ((monster_rect.bottom - monster_rect.top) / 2 + monster_rect.top - (player_rect.bottom - player_rect.top) / 2 + player_rect.top) / 30 ;
       //vy = (monster_rect.bottom - player_rect.bottom) / 30;
       vy = (monster_rect.top - player_rect.top) / 30;
       x = player_rect.right;
       y = (player_rect.bottom - player_rect.top) / 2 + player_rect.top;
       x_end = monster_rect.left - move * 30;

}

}




