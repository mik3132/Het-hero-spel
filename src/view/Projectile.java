package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import model.GameBoardModel;
import model.ProjectileModel;
import model.ProjectileMovement;

/**
 * 
 * @author Martijn
 *
 * Teken de vliegende objecten
 *
 */
public class Projectile extends ProjectileModel
{
	int x,y,direction;
	public final static int projectileSize = 10;
	GameBoardModel gbm;
	ArrayList<ProjectileMovement> pcmv;
	
	Projectile( int xTile, int yTile, int direction, GameBoardModel gbm )
	{
		super( xTile, yTile, direction, projectileSize, gbm );
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
				g.setColor( Color.BLUE );
				g.fillOval(pcmv.get(0).x, pcmv.get(0).y, projectileSize, projectileSize);
			} else if(pcmv.get(0).time < systime)
			{
				pcmv.remove(0);
				rePaint(g);
			}
		}
	}
}
