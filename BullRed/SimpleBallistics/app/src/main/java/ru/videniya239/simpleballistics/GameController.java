package ru.videniya239.simpleballistics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;
import java.util.Timer;

enum GameState
{
	PHASE_NEW_GAME,
	PHASE_PLAY,
	PHASE_END_LEVEL,
	PHASE_RESULT,
	PHASE_SETTINGS
}

public class GameController extends SurfaceView implements SurfaceHolder.Callback
{
	public static final int ACTION_MOVE = 1;
	public static final int ACTION_DOWN = 2;
	public static final int ACTION_UP = 3;
	public static final int ACTION_DOUBLE_TAP = 4;

	private static Activity activity;
	private static GameState gamePhase;
	private static IGameState currentState;

	public static float screenHeight;
	public static float screenWidth;
	private Paint paint;

	private long lastTimeMillis;
	private long currentTimeMillis;

    private final int QUIT_KEY = 1;
    private final int NEW_GAME_KEY = 0;

	//private static GameController instance;
	public GameController(Context context)
	{
		super(context);
		getHolder().addCallback(this);
		activity = (Activity)context;
		//drawThread.setRunning(true);
		//instance = this;
		//Init();
	}

	/*public static GameController GetInstance()
	{
		return instance;
	}*/

	public static void Init(Context context)
	{
		//instance = new GameController(context);
		//instance.Init();
	}

	private void Init()
	{
		paint = new Paint();
		buttons = new ArrayList<>();
		sliders = new ArrayList<>();
		paint.setColor(Color.WHITE);
		setGamePhase(GameState.PHASE_NEW_GAME);
		lastTimeMillis = System.currentTimeMillis();

	}

	public static void setGamePhase(GameState nextPhase)
	{
		if (currentState != null) {
			currentState.EndState();
		}
		gamePhase = nextPhase;
		switch (nextPhase)
		{
			case PHASE_END_LEVEL:
				currentState = new EndLevelState();
				break;
			case PHASE_NEW_GAME:
				currentState = new StartGameState();
				break;
			case PHASE_PLAY:
				currentState = new PlayGameState();
				break;
			case PHASE_RESULT:
				currentState = new WinGameState();
				break;
			case PHASE_SETTINGS:
				currentState = new SettingsGameState();
				break;
		}

		currentState.InvokeState();
	}

	private void updateAll(float deltaT)
	{
		currentState.Update(deltaT);
	}

	boolean firstCall = true;
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		//Log.d("Cont", "Draw");

		if (firstCall)
		{
			firstCall = false;
			Init();
		}

		float deltaT = getDeltaT();
		updateAll(deltaT);
		currentState.Draw(canvas);
	}

	private float getDeltaT()
	{

		currentTimeMillis = System.currentTimeMillis();
		float deltaT = currentTimeMillis - lastTimeMillis;
		//Log.d("time", "" + System.currentTimeMillis() + " " + lastTimeMillis + " " + deltaT);
		lastTimeMillis = currentTimeMillis;
		return deltaT;
	}

	public static void stopGame()
	{
		drawThread.setRunning(false);
	}

	// releases resources; called by onDestroy method
	public void releaseResources()
	{
	}


	private static ArrayList<ITappable> buttons;
	private static ArrayList<Slider> sliders;
	public void motionEvent(int eventType, MotionEvent event)
	{
		switch (eventType)
		{
			case ACTION_DOWN:
				notifyButtons(new Vector2(event.getX(), event.getY()));
				break;
			case ACTION_UP:
				for (Slider slider : sliders)
				{
					slider.onUp();
				}
				break;
			case ACTION_MOVE:
				Log.d("Input", "Move");
				notifySliders(new Vector2(event.getX(), event.getY()));
				break;
			case ACTION_DOUBLE_TAP:
				break;
		}
	}

	public static void AttachButton(ITappable button)
	{
		buttons.add(button);
	}
	public static void DetachButton(ITappable button)
	{
		buttons.remove(button);
	}
	public static void AttachSlider(Slider slider)
	{
		sliders.add(slider);
	}
	public static void DetachSlider(Slider slider)
	{
		sliders.remove(slider);
	}

	private void notifyButtons(Vector2 position)
	{
		for (ITappable button : buttons)
		{
			boolean caught = button.onTap(position);
			if (caught)
				break;
		}
	}

	private void notifySliders(Vector2 position)
	{
		for (Slider slider : sliders)
		{
			boolean caught = slider.update(position);
			if (caught)
				break;
		}
	}

	public void motionScrollEvent(MotionEvent e1, MotionEvent e2, float dx, float dy)
	{

	}

	public static DrawThread drawThread;
	@Override
	public void surfaceCreated(SurfaceHolder surfaceHolder)
	{
		drawThread = new DrawThread(getHolder());
		drawThread.setRunning(true);
		drawThread.start();

	}

	@Override
	public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2)
	{

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder surfaceHolder)
	{
		boolean retry = true;
		// завершаем работу потока
		drawThread.setRunning(false);

		while (retry)
		{
			try
			{
				drawThread.join();
				retry = false;
			}
			catch (InterruptedException e)
			{
				// если не получилось, то будем пытаться еще и еще
			}
		}
	}

	class DrawThread extends Thread{
		private boolean runFlag = false;
		private SurfaceHolder surfaceHolder;


		public DrawThread(SurfaceHolder surfaceHolder)
		{
			this.surfaceHolder = surfaceHolder;
		}

		public void setRunning(boolean run)
		{
			runFlag = run;
		}

		@Override
		public void run()
		{
			Canvas canvas;
			while (runFlag)
			{
				canvas = null;
				try
				{
					// получаем объект Canvas и выполняем отрисовку
					canvas = surfaceHolder.lockCanvas(null);
					if (canvas != null)
					{
						synchronized (surfaceHolder)
						{

							screenHeight = canvas.getHeight();
							screenWidth = canvas.getWidth();
							draw(canvas);
						}
					}
				}
				finally
				{
					if (canvas != null)
					{
						// отрисовка выполнена. выводим результат на экран
						surfaceHolder.unlockCanvasAndPost(canvas);
					}
				}
			}
			activity.finish();
		}
	}
}


