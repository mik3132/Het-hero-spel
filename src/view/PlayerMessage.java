package view;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerMessage
{
	int[] y = new int[40]; //x, y
	int x = (PlayPanel.width/2)-(GameBoard.squareSize/3);
	String message;
	
	int skippixels = 0; //skip pixels
	long lasttime = System.nanoTime(); // timenow
	int lastid = 0; //id
	int timeout = 10000000; //nanoseconde
	
	
	public PlayerMessage( String message )
	{
		this.message = message;
		messagePositions();
	}
	
	private void messagePositions()
	{
		for(int i = 0; i < y.length; i++)
		{
			this.y[i] = ((PlayPanel.height/2)-(i+skippixels));
		}
	}
	
	public void drawMessage(Graphics g)
	{
		if((lastid+1) != y.length)
		{
			g.setColor(Color.red);
			g.drawString(message, x, y[lastid]);
			
			if((lasttime+timeout) < System.nanoTime())
			{
				lasttime = System.nanoTime();
				if((lastid+1) < y.length)
					lastid++;
			}
		}
	}
	
	public boolean hasStoped()
	{
		return !((lastid+1) != y.length);
	}
}
