package ru.videniya239.simpleballistics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameController extends SurfaceView
{
	public static final int ACTION_MOVE = 1;
	public static final int ACTION_DOWN = 2;
	public static final int ACTION_UP = 3;
	public static final int ACTION_DOUBLE_TAP = 4;

	private static final int PHASE_NEW_GAME = 1;
	private static final int PHASE_PLAY = 2;
	private static final int PHASE_RESULT = 3;

	private Activity activity;
	private int gamePhase;

	public static float screenHeight;
	public static float screenWidth;
	private Paint paint;
	private Paint textPaint;
	

    private final int QUIT_KEY = 1;
    private final int NEW_GAME_KEY = 0;

	
	public GameController(Context context)
	{
		super(context);
	}

	public void Init(int w, int h, int oldw, int oldh)
	{
		screenHeight = h;
		screenWidth = w;
	}

	public void newGame()
	{

	}
	
	private void phasePlay(double deltaT)
	{

	}

	void setGamePhase(int nextPhase)
	{
		switch (nextPhase)
		{
			case PHASE_NEW_GAME:
				gamePhase = PHASE_NEW_GAME;
				break;
			case PHASE_PLAY:
				gamePhase = PHASE_PLAY;
				newGame();
				break;
			case PHASE_RESULT:
				gamePhase = PHASE_RESULT;
				break;
		}
	}
	
	private void updateAll(double deltaT)
	{
		switch (gamePhase)
		{
			case PHASE_NEW_GAME:
				break;
			case PHASE_PLAY:
				break;
			case PHASE_RESULT:
				break;
		}
		
		
	}

	@Override
	protected void onDraw(Canvas canvas)
	{

	}

	public void stopGame()
	{

	}

	// releases resources; called by CannonGame's onDestroy method 
	public void releaseResources()
	{
		//soundPool.release(); // release all resources used by the SoundPool
		//soundPool = null; 
	}

	public void motionEvent(int eventType, MotionEvent event)
	{
		switch (eventType)
		{
			
			case ACTION_DOWN:				

				break;
			case ACTION_UP:

				break;
			case ACTION_MOVE:

				break;
			case ACTION_DOUBLE_TAP:
				break;
		}
	}

	public void motionScrollEvent(MotionEvent e1, MotionEvent e2, float dx, float dy)
	{
		
	}
}


