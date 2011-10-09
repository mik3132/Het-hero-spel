package model;

/**
 * 
 * @author Martijn
 *
 * Data van het grid per square, opslag van een wall of grond of enemy of player 
 *
 */
public class SquareGrid 
{
	public int x,y;
	public String item;
	
	public SquareGrid(int X, int Y, String command)
	{
		this.x = X;
		this.y = Y;
		this.item = command;
	}
}
