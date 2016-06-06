package com.example.user.shooter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.SurfaceHolder;

/**
 * Created by user on 6/6/2016.
 */
public class BG extends Thread {

    private boolean runFlag = false;
    private SurfaceHolder surfaceHolder;
    private Bitmap picture;
    public static NLO nlo;
    public static float H;
    public static float W;
    public static Bums babams;

    public BG(SurfaceHolder surfaceHolder, Resources resources){
        this.surfaceHolder = surfaceHolder;
        // загружаем картинку, которую будем отрисовывать
        H = 50.0f;
        W = 50.0f;
        picture = BitmapFactory.decodeResource(resources, R.drawable.bg);
        nlo = new NLO(resources);
        babams = new Bums();
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
                    canvas.drawBitmap(picture,0,0,null);
                    //canvas.drawBitmap(nlo.getPicture(),nlo.getX(),nlo.getY(),null);
                    Paint p = new Paint();
                    p.setColor(Color.BLACK);
                    canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),p);
                    p.setColor(Color.CYAN);
                    canvas.drawRect(nlo.getX(), nlo.getY(),nlo.getX()+W, nlo.getY()+H,p);
                    p.setColor(Color.RED);
                    canvas.drawRect(nlo.getX()+W/2-babams.getW()/2, nlo.getY()-babams.getH(),nlo.getX()+W/2+babams.getW()/2, nlo.getY(),p);
                }
            }
            finally {
                if (canvas != null) {
                    // отрисовка выполнена. выводим результат на экран
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

}

//хехех