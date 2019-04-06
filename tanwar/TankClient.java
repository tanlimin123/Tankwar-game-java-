package tanwar;


import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class TankClient  extends  Frame
{
	
	public static final  int GAME_WIDTH=800;
	public static final int GAME_HEIGTH=600;
	Tank myTank=new Tank(50,50,true,this);
	
	Missile m=null;
	List<Missile> missiles = new ArrayList<Missile>();
	List<Tank>tanks=new  ArrayList<Tank>();
	public void paint(Graphics g) 
	{
		g.drawString("missile  cout"+missiles.size(),10,50);
		for(int i=0;i<missiles.size();i++){
			
			Missile m=missiles.get(i);
			m.hitTanks(tanks);
			m.draw(g);
              
			
		}
		myTank.draw(g);
		for(int i=0;i<tanks.size();i++){
			Tank t=tanks.get(i);
			t.draw(g);
		}
	
	}


	public void launchFrame()
	{
		for(int i=0;i<10;i++){
			tanks.add(new Tank(50+40*(i+1),50,false,this));
		}
		this.setLocation(400,300);
		this.setBackground(Color.GREEN);
	    this.setSize(GAME_WIDTH,GAME_HEIGTH);
	    this.addWindowListener(new WindowAdapter()
	    {
	    	public  void  windowClosing(WindowEvent e)
	    	{System.exit(0);}
	    });
	   
	    this.setVisible(true);
	    new  Thread(new PaintThread()).start();
	    this.addKeyListener(new KeyMonitor());
	    
	 }

	public static void main(String[] args) 
	{

		TankClient  c=new TankClient();
		c.launchFrame();
		
	 

	}
	private  class  PaintThread  implements  Runnable
	{
		public  void  run()
		{
			while(true)
			{
			repaint();
			try 
				{
				Thread.sleep(100);
				} 
			catch (InterruptedException e) 
				{
				
				e.printStackTrace();
				}
			}
		}
	}
		
	private class  KeyMonitor  extends KeyAdapter
	{

		
		
		public void keyReleased(KeyEvent e) 
		{
			myTank.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) 
		{
			myTank.keyPressed(e);
		}
			
			
	}
		
	
	

}

