package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Input;

import model.GameBoardModel;
import model.HeroModel;

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
	public ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public final static int width = 850, height = 850; //px
	
	public PlayPanel( GameBoardModel gbm, HeroModel hm)
	{
		this.gbm = gbm;
		this.gb = new GameBoard( width, height, gbm );
		this.hero = new Hero( hm );
		this.hm = hm;
		this.setSize(width, height);
		this.setBackground( Color.white );
		this.setVisible(true);
	}
	
	public void setNewProjectile()
	{
		projectiles.add(new Projectile( hm.heroPosX, hm.heroPosY, hm.direction, gbm ));
	}
	

	public void paint(Graphics g)
	{
		super.paint(g);
		//gb.drawGrid(g); //Laat Grid zien
		gb.drawGameBoard(g);
		hero.drawHero(g);
		for(int i = 0; i < projectiles.size(); i++)
			projectiles.get(i).rePaint( g );
	}
	
}
