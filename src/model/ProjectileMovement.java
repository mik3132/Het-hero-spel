package model;

/**
 * 
 * ProjectileMovement class
 * This class contains the movement of the projectile
 * 
 * @author Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class ProjectileMovement
{
	/** The time the projectile travels */
	public long time;
	/** The x and y coordinates of the projectile */
	public int x, y;
	
	/**
	 * Constructor
	 * 
	 * @param int x The x coordinate of the projectile
	 * @param int y The y coordinate of the projectile
	 * @param long time The time a projectile travels
	 */
	public ProjectileMovement( int x, int y, long time)
	{
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
