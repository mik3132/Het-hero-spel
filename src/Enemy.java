import java.awt.Graphics;

/**
 * 
 * Enemy class
 * The enemy class represents an enemy for the hero to take out
 * An enemy has a Position and a graphical representation
 * 
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class Enemy extends GameElement {
	
	/**
	 * Constructor method
	 * @param GameBoard gb The GameBoard for the Enemy
	 * @param Position p The position of the Enemy
	 */
	public Enemy(GameBoard gb, Position p)
	{
		super(gb, p);
	}
	
	/**
	 * Removes the Enemy from the game when it's hit
	 * @param Shot shot The shot fired
	 */
	public void hit(Shot shot)
	{
		
	}
	
	/**
	 * Paint method for the Enemy
	 * @param g
	 */
	public void paint(Graphics g)
	{
		
	}

}
