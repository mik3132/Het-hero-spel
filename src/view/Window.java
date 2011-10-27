package view;

import java.awt.Color;
import java.awt.Graphics;

import model.SquareGrid;

/**
*
* Window class
* The window class represents an wall on the gameboard, players cannot move or shoot through the wall
*
* @author Leon
* @version 0.1
* @date 26-10-2011
*
*/
public class Window implements SquareGrid
{
	/** x and y coordinates for the wall (tileFormat) */
	int x, y, v;
	
	/**
	 * Constructor
	 * 
	 * @param int x The x coordinate to create the wall at
	 * @param int y The y coordinate to create the wall at
	 */
	public Window(int x, int y, int v) 
	{
		this.x = x;
		this.y = y;
		this.v = v;
	}
	
	/**
	 * Draw method for the Wall
	 * 
	 * @param Graphics g The Graphics manager
	 */
	public void drawWindow(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect( x, y, GameBoard.squareSize, GameBoard.squareSize);
		g.fillRect( x, y, GameBoard.squareSize, GameBoard.squareSize);
	}

	public void drawObject(Graphics g, int newX, int newY)
	{
		if (this.v == 0)
		{
			g.setColor(Color.BLUE);
			g.drawRect( newX + 15, newY, GameBoard.squareSize -30, GameBoard.squareSize);
			g.fillRect( newX + 15, newY, GameBoard.squareSize -30, GameBoard.squareSize);
		}
		else
		{
			g.setColor(Color.BLUE);
			g.drawRect( newX, newY + 15, GameBoard.squareSize, GameBoard.squareSize -30);
			g.fillRect( newX, newY + 15, GameBoard.squareSize, GameBoard.squareSize -30);
		}
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
