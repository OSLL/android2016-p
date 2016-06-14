package com.example.user.newshooter;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 6/8/2016.
 */
public class SpaceShooterView extends SurfaceView implements Runnable{

    Context context;
    final Random random = new Random();
    // This is our thread
    private Thread gameThread = null;

    // Our SurfaceHolder to lock the surface before we draw our graphics
    private SurfaceHolder ourHolder;

    // A boolean which we will set and unset
    // when the game is running- or not.
    private volatile boolean playing;

    // Game is paused at the start
    private boolean paused = true;

    // A Canvas and a Paint object
    private Canvas canvas;
    private Paint paint;

    // This variable tracks the game frame rate
    private long fps;

    // This is used to help calculate the fps
    private long timeThisFrame;

    // The size of the screen in pixels
    private int screenX;
    private int screenY;

    // The players ship
    //private EnemyShip enemyShip;
    private ArrayList<EnemyShip> enemyShip;
    private PlayerShip playerShip;

    // The player's bullets
    private ArrayList<Bullet> bullets;


    // The invaders bullets
    private Bullet[] invadersBullets = new Bullet[200];
    private int nextBullet;
    private int maxInvaderBullets = 10;

    // Up to 60 invaders
//    Invader[] invaders = new Invader[60];
//    int numInvaders = 0;

    // The player's shelters are built from bricks
//    private DefenceBrick[] bricks = new DefenceBrick[400];
//    private int numBricks;

    // For sound FX
    private SoundPool soundPool;
    private int playerExplodeID = -1;
    private int invaderExplodeID = -1;
    private int shootID = -1;
    private int damageShelterID = -1;
    private int uhID = -1;
    private int ohID = -1;

    // The score
    static int score = 0;

    // Lives
    private int lives = 3;

    // How menacing should the sound be?
    private long menaceInterval = 1000;
    // Which menace sound should play next
    private boolean uhOrOh;
    // When did we last play a menacing sound
    private long lastMenaceTime = System.currentTimeMillis();

    private boolean wasTouched;


    int bTime = 0;
    int eTime = 0;

    int eSpeed = 45;
    int bSpeed = 10;

    // When the we initialize (call new()) on gameView
    // This special constructor method runs
    public SpaceShooterView(Context context, int x, int y) {

        // The next line of code asks the
        // SurfaceView class to set up our object.
        // How kind.
        super(context);

        // Make a globally available copy of the context so we can use it in another method
        this.context = context;

        // Initialize ourHolder and paint objects
        ourHolder = getHolder();
        paint = new Paint();

        screenX = x;
        screenY = y;

        // This SoundPool is deprecated but don't worry
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);

        try{
            // Create objects of the 2 required classes
            AssetManager assetManager = context.getAssets();
            AssetFileDescriptor descriptor;

            // Load our fx in memory ready for use
            descriptor = assetManager.openFd("shoot.ogg");
            shootID = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("invaderexplode.ogg");
            invaderExplodeID = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("damageshelter.ogg");
            damageShelterID = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("playerexplode.ogg");
            playerExplodeID = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("damageshelter.ogg");
            damageShelterID = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("uh.ogg");
            uhID = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("oh.ogg");
            ohID = soundPool.load(descriptor, 0);

        }catch(IOException e){
            // Print an error message to the console
            Log.e("error", "failed to load sound files");
        }

