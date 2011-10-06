package model;

/**
 * Direction class
 * Class that keeps track of the directions for GameElements
 * 
 * @author edofre
 *
 */
public class Direction {

	/** Direction North */
	public static final Direction NORTH = null;
	/** Direction East */
	public static final Direction EAST = null;
	/** Direction South */
	public static final Direction SOUTH = null;
	/** Direction West */
	public static final Direction WEST = null;
	
	/**
	 * Constructor method
	 */
	private Direction()
	{

	}
	
	/**
	 * Returns the current direction
	 * @return Direction The current direction
	 */
	protected Direction getDirection()
	{
		return Direction.NORTH;
	}
	
}
