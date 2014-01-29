package model;

import java.util.ArrayList;
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
	/** The points for the game <Name, Point>*/
	public HashMap<String, Point> points;
	
	/** when one of the actions = 0 the game is won, String is action*/
	public ArrayList<String> wonTerms = new ArrayList<String>();
	/**when one of the actions = 0 the game is lost, String is action */
	public ArrayList<String> gameoverTerms = new ArrayList<String>();
	
	/** Boolean to check if the game is won */
	public boolean won = false;
	/** Boolean to check if the game is over */
	public boolean gameover = false;
	
	/**
	 * Constructor
	 * 
	 * @param int Max points of the game
	 */
	public Scores()
	{
		this.points = new HashMap<String, Point>();
	}	
	
	/**
	 * Associates the specified points with the specified action in this map. If the actionspoints previously 
	 * contained a mapping for the action, the old action is replaced. 
	 * 
	 * @param String pointName
	 * @param Point point
	 * @param int the given points for the actions
	 * @param boolean can the game go on without the points?
	 */
	public void addAction(String pointName, Point point)
	{
		points.put(pointName, point);	
	}
	
	/**
	 * 
	 * @param pointsName the name of the point
	 * @param ifAction if zero the game is won (true) or the game is lost (false)
	 */
	public void setIfAction(String pointsName, Boolean ifAction)
	{
		try {
			//Do we have any action set?
			if(points.isEmpty()) 
				throw(new Exception("No actions set in Scores->points setIfAction hashmap"));
			
			//Does the point exist?
			if(points.containsValue(pointsName))
				throw(new Exception("the Point does not exist in Scores->setIfAction String pointName. Given pointname:"+pointsName));
			
			if(ifAction)
				wonTerms.add(pointsName);
			else
				gameoverTerms.add(pointsName);
				
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Add game points to the given pointsName
	 * @param pointsName the key of points
	 * @param gamePoints the points that needs to be added
	 */
	public void addGamePoints(String pointsName, int gamePoints )
	{		
		try {
			//Do we have any action set?
			if(points.isEmpty()) 
				throw(new Exception("No actions set in Scores->points hashmap"));
			
			//Does the point exist?
			if(!points.containsKey(pointsName))
				throw(new Exception("the Point does not exist in Scores->addGamePoints String pointName"));
			
			points.get(pointsName).pointsLeft += gamePoints;
		} catch(Exception e) {
			System.out.println(e);
		}
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
			//Do we have any points set?
			if(points.isEmpty()) {
				throw(new Exception("No actions set in Scores->points hashmap"));
			}
			
			//Does the action exists in any point?
			boolean actionExist = false;			
			
			//get the current points
			for(String pointName : points.keySet())
			{
				HashMap<String, Integer> actions = points.get(pointName).actions;
				if (actions.containsKey(action)) {					
					actionExist = true; //the action does exist
					//Do i have enough points to perform this action
					if(actions.get(action) <= points.get(pointName).pointsLeft) {
						//Remove the points off
						points.get(pointName).pointsLeft -= actions.get(action);						
					}
				}
						
			}
			
			//Throw error because no action was found;
			if(!actionExist) 
				throw(new Exception("Action does not exist in Scores->points hashmap"));
			
			//check for gameover
			for(String pointName : gameoverTerms)
			{
				Point point = points.get(pointName);
				if (point.actions.containsKey(action)) {
					if(point.actions.get(action) > point.pointsLeft)				{
						gameover = true;
						return false;
					}
				}
			}
			this.setGameStatus();
			return true;
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
			if(points.isEmpty()) {
				throw(new Exception("No actions set in Scores->points hashmap"));
			}
			
			//Loop through the points hashmap
			for(String pointName : points.keySet())
			{
				HashMap<String, Integer> actions = points.get(pointName).actions;
				for(String actionName : actions.keySet())
				{
					//Do i have enough points to perform this action
					if( actions.get(actionName) <= points.get(pointName).pointsLeft)
						allowdActions += actionName + " cost " + actions.get(actionName) + " points \n";
				}
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
		//check for won
		for(String pointName : wonTerms)
		{
			Point point = points.get(pointName);
			if(point.pointsLeft <= 0) 
				won = true;			
		}
		
		//If there are no more allowed moves are left.
		if(this.getAllowdActions() == "") {
			gameover = true;
		}
	}
	
	/**
	 * reset the won, gameover, enemies and points
	 */
	public void resetScores() {
		won = false;
		gameover = false;
		for(String pointName : points.keySet())
		{
			points.get(pointName).resetPoint();
		}
	}
	
}
