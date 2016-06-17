package ru.videniya239.simpleballistics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.Timer;


enum GameState
{
	PHASE_NEW_GAME,
	PHASE_PLAY,
	PHASE_RESULT,
}

public class GameController extends View
{
	public static final int ACTION_MOVE = 1;
	public static final int ACTION_DOWN = 2;
	public static final int ACTION_UP = 3;
	public static final int ACTION_DOUBLE_TAP = 4;

	private Activity activity;
	private GameState gamePhase;
	private IGameState currentState;

	public static float screenHeight;
	public static float screenWidth;
	private Paint paint;

	private float lastTimeMillis;
	private float currentTimeMillis;

    private final int QUIT_KEY = 1;
    private final int NEW_GAME_KEY = 0;

	private static GameController instance;
	private GameController(Context context)
	{
		super(context);
	}

	public static GameController GetInstance()
	{
		return instance;
	}

	public static void Init(Context context)
	{
		instance = new GameController(context);
		instance.Init();
	}

	private void Init()
	{
		paint = new Paint();
		paint.setColor(Color.WHITE);
		setGamePhase(GameState.PHASE_NEW_GAME);
		screenHeight = getHeight();
		screenWidth = getWidth();
		lastTimeMillis = System.currentTimeMillis();
	}

	void setGamePhase(GameState nextPhase)
	{
		switch (nextPhase)
		{
			case PHASE_NEW_GAME:
				gamePhase = GameState.PHASE_NEW_GAME;
				currentState = new StartGameState();
				currentState.InvokeState();
				break;
			case PHASE_PLAY:
				gamePhase = GameState.PHASE_PLAY;
				currentState = new PlayGameState();
				break;
			case PHASE_RESULT:
				gamePhase = GameState.PHASE_RESULT;
				break;
		}
	}
	
	private void updateAll(float deltaT)
	{
		/*switch (gamePhase)
		{
			case PHASE_NEW_GAME:
				break;
			case PHASE_PLAY:
				break;
			case PHASE_RESULT:
				break;
		}*/

		currentState.Update(deltaT);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		float deltaT = getDeltaT();
		updateAll(deltaT);
	}

	private float getDeltaT()
	{
		currentTimeMillis = System.currentTimeMillis();
		float deltaT = currentTimeMillis - lastTimeMillis;
		lastTimeMillis = currentTimeMillis;
		return deltaT;
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


