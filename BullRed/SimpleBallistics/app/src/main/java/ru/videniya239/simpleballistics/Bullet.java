package ru.videniya239.simpleballistics;

import android.graphics.Canvas;

/**
 * Created by user on 6/17/2016.
 */
public class Bullet
{
    private Body body;

    public Body GetBody()
    {
        return body;
    }

    public Bullet()
    {
        Vector2 vector2 = new Vector2(10, 10);
    }

    public void Update(float deltaT)
    {

    }

    public void Draw(Canvas canvas)
    {

    }
}

/*
 uses graphABC;
2 type vector2 = record
3   x : real;
4   y : real;
5
6 end;
7

8 var a, g, v0, vv, v, pos, obl: vector2;
9 dt, i, j, w, h : integer;
10 k, m, w_m, h_m, alpha, modV, pi, pos0 : real;

24 begin
25   maximizewindow;
26   w := WINDOWWIDTH;
27   h := windowheight;
28
29   pi:=3.1415926535;
30
31   w_m:=2000; //óñëîâíûé ðàçìåð ýêðâíà â ìåòðàõ
32   h_m:=w_m/w*h;
33
34   g.x := 0;
35   g.y := 10/w_m*w;
36
37   //v [300, 400]ì/ñ
38
39   modV:=400;//â ìåòðàõ â ñåêóíäó
40   alpha:=50;//â ãðàäóñàõ
41
42   v.x := modV*cos(alpha*pi/180)*w/w_m;
43   v.y := -modV*sin(alpha*pi/180)*w/w_m;
44
45   k := 200;
46   m := 1500;
47
48   vv.y := 0;
49   vv.x := -10/w_m*w;//ñêîðîñòü âåòðà â ì/ñ
50
51   dt := 5;
52
53   pos.x := 20;
54   pos.y := windowheight-20;
55
56   pos0:=pos.y;
57
58   setpencolor(clBlack);
59   setbrushcolor(clBlack);
60   fillcircle(trunc(pos.x), trunc(pos.y), 5);
61   obl.x := w;
62   obl.y := h div 10;
63
64   i := 0;
65   while pos.y<=pos0 do
66   begin
67
68     i:=i+1;
69     if i mod 100 = 0 then fillcircle(trunc(pos.x), trunc(pos.y), 5);
70
71     a.x := (k / m) * (v.x + (-vv.x));
72     a.y := -g.y + (k / m) * v.y;
73
74     v.x := v.x - (dt / 1000) * a.x;
75     v.y := v.y - (dt / 1000) * a.y;
76
77     pos.x := pos.x + (dt / 1000) * v.x;
78     pos.y := pos.y + (dt / 1000) * v.y;
79
80
81     //sleep(dt div 5);
82     //clearwindow;
83   end; 
93
94   sleep(10000);
95   halt;
96
97 end.


 */
