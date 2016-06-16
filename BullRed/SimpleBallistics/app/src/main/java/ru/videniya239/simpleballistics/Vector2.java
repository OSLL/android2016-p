package ru.videniya239.simpleballistics;

public class Vector2
{
	static final float eps = 0.00001f;
	float x,y;
	Vector2()
	{
		x = 0;
		y = 0;
	}
	Vector2(float x,float y)
	{
		this.x = x;
		this.y = y;
	}
	Vector2(Vector2 other)
	{
		x = other.x;
		y = other.y;
	}
	float len()
	{
		return (float)Math.sqrt(x*x + y*y);
	}
	void normalize()
	{
		float L = len();
		if(L < eps)
		{
			x = 0;
			y = 0;
		}
		else
		{
			x /= L;
			y /= L;
		}
	}
	Vector2 norm()
	{
		float L = len();
		Vector2 v = new Vector2();
		if(L < eps)
		{
			v.x = 0;
			v.y = 0;
		}
		else
		{
			v.x = x/L;
			v.y = y/L;
		}
		return v;
	}
	void plusMe(Vector2 v)
	{
		x += v.x;
		y += v.y;
	}
	Vector2 plus(Vector2 v)
	{
		Vector2 res = new Vector2(this);
		res.x += v.x;
		res.y += v.y;
		return res;
	}
	void minusMe(Vector2 v)
	{
		x -= v.x;
		y -= v.y;
	}
	Vector2 minus(Vector2 v)
	{
		Vector2 res = new Vector2(this);
		res.x -= v.x;
		res.y -= v.y;
		return res;
	}
	float dot(Vector2 v)
	{
		return x * v.x + y * v.y;
	}
	void rotateMe(float angle)
	{
		float x1 =(float)( x * Math.cos(angle) - y * Math.sin(angle));
		y = (float) (x * Math.sin(angle) + y * Math.cos(angle));
		x = x1;
	}
	Vector2 rotate(float angle)
	{
		Vector2 res = new Vector2();
		res.x = (float)(x * Math.cos(angle) - y * Math.sin(angle));
		res.y = (float)(x * Math.sin(angle) + y * Math.cos(angle));
		return res;
	}
	void xRMe(float r)
	{
		x *= r;
		y *= r;
	}
	Vector2 xR(float r)
	{
		Vector2 res = new Vector2(this);
		res.x *= r;
		res.y *= r;
		return res;
	}
}
