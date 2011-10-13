package view;

import java.awt.Color;
import java.awt.Graphics;

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
public class Wall
{
	/** x and y coordinates for the wall */
	int x, y;
	
	/**
	 * Constructor
	 * 
	 * @param int x The x coordinate to create the wall at
	 * @param int y The y coordinate to create the wall at
	 */
	Wall(int x, int y) 
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
	
}
