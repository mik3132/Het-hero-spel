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
		
		// add action to Scores
		hm.scs.addAction("SHOOT", hm.scs.shotCost);
	}
	
	public void setNewProjectile()
	{
		if( hm.scs.removeActionPoints("SHOOT") )
		{
			long timenow = System.currentTimeMillis();
			if(lastProjectile == 0 || lastProjectile < timenow)
			{
				lastProjectile = (timenow+Timing.bulletNext);
				projectiles.add(new Projectile( hm.heroPosX, hm.heroPosY, hm.direction, gbm ));
			}
		} else {
			System.out.println("game over?");
		}
	}
	

	public void paint(Graphics g)
	{
		super.paint(g);
		gb.drawGrid(g); //Laat Grid zien
		gb.drawGameBoard(g);
		hero.drawHero(g);
		for(int i = 0; i < projectiles.size(); i++)
			projectiles.get(i).rePaint( g );
	}
	
}
