package model;


/**
 * Position class.
 * This class represents a position on the GameBoard
 * 
 * @author edofre
 *
 */
public class Position {
	
	/** The x coordinate of the position  */
	private int x;
	/** The y coordinate of the position */
	private int y;

	/**
	 * Constructor method
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Position(int x, int y)
	{
		x = this.x;
		y = this.y;
	}
	
	/**
	 * Getter for the x coordinate
	 * @return int The x coordinate
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Getter for the y coordinate
	 * @return int The y coordinate
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Method that returns the position of the neighbour position
	 * @param Direction direction The direction to look for a neighbour
	 * @return Position The position of the neighbour
	 */
	public Position neighbour(Direction direction)
	{
		return new Position(0,0);
	}
	
}
