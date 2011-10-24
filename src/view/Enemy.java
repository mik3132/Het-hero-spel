package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import model.EnemyModel;

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
public class Enemy extends EnemyModel
{
	/** x and y coordinates for the enemy */
	int x, y; 
	/** the direction the enemy is facing*/
	int direction;
	

	/**
	 * Constructor
	 * 
	 * @param int x The x position of the enemy
	 * @param int y The y position of the enemy
	 * @param Graphics g The graphics manager
	 */
	Enemy(int x, int y, Graphics g)
	{
		super(x,y);
		this.x = x;
		this.y = y;
		this.drawEnemy(g);			
	}
	
	public void update()
	{

	}

	/**
	 * Draw method for the enemy
	 * 
	 * @param Graphics g The graphics manager
	 */
	public void drawEnemy( Graphics g )
	{
		g.setColor(Color.RED);
		g.drawOval(super.x, super.y, GameBoard.squareSize, GameBoard.squareSize);
		g.fillOval(super.x, super.y, GameBoard.squareSize, GameBoard.squareSize);
		g.setColor(Color.BLACK);
		//g.drawLine(hm.midX, hm.midY, hm.viewX, hm.viewY);
	}
	
	
}
