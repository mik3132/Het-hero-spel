package view;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * @author Martijn
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
	
	/**
	 * Constructor method
	 */
	public GameBoard( int width, int height)
	{
		this.width = width;
		this.height = height;
		squaresVertical = (height / squareSize);
		squaresHorizontal = (width / squareSize);
	}
	
	public void drawGrid(Graphics g)
	{
		for(int i = 1; i < this.squaresHorizontal; i++)
		{
			g.drawLine(0, (i*this.squareSize), width, (i*this.squareSize));
			g.drawLine((i*this.squareSize), 0, (i*this.squareSize), height);
		}
	}
	
	/**
	 * Getter method for the Hero of the games
	 * @return Hero The Hero object
	 */
	public Hero getHero()
	{
		return null; //new Hero(new GameBoard(), new Position(0,0), Direction.NORTH);
	}
	
	/**
	 * Getter method for the width of a GameElement
	 * @return int The width of the GameElement
	 */
	public int getElementWidth()
	{
		return 0;
	}
	
	/**
	 * Getter method for the length of a GameElement
	 * @return int The height of the GameElement
	 */
	public int getElementHeight()
	{
		return 0;
	}
	
	/**
	 * Getter method for the Enemy count
	 * @return int The number of Enemies left on the GameBoard
	 */
	public int getEnemyCount()
	{
		return 0;
	}
	
	/**
	 * Checks if the GameBoard is clear at a given Position
	 * @param Position p The Position to check the GameBoard
	 * @return boolean True if the space is occupied, False if the space is empty
	 */
	public boolean isOccupied()
	{
		return false;
	}
	
	/**
	 * Getter for the Element at a given Position 
	 * @param Position p The position to get the Element from the GameBoard
	 * @return GameElement The GameElement occupying the given Position
	 */
	public void getOccupier()
	{
		//return new GameElement(new GameBoard(), new Position(0,0));
	}
	
	/**
	 * Checks wether or not the given Position is located on the GameBoard
	 * @param Position p The Position to be checked
	 * @return boolean True if the Position is on the GameBoard, False if the Position is not on the GameBoard
	 */
	public boolean inBoard()
	{
		return true;
	}
	
	/**
	 * Gives the Point representation of the given Position
	 * @param Position p The Position to be converted into a Point
	 * @return Point The converted Position into Point
	 */
	public void toPoint( )
	{
		//return new Point();
	}

	/**
	 * Removes the given GameElement from the GameBoard
	 * @param GameElement ge The GameElement to be removed
	 */
	public void delete( )
	{
		
	}
	
	/**
	 * Adds a given GameElement to the GameBoard
	 * @param GameElement ge The GameElement to be added
	 */
	public void add( )
	{
		
	}
	
	/**
	 * Removes the number of Enemies on the GameBoard
	 * @param Enemy e The Enemy to be removed
	 */
	public void enemyRemoved(Enemy e)
	{
		
	}
}
