package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import model.GameBoardModel;
import model.HeroModel;
import model.ProjectileMovement;
import model.SquareGrid;
import model.Timing;

public class Projectile
{
	int direction;
	int xTile, yTile;
	int firedBy;
	public int px, py;

	public final static int projectileSize = 10;
	public final static int projectileTileLenght = 5;
	
	GameBoardModel gbm;
	ArrayList<ProjectileMovement> pcmv = new ArrayList<ProjectileMovement>();
	
	/**
	 * Constructor 
	 * 
	 * @param int xTile The x position of the projectile
	 * @param int yTile The y position of the projectile
	 * @param int direction The direction the projectile is moving in
	 * @param GameBoardModel gbm The GameBoardModel containing all the GameBoard data
	 */
	public Projectile( int xTile, int yTile, int direction, GameBoardModel gbm, int firedBy )
	{
		this.direction = direction;
		this.xTile = xTile;
		this.yTile = yTile;
		this.gbm = gbm;
		this.firedBy = firedBy;
		this.createProjectileMovements();
	}
	
	public void createProjectileMovements()
	{
		int totalPixels = (GameBoard.squareSize*projectileTileLenght);
		
		long systime = System.currentTimeMillis();
		for(int i = 0; i < totalPixels; i++)
		{
			pcmv.add( new ProjectileMovement( direction, i, (systime+Timing.bulletTime) ) );
			systime = (systime+Timing.bulletTime);
			i = Timing.bulletSkip+i;
		}
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

				int direction = pcmv.get(0).direction;
				int pixels = pcmv.get(0).pixel;
				
				int x = (((xTile - gbm.heroModel.heroPosX)*50)+(PlayPanel.width/2))-(projectileSize/2);
				int y = (((yTile - gbm.heroModel.heroPosY)*50)+(PlayPanel.height/2))-(projectileSize/2);
				int tileXfromX = xTile;
				int tileYfromY = yTile;
				
				if(direction == HeroModel.VIEWUP){
					y = (y-pixels);
					tileYfromY -= (pixels/GameBoard.squareSize);
				} else if(direction == HeroModel.VIEWDOWN){
					y = (y+pixels);
					tileYfromY += (pixels/GameBoard.squareSize);
				} else if(direction == HeroModel.VIEWLEFT){
					x = (x-pixels);
					tileXfromX -= (pixels/GameBoard.squareSize);
				} else if(direction == HeroModel.VIEWRIGHT){
					x = (x+pixels);
					tileXfromX += (pixels/GameBoard.squareSize);
				}

				try {
					if(this.firedBy == Enemy.fireBy && gbm.getHeroModel().heroPosX == tileXfromX && gbm.getHeroModel().heroPosY == tileYfromY)
					{
						//Hero verliest leven
						gbm.heroModel.scs.removeActionPoints("HEROHIT");
						pcmv.clear();
						return;
					}
					
					SquareGrid sg = gbm.getObjectFromPlayGround(tileXfromX, tileYfromY);
					if(sg instanceof Enemy && this.firedBy == Hero.fireBy) {
						gbm.removeFromPlayGround( gbm.getIndexFromBoard(tileXfromX, tileYfromY), "+ 200" );
						gbm.heroModel.scs.addGamePoints("Stappen", 200);
						gbm.heroModel.scs.removeEnemy();
						return;
					} else if(sg instanceof Wall) {
						pcmv.clear();
						return;
					}
				} catch(Exception e) {
					System.out.println("Errormessage: " + e);
				}
				
				if(tileXfromX < 1 || tileYfromY < 1 || gbm.sizePlayGroundX < tileXfromX || gbm.sizePlayGroundY < tileYfromY) {
					pcmv.clear();
					return;
				} else {
					px = x;
					py = y;

					g.setColor( Color.BLUE );
					g.fillOval( x, y, projectileSize, projectileSize);
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
