package ru.videniya239.simpleballistics;

public class Vector2
{
	static final double eps = 0.00001;
	double x,y;
	Vector2()
	{
		x = 0;
		y = 0;
	}
	Vector2(double x,double y)
	{
		this.x = x;
		this.y = y;
	}
	Vector2(Vector2 other)
	{
		x = other.x;
		y = other.y;
	}
	double len()
	{
		return Math.sqrt(x*x + y*y);
	}
	void normalize()
	{
		double L = len();
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
		double L = len();
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
	double dot(Vector2 v)
	{
		return x * v.x + y * v.y;
	}
	void rotateMe(double angle)
	{
		double x1 = x * Math.cos(angle) - y * Math.sin(angle);
		y = x * Math.sin(angle) + y * Math.cos(angle);
		x = x1;
	}
	Vector2 rotate(double angle)
	{
		Vector2 res = new Vector2();
		res.x = x * Math.cos(angle) - y * Math.sin(angle);
		res.y = x * Math.sin(angle) + y * Math.cos(angle);
		return res;
	}
	void xRMe(double r)
	{
		x *= r;
		y *= r;
	}
	Vector2 xR(double r)
	{
		Vector2 res = new Vector2(this);
		res.x *= r;
		res.y *= r;
		return res;
	}
}
