package view;

import java.awt.Graphics;

/**
 * 
 * @author Martijn
 *
 * Hero class
 * This class represent the protagonist of the game
 * A Hero is an Actor with a score 
 * 
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 * 
 */
public class Hero 
{
	int ovalSize, x, y;
	Hero(int width, int height, GameBoard gb)
	{
		this.x = (width/2)-(gb.squareSize/2);
		this.y = (height/2)-(gb.squareSize/2);
		this.ovalSize = gb.squareSize;
	}

	public void drawHero( Graphics g )
	{
		g.drawOval(x, y, ovalSize, ovalSize);
	}
}