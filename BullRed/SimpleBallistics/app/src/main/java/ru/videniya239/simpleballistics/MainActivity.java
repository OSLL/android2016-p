package ru.videniya239.simpleballistics;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends Activity {


    public static Bitmap tutorial;
    private GameController gameController;
    private GestureDetector gestureDetector;
    public static Bitmap startMenuImage;
    public static Bitmap cannon;
    public static Bitmap carriageImage;
    public static Bitmap arrow;

    public static Bitmap wind;
    public static Bitmap velocity;

    public static Bitmap win;
    public static Bitmap lose;
    public static Bitmap settings;

    public static Bitmap[] numbers;
    public static Bitmap bullets;

   /* private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }*/

    //public static SeekBar seekBar;

    public static Bitmap level1Map;
    public static Bitmap level1Texture;
    public static Bitmap level2Map;
    public static Bitmap level2Texture;
    public static Bitmap level3Map;
    public static Bitmap level3Texture;
    public static Bitmap level4Map;
    public static Bitmap level4Texture;
    public static Bitmap level5Map;
    public static Bitmap level5Texture;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // hide head-line
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide uvedomlenia:
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        startMenuImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.startmenu1);

        ImageView imageViewTest = (ImageView) findViewById(R.id.cannon);
        cannon = BitmapFactory.decodeResource(this.getResources(), R.drawable.cannon);

        ImageView level1ImageView = (ImageView) findViewById(R.id.levelm1);
        level1Map = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelm1);

        ImageView level1TextureView = (ImageView) findViewById(R.id.levelt1);
        level1Texture = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelt1);

        ImageView level2ImageView = (ImageView) findViewById(R.id.levelm2);
        level2Map = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelm2);

        ImageView level2TextureView = (ImageView) findViewById(R.id.levelt2);
        level2Texture = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelt2);

        ImageView level3ImageView = (ImageView) findViewById(R.id.levelm3);
        level3Map = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelm3);

        ImageView level3TextureView = (ImageView) findViewById(R.id.levelt3);
        level3Texture = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelt3);

        ImageView level4ImageView = (ImageView) findViewById(R.id.levelm4);
        level4Map = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelm4);

        ImageView level4TextureView = (ImageView) findViewById(R.id.levelt4);
        level4Texture = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelt4);

        ImageView level5ImageView = (ImageView) findViewById(R.id.levelm5);
        level5Map = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelm5);

        ImageView level5TextureView = (ImageView) findViewById(R.id.levelt5);
        level5Texture = BitmapFactory.decodeResource(this.getResources(), R.drawable.levelt5);


        ImageView arrowImage = (ImageView) findViewById(R.id.arrow);
        arrow = BitmapFactory.decodeResource(this.getResources(), R.drawable.arrow);


        ImageView winView = (ImageView) findViewById(R.id.win);
        win = BitmapFactory.decodeResource(this.getResources(), R.drawable.win);

        ImageView gameOverView = (ImageView) findViewById(R.id.gameover);
        lose = BitmapFactory.decodeResource(this.getResources(), R.drawable.gameover);

        ImageView settingsView = (ImageView) findViewById(R.id.settings);
        settings = BitmapFactory.decodeResource(this.getResources(), R.drawable.settings);

        ImageView carriageView = (ImageView) findViewById(R.id.carriage);
        carriageImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.carriage);


        numbers = new Bitmap[10];
        ImageView oneImage = (ImageView) findViewById(R.id.one);
        numbers[1] = BitmapFactory.decodeResource(this.getResources(), R.drawable.one);

        ImageView twoView = (ImageView) findViewById(R.id.two);
        numbers[2] = BitmapFactory.decodeResource(this.getResources(), R.drawable.two);

        ImageView threeView = (ImageView) findViewById(R.id.three);
        numbers[3] = BitmapFactory.decodeResource(this.getResources(), R.drawable.three);

        ImageView fourView = (ImageView) findViewById(R.id.four);
        numbers[4] = BitmapFactory.decodeResource(this.getResources(), R.drawable.four);

        ImageView fiveView = (ImageView) findViewById(R.id.five);
        numbers[5] = BitmapFactory.decodeResource(this.getResources(), R.drawable.five);

        ImageView sixView = (ImageView) findViewById(R.id.six);
        numbers[6] = BitmapFactory.decodeResource(this.getResources(), R.drawable.six);

        ImageView sevenView = (ImageView) findViewById(R.id.seven);
        numbers[7] = BitmapFactory.decodeResource(this.getResources(), R.drawable.seven);

        ImageView eightView = (ImageView) findViewById(R.id.eight);
        numbers[8] = BitmapFactory.decodeResource(this.getResources(), R.drawable.eight);

        ImageView nineView = (ImageView) findViewById(R.id.nine);
        numbers[9] = BitmapFactory.decodeResource(this.getResources(), R.drawable.nine);

        ImageView zeroView = (ImageView) findViewById(R.id.zero);
        numbers[0] = BitmapFactory.decodeResource(this.getResources(), R.drawable.zero);

        ImageView bulletsView = (ImageView) findViewById(R.id.bullets);
        bullets = BitmapFactory.decodeResource(this.getResources(), R.drawable.bullets);

        ImageView windView = (ImageView) findViewById(R.id.wind);
        wind = BitmapFactory.decodeResource(this.getResources(), R.drawable.wind);

        ImageView velocityView = (ImageView) findViewById(R.id.velocity);
        velocity = BitmapFactory.decodeResource(this.getResources(), R.drawable.velocity);

        ImageView tutorialView = (ImageView) findViewById(R.id.tutorial);
        tutorial = BitmapFactory.decodeResource(this.getResources(), R.drawable.tutorial);
      //  BitmapFactory.decodeResource(activity)



       // GameController.Init(this);
       // setContentView(GameController.GetInstance());


        gameController = new GameController(this);

        //LevelManager.GetInstance().Reset();
        //GameController.Init(this);
        //setContentView(GameController.GetInstance());
       setContentView(gameController);
        //myView = new MyView(this);
       // gameController = new GameController(this);
        gestureDetector = new GestureDetector(this, new MyGestureListener());


        long heapSize = Runtime.getRuntime().totalMemory();
        //Log.d("heap", "" + heapSize);
    }

    public static void onFinish()
    {
        startMenuImage = null;
        cannon = null;
        carriageImage = null;
        arrow = null;


        tutorial = null;
        win = null;
        lose = null;
        settings = null;

        numbers = null;
        bullets = null;


        level1Map = null;
        level1Texture = null;
        level2Map = null;
        level2Texture = null;
        level3Map = null;
        level3Texture = null;
        level4Map = null;
        level4Texture = null;
        level5Map = null;
        level5Texture = null;
    }

    @Override
    public void onPause()
    {
        super.onPause(); // call the super method
        gameController.stopGame(); // terminates the game
    } // end method onPause

    // release resources
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        gameController.releaseResources();
    } // end method onDestroy

    @Override
    public void onResume()
    {
        super.onResume();
        //GameController.drawThread.setRunning(true);
        gameController = new GameController(this);
        //gameController.surfaceCreated();
        //GameController.drawThread.setRunning(true);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                //log += "D,";
                gameController.motionEvent(GameController.ACTION_DOWN, event);
                break;
            case MotionEvent.ACTION_UP:
                gameController.motionEvent(GameController.ACTION_UP, event);
                //log += "U,";
                break;
            case MotionEvent.ACTION_MOVE:
                gameController.motionEvent(GameController.ACTION_MOVE, event);
                //log += "M,";
                break;
        }

        gestureDetector.onTouchEvent(event);
        return true;
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
        {
            gameController.motionScrollEvent(e1, e2, distanceX, distanceY);
            //log += "SCR,";
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent event)
        {
            gameController.motionEvent(GameController.ACTION_DOUBLE_TAP, event);
            //log += "DT,";
            return true;
        }
    }
}