        prepareLevel();
    }

    private void prepareLevel(){

        // Here we will initialize all the game objects

        // Make a new player space ship
        playerShip = new PlayerShip(context, screenX-100, screenY-200);
        // Prepare the players bullet
        bullets = new ArrayList<Bullet>();
        // Initialize the invadersBullets array

        // Build an army of invaders
        //enemyShip = new EnemyShip(context, screenX-150, screenY-1000);
        enemyShip = new ArrayList<EnemyShip>();
        // Build the shelters

    }

    private int z = 1;
    private int s = 1;
    @Override
    public void run() {
        while (playing) {

            // Capture the current time in milliseconds in startFrameTime
            long startFrameTime = System.currentTimeMillis();
            // Update the frame
            update();
            // Draw the frame
            draw();
            // Calculate the fps this frame
            // We can then use the result to
            // time animations and more.
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if (timeThisFrame >= 1) {
                fps = 1000 / timeThisFrame;
            }
        }
    }

    private void update(){

        // Did an invader bump into the side of the screen
        boolean bumped = false;

        // Has the player lost
        boolean lost = false;


        long nextTime = System.currentTimeMillis();
        if(bTime == bSpeed){
            playerShip.shoot(bullets);
            bTime-=bSpeed;
        }
        else bTime++;
        if(eTime == eSpeed){
            EnemyShip enemy = new EnemyShip(context, screenX, screenY);
            enemy.startShip((random.nextInt((screenX-(int)enemy.getWidth()*2))+(int)enemy.getWidth())+random.nextFloat());
            enemyShip.add(enemy);
            eTime-=eSpeed;
        }
        else eTime++;

        // Move the player's ship
        playerShip.update(fps);
        // Update the invaders if visible
        for(int i = 0; i < enemyShip.size(); i++){
            EnemyShip e = enemyShip.get(i);
            if(e.getStatus()) {
                e.update(fps);
            }
            if(e.getY() > screenY && e.isVisible() == true) {
                enemyShip.remove(e);
                lives--;
                if (lives == 0){
                    playing = false;
                    Intent intent = new Intent(getContext(), FinalActivity.class);
                    getContext().startActivity(intent);
                }
            }
        }
        // Update all the invaders bullets if active

        // Did an invader bump into the edge of the screen

        if(lost){
            prepareLevel();
        }

        // Update the players bullet

        for(int i = 0; i < bullets.size(); i++){
            Bullet b = bullets.get(i);
            if(b.getStatus()) {
                b.update(fps);
            }
            if(b.getY() < 0)
                bullets.remove(b);
        }
        //Log.d("bulletsCount",String.valueOf(bullets.size()));

        // Has the player's bullet hit the top of the screen

        // Has an invaders bullet hit the bottom of the screen

        // Has the player's bullet hit an invader
        for(Bullet b : bullets) {
            if (b.getStatus()) {
                if (b.isVisible()) {
                    for (EnemyShip e : enemyShip) {
                        if (e.getStatus()) {
                            if (e.isVisible()) {
                                if (RectF.intersects(b.getRect(), e.getRect())) {
                                    e.setVisible(false);
                                    b.setVisible(false);
                                    score = score + 1;
                                    Log.d("bulletsCount", "true");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void draw(){
        // Make sure our drawing surface is valid or we crash

        if (ourHolder.getSurface().isValid()) {
            // Lock the canvas ready to draw
            canvas = ourHolder.lockCanvas();

            // Draw the background color
            //canvas.drawColor(Color.argb(255, 26, 128, 182));
            canvas.drawColor(Color.BLACK);
            // Choose the brush color for drawing
            paint.setColor(Color.argb(255, 255, 255, 255));

            // Draw the player spaceship
            canvas.drawBitmap(playerShip.getBitmap(), playerShip.getX(), playerShip.getY(), paint);
            // Draw the invaders
            for (EnemyShip e : enemyShip) {
                if (e.getStatus() && e.isVisible()) {
                    canvas.save();
                    canvas.rotate(180);
                    canvas.drawBitmap(e.getBitmap(), -e.getWidth() - e.getX(), -e.getHeight() - e.getY(), paint);

                    canvas.restore();
                }
            }
            // Draw the bricks if visible

            // Draw the players bullet if active
            paint.setColor(Color.CYAN);
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bull = bullets.get(i);
                if (bull.getStatus() && bull.isVisible()) {
                    //canvas.drawRect(bull.getRect(), paint);
                    canvas.drawBitmap(bull.getBitmap(), null, bull.getRect(), paint);
                }
            }
            // Draw the invaders bullets if active

            // Draw the score and remaining lives
            // Change the brush color
            paint.setColor(Color.argb(255, 249, 129, 0));
            paint.setTextSize(40);
            canvas.drawText("Score: " + score + "   Lives: " + lives, 10, 50, paint);

            // Draw everything to the screen
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }


    // If SpaceInvadersActivity is paused/stopped
    // shutdown our thread.
    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Log.e("Error:", "joining thread");
        }

    }

    // If SpaceInvadersActivity is started then
    // start our thread.
    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    // The SurfaceView class implements onTouchListener
    // So we can override this method and detect screen touches.
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие

                if ((playerShip.getX() < x && (playerShip.getX() + playerShip.getWidth() > x))
                        && (playerShip.getY() < y && (playerShip.getY() + playerShip.getHeight() > y))) {

                    playerShip.setX(x-playerShip.getWidth()/2);
                    playerShip.setY(y-playerShip.getHeight()/2);
                    wasTouched = true;
                }
                break;
            case MotionEvent.ACTION_MOVE: // движение
                if (wasTouched) {
                    playerShip.setX(x-playerShip.getWidth()/2);
                    playerShip.setY(y-playerShip.getHeight()/2);
                }
                break;
            case MotionEvent.ACTION_UP: // отпускание
                if (wasTouched) {
                    playerShip.setX(x-playerShip.getWidth()/2);
                    playerShip.setY(y-playerShip.getHeight()/2);
                    wasTouched = false;
                }
                break;
        }
        return true;
    }
}
