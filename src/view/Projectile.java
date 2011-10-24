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
 * Projectile class
 * This class draws the projectiles on the GameBoard
 * 
 * @author Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 * 
 */
public class Projectile extends ProjectileModel
{
	/** The x and y coordinates of a projectile */
	int x,y;
	/** An integer representation of the projectile direction */
	int direction;
	/** The x and y coordinates the projectile wants to move */
	int xTile, yTile;
	/** The size of a projectile */
	public final static int projectileSize = 10;
	/** The GameBoardModel containing all the GameBoard data */
	GameBoardModel gbm;
	/** The ArrayList containing the movement of the projectile */
	ArrayList<ProjectileMovement> pcmv;
	
	/**
	 * Constructor 
	 * 
	 * @param int xTile The x position of the projectile
	 * @param int yTile The y position of the projectile
	 * @param int direction The direction the projectile is moving in
	 * @param GameBoardModel gbm The GameBoardModel containing all the GameBoard data
	 */
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

	/**
	 * The rePaint method
	 * Makes sure the drawing of the projectile is smooth and flowing
	 * 
	 * @param Graphics g The graphics manager
	 */
	public void rePaint(Graphics g)
	{
		// Enter loop if the projectile 
		if(pcmv.size() > 0) {
			long systime = System.currentTimeMillis();
			if(pcmv.get(0).time >= systime) {
				int Xless = (((PlayPanel.width-GameBoard.squareSize)/2)/GameBoard.squareSize);
				int Yless = (((PlayPanel.height-GameBoard.squareSize)/2)/GameBoard.squareSize);
				int Xnew = x+pcmv.get(0).x - (gbm.getHeroModel().heroPosX * GameBoard.squareSize);
				int Ynew = y+pcmv.get(0).y - (gbm.getHeroModel().heroPosY * GameBoard.squareSize);
				int tileX = ((Xnew/GameBoard.squareSize+gbm.getHeroModel().heroPosX)-Xless);
				int tileY = ((Ynew/GameBoard.squareSize+gbm.getHeroModel().heroPosY)-Yless);
				
				try {
					SquareGrid sg = gbm.getObjectFromPlayGround(tileX, tileY);
					if(sg instanceof Enemy) {
						gbm.removeFromPlayGround( gbm.getIndexFromBoard(tileX, tileY), "+ 200" );
						gbm.heroModel.scs.points += 200;
						gbm.heroModel.scs.removeEnemy();
						//pcmv.clear();
						return;
					} else if(sg instanceof Wall) {
						pcmv.clear();
						return;
					}
				} catch(Exception e) {
					System.out.println("Errormessage: " + e);
				}
				
				if(tileX < 1 || tileY < 1 || gbm.sizePlayGroundX < tileX || gbm.sizePlayGroundY < tileY) {
					pcmv.clear();
					return;
				} else {
					g.setColor( Color.BLUE );
					g.fillOval( Xnew, Ynew, projectileSize, projectileSize);
				}
				
			} else if(pcmv.get(0).time < systime) {
				
				pcmv.remove(0);
				
				if(pcmv.size() > 0) {
					rePaint(g);
				}
			}
		}
	}
}
