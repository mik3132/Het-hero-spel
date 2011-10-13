package model;

/**
*
* SquareGrid class
* This class represents an Enemy, Wall or Empty spot on the GameBoard
*
* @author Martijn, Edo
* @version 0.1
* @date 04-10-2011
*
*/
public class SquareGrid 
{
	/** Integers for the position of the SquareGrid */
	public int x,y;
	/** Integer to indicate what kind of object it is */
	public int item;
	/** Boolean whether or not the object will block */
	public boolean isBlocking;
	
	/**
	 * Constructor
	 * 
	 * @param int X The x position of the SquareGrid
	 * @param int Y The y position of the SquareGrid
	 * @param int type The type of SquareGrid
	 * @param boolean isBlocking True if the SquareGrid will block, False if it will not
	 */
	public SquareGrid(int x, int y, int type, boolean isBlocking)
	{
		this.x = x;
		this.y = y;
		this.item = type;
		this.isBlocking = isBlocking;
	}
}
