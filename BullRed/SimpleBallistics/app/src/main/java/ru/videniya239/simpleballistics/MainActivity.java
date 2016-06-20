package ru.videniya239.simpleballistics;

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

public class MainActivity extends AppCompatActivity {

    private GameController gameController;
    private GestureDetector gestureDetector;
    public static Bitmap startMenuImage;
    public static Bitmap cannon;
   /* private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }*/

    //public static SeekBar seekBar;

    public static Bitmap level1Map;
    public static Bitmap level1Texture;

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
      //  BitmapFactory.decodeResource(activity)

       // GameController.Init(this);
       // setContentView(GameController.GetInstance());


        gameController = new GameController(this);
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
