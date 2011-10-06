package Model;
import View.GameBoard;


/**
 * 
 * Game class
 * The Game class builds the Game ( NOTE: GameBoard places the pieces but Game creates the GameBoard )
 * The Game class keeps track of the Game statistics
 * 
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class Game {
	
	/**
	 * Constructor method
	 */
	public Game()
	{
		new GameBoard();
	}
	
	/**
	 * Getter for the current GameBoard
	 * @return GameBoard The current GameBoard
	 */
	public GameBoard getGameBoard()
	{
		return new GameBoard();
	}
	
	/**
	 * Checks if the Game is finished
	 * @return boolean True if the Game is finished, False if the Game is still running
	 */
	public boolean isFinished()
	{
		return false;
	}
	
	/**
	 * Checks if the Hero has won the Game
	 * @return boolean True if the Hero has won, False if the Hero has Lost
	 */
	public boolean heroWon()
	{
		return false;
	}
	
	/**
	 * Checks if the Hero has lost the Game
	 * @return boolean True if the Hero has lost, False if the Hero has won
	 */
	public boolean heroLost()
	{
		return false;
	}
	
}
