package model;

import view.GameBoard;

/**
 * 
 * @author Martijn
 *
 * De data van de hero wat getekend moet worden voor de view klasse.
 *
 */
public class HeroModel 
{
	public static final int VIEWUP = 0;
	public static final int VIEWLEFT = 1;
	public static final int VIEWRIGHT = 2;
	public static final int VIEWDOWN = 3;
	
	public static final int MOVEUP = 0;
	public static final int MOVELEFT = 1;
	public static final int MOVERIGHT = 2;
	public static final int MOVEDOWN = 3;
	
	public int ovalSize, x, y, viewX, viewY, midX, midY;
	
	public HeroModel(int width, int height )
	{
		this.midX = (width/2);
		this.midY = (height/2);
		this.viewX = midX;
		this.viewY = midY;
		this.x = (width/2)-(GameBoard.squareSize/2);
		this.y = (height/2)-(GameBoard.squareSize/2);
		this.ovalSize = GameBoard.squareSize;
	}
	
	public void rotateHero(int direction)
	{
		switch( direction )
		{
			case VIEWUP:
				viewY = (midY-(GameBoard.squareSize/2));
				viewX = midX;
				
				midY -= 50;
				viewY -= 50;
				y -= 50;
			break;
			case VIEWDOWN:
				viewY = (midY+(GameBoard.squareSize/2));
				viewX = midX;
				
				midY += 50;
				viewY += 50;
				y += 50;
			break;
			case VIEWLEFT:
				viewX = (midX-(GameBoard.squareSize/2));
				viewY = midY;
				
				midX -= 50;
				viewX -= 50;
				x -= 50;
			break;
			case VIEWRIGHT:
				viewX = (midX+(GameBoard.squareSize/2));
				viewY = midY;
				
				midX += 50;
				viewX += 50;
				x += 50;
			break;
		}
	}

}
