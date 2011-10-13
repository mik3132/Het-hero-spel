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
 * @author Martijn
 *
 * Hierin word het speelveld getekend incl spelers enemys etc.
 *
 */
public class PlayPanel extends JPanel
{
	GameBoard gb;
	GameBoardModel gbm;
	Input in;
	Hero hero;
	Wall wall;
	HeroModel hm;
	long lastProjectile = 0;
	public ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public final static int width = 850, height = 850; //px
	boolean gameover = false;
	boolean won = false;
	
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
		
		//add action to Scores
		hm.scs.addAction("SHOOT", 500);
	}
	
	public void setNewProjectile()
	{
		//Remove the points that the action cost, else check if the player is game over.
		if( hm.scs.removeActionPoints("SHOOT") )
		{
			long timenow = System.currentTimeMillis();
			if(lastProjectile == 0 || lastProjectile < timenow) {
				lastProjectile = (timenow+Timing.bulletNext);
				projectiles.add(new Projectile( hm.heroPosX, hm.heroPosY, hm.direction, gbm ));
			}
		} else {
			String allowdActions = hm.scs.getAllowdActions();
			if(allowdActions != "")
				System.out.println("Not enough points left for the actions. You can still do the following moves:\n"+allowdActions);
			else
				gameover = true;
		}
	}
	

	public void paint(Graphics g)
	{
		if(gameover) {
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
