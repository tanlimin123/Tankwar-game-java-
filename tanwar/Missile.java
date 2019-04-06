package tanwar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Missile
{
	private  boolean  live=true;
   public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
public static final int WIDTH=10;
	public  static final int HEIGHT=10;
    public static final int XSPEED=10;
    public static final int YSPEED=10;
    int x,y;
    Tank.Direction  dir;
public Missile  (int x,int y,Tank.Direction  dir)
	{
	this.x=x;
	this.y=y;
	this.dir=dir;
	}
public void draw(Graphics g)
	{
    if(!live)return;
	Color c=g.getColor();
	g.setColor(Color.BLACK);
	g.fillOval(x, y, WIDTH, HEIGHT);
	g.setColor(c);
	move();
	}
private void move()
	{
	
	switch(dir)
		{
	case L:
		x -=XSPEED;
		break;
	
	case U:
		y -=YSPEED;
		break;
	
	case R:
		x +=XSPEED;
		break;
	
	case D:
	
		y +=YSPEED;
		break;
	
	
	
		}
	
	
	}


	public  Rectangle  getRect()
	{
	  return  new Rectangle(x,y,WIDTH,HEIGHT);
	}
	public  boolean  hitTank(Tank t){
		if(this.getRect().intersects(t.getRect())){
			t.setLive(false);
			this.live=false;
			return  true;
		}
		return  false;
		
	}
  public  boolean  hitTanks(List<Tank> tanks){
	  for(int i=0;i<tanks.size();i++)
	  {
		  
		  if(hitTank(tanks.get(i)))
		  return true;
	  }
          return false;
  }
  
		
	 

  
}
