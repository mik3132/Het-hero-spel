package model;

import java.util.ArrayList;

import view.GameBoard;
import view.PlayPanel;

/**
 * 
 * ProjectileModel class
 * This class contains the data of the projectiles fired, it contains the movement data of the projectile from start till it.
 * This way you know exactly where the projectile is heading and check when it impacts
 * 
 * @author Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class ProjectileModel
{
	/** The x and y coordinates of the projectile */
	int x, y;
	/** The size of the projectile */
	int projectileSize;
	/** The direction of the projectile */
	int direction;
	/** ArrayList containing the movement of the projectile */
	ArrayList<ProjectileMovement> pcmv = new ArrayList<ProjectileMovement>();
	/** The GameBoardModel */
	GameBoardModel gbm;
	
	/**
	 * Constructor 
	 * 
	 * @param int x The x coordinate from where the projectile was fired 
	 * @param int y The y coordinate from where the projectile was fired
	 * @param int direction The integer representation of the direction the projectile is traveling in
	 * @param int projectileSize The projectile size
	 * @param GameBoardModel gbm The GameBoardModel representing the current GameBoard
	 */
	public ProjectileModel(int x, int y, int direction, int projectileSize, GameBoardModel gbm)
	{
		this.x = (GameBoard.squareSize*x)+((GameBoard.squareSize - projectileSize)/2);
		this.y = (GameBoard.squareSize*y)+((GameBoard.squareSize - projectileSize)/2);
		this.projectileSize = projectileSize;
		this.direction = direction;
		this.gbm =gbm;
		this.calculatePositions();
	}

	/**
	 * Method that will calculate the positions the projectile will travel on
	 */
	public void calculatePositions()
	{
		int totalX = (PlayPanel.width/2)-(projectileSize/2);
		int totalY = (PlayPanel.height/2)-(projectileSize/2);
		
		int calPosX = (((PlayPanel.width/2)-(GameBoard.squareSize/2)) - (gbm.getHeroModel().heroPosX * GameBoard.squareSize));
		int calPosY = (((PlayPanel.height/2)-(GameBoard.squareSize/2)) - (gbm.getHeroModel().heroPosY * GameBoard.squareSize));
		int xRedraw = x + calPosX;
		int yRedraw = y + calPosY;
		
		long systime = System.currentTimeMillis();
		if(direction == HeroModel.VIEWUP)
			for(int i = 0; i < totalY; i++)
			{
				pcmv.add( new ProjectileMovement(
						xRedraw, yRedraw-i, (systime+Timing.bulletTime)
						) );
				systime = (systime+Timing.bulletTime);
				i = Timing.bulletSkip+i;
			}
		else if(direction == HeroModel.VIEWDOWN)
			for(int i = 0; i < totalY; i++)
			{
				pcmv.add( new ProjectileMovement(
						xRedraw, yRedraw+i, (systime+Timing.bulletTime)
						) );
				systime = (systime+Timing.bulletTime);
				i = Timing.bulletSkip+i;
			}
		else if(direction == HeroModel.VIEWLEFT)
			for(int i = 0; i < totalX; i++)
			{
				pcmv.add( new ProjectileMovement(
						xRedraw-i, yRedraw, (systime+Timing.bulletTime)
						) );
				systime = (systime+Timing.bulletTime);
				i = Timing.bulletSkip+i;
			}
		else if(direction == HeroModel.VIEWRIGHT)
			for(int i = 0; i < totalX; i++)
			{
				pcmv.add( new ProjectileMovement(
						xRedraw+i, yRedraw, (systime+Timing.bulletTime)
						) );
				systime = (systime+Timing.bulletTime);
				i = Timing.bulletSkip+i;
			}
	}
	
	/**
	 * Getter method for the projectileMovement
	 * 
	 * @return ArrayList the projectile movement
	 */
	public ArrayList<ProjectileMovement> getProjectileMovement()
	{
		return pcmv;
	}
}
