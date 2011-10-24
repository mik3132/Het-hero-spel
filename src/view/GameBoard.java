package view;

import java.awt.Color;
import java.awt.Graphics;

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
		gbm.setSquereSize(squareSize);
	}
	
	public void drawMessages(Graphics g)
	{
		for(int i =0; i < gbm.arrpm.size(); i++)
			if(gbm.arrpm.get(i).hasStoped())
				gbm.arrpm.remove(i);
			else
				gbm.arrpm.get(i).drawMessage(g);
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
		// Draw the edge of the GameBoard
		
		// Loop through the list of object to add the object
		for(int i = 0; i < gbm.sglist.size(); i++) {
			gbm.sglist.get(i).update();
			int x = (gbm.sglist.get(i).getX() * squareSize) + calPosX; // Iets extra voor het positioneren waar de Hero is
			int y = (gbm.sglist.get(i).getY() * squareSize) + calPosY; // Iets extra voor het positioneren waar de Hero is
			gbm.sglist.get(i).drawObject(g, x, y);
		}
				
	}
	
	public void drawGameOver(Graphics g)
	{
		g.clearRect(0, 0, width, height);
		g.setColor(Color.black);
		g.drawString("Game Over", 400, 400);
	}
	
	public void drawWon(Graphics g)
	{
		g.clearRect(0, 0, width, height);
		g.setColor(Color.black);
		g.drawString("You have won!!!", 400, 400);
	}
}
