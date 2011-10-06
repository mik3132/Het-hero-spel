package view;

import java.awt.Color;
import java.awt.Graphics;

import model.HeroModel;

/**
 * 
 * @author Martijn
 *
 * Hero class
 * This class represent the protagonist of the game
 * A Hero is an Actor with a score 
 * 
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 * 
 */
public class Hero 
{
	HeroModel hm;

	Hero(HeroModel hm)
	{
		this.hm = hm;
	}

	public void drawHero( Graphics g )
	{
		g.setColor(Color.GREEN);
		g.drawOval(hm.x, hm.y, hm.ovalSize, hm.ovalSize);
		g.fillOval(hm.x, hm.y, hm.ovalSize, hm.ovalSize);
		g.setColor(Color.BLACK);
		g.drawLine(hm.midX, hm.midY, hm.viewX, hm.viewY);
	}
}