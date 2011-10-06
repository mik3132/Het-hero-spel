package View;
import Model.Direction;
import Model.Position;


/**
 * 
 * Hero class
 * This class represent the protagonist of the game
 * A Hero is an Actor with a score 
 * 
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class Hero extends Actor{
	
	/**
	 * Constructor method
	 * @param GameBoard gb The GameBoard that is played on
	 * @param Position p The Position of the Hero 
	 * @param Direction d The Direction of the Hero
	 */
	public Hero(GameBoard gb, Position p, Direction d)
	{
		super(gb, p, d);
	}
	
	/**
	 * Getter for the points 
	 * @return int The points the Hero has collected
	 */
	public int getPoints()
	{
		return 0;
	}
	
	/**
	 * Checks wether or not the Hero has enough points to shoot
	 * @return
	 */
	public boolean canShoot()
	{
		return true;
	}
	
	/**
	 * Makes the Hero step into a Direction
	 * @param Direction d The direction to be stepped into
	 */
	public void step(Direction d)
	{
		
	}
	
	/**
	 * Makes the Hero shoot his gun
	 */
	public void shoot()
	{

	}

}
