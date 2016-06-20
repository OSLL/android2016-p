package ru.videniya239.simpleballistics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class BackTexture extends Body 
{
	//private Paint paint;
	public BackTexture(Bitmap image)
	{
		super(image, 0, 0, 0, 0);
		//paint = new Paint();
	}
	
	@Override
	void draw(Canvas canvas, Paint paint, float w, float h)
	{
		canvas.save();
		//Log.d("Test", image.toString());
		canvas.drawBitmap(image, null, new RectF(0, 0, (int)GameController.screenWidth, (int)GameController.screenHeight),
				//0, 0,
				paint);
		canvas.restore();
	}

	public void draw(Canvas canvas, Paint paint)
	{
		//Log.d("Test2", image.toString());
		draw(canvas, paint, GameController.screenWidth, GameController.screenHeight);
	}

	public void draw(Canvas canvas)
	{
		draw(canvas, new Paint(), GameController.screenWidth, GameController.screenHeight);
	}
	
}
