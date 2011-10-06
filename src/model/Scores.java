package model;

import java.util.HashMap;

/**
 * 
 * @author Martijn
 *
 * Score data bij houden
 *
 */
public class Scores {
	public int points; //The points that are left for the game.	
	private int lowestCost; //the lowest number of points that a action can cost
	private HashMap<String, Integer> actionspoints; //HashMap<String actionname, Integer how many points the action cost>
	
	/**
	 * Score constructor
	 * @param max points of the game
	 */
	public Scores() //int points
	{
		this.points = points;
		this.actionspoints = new HashMap<String, Integer>();
		this.lowestCost = points;
	}	
	
	/**
	 * Associates the specified points with the specified action in this map. If the actionspoints previously 
	 * contained a mapping for the action, the old action is replaced. 
	 * @param actionname
	 * @param points
	 */
	public void addAction(String actionname, int points)
	{
		//add action
		actionspoints.put(actionname, points);
		//if the action costs the lowest, save this in lowestCost;
		if(points < lowestCost)
			lowestCost = points;
	}
	
	/**
	 * Removes the mapping for the specified action from this map if present. 
	 * @param actionname
	 */
	public void removeAction(String actionname)
	{
		actionspoints.remove(actionname);
		//TODO reset the lowestCost if lowestCost is removed
	}
	
	/**
	 * Trying to do the specified action. When there are enough points it will remove the needed points
	 * and return true. Otherwise it will return false
	 * @param action
	 * @return true if the action was succeeded.
	 */
	public boolean removeActionPoints (String action) 
	{		
		try {
			//Do we have any action set?
			if(actionspoints.isEmpty())
				throw(new Exception("No actions set in Scores->actionspoints hashmap"));
			
			//Does the action exists?
			if(!actionspoints.containsKey(action))
				throw(new Exception("Action does not exist in Scores->actionspoints hashmap"));
			
			//Do i have enough points to perform this action
			if(actionspoints.get(action) >= points) {
				//Remove the points off
				points -= actionspoints.get(action);
				return true;
			}			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		//There where not enough points, return false.
		return false;
	}
	
	/**
	 * Displays all actions for which the player has enough points. 
	 * @return String of all actions for which the player has enough points. 
	 * empty String if there are no more actions available.
	 */
	public String getAllowdActions() {
		String allowdActions = "";	
		
		try{
			//Do we have any action set?
			if(actionspoints.isEmpty())
				throw(new Exception("No actions set in Scores->actionspoints hashmap"));
			//Loop through the actionpoints hashmap
			for(String action : actionspoints.keySet())
			{			
				//Do i have enough points to perform this action
				if(actionspoints.get(action) >= points) 
				allowdActions += action + " cost " + actionspoints.get(action) + " points \n";
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}		
		
		return allowdActions;
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}	
}
