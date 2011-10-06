package View;
import Model.GameElement;
import Model.Position;


/**
 * Wall class
 * This class represents a wall object in the game
 * A wall has a Position and a graphical representation
 * 
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class Wall extends GameElement {

	/**
	 * Constructor method
	 * @param GameBoard gb The GameBoard for the Wall 
	 * @param Position p The Position of the Wall
	 */
	public Wall(GameBoard gb, Position p)
	{
		super(gb, p);
	}
	
}
