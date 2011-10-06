package View;
import Model.Direction;
import Model.GameElement;
import Model.Position;


/**
 * 
 * Shot class
 * This class represents a shot fired in the game
 * A Shot has a Position, Direction and a graphical representation
 * 
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class Shot extends GameElement{
	
	/**
	 * Constructor method
	 * @param GameBoard gb The GameBoard for the shot
	 * @param Position p The Position of the shot
	 * @param Direction d The Direction of the shot
	 */
	public Shot(GameBoard gb, Position p, Direction d)
	{
		super(gb, p);
		super.setDirection(d);
	}
	
	/**
	 * Makes the shot move of the GameBoard untill and obstacle is hit
	 */
	public void fire()
	{
		
	}
	

}
