package model;

import java.util.Random;

import view.Enemy;
import view.GameBoard;
import view.PlayPanel;

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
	
	int posibilityFire = 100;
	
	/** The GameBoardModel */
	GameBoardModel gbm;
	PlayPanel playPanel;
	Random rdm;
	
	/** The position in px */
	public int x, y;
	
	/** the path the enemy is walking*/
	Integer[] walkway = new Integer[]{VIEWRIGHT, VIEWUP, VIEWLEFT, VIEWDOWN};
	/** the current place on the path	 */
	int place = 0;
	public int midX, midY, viewX, viewY;
	
	/**
	 * Constructor 
	 * 
	 * @param int x The x coordinate of the enemy
	 * @param int y The y coordinate of the enemy
	 */
	protected EnemyModel(int x, int y, GameBoardModel gbm, PlayPanel playPanel, Random rdm)
	{
		this.playPanel = playPanel;
		this.x = x;
		this.y = y;
		this.midX = (GameBoard.squareSize*x);
		this.midY = (GameBoard.squareSize*y);
		this.viewX = midX;
		this.viewY = midY;
		this.gbm = gbm;
		this.rdm = rdm;
	}
	
	protected void moveEnemy()
	{		
		this.rotate(walkway[place]);
		
		if(place < (walkway.length-1))
			place++;
		else
			place = 0;
	}
	
	private void rotate(int direction)
	{
		int tempX = x,tempY = y;
		
		switch( direction ) {
			case VIEWUP:			
				tempY--;
			break;
			case VIEWDOWN:
				tempY++;
			break;
			case VIEWLEFT:
				tempX--;
			break;
			case VIEWRIGHT:
				tempX++;
			break;
		}

		if(this.movePossible( tempX, tempY )) {
			this.x = tempX;
			this.y = tempY;
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
		if(x < 1 || 
			y < 1 || 
			x > gbm.sizePlayGroundX || 
			y > gbm.sizePlayGroundY || 
			(gbm.heroModel.heroPosX == x && gbm.heroModel.heroPosY == y))
			return false;
		
		// Loop through the GameBoardModel object list checking for objects
		for(int i = 0; i < gbm.sglist.size(); i++) {
			SquareGrid check = gbm.sglist.get(i);
			if(check.getX() == x && check.getY() == y)
				return !check.isBlocking();
		}
		return false;
	}

	public void followHero(int newX, int newY)
	{
		this.midX = newX+(GameBoard.squareSize/2);
		this.midY = newY+(GameBoard.squareSize/2);
		this.viewX = midX;
		this.viewY = midY;
		
		int heroTilePosX = gbm.heroModel.heroPosX;
		int heroTilePosY = gbm.heroModel.heroPosY;
		
		if(heroTilePosX == x)
			if(heroTilePosY < y)
			{
				this.viewY -= (GameBoard.squareSize/2);
				if(rdm.nextInt(posibilityFire+1) == posibilityFire)
					playPanel.setNewProjectile(x, y, HeroModel.VIEWUP, Enemy.fireBy);
			} else {
				this.viewY += (GameBoard.squareSize/2);
				if(rdm.nextInt(posibilityFire+1) == posibilityFire)
					playPanel.setNewProjectile(x, y, HeroModel.VIEWDOWN, Enemy.fireBy);
			}
		if(heroTilePosY == y)
			if(heroTilePosX < x)
			{
				this.viewX -= (GameBoard.squareSize/2);
				if(rdm.nextInt(posibilityFire+1) == posibilityFire)
					playPanel.setNewProjectile(x, y, HeroModel.VIEWLEFT, Enemy.fireBy);
			} else {
				this.viewX += (GameBoard.squareSize/2);
				if(rdm.nextInt(posibilityFire+1) == posibilityFire)
					playPanel.setNewProjectile(x, y, HeroModel.VIEWRIGHT, Enemy.fireBy);
			}
	}
	
}
