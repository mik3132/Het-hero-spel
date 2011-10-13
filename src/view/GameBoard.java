package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import model.GameBoardModel;

/**
 *
 * GameBoard class
 * This class represents the GameBoard that is being played on
 * The GameBoard manages the GameElements and knows where they are positioned
 * The GameBoard places all the GameElements on the board at the beginning
 *
 * @author Edo, Martijn
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class GameBoard
{
	/** The width and height of the GameBoard */
	int width, height;
	/** The number of squares vertical and horizontal */
	int squaresVertical,  squaresHorizontal;
	/** The GameBoardModel */
	GameBoardModel gbm;
	/** The ArrayList containing the enemies */
	ArrayList<Enemy> arEnemy = new ArrayList<Enemy>();
	
	/** The size of the squares */
	public static final int squareSize = 50;
	/** Integer representation for an empty spot */
	public static final int EMPTY = 0;
	/** Integer representation for a wall */
	public static final int WALL = 1;
	/** Integer representation for an enemy */
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
	
	/**
	 * Method that draws the grid
	 * 
	 * @param Graphics g The Graphic manager to execute the drawing
	 */
	public void drawGrid(Graphics g)
	{
		for(int i = 1; i <= this.squaresHorizontal; i++) {
			g.drawLine(0, (i*GameBoard.squareSize), width, (i*GameBoard.squareSize));
			g.drawLine((i*GameBoard.squareSize), 0, (i*GameBoard.squareSize), height);
		}
	}
	
	/**
	 * Method that draws the GameBoard
	 * 
	 * @param Graphics g The Graphic manager to execute the drawing
	 */
	public void drawGameBoard(Graphics g)
	{
		// Calculate the x position based on the hero's movement
		int calPosX = (((width/2)-(squareSize/2)) - (gbm.getHeroModel().heroPosX * squareSize));
		// Calculate the y position based on the hero's movement
		int calPosY = (((height/2)-(squareSize/2)) - (gbm.getHeroModel().heroPosY * squareSize));
		
		// Loop through the list of object to add the object
		for(int i = 0; i < gbm.sglist.size(); i++)
		{
			int x = (gbm.sglist.get(i).x * squareSize) + calPosX; // Iets extra voor het positioneren waar de Hero is
			int y = (gbm.sglist.get(i).y * squareSize) + calPosY; // Iets extra voor het positioneren waar de Hero is
			this.drawObject( g, gbm.sglist.get(i).item, x, y );
		}
		
		// Draw the edge of the GameBoard
		this.drawGameBoardEdge(calPosX, calPosY, g);		
	}
	
	public void drawGameOver(Graphics g)
	{
		g.setColor(Color.black);
		g.drawString("Game Over", 400, 400);
	}
	
	/**
	 * Method that draws the edge around the GameBoard
	 * 
	 * @param int posX The x position calculated based on the hero's movement
	 * @param int posY The y position calculated based on the hero's movement
	 * @param Graphics g The Graphic manager to execute the drawing
	 */
	private void drawGameBoardEdge(int posX, int posY, Graphics g)
	{
		// Draw the horizontal edges
		for(int i=0; i <= gbm.sizePlayGroundX; i++) {
			// Upper border
			new Wall(posX + (i * squareSize), posY).drawWall(g);
			// Lower border
			new Wall(posX + (i * squareSize), posY + (gbm.sizePlayGroundY * squareSize) + squareSize).drawWall(g);
		}
		
		// Draw the vertical edges
		for(int i=0; i <= gbm.sizePlayGroundY; i++) {
			// Left border
			new Wall(posX, posY + (i * squareSize)).drawWall(g);
			// Right border
			new Wall(posX + (gbm.sizePlayGroundX * squareSize) + squareSize, posY + (i * squareSize)).drawWall(g);
		}
		
		// Draw the right lower corner wall
		new Wall(posX + ( gbm.sizePlayGroundX * squareSize ) + squareSize , posY + (gbm.sizePlayGroundY * squareSize) + squareSize).drawWall(g);
	}

	/**
	 * Method that draws the empty spaces, enemies and walls on the GameBoard
	 * 
	 * @param Grahpics g The Graphic manager to execute the drawing
	 * @param int object The object to be added
	 * @param int x The x position for the object
	 * @param int y The y position for the object
	 */
	private void drawObject(Graphics g, int object, int x, int y)
	{
		switch(object)
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
