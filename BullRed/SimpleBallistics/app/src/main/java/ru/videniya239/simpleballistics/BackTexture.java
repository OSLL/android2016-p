package ru.videniya239.simpleballistics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class BackTexture extends Body 
{

	public BackTexture(Bitmap image)
	{
		super(image, 0, 0, 0, 0);
	}
	
	@Override
	void draw(Canvas canvas, Paint paint, float w, float h) {
		canvas.save();
		canvas.drawBitmap(image, null, new RectF(0, 0, GameController.screenWidth, GameController.screenHeight),
				paint);
		canvas.restore();
	}
	
}
