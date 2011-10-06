package View;

import java.awt.Color;
import java.awt.Graphics;

import Model.Direction;
import Model.GameElement;
import Model.Position;

/**
 * Actor class
 * This class represents GameElements that are able to move and shoot
 * 
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class Actor extends GameElement{

	/** The color the actor is */
	protected Color characterColor;
	/** The color of the gunfire */
	protected Color fireColor = Color.black;
	
	/**
	 * Constructor method
	 * @param GameBoard gb The GameBoard currently playing on
	 * @param Position p The position of the actor
	 * @param Direction d The direction of the actor
	 */
	public Actor(GameBoard gb, Position p, Direction d)
	{
		super(gb, p);
		super.setDirection(d);
	}
	
	/**
	 * Actor takes a step in given direction
	 * @param Direction d The direction to step in
	 */
	public void step(Direction d)
	{
		
	}
	
	/**
	 * Actor fires his gun
	 */
	public void shoot()
	{
		
	}
	
	/**
	 * Paint method
	 * @param Graphics g 
	 */
	public void paint(Graphics g)
	{
		
	}
	
}
