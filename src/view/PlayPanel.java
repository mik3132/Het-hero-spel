package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.GameBoardModel;

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
	Hero hero;
	int width = 850, height = 850; //px
	public PlayPanel(GameBoardModel gbm)
	{
		this.gb = new GameBoard( width, height );
		this.hero = new Hero( width, height, gb );
		this.setSize(width, height);
		this.setBackground( Color.white );
		this.setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		gb.drawGrid(g);
		hero.drawHero(g);
	}
	
}
