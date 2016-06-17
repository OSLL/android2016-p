package ru.programi4koff.team.superuplication228;

import android.content.res.Resources;
import android.graphics.*;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by user on 6/17/2016.
 */
class DrawThread extends Thread  implements View.OnTouchListener{
    private boolean runFlag = false;
    private SurfaceHolder surfaceHolder;
    private Bitmap picture;
    private float screenWidth;
    private Player player;
    private float screenHeight;
    private  Canvas can;
    private ArrayList<Poligon> map = new ArrayList<>();
    private Matrix matrix;
    private long prevTime;
    private float xTouch;
    private float yTouch;

    public DrawThread(SurfaceHolder surfaceHolder, View view){
        this.surfaceHolder = surfaceHolder;
        // Добавить код инициализации
        player = new Player(100,100,50);
    }

    public void update(float xTouch, float yTouch){

        if (xTouch > screenWidth / 2) {
            player.setxPlayer(player.getxPlayer() + 3);
        } else player.setxPlayer(player.getxPlayer() - 3);

        //onDraw(can);
        System.out.println("ygawyaghyorewygboery");

    }

    public void cratePlayer(float screenWidth) {
        player = new Player(500, 500, screenWidth/18);
    }

    public void setRunning(boolean run) {
        runFlag = run;
    }

    @Override
    public void run() {
        Canvas canvas;
        while (runFlag) {
            canvas = null;
            try {
                // получаем объект Canvas и выполняем отрисовку
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder) {


                    float screenHeight = 100;
                    float screenWidth = 100;

                    if (canvas != null) {
                        screenHeight = canvas.getHeight();
                        screenWidth = canvas.getWidth();
                        //canvas.rotate(90);
                       // canvas.scale(0.4f,0.4f);
                        //canvas.translate();
                    }

                    Paint pt = new Paint();
                    pt.setColor(Color.WHITE);

                    Generic gen = new Generic();
                    map = gen.getMap(screenWidth,screenHeight);
                    //System.out.println(pt.getColor());

                    canvas.drawRect(0,0, screenWidth , screenHeight, pt);
                    pt.setColor(Color.BLACK);

                    for (int i = 0; i < 18; i++) {
                        canvas.drawRect((float) map.get(i).getxCoordinate(),(float)map.get(i).getyCoordinate(), (float)(map.get(i).getxCoordinate()+map.get(i).getWidth()), screenHeight, pt);
                        //canvas.drawRe
                        //   System.out.println((float) map.get(i).getxCoordinate()+"     "+(float)map.get(i).getyCoordinate()+"     "+
                        //           (float)(map.get(i).getxCoordinate()+map.get(i).getWidth())+"     "+screenHeight+"    "+ pt.getColor());
                    }
                    pt.setColor(Color.RED);
                    canvas.drawRect(player.getxPlayer() ,player.getyPlayer(), player.getxPlayer() + player.getSide(), player.getyPlayer() + player.getSide(), pt);
                    player.setxPlayer(player.getxPlayer());
                    player.setyPlayer(player.getyPlayer()+20);
                    //Log.i("koord","x1="+player.getxPlayer());
                    //Log.i("koord","y1="+player.getyPlayer());
                    //Log.i("koord","x2="+player.getxPlayer()+ player.getSide());
                    //Log.i("koord","y2="+player.getxPlayer()+ player.getSide());
                    //canvas.drawRect(60,60,160,160, pt);
                    System.out.println(" ddddddddddddddddddddddddd");

                }



                    // То, что мы рисуем
                    //canvas.drawColor(Color.BLACK);
                    //float screenHeight = canvas.getHeight();
                    //float screenWidth = canvas.getWidth();
                    //Paint pt = new Paint();
                    //pt.setColor(Color.WHITE);

                    // Generic gen = new Generic();
                    // map = gen.getMap(screenWidth,screenHeight);
                    //System.out.println(pt.getColor());
                    //canvas.drawRect(0, 0, screenWidth, screenHeight, pt);
               // }
            }
            finally {
                if (canvas != null) {
                    // отрисовка выполнена. выводим результат на экран
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final float x = event.getX();
        final float y = event.getY();
        player.setyPlayer(player.getyPlayer()-1000);
        Log.i("kord","fasdddddddddddddddddddddddddddddddddddddddddddddddddfghggggggggggggggghgggggggggggggggggggg");
        return false;
    }


}


