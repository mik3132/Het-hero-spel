package model;

import java.util.ArrayList;

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
	
	GameBoardModel gbm;
	public int ovalSize, x, y, viewX, viewY, midX, midY, posHeroPosX, posHeroPosY, heroPosX, heroPosY, direction, posViewY, posViewX;
	
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
	
	public void rotateHero(int direction, boolean ctrl)
	{
		switch( direction )
		{
			case VIEWUP:
				viewY = (midY-(GameBoard.squareSize/2));
				viewX = midX;
				if(!ctrl)
					posHeroPosY--;
			break;
			case VIEWDOWN:
				viewY = (midY+(GameBoard.squareSize/2));
				viewX = midX;
				if(!ctrl)
					posHeroPosY++;
			break;
			case VIEWLEFT:
				viewX = (midX-(GameBoard.squareSize/2));
				viewY = midY;
				if(!ctrl)
					posHeroPosX--;
			break;
			case VIEWRIGHT:
				viewX = (midX+(GameBoard.squareSize/2));
				viewY = midY;
				if(!ctrl)
					posHeroPosX++;
			break;
		}
		this.direction = direction;		
		if(this.movePossible( posHeroPosX, posHeroPosY ))
		{
			heroPosX = posHeroPosX;
			heroPosY = posHeroPosY;
		} else {
			posHeroPosX = heroPosX;
			posHeroPosY = heroPosY;
			System.out.println("Move not possible.");
		}
	}

	private boolean movePossible(int x, int y)
	{
		if(x < 1 || y < 1 || x > gbm.sizePlayGroundX || y > gbm.sizePlayGroundY)
			return false;
		int tileX = posHeroPosX;
		int tileY = posHeroPosY;

		for(int i = 0; i < gbm.sglist.size(); i++)
		{
			SquareGrid check = gbm.sglist.get(i);
			if(check.x == tileX && check.y == tileY)
				return !check.isBlocking;
		}
		return false;
	}

	public void setSquareGrids( GameBoardModel gbm)
	{
		this.gbm = gbm;
	}
}
