package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

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
	Input in;
	Hero hero;
	Wall wall;
	public static int width = 850, height = 850; //px
	
	public PlayPanel( GameBoardModel gbm, HeroModel hm)
	{
		this.gb = new GameBoard( width, height );
		this.hero = new Hero( hm );
		this.wall = new Wall();

		this.setSize(width, height);
		this.setBackground( Color.white );
		this.setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		gb.drawGrid(g);
		hero.drawHero(g);
		wall.drawWallHorizontal(g);
		wall.drawWallCorner(g);
		wall.drawWallVertical(g);
	}
	
}
