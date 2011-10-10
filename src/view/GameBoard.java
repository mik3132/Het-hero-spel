package view;

import java.awt.Graphics;
import java.util.ArrayList;

import model.GameBoardModel;

/**
 *
 * Waar alle grond titels gevuld zijn, doorloop GrondModel met SquareGrid
 * 
 * GameBoard class
 * This class represents the GameBoard that is being played on
 * The GameBoard manages the GameElements and knows where they are positioned
 * The GameBoard places all the GameElements on the board at the beginning
 *
 *
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class GameBoard
{
	int width, height;
	public static final int squareSize = 50;
	int squaresVertical;
	int squaresHorizontal;
	GameBoardModel gbm;
	ArrayList<Enemy> arEnemy = new ArrayList<Enemy>();
	
	public static final int EMPTY = 0;
	public static final int WALL = 1;
	public static final int ENEMY = 2; 
	
	/**
	 * Constructor method
	 */
	public GameBoard( int width, int height, GameBoardModel gbm)
	{
		this.gbm = gbm;
		this.width = width;
		this.height = height;
		squaresVertical = (height / squareSize); //y
		squaresHorizontal = (width / squareSize); //x
	}
	
	public void drawGrid(Graphics g)
	{
		for(int i = 1; i < this.squaresHorizontal; i++)
		{
			g.drawLine(0, (i*GameBoard.squareSize), width, (i*GameBoard.squareSize));
			g.drawLine((i*GameBoard.squareSize), 0, (i*GameBoard.squareSize), height);
		}
	}
	
	public void drawGameBoard(Graphics g)
	{
		int calPosX = (((width/2)-(squareSize/2)) - (gbm.getHeroModel().heroPosX * squareSize));
		int calPosY = (((height/2)-(squareSize/2)) - (gbm.getHeroModel().heroPosY * squareSize));
		for(int i = 0; i < gbm.sglist.size(); i++)
		{
			int x = (gbm.sglist.get(i).x * squareSize) + calPosX; // Iets extra voor het positioneren waar de Hero is
			int y = (gbm.sglist.get(i).y * squareSize) + calPosY; // Iets extra voor het positioneren waar de Hero is
			this.drawObject( g, gbm.sglist.get(i).item, x, y );
		}
	}

	private void drawObject(Graphics g, int command, int x, int y)
	{
		switch(command)
		{
			case GameBoard.EMPTY:
			break;
			case GameBoard.ENEMY:
				arEnemy.add( new Enemy(x, y, g) );
			break;
			case GameBoard.WALL:
				new Wall(x, y).drawWall(g);
			break;
		}
	}
}
