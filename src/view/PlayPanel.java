package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Input;

import model.GameBoardModel;
import model.HeroModel;
import model.Timing;

/**
 * 
 * PlayPanel class
 * This class represents the PlayPanel in which the game is played
 * 
 * @author Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 * 
 */
public class PlayPanel extends JPanel
{
	/** The GameBoard to draw s*/
	GameBoard gb;
	/** The GameBoardModel containing all the GameBoard data */
	GameBoardModel gbm;
	/** The Input manager */
	Input in;
	/** The graphical representation of the Hero */
	Hero hero;
	/** The HeroModel containing all the data of the Hero */
	HeroModel hm;
	/** The Wall objects */
	Wall wall;
	/** */
	long lastProjectile = 0, lastProjectileEnemy = 0;
	/** The ArrayList containing all the projectiles */
	public ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	/** The width and height in pixels */	
	public final static int width = 850, height = 850;
	
	/**
	 * Constructor 
	 * @param GameBoardModel gbm
	 * @param HeroModel hm
	 */
	public PlayPanel( GameBoardModel gbm, HeroModel hm)
	{
		this.gbm = gbm;
		this.gb = new GameBoard( width, height, gbm );
		this.hero = new Hero( hm );
		this.hm = hm;
		this.setSize(width, height);
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setBackground( Color.white );
		this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		this.setVisible(true);
	}
	
	/**
	 * Places a new projectile on the GameBoard
	 */
	public void setNewProjectile(int firedBy)
	{
		//Remove the points that the action cost, return false if there are not enough points
		if( hm.scs.removeActionPoints("SHOOT") )
		{
			long timenow = System.currentTimeMillis();
			if(lastProjectile == 0 || lastProjectile < timenow) {
				lastProjectile = (timenow+Timing.bulletNext);
				projectiles.add(new Projectile( hm.heroPosX, hm.heroPosY, hm.direction, gbm, firedBy ));
			}
		} 
	}
	
	/**
	 * Places a new projectile on the GameBoard
	 */
	public void setNewProjectile( int x,int y, int direction, int firedBy)
	{
		long timenow = System.currentTimeMillis();
		if(lastProjectileEnemy == 0 || lastProjectileEnemy < timenow) {
			lastProjectileEnemy = (timenow+Timing.bulletNext);
			projectiles.add(new Projectile( x, y, direction, gbm, firedBy));
		}
	}
	
	public void update()
	{
		for(int f = 0; f < projectiles.size(); f++)
		{
			for(int s = 0; s < projectiles.size(); s++)
				if(s!=f && projectiles.get(f).rct.intersects( projectiles.get(s).rct ))
				{
					projectiles.get(f).pcmv.clear();
					projectiles.get(s).pcmv.clear();
				}
			if(projectiles.get(f).pcmv.size() < 1)
				projectiles.remove(f);
		}
	}
	
	/**
	 * The paint method
	 * 
	 * @param Graphics g The graphics manager
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		if(hm.scs.gameover)
			gb.drawGameOver(g);
		else if(hm.scs.won)
			gb.drawWon(g);
		else {
			gb.drawGrid(g); // Draw the Grid
			gb.drawGameBoard(g); // Draw the GameBoard
			hero.drawHero(g); // Draw the Hero
			gb.drawMessages(g);	// Draw hero messages	
			
			for(int i = 0; i < projectiles.size(); i++)
				projectiles.get(i).rePaint( g );
		}
	}
	
	
}
