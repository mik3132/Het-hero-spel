package view;

import java.awt.Color;
import java.awt.Graphics;

import model.HeroModel;
import model.SquareGrid;

/**
 * 
 * Hero class
 * This class represent the protagonist of the game
 * A Hero is an Actor with a score 
 * 
 * @author Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 * 
 */
public class Hero implements SquareGrid
{
	/** The HeroModel containing all the Hero data */
	HeroModel hm;

	/**
	 * Constructor
	 * 
	 * @param HeroModel hm The HeroModel containing the data
	 */
	Hero(HeroModel hm)
	{
		this.hm = hm;
	}

	/**
	 * The drawing method for the Hero
	 * 
	 * @param Graphics g The graphics manager
	 */
	public void drawHero( Graphics g )
	{
		g.setColor(Color.GREEN);
		g.drawOval(hm.x, hm.y, hm.ovalSize, hm.ovalSize);
		g.fillOval(hm.x, hm.y, hm.ovalSize, hm.ovalSize);
		g.setColor(Color.BLACK);
		g.drawLine(hm.midX, hm.midY, hm.viewX, hm.viewY);
	}

	public void drawObject(Graphics g, int newX, int newY)
	{
		g.setColor(Color.GREEN);
		g.drawOval(hm.x, hm.y, hm.ovalSize, hm.ovalSize);
		g.fillOval(hm.x, hm.y, hm.ovalSize, hm.ovalSize);
		g.setColor(Color.BLACK);
		g.drawLine(hm.midX, hm.midY, hm.viewX, hm.viewY);
	}

	public int getX()
	{
		return hm.x;
	}

	public int getY()
	{
		return hm.y;
	}

	@Override
	public boolean isBlocking()
	{
		return true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}