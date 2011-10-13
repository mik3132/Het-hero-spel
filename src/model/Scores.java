package model;

import java.util.HashMap;

/**
 * 
 * Scores class
 * The Scores class contains the scores of the Hero
 * 
 * @author Michael, Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class Scores
{
	/** The points that are left for the game */
	public int points;
	/** The points that where given for resetting the game */
	public int givenpoints;
	/** The lowest number of points that a action can cost */
	private int lowestCost;
	/** HashMap<String actionname, Integer how many points the action cost> */
	private HashMap<String, Integer> actionspoints;
	/** The cost of moving */
	public int movementCost = 10;
	/** The cost of shooting */
	public int shotCost = 50;
	public boolean won = false;
	public boolean gameover = false;
	public int enemies;
	
	/**
	 * Constructor
	 * 
	 * @param int Max points of the game
	 */
	public Scores(int points)
	{
		this.points = points;
		this.givenpoints = points;
		this.actionspoints = new HashMap<String, Integer>();
		this.lowestCost = points;
	}	
	
	/**
	 * Associates the specified points with the specified action in this map. If the actionspoints previously 
	 * contained a mapping for the action, the old action is replaced. 
	 * 
	 * @param String actionName The String representation of the action taken
	 * @param int points The number of points the action costs
	 */
	public void addAction(String actionName, int points)
	{
		// Add action
		actionspoints.put(actionName, points);
		
		// If the action costs the lowest, save this in lowestCost;
		if(points < lowestCost) {
			lowestCost = points;
		}
	}
	
	/**
	 * Removes the mapping for the specified action from this map if present. 
	 * 
	 * @param String actionName The string representation of the action taken
	 */
	public void removeAction(String actionName)
	{
		actionspoints.remove(actionName);
		//TODO reset the lowestCost if lowestCost is removed
	}
	
	/**
	 * Trying to do the specified action. When there are enough points it will remove the needed points
	 * and return true. Otherwise it will return false
	 * 
	 * @param String action The action to take
	 * @return Boolean True if the action was successful.
	 */
	public boolean removeActionPoints (String action) 
	{		
		try {
			//Do we have any action set?
			if(actionspoints.isEmpty()) {
				throw(new Exception("No actions set in Scores->actionspoints hashmap"));
			}
			
			//Does the action exists?
			if(!actionspoints.containsKey(action)) {
				throw(new Exception("Action does not exist in Scores->actionspoints hashmap"));
			}
			
			//Do i have enough points to perform this action
			if(actionspoints.get(action) <= points) {
				//Remove the points off
				points -= actionspoints.get(action);
				return true;
			}
			//There where not enough points, show the allowd actions
			String allowdActions = this.getAllowdActions();
			if(allowdActions != "")
				System.out.println("Not enough points left for the actions. You can still do the following moves:\n"+allowdActions);
			this.setGameStatus();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		//return false.
		return false;
	}
	
	/**
	 * Displays all actions for which the player has enough points. 
	 * 
	 * @return String of all actions for which the player has enough points. 
	 * empty String if there are no more actions available.
	 */
	public String getAllowdActions() {
		String allowdActions = "";	
		try{
			
			//Do we have any action set?
			if(actionspoints.isEmpty()) {
				throw(new Exception("No actions set in Scores->actionspoints hashmap"));
			}
			
			//Loop through the actionpoints hashmap
			for(String action : actionspoints.keySet()) {			
				//Do i have enough points to perform this action
				if(actionspoints.get(action) <= points) 
				allowdActions += action + " cost " + actionspoints.get(action) + " points \n";
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}		
		
		return allowdActions;
	}
	
	/**
	 * Checks if the game is lost or won and set the value of the 
	 * public variables boolean game and won.
	 */
	private void setGameStatus()
	{
		//if there are no more enemies left the game is won
		if(enemies <= 0)
			won = true;
		//If there are no more allowed moves are left.
		if(this.getAllowdActions() == "")
			gameover = true;
	}
	
	/**
	 * Update method
	 */
	public void update() {
		// TODO Auto-generated method stub
		
	}	
	
	/**
	 * Adds one enemy
	 */
	public void addEnemy() {
		enemies++;
	}
	
	/**
	 * Removes one enemy
	 */
	public void removeEnemy() {
		enemies--;
		this.setGameStatus();
	}
	
	/**
	 * reset the won, gameover, enemies and points
	 */
	public void resetScores() {
		won = false;
		gameover = false;
		enemies = 0;
		points = givenpoints;
	}
}
