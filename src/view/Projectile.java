package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import model.GameBoardModel;
import model.ProjectileModel;
import model.ProjectileMovement;
import model.SquareGrid;

/**
 * 
 * @author Martijn
 *
 * Teken de vliegende objecten
 *
 */
public class Projectile extends ProjectileModel
{
	int x,y,direction, xTile, yTile;
	public final static int projectileSize = 10;
	GameBoardModel gbm;
	ArrayList<ProjectileMovement> pcmv;
	
	Projectile( int xTile, int yTile, int direction, GameBoardModel gbm )
	{
		super( xTile, yTile, direction, projectileSize, gbm );
		this.xTile = xTile;
		this.yTile = yTile;
		this.x = (GameBoard.squareSize*xTile);
		this.y = (GameBoard.squareSize*yTile);
		this.direction = direction;
		this.gbm = gbm;
		this.pcmv = getProjectileMovement();
	}

	public void rePaint(Graphics g)
	{
		if(pcmv.size() > 0)
		{
			long systime = System.currentTimeMillis();
			if(pcmv.get(0).time >= systime)
			{
				int Xless = (((PlayPanel.width-GameBoard.squareSize)/2)/GameBoard.squareSize);
				int Yless = (((PlayPanel.height-GameBoard.squareSize)/2)/GameBoard.squareSize);
				int Xnew = x+pcmv.get(0).x - (gbm.getHeroModel().heroPosX * GameBoard.squareSize);
				int Ynew = y+pcmv.get(0).y - (gbm.getHeroModel().heroPosY * GameBoard.squareSize);
				
				int tileX = ((Xnew/GameBoard.squareSize+gbm.getHeroModel().heroPosX)-Xless);
				int tileY = ((Ynew/GameBoard.squareSize+gbm.getHeroModel().heroPosY)-Yless);
				try{
					int sg = gbm.getObjectFromPlayGround(tileX, tileY).item;
					if(sg == GameBoard.ENEMY)
					{
						gbm.removeFromPlayGround( gbm.getIndexFromBoard(tileX, tileY) );
						pcmv.clear();
						return;
					} else if(sg == GameBoard.WALL)
					{
						pcmv.clear();
						return;
					}
				} catch(Exception e){}
				if(tileX < 1 || tileY < 1 || gbm.sizePlayGroundX < tileX || gbm.sizePlayGroundY < tileY)
				{
					pcmv.clear();
					return;
				} else
				{
					g.setColor( Color.BLUE );
					g.fillOval( Xnew, Ynew, projectileSize, projectileSize);
				}
			} else if(pcmv.get(0).time < systime)
			{
				pcmv.remove(0);
				if(pcmv.size() > 0)
					rePaint(g);
			}
		}
	}
}
