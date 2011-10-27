package model;

import java.util.HashMap;

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
		// Add scores and move actions
		this.scs = new Scores();
		HashMap<String, Integer> actions = new HashMap<String, Integer>();
		actions.put("VIEWUP", 10);
		actions.put("VIEWDOWN", 10);
		actions.put("VIEWLEFT", 10);
		actions.put("VIEWRIGHT", 10);
		Point point = new Point ("Stappen", actions, 500);
		this.scs.addAction("Stappen", point);
		this.scs.setIfAction("Stappen", false);
		
		// add shoot actions to scs
		actions = new HashMap<String, Integer>();
		actions.put("SHOOT", 50);		
		this.scs.addAction("Ammo", new Point("Ammo", actions, 500));
		this.scs.setIfAction("Ammo", false);
		
		// add lives
		actions = new HashMap<String, Integer>();
		actions.put("HEROHIT", 1);
		this.scs.addAction("Levens", new Point("Levens", actions, 5));
		this.scs.setIfAction("Levens", false);

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
				//Remove the points that the action cost, return false if there are not enough points	
				viewX = midX;
				if(scs.removeActionPoints("VIEWUP"))	
					if(!ctrl)									
						posHeroPosY--;
			break;
			case VIEWDOWN:
				viewY = (midY+(GameBoard.squareSize/2));
				viewX = midX;
				//Remove the points that the action cost, return false if there are not enough points
				if(scs.removeActionPoints("VIEWDOWN"))
					if(!ctrl)					
						posHeroPosY++;
			break;
			case VIEWLEFT:
				viewX = (midX-(GameBoard.squareSize/2));
				viewY = midY;
				//Remove the points that the action cost, return false if there are not enough points
				if(scs.removeActionPoints("VIEWLEFT"))
					if(!ctrl)
						posHeroPosX--;
			break;
			case VIEWRIGHT:
				viewX = (midX+(GameBoard.squareSize/2));
				viewY = midY;
				//Remove the points that the action cost, return false if there are not enough points
				if(scs.removeActionPoints("VIEWRIGHT"))
					if(!ctrl)					
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
			
			if(check.getX() == tileX && check.getY() == tileY) {
				return !check.isBlocking();
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
