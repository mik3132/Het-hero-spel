package model;

import view.GameBoard;

/**
 * 
 * HeroModel class
 * The HeroModel class represents the hero in the game
 * 
 * @author Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class HeroModel 
{
	/** static final integer for VIEWUP */
	public static final int VIEWUP = 0;
	/** static final integer for VIEWLEFT */
	public static final int VIEWLEFT = 1;
	/** static final integer for VIEWRIGHT */
	public static final int VIEWRIGHT = 2;
	/** static final integer for VIEWDOWN */
	public static final int VIEWDOWN = 3;
	
	/** The Scores model */
	public Scores scs;
	
	/** The GameBoardModel */
	GameBoardModel gbm;
	
	public int ovalSize, x, y, viewX, viewY, midX, midY, posHeroPosX, posHeroPosY, heroPosX, heroPosY, direction, posViewY, posViewX;
	 
	public HeroModel(int width, int height, int points )
	{
		// Add scores and actions
		this.scs = new Scores(points);
		this.scs.addAction("VIEWUP", scs.movementCost);
		this.scs.addAction("VIEWDOWN", scs.movementCost);
		this.scs.addAction("VIEWLEFT", scs.movementCost);
		this.scs.addAction("VIEWRIGHT", scs.movementCost);
		
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
		switch( direction ) {
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
		
		if(this.movePossible( posHeroPosX, posHeroPosY )) {
			heroPosX = posHeroPosX;
			heroPosY = posHeroPosY;
		} else {
			posHeroPosX = heroPosX;
			posHeroPosY = heroPosY;
			System.out.println("Move not possible.");
		}
	}

	/**
	 * Checks if the move is possible to the given coordinates
	 * @param int x The x coordinate to move to
	 * @param int y The y coordinate to move to
	 * @return boolean True if the move is possible and False when it isn't
	 */
	private boolean movePossible(int x, int y)
	{
		//TODO Magic numbers....
		if(x < 1 || y < 1 || x > gbm.sizePlayGroundX || y > gbm.sizePlayGroundY) {
			return false;
		}
		
		int tileX = posHeroPosX;
		int tileY = posHeroPosY;

		// Loop through the GameBoardModel object list checking for objects
		for(int i = 0; i < gbm.sglist.size(); i++) {
			SquareGrid check = gbm.sglist.get(i);
			
			if(check.x == tileX && check.y == tileY) {
				return !check.isBlocking;
			}
		}
		return false;
	}

	/**
	 * Setter method for the current GameBoardModel
	 * @param GameBoardModel gbm The GameBoardModel to set
	 */
	public void setSquareGrids( GameBoardModel gbm)
	{
		this.gbm = gbm;
	}
}
