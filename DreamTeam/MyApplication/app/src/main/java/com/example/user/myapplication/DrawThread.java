package com.example.user.myapplication;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;


import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


class DrawThread extends Thread implements View.OnTouchListener{
    private boolean       runFlag = false;
    private SurfaceHolder surfaceHolder;
    private DrawingView   dView;
    private Ball          mBall;
    FObj                  ring1 = null,
                          ring2 = null,
                          ring3 = null,
                          block1 = null,
                          block2 = null,
                          block3 = null,
                          block4 = null,
    plank = null,prev = null;
    Canvas                canvas = null;
    boolean               ifmore = false;
    boolean               play = false;
    Button                b;
    boolean               finish_menu = false;
    Random r = new Random(386920l);
    FObj                  pForColor = null;
    int SCORE = 0;

    public DrawThread(SurfaceHolder surfaceHolder, DrawingView dView){
        this.surfaceHolder = surfaceHolder;
        this.dView = dView;
        dView.setOnTouchListener(this);
    }


    public void setRunning(boolean run) {
        runFlag = run;
    }
    public void sendEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
           mBall.speed = -12;
            mBall.up = true;
        }
    }
    float getCurrentTime(float lastTime)
    {
        return (System.nanoTime() - lastTime) / 100f;
    }


    void processObj(ArrayList<FObj> obj, Canvas canvas, float time)
    {
        for (FObj f: obj
             ) {
            f.draw(canvas, time, -1);
            if(!f.update(canvas, time))
            {
                mBall.pos.setY(canvas.getHeight() - 20);
            }
        }
    }

   void scrollObj(ArrayList<FObj> obj)
    {
        for (FObj f: obj
             ) {
            f.Center_y -= mBall.delta;

        }
    }

    boolean ballInSomth(ArrayList<FObj> objs)
    {
        for (FObj f: objs
             ) {
            if(f.inRing())
                return true;

        }
        return false;
    }

    float getGenY(FObj f)
    {
        return prev.Center_y - prev.getRadius() - 430 - f.getRadius();
    }

    void changBallColor(ArrayList<FObj> objs)
    {

        float y = mBall.pos.getY();
        for(int i = 0; i < objs.size() - 1; i++)
        {
            if(objs.get(i).Center_y - objs.get(i).getRadius() - mBall.radius * 1.2 > y && objs.get(i+1).Center_y + objs.get(i+1).getRadius() < y)
            {
                if(pForColor == null)
                {
                    pForColor =objs.get(i);
                }
                else if(pForColor.equals(objs.get(i))|| pForColor == objs.get(i))
                {
                    return;
                }
                pForColor = objs.get(i);
                Figurs fig = new Figurs();


                int col  = Math.abs(r.nextInt() % 4);

                Log.d("GAME_T", "change" + col);
                switch (col)
                {
                    case 0:
                        mBall.color = fig.int_colors.get("pink");
                        break;
                    case 1:
                        mBall.color = fig.int_colors.get("yellow");
                        break;
                    case 2:
                        mBall.color = fig.int_colors.get("fiol");
                        break;
                    case 3:
                        mBall.color = fig.int_colors.get("lblue");
                }
                SCORE += 10;
                return;
            }
        }


    }

    void generateNext(ArrayList<FObj> objs, Canvas canvas) {
        ArrayList<FObj> toGen = new ArrayList<>();
        for (FObj f : objs) {
            if (f.Center_y - f.getRadius() > canvas.getHeight()) {
                toGen.add(f);


            }
        }
        boolean ifWasBl = false;
        int size = toGen.size();
        for (int i = 0; i < size; i++) {
            Figurs fig = new Figurs();
            if(toGen.size() != 0)
            {
            }
            int curSize = toGen.size();
            int index = Math.abs(r.nextInt(354902)) % curSize;
            Log.d("GAME_T", "current size: " + curSize + "  index " + index );
            FObj f = toGen.get(index);
            toGen.remove(index);
            //Log.d("GAME_T", "Gen one more");
            if (prev == null)
                prev = toGen.get(0);

            switch (f.id) {
                case 0:
                    f.Center_y = getGenY(f);
                    prev = f;
                    break;
                case 4:
                    if(ifWasBl)
                        break;
                    ifWasBl = true;
                    float block_y = getGenY(f);
                    block1.Center_y =
                    block2.Center_y =
                    block3.Center_y =
                    block4.Center_y = block_y;
                    prev = f;
                    break;
                case 10:
                    plank.setFullBY(getGenY(plank));
                    prev = f;
            }
            break;
        }

    }


    @Override
    public void run() {
        float deltaFig = 430;
        float startTime = System.nanoTime();
        Figurs f = new Figurs();
        ArrayList<FObj> objs = new ArrayList<>();
        float rad1 = 2.2f * 100;
        float rad2 = 2.5f * 100;
        float rad3 = 2.4f * 100;
        b = new Button(dView);
        while (runFlag) {
            try {


                float time = System.nanoTime();
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder) {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                    if (!play) {
                        b.DrawButton(canvas.getWidth() / 2, canvas.getHeight() / 2, 300, 300, (canvas));
                    } else {
                        if (!ifmore) {
                            float Start_y = 2 * canvas.getHeight();
                            mBall = new Ball(new Vector2d((float) canvas.getWidth() / 2, canvas.getHeight() * 0.9f), Color.parseColor(f.colors.get("yellow")));
                            mBall.pos = new Vector2d(canvas.getWidth() / 2, canvas.getHeight() * 0.9f);
                            ifmore = true;
                            float block_y = Start_y;
                            float len = canvas.getWidth() / 3;
                            block1 = new FObj(4, len / 2, block_y, 0, 0, 0, mBall);
                            block2 = new FObj(4, len + len / 2, block_y, 0, 0, 0, mBall);
                            block3 = new FObj(4, 2 * len + len / 2, block_y, 0, 0, 0, mBall);
                            block4 = new FObj(4, 3 * len + len / 2, block_y, 0, 0, 0, mBall);
                            ring1 = new FObj(0, canvas.getWidth() / 2, canvas.getHeight() * 0.3f, 0, 0, rad1 / 100, mBall);

                            ring3 = new FObj(0, canvas.getWidth() / 2, Start_y, 0, 0, rad3 / 100, mBall);
                            ring2 = new FObj(0, canvas.getWidth() / 2, Start_y, 0, 0, rad2 / 100, mBall);


                            //plank = new FObj(block1, block2, block3, block4);

                            block1.setColor(f.int_colors.get("pink"));
                            block3.setColor(f.int_colors.get("yellow"));
                            block2.setColor(f.int_colors.get("fiol"));
                            block4.setColor(f.int_colors.get("lblue"));

/**/
                            objs.add(block1);
                            objs.add(block2);
                            objs.add(block3);
                            objs.add(block4);
                            //                                objs.add(plank);
                            objs.add(ring1);
                            objs.add(ring2);


                            objs.add(ring3);
                            //objs.add(plank);
                            prev = ring1;
                        } else {


                            processObj(objs, canvas, getCurrentTime(startTime));


                            if (mBall.pos.getY() < canvas.getHeight() * 0.5 && mBall.delta < 0)
                                scrollObj(objs);
                            mBall.drawBall(canvas, (getCurrentTime(time)));
                            generateNext(objs, canvas);
                            changBallColor(objs);
                            Paint p = new Paint();
                            p.setColor(mBall.color);
                            p.setTextSize(canvas.getHeight() * 0.1f);
                            canvas.drawText(SCORE + "", canvas.getWidth() * 0.8f, canvas.getHeight() * 0.1f, p);
                        }
                    }


                }}catch(NullPointerException e){
                    e.printStackTrace();
                }
                finally{
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                       }
                 }
              }
        }


    void init()
    {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getX() > b.x1 && event.getX() < b.x2 && event.getY() > b.y1 && event.getY() < b.y2) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: // нажатие
                    play = true;
                    ifmore = false;
                    runFlag = true;
                    mBall = null;
                    finish_menu = true;

                    break;
                default:
                    break;
            }
            return true;
        } else {
            return false;
        }
    }
}
