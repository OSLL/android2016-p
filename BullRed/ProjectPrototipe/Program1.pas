uses graphABC;
type vector2 = record
  x : integer;
  y : integer;
  
end;

var a, g, v0, vv, v, pos: vector2;
dt, i, j, w, h: integer; 
k, m : real;
begin
  maximizewindow;
  w := WINDOWWIDTH;
  h := windowheight;
  g.x := 0;
      g.y := 100;
  //g.y := h div 200;
  
  v.x := 200;
  v.y := -200;
  k := 20;
  m := 100;
  vv.y := 0;
  vv.x := -30;
  dt := 50;
  pos.x := 10;
  pos.y := h div 2;
  setpencolor(clBlack);
  setbrushcolor(clBlack);
  fillcircle(pos.x, pos.y, 2);
  
  while true do
  begin
    fillcircle(pos.x, pos.y, 2);
    
    a.x := trunc((k / m) * (v.x + (-vv.x)) );
    a.y := -g.y + trunc((k / m) * v.y);
    
    v.x := v.x - trunc((dt / 1000) * a.x);
    v.y := v.y - trunc((dt / 1000) * a.y);
    
    pos.x := pos.x + trunc((dt / 1000) * v.x);
    pos.y := pos.y + trunc((dt / 1000) * v.y);
    
    
    sleep(dt);
  end;
end.