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
	long lastProjectile = 0;
	/** The ArrayList containing all the projectiles */
	public ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	/** The width and height in pixels */	
	public final static int width = 850, height = 850; //px
	boolean gameover = false;
	boolean won = false;

	
	/**
	 * Constructor 
	 * @param GameBoardModel gbm
	 * @param HeroModel hm
	 */
	public PlayPanel( GameBoardModel gbm, HeroModel hm)
	{
		this.gbm = gbm;
		this.gb = new GameBoard( width, height, gbm, hm );
		this.hero = new Hero( hm );
		this.hm = hm;
		this.setSize(width, height);
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setBackground( Color.white );
		this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		this.setVisible(true);

		// add action to Scores
		hm.scs.addAction("SHOOT", hm.scs.shotCost);
	}
	
	/**
	 * Places a new projectile on the GameBoard
	 */
	public void setNewProjectile()
	{
		//Remove the points that the action cost, return false if there are not enough points
		if( hm.scs.removeActionPoints("SHOOT") )
		{
			long timenow = System.currentTimeMillis();
			if(lastProjectile == 0 || lastProjectile < timenow) {
				lastProjectile = (timenow+Timing.bulletNext);
				projectiles.add(new Projectile( hm.heroPosX, hm.heroPosY, hm.direction, gbm ));
			}
		} 
	}
	
	/**
	 * The paint method
	 * 
	 * @paramn Graphics g The graphics manager
	 */
	public void paint(Graphics g)
	{
		if(hm.scs.gameover) {
			g.clearRect(0, 0, width, height);
			this.gameOver(g);
		} else {
			super.paint(g);
			gb.drawGrid(g); //Laat Grid zien
			gb.drawGameBoard(g);
			hero.drawHero(g);
			for(int i = 0; i < projectiles.size(); i++)
			{
				projectiles.get(i).rePaint( g );
			}
		}
	}
	
	public void gameOver(Graphics g)
	{
		gb.drawGameOver(g);
	}
	
}
