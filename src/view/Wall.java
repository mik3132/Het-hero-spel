package view;

import java.awt.Color;
import java.awt.Graphics;

import model.SquareGrid;

/**
*
* Wall class
* The wall class represents an wall on the gameboard, players cannot move or shoot through the wall
*
* @author Edo, Martijn
* @version 0.1
* @date 04-10-2011
*
*/
public class Wall implements SquareGrid
{
	/** x and y coordinates for the wall (tileFormat) */
	int x, y;
	
	/**
	 * Constructor
	 * 
	 * @param int x The x coordinate to create the wall at
	 * @param int y The y coordinate to create the wall at
	 */
	public Wall(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Draw method for the Wall
	 * 
	 * @param Graphics g The Graphics manager
	 */
	public void drawWall(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawRect( x, y, GameBoard.squareSize, GameBoard.squareSize);
		g.fillRect( x, y, GameBoard.squareSize, GameBoard.squareSize);
	}

	public void drawObject(Graphics g, int newX, int newY)
	{
		g.setColor(Color.BLACK);
		g.drawRect( newX, newY, GameBoard.squareSize, GameBoard.squareSize);
		g.fillRect( newX, newY, GameBoard.squareSize, GameBoard.squareSize);
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public boolean isBlocking()
	{
		return true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
