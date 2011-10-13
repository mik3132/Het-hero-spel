package model;

import java.util.ArrayList;

import view.GameBoard;
import view.PlayPanel;

/**
 * 
 * @author Martijn
 *
 * Projectile wat afgevuurd word op een doelwit moet alle coordinaten bevatten waar het getekent moet worden
 * Bijv (X) = x,y tot aan x,y
 * A > B > C enz. zodat je weet waar die projectile heen gaat en kunt zien wanneer het mogelijk inpact heeft
 *
 */
public class ProjectileModel
{
	int x,y,projectileSize, direction;
	ArrayList<ProjectileMovement> pcmv = new ArrayList<ProjectileMovement>();
	GameBoardModel gbm;
	public ProjectileModel(int x, int y, int direction, int projectileSize, GameBoardModel gbm)
	{
		this.x = (GameBoard.squareSize*x)+((GameBoard.squareSize - projectileSize)/2);
		this.y = (GameBoard.squareSize*y)+((GameBoard.squareSize - projectileSize)/2);
		this.projectileSize = projectileSize;
		this.direction = direction;
		this.gbm =gbm;
		this.calculatePositions();
	}

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
	
	public ArrayList<ProjectileMovement> getProjectileMovement()
	{
		return pcmv;
	}
}
