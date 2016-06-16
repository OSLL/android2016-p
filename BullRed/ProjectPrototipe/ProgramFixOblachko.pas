uses graphABC;
type vector2 = record
  x : real;
  y : real;
  
end;

var a, g, v0, vv, v, pos, obl: vector2;
dt, i, j, w, h : integer; 
k, m, w_m, h_m, alpha, modV, pi, pos0 : real;

procedure oblako(x, y: integer);
begin
  setbrushcolor(clSkyblue);
  fillcircle(x , y - 30, 50);
  fillcircle(x - 30, y - 50, 50);
  fillcircle(x - 50, y - 30, 50);
  fillcircle(x + 50, y - 30, 50);
  fillcircle(x + 30, y - 50, 50);
  setbrushcolor(clBlack);
end;

procedure exp;
var i: integer;
begin
    for i:=1 to 100 do
  begin
    if i mod 3 <> 0 then setbrushcolor(clRed)
    else setbrushcolor(clOrange);
    //setbrushcolor(clRed);
    fillcircle(trunc(pos.x), trunc(pos.y), 4*i);  
  end;
end;

begin
  maximizewindow;
  w := WINDOWWIDTH;
  h := windowheight;
  
  pi:=3.1415926535;
  
  w_m:=2000; //условный размер экрвна в метрах
  h_m:=w_m/w*h;
  
  g.x := 0;
  g.y := 10/w_m*w;
  
  //v [300, 400]м/с
  
  modV:=300;//в метрах в секунду
  alpha:=60;//в градусах
  
  v.x := modV*cos(alpha*pi/180)*w/w_m;
  v.y := -modV*sin(alpha*pi/180)*w/w_m;
  
  k := 200;
  m := 1500;
  
  vv.y := 0;
  vv.x := -10/w_m*w;//скорость ветра в м/с
  
  
  
  dt := 500;
  
  pos.x := 20;
  pos.y := windowheight-20;
  
  pos0:=pos.y;
  
  setpencolor(clBlack);
  setbrushcolor(clBlack);
  fillcircle(trunc(pos.x), trunc(pos.y), 5);
  obl.x := w;
  obl.y := h div 10;
  i := 0;
  while i < 10 do
  begin
  
    fillcircle(trunc(pos.x), trunc(pos.y), 25);
    
    a.x := (k / m) * (v.x + (-vv.x));
    a.y := -g.y + (k / m) * v.y;
    
    v.x := v.x - (dt / 1000) * a.x;
    v.y := v.y - (dt / 1000) * a.y;
    
    if i = 0 then 
    begin
    pos.x := pos.x + (dt / 1000) * v.x;
    pos.y := pos.y + (dt / 1000) * v.y;
    end;
         
    sleep(dt div 10);
    clearwindow;
  end;
  
  //-----------------------------------------------взрыв :)
    exp;
    sleep(100);
    clearwindow;  
  //-----------------------------------------------взрыв :)
  setfontsize(50);
  setbrushcolor(clWhite);
  textout(w div 2, h div 2, 'LEVEL COMPLETE!');
  
  sleep(5000);
  halt;
  
end.