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
	/** Static final integer for VIEWUP */
	public static final int VIEWUP = 0;
	/** Static final integer for VIEWLEFT */
	public static final int VIEWLEFT = 1;
	/** Static final integer for VIEWRIGHT */
	public static final int VIEWRIGHT = 2;
	/** Static final integer for VIEWDOWN */
	public static final int VIEWDOWN = 3;
	
	/** The Scores model */
	public Scores scs;
	/** The GameBoardModel */
	GameBoardModel gbm;
	
	/** The size of an oval representing our Hero */
	public int ovalSize; 
	/** The position of the Hero */
	public int x, y; 
	/** The middle points of the Hero */
	public int midX, midY, viewX, viewY;
	/** The position of the Hero */
	public int heroPosX, heroPosY;
	/** The position the hero wants to go to */
	public int posHeroPosX, posHeroPosY; 
	/** Integer representation of the direction of the Hero */
	public int direction; 
	/** The position the Hero is looking at */
	public int posViewY, posViewX;
	 
	/**
	 * Constructor
	 * 
	 * @param int width The width of the hero
	 * @param int height The height of the hero
	 * @param int points The number of the points the hero has
	 */
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
	
	/**
	 * Rotates the hero in the given direction
	 * 
	 * @param int direction Integer representation of the direction
	 * @param boolean ctrl Boolean whether or not the control button is pressed
	 */
	public void rotateHero(int direction, boolean ctrl)
	{
		switch( direction ) {
			case VIEWUP:
				viewY = (midY-(GameBoard.squareSize/2));
				viewX = midX;
				if(!ctrl)
					//Remove the points that the action cost, return false if there are not enough points
					if(scs.removeActionPoints("VIEWUP"))						
						posHeroPosY--;
			break;
			case VIEWDOWN:
				viewY = (midY+(GameBoard.squareSize/2));
				viewX = midX;
				if(!ctrl)
					//Remove the points that the action cost, return false if there are not enough points
					if(scs.removeActionPoints("VIEWDOWN"))
						posHeroPosY++;
			break;
			case VIEWLEFT:
				viewX = (midX-(GameBoard.squareSize/2));
				viewY = midY;
				if(!ctrl)
					//Remove the points that the action cost, return false if there are not enough points
					if(scs.removeActionPoints("VIEWLEFT"))
						posHeroPosX--;
			break;
			case VIEWRIGHT:
				viewX = (midX+(GameBoard.squareSize/2));
				viewY = midY;
				if(!ctrl)
					//Remove the points that the action cost, return false if there are not enough points
					if(scs.removeActionPoints("VIEWRIGHT"))
						posHeroPosX++;
			break;
		}
		
		this.direction = direction;		
		
		// Check if the move is possible
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
	 * 
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
	 * 
	 * @param GameBoardModel gbm The GameBoardModel to set
	 */
	public void setSquareGrids( GameBoardModel gbm)
	{
		this.gbm = gbm;
	}
}
