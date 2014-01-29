package model;

import java.util.HashMap;

public class Point {
	public String name;
	/* The actions and what the action cost */
	public HashMap<String, Integer> actions;
	public int pointsLeft;
	public int givenPoints;
	
	/**
	 * Constructor
	 */
	public Point(String name, HashMap<String, Integer> actions, int givenPoints) {
		this.name = name;
		this.actions = actions;
		this.pointsLeft = givenPoints;
		this.givenPoints = givenPoints;		
	}
	
	/**
	 * reset the points left to givenPoints
	 */
	public void resetPoint()
	{
		this.pointsLeft = this.givenPoints;
	}

}
