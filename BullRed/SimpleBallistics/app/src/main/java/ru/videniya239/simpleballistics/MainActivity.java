package ru.videniya239.simpleballistics;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends Activity {

    public static Bitmap carriageImage;
    private GameController gameController;
    private GestureDetector gestureDetector;
    public static Bitmap startMenuImage;
    public static Bitmap cannon;
    public static Bitmap arrow;

    public static Bitmap win;
    public static Bitmap settings;

   /* private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }*/

    //public static SeekBar seekBar;

    public static Bitmap level1Map;
    public static Bitmap level1Texture;
    public static Bitmap level2Map;
    public static Bitmap level2Texture;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // hide head-line
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide uvedomlenia:
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //seekBar = (SeekBar)findViewById(R.id.seekBar);

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


        ImageView arrowImage = (ImageView) findViewById(R.id.arrow);
        arrow = BitmapFactory.decodeResource(this.getResources(), R.drawable.arrow);


        ImageView winView = (ImageView) findViewById(R.id.win);
        win = BitmapFactory.decodeResource(this.getResources(), R.drawable.win);

        ImageView settingsView = (ImageView) findViewById(R.id.settings);
        settings = BitmapFactory.decodeResource(this.getResources(), R.drawable.settings);

        ImageView carriageView = (ImageView) findViewById(R.id.carriage);
        carriageImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.carriage);
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
