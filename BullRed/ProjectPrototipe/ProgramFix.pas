uses graphABC;
type vector2 = record
  x : real;
  y : real;
  
end;

var a, g, v0, vv, v, pos, obl: vector2;
dt, i, j, w, h : integer; 
k, m, w_m, h_m, alpha, modV, pi, pos0 : real;

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
  
  modV:=400;//в метрах в секунду
  alpha:=50;//в градусах
  
  v.x := modV*cos(alpha*pi/180)*w/w_m;
  v.y := -modV*sin(alpha*pi/180)*w/w_m;
  
  k := 200;
  m := 1500;
  
  vv.y := 0;
  vv.x := -10/w_m*w;//скорость ветра в м/с
  
  dt := 5;
  
  pos.x := 20;
  pos.y := windowheight-20;
  
  pos0:=pos.y;
  
  setpencolor(clBlack);
  setbrushcolor(clBlack);
  fillcircle(trunc(pos.x), trunc(pos.y), 5);
  obl.x := w;
  obl.y := h div 10;
  
  i := 0;
  while pos.y<=pos0 do
  begin
    
    i:=i+1;
    if i mod 100 = 0 then fillcircle(trunc(pos.x), trunc(pos.y), 5);
    
    a.x := (k / m) * (v.x + (-vv.x));
    a.y := -g.y + (k / m) * v.y;
    
    v.x := v.x - (dt / 1000) * a.x;
    v.y := v.y - (dt / 1000) * a.y;
    
    pos.x := pos.x + (dt / 1000) * v.x;
    pos.y := pos.y + (dt / 1000) * v.y;
    
         
    //sleep(dt div 5);
    //clearwindow;
  end;
  
  //-----------------------------------------------взрыв :)
  //  exp;
  //  sleep(100);
  //clearwindow;  

  //setfontsize(50);
  //setbrushcolor(clWhite);
  //textout(w div 2, h div 2, 'LEVEL COMPLETE!');
  
  sleep(10000);
  halt;
  
end.