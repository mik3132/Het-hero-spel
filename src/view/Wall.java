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
	int x, y;
	
	Wall( int x, int y )
	{
		this.x = x;
		this.y = y;
	}
	
	public void drawWall( Graphics g )
	{
		g.setColor(Color.BLACK);
		g.drawRect( x, y, GameBoard.squareSize, GameBoard.squareSize);
		g.fillRect( x, y, GameBoard.squareSize, GameBoard.squareSize);
	}
	
	/**
	 * g.drawRect(25/2 + 0, 0, GameBoard.squareSize/2, GameBoard.squareSize);
	 * g.fillRect(25/2 + 0, 0, GameBoard.squareSize/2, GameBoard.squareSize);
	 *
	 * The 25/2 as first parameter ensures the size of the vertical wall, the + 0 and 0 are the positions for the wall
	 *
	
	public void drawWallVertical( Graphics g )
	{
		g.setColor(Color.PINK);
		g.drawRect(25/2 + 0, 0, GameBoard.squareSize/2, GameBoard.squareSize);
		g.fillRect(25/2 + 0, 0, GameBoard.squareSize/2, GameBoard.squareSize);
	}
	
	public void drawWallHorizontal(Graphics g)
	{
		g.setColor(Color.PINK);
		g.drawRect(50, 25/2 + 50 , GameBoard.squareSize, GameBoard.squareSize/2);
		g.fillRect(50, 25/2 + 50, GameBoard.squareSize, GameBoard.squareSize/2);
	}
	
	public void drawWallCorner(Graphics g)
	{
		g.setColor(Color.PINK);
		g.drawRect(25, 25/2 + 50, GameBoard.squareSize/2, GameBoard.squareSize/2);
		g.fillRect(25, 25/2 + 50, GameBoard.squareSize/2, GameBoard.squareSize/2);
		
		g.setColor(Color.RED);
		g.drawRect(25/2, 50, GameBoard.squareSize/2, GameBoard.squareSize/2);
		g.fillRect(25/2, 50, GameBoard.squareSize/2, GameBoard.squareSize/2);
		
		g.setColor(Color.BLUE);
		g.drawOval(25/2 + 0, 25/2 + 50, GameBoard.squareSize/2, GameBoard.squareSize/2);
		g.fillOval(25/2 + 0, 25/2 + 50, GameBoard.squareSize/2, GameBoard.squareSize/2);
	}
	 */
	
}
