package model;

import java.awt.Graphics;

/**
*
* SquareGrid class
* This class represents an Enemy, Wall or Empty spot on the GameBoard
*
* @author Martijn, Edo
* @version 0.1
* @date 04-10-2011
*
*/
public interface SquareGrid 
{
	int getX();
	int getY();
	void drawObject(Graphics g, int newX, int newY);
	boolean isBlocking();
	void update();
}
