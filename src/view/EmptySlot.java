package view;

import java.awt.Graphics;

import model.SquareGrid;

public class EmptySlot implements SquareGrid 
{
	int x,y;
	public EmptySlot( int x, int y )
	{
		this.x = x;
		this.y = y;
	}

	public void drawObject(Graphics g, int newX, int newY)
	{
	}

	public int getX() {
		return x;
	}

	public int getY()
	{
		return y;
	}

	public boolean isBlocking() 
	{
		return false;
	}

	public void update() { }

}
