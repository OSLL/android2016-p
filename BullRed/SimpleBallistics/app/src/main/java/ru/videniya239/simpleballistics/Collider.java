package ru.videniya239.simpleballistics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Collider
{
	RectF rect;
	int key;
	Paint paint;
	private int curRed;
	
	public Collider(RectF rect, int key)
	{
		this.rect = rect;
		this.key = key;
		paint = new Paint();
		curRed = 255;
		paint.setARGB(255, 255, 0, 0);
	}
	
	/*protected Collider(RectF rect)
	{
		this.rect = rect;
		paint = new Paint();
		curRed = 255;
		paint.setARGB(255, 255, 0, 0);
	}*/
	
	void changeColor()
	{
		curRed = Math.abs(curRed - 255);
		paint.setARGB(255, curRed, 0, 0);	
	}
	
	boolean intersectsF(RectF rectF)
	{
		if ((((rectF.left > rect.left) && (rectF.left < rect.right)) || 
			((rectF.right < rect.right) && (rectF.right > rect.left)) ||
			((rectF.right > rect.right) && (rectF.left < rect.left))) &&
			(((rectF.top < rect.bottom) && (rectF.top > rect.top)) || 
			((rectF.bottom > rect.top) && (rectF.bottom < rect.bottom)) ||
			((rectF.bottom > rect.bottom) && (rectF.top < rect.top))))
			return true;
		else
			return false;
	}
	
	boolean intersectsP(float x, float y)
	{
		if (rect.contains(x, y))
			return true;
		else
			return false;
	}
	
	boolean rightCollider(int key)
	{
		if (key == this.key)
			return true;
		else
			return false;
	}
	
	void draw(Canvas canvas)
	{
		canvas.drawRect(rect, paint);
	}
	
}
