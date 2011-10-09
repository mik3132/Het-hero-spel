package view;

import java.awt.Color;
import java.awt.Graphics;

import model.EnemyModel;

/**
 * 
 * @author Martijn
 *
 * Circeltje rood ofzo als vijand
 *
 */
public class Enemy extends EnemyModel
{
	int x, y, direction;

	Enemy(int x, int y, Graphics g)
	{
		super(x,y);
		this.x = x;
		this.y = y;
		this.drawEnemy(g);
	}

	public void drawEnemy( Graphics g )
	{
		g.setColor(Color.RED);
		g.drawOval(x, y, GameBoard.squareSize, GameBoard.squareSize);
		g.fillOval(x, y, GameBoard.squareSize, GameBoard.squareSize);
		g.setColor(Color.BLACK);
		//g.drawLine(hm.midX, hm.midY, hm.viewX, hm.viewY);
	}
}
