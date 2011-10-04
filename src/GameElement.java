
/**
 * GameElement class
 * The GameElement class represents elements in the game that are on the board
 * GameElements have a position, graphical representation and an optional direction
 * 
 * @author edofre
 *
 */
public class GameElement extends Canvas{

	/** The width of the GameElement */
	private int width;
	/** The height of the GameElement */
	private int height; 
	
	/**
	 * Constructor method
	 * @param GameBoard gb The GameBoard being played on
	 * @param Position p The Position of the GameElement
	 */
	public GameElement(GameBoard gb, Position p)
	{
		
	}
	
	/**
	 * Getter for the width of the GameElement
	 * @return int The width of the GameElement
	 */
	protected int getWidth()
	{
		return width;
	}
	
	/**
	 * Getter for the height of the GameElement
	 * @return int The height of the GameElement
	 */
	protected int getHeight()
	{
		return height;
	}
	
	/**
	 * Getter for the direction of the GameElement
	 * @return Direction The Direction of the GameElement
	 */
	protected Direction getDirection()
	{
		return Direction.EAST;
	}
	
	/**
	 * Getter for the GameBoard 
	 * @return GameBoard The current GameBoard
	 */
	protected GameBoard getGameBoard()
	{
		return new GameBoard();
	}
	
	/**
	 * Getter for the position of the GameElement
	 * @return Position The position of the GameElement
	 */
	public Position getPosition()
	{
		return new Position(0,0);
	}
	
	/**
	 * Setter for the Direction of the GameElement
	 * @param Direction d The direction of the GameElement
	 */
	protected void setDirection(Direction d)
	{
		
	}
	
	/**
	 * Setter for the Position of the GameElement
	 * @param Positon p The position of the the GameElement
	 */
	public void setPosition(Position p)
	{
		
	}
	
	/**
	 * Removes the GameElement from the game if it's hit
	 * @param Shot shot The shot that is fired
	 */
	public void hit(Shot shot)
	{
		
	}
}
