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
	public Scores scs;
	
	GameBoardModel gbm;
	public int ovalSize, x, y, viewX, viewY, midX, midY, posHeroPosX, posHeroPosY, heroPosX, heroPosY, direction, posViewY, posViewX;
	
	public HeroModel(int width, int height, int points )
	{
		//Add scores and actions
		this.scs = new Scores(points);
		this.scs.addAction("VIEWUP", 10);
		this.scs.addAction("VIEWDOWN", 10);
		this.scs.addAction("VIEWLEFT", 10);
		this.scs.addAction("VIEWRIGHT", 10);
		
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
					if(scs.removeActionPoints("VIEWUP"))						
						posHeroPosY--;
					else
						System.out.println("gameover?");
			break;
			case VIEWDOWN:
				viewY = (midY+(GameBoard.squareSize/2));
				viewX = midX;
				if(!ctrl)
					if(scs.removeActionPoints("VIEWDOWN"))
						posHeroPosY++;
					else
						System.out.println("gameover?");
			break;
			case VIEWLEFT:
				viewX = (midX-(GameBoard.squareSize/2));
				viewY = midY;
				if(!ctrl)
					if(scs.removeActionPoints("VIEWLEFT"))
						posHeroPosX--;
					else
						System.out.println("gameover?");
			break;
			case VIEWRIGHT:
				viewX = (midX+(GameBoard.squareSize/2));
				viewY = midY;
				if(!ctrl)
					if(scs.removeActionPoints("VIEWRIGHT"))
						posHeroPosX++;
					else
						System.out.println("gameover?");
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
