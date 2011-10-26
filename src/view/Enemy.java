package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import model.EnemyModel;
import model.GameBoardModel;
import model.SquareGrid;

/**
*
* Enemy class
* The enemy class represents an enemy on the gameboard, players cannot move through the enemies but they can shoot them
*
* @author Edo, Martijn
* @version 0.1
* @date 04-10-2011
*
*/
public class Enemy extends EnemyModel implements SquareGrid
{
	/** x and y coordinates for the enemy (tile format) */
	int x, y; 
	/** the direction the enemy is facing*/
	int direction;
	/** The color of the enemy */
	private static final Color ENEMY_COLOR = Color.GRAY;
	/** The current time in nano seconds */
	long lasttime = System.nanoTime(); // timenow
	/** The timout time in nano seconds */
	int timeout = 1000000000;
	/** Random generator for the enemy AI*/
	Random rdm;
	/** Timing int for the rate of fire by enemies*/
	public static final int fireBy = 1;

	/**
	 * Constructor
	 * 
	 * @param int x The x position of the enemy
	 * @param int y The y position of the enemy
	 * @param Graphics g The graphics manager
	 */
	public Enemy( int x, int y, GameBoardModel gbm, Random rdm, PlayPanel playPanel )
	{
		super(x,y, gbm, playPanel, rdm);
		this.rdm = rdm;
		this.x = x;
		this.y = y;			
	}
	
	public void update()
	{
		int prediction = 1;
		int sizeprediction = 20;
		if((lasttime+timeout) < System.nanoTime() && (prediction == rdm.nextInt( sizeprediction )))
		{
			super.moveEnemy();
			lasttime = System.nanoTime();
		}
		this.x = super.x;
		this.y = super.y;
	}

	public void drawObject(Graphics g, int newX, int newY)
	{
		super.followHero(newX, newY);
		g.setColor(ENEMY_COLOR);
		g.drawOval(newX, newY, GameBoard.squareSize, GameBoard.squareSize);
		g.fillOval(newX, newY, GameBoard.squareSize, GameBoard.squareSize);
		g.setColor(Color.BLACK);
		g.drawLine(super.midX, super.midY, super.viewX, super.viewY);
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	@Override
	public boolean isBlocking()
	{
		return true;
	}
}
