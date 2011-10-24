package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * EnemyModel class
 * The data of the enemies that will be drawn on the GameBoard
 * 
 * @author Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class EnemyModel
{
	/** Static final integer for VIEWUP */
	public final int VIEWUP = 0;
	/** Static final integer for VIEWLEFT */
	public final int VIEWLEFT = 1;
	/** Static final integer for VIEWRIGHT */
	public final int VIEWRIGHT = 2;
	/** Static final integer for VIEWDOWN */
	public final int VIEWDOWN = 3;
	
	/** The GameBoardModel */
	GameBoardModel gbm;
	
	/** The position in px */
	public int x, y; 
	/** The future position in px */
	public int fx, fy;
	
	/** the path the enemy is walking*/
	Integer[] walkway;
	/** the current place on the path	 */
	int place = 0;
	
	/**
	 * Constructor 
	 * 
	 * @param int x The x coordinate of the enemy
	 * @param int y The y coordinate of the enemy
	 */
	public EnemyModel(int x, int y)
	{
		//walkway of the enemy, walk right, up, left and down.
		this.walkway = new Integer[]{VIEWRIGHT, VIEWUP, VIEWLEFT, VIEWDOWN};
		this.x = x;
		this.y = y;
		this.fx = x;
		this.fy = y;
	}
	
	public void moveEnemy()
	{		
		this.rotate(walkway[place]);
		
		if(place < (walkway.length-1))
			place++;
		else
			place = 0;
	}
	
	private void rotate(int direction)
	{
		switch( direction ) {
			case VIEWUP:				
				fy -= gbm.squareSize;
			break;
			case VIEWDOWN:
				fy += gbm.squareSize;
			break;
			case VIEWLEFT:
				fx -= gbm.squareSize;
			break;
			case VIEWRIGHT:
				fx += gbm.squareSize;
			break;
		}
		
		// Check if the move is possible
		if(this.movePossible( (x/gbm.squareSize), (y/gbm.squareSize) )) {
			x = fx;
			y = fy;
			System.out.println("Move possible.");
		} else {
			fy = y;
			fx = x;
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

		int tileX = x;
		int tileY = y;

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
