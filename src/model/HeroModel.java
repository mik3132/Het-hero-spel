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
	
	public int ovalSize, x, y, viewX, viewY, midX, midY, heroPosX, heroPosY, direction;
	
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
				if(this.direction==direction)
					heroPosY--;
			break;
			case VIEWDOWN:
				viewY = (midY+(GameBoard.squareSize/2));
				viewX = midX;
				if(this.direction==direction)
					heroPosY++;
			break;
			case VIEWLEFT:
				viewX = (midX-(GameBoard.squareSize/2));
				viewY = midY;
				if(this.direction==direction)
					heroPosX--;
			break;
			case VIEWRIGHT:
				viewX = (midX+(GameBoard.squareSize/2));
				viewY = midY;
				if(this.direction==direction)
					heroPosX++;
			break;
		}
		this.direction = direction;
	}

}
