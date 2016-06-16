package ru.videniya239.simpleballistics;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Body
{
	Vector2 pos = new Vector2(0,0);
	Vector2 velocity;
	float sizeH = 72;
	float sizeW = 72;
	float angle;
	Bitmap image;
	int value;
	boolean canBeTapped = true;
	boolean tapped = false;
	
	Body()
	{
	}
	
	Body(Bitmap image, float startX, float startY, float velocityX, float velocityY)
	{
		pos = new Vector2(startX, startY);
		velocity = new Vector2(velocityX, velocityY);
		angle = 0;
		sizeH = image.getHeight();
		sizeW = image.getWidth();
		this.image = image;
	}
	
	Body(Vector2 pos, Vector2 velocity, float size, Bitmap image)
	{
		this.pos = new Vector2(pos);
		this.velocity = new Vector2(velocity);
		this.angle = 0;
		if (image == null)
		{
			sizeH = size;
			sizeW = size;
		}
		else
		{
			this.sizeH = image.getHeight() * size;
			this.sizeW = image.getWidth() * size;
		}
		this.image = image;
	}
	Body(float posx, float posy, float velocityx, float velocityy,
		 float size, Bitmap image)
	{
		this.pos = new Vector2(posx, posy);
		this.velocity = new Vector2(velocityx, velocityy);
		this.angle = 0;
		this.sizeH = image.getHeight() * size;
	    this.sizeW = image.getWidth() * size;
		this.image = image;
	}
	
	void setPos(float x, float y)
	{
		pos.x = x;
		pos.y = y;
	}
	void setPos(Vector2 pos)
	{
		this.pos.x = pos.x;
		this.pos.y = pos.y;
	}
	void setVelocity(float x, float y)
	{
		velocity.x = x;
		velocity.y = y;
	}
	void setVelocity(Vector2 velocity)
	{
		this.velocity.x = velocity.x;
		this.velocity.y = velocity.y;
		setAngle(velocity);
	}
	void setAngle(float angle)
	{
		this.angle = angle;
	}
	void setAngle(float x, float y)
	{
		angle = (float)(Math.atan2(y, x) / Math.PI * 180);
	}
	void setAngle(Vector2 dir)
	{
		angle = (float)(Math.atan2(dir.y, dir.x) / Math.PI * 180);
	}
	
	void update(Vector2 F, float deltaT)
	{
		pos.plusMe(velocity.xR(deltaT));
		
	}
	
	void draw(Canvas canvas, Paint paint, float w, float h)
	{
		
			canvas.save();
			canvas.drawBitmap(image, null, new RectF((float)pos.x, (float)(pos.y), (float)pos.x + w/11f,
					(float)pos.y + h/16f), paint);
			canvas.restore();
			
	}
	
	boolean isOutOfScreen()
	{		
		if (pos.x - sizeW > GameController.screenWidth || pos.x + sizeW < 0 ||
				pos.y - sizeH > GameController.screenHeight|| pos.y + sizeH < 0)
			return true;
		else				
			return false;
	}
	
	boolean collides(Collider collider)
	{
		if (canBeTapped)
			if (collider.intersectsF(new RectF((float)pos.x, (float)pos.y, (float)(pos.x + sizeW),
					(float)(pos.y + sizeH))))
				return true;
			else
				return false;
		else
			return false;
	}
	

}
