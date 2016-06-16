package ru.programi4koff.team.superuplication228;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by user on 6/16/2016.
 */
public class DrawView extends View {

    private float screenWidth;
    private Player player;
    private float screenHeight;
    private ArrayList<Poligon> map = new ArrayList<>();
    private  Canvas can;

    private float xTouch;
    private float yTouch;

    public DrawView(Context context) {
        super(context);
       // player = new Player(500, 500, screenWidth/18);
       // System.out.println("-------------------------------------------------asdgf-------------");
    }


    @Override
    protected void onDraw(Canvas canvas) {

            can =  canvas;
        screenHeight = canvas.getHeight();
        screenWidth = canvas.getWidth();


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
        canvas.drawRect(player.getxPlayer(),player.getyPlayer(), player.getxPlayer() + player.getSide(), player.getyPlayer() - player.getSide(), pt);
        System.out.println(" ddddddddddddddddddddddddd");

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
}
