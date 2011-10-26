package model;

import java.awt.BorderLayout;
import javax.swing.*;

import controller.Input;

import view.*;

/**
 *
 * Main class
 * The main class controls all the other classes, hence the name main class.
 * This class also contains a threadpool for executing the application
 *
 * @author TeamX
 * @version 0.1
 * @date 09-10-2011
 * 
 */
public class Main extends JFrame implements Runnable 
{
	/** The PlayPanel that shows the GameBoard */
	PlayPanel playPanel;
	/** The ControlPanel that shows the buttons and scores */
	ControlPanel controlPanel;
	/** The GameBoardModel that manages all the objects */
	GameBoardModel gbm;
	/** The Input manager for controlling user input */
	Input in;
	/** The HeroModel representing the Hero */
	HeroModel heroModel;

	/** boolean that checks if the application is running */
	boolean run = true;

	/**
	 * Constructor
	 */
	Main()
	{
		// Create models
		heroModel = new HeroModel( PlayPanel.width, PlayPanel.height, 1000 );
		gbm = new GameBoardModel( heroModel );
		
		// Create views
		controlPanel = new ControlPanel(heroModel);
		playPanel = new PlayPanel( gbm, heroModel);
		gbm.setPlayPanel( playPanel );
		
		// Create controller
		in = new Input( heroModel, gbm, controlPanel, playPanel );
		controlPanel.setInput(in); //SetActionListners
		
		// Standard setters for a JFrame
		this.setTitle("Het hero spel");
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.EAST, controlPanel);
		this.add(BorderLayout.CENTER, playPanel);
		
		// Standard setters for JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1124, 880);
		this.setResizable(false);
		this.addKeyListener(in);
		this.setVisible(true);
	}

	/**
	 * Method that updates the Scores and GameBoardModel
	 */
	private void update()
	{
		// Update the control panel
		controlPanel.update();
		// Update the GameBoardModel
		gbm.update();
		playPanel.update();
	}
	
	/**
	 * Standard main function for executing the application
	 * 
	 * @param String[] args
	 */
	public static void main(String[] args)
	{
		Thread main = new Thread(new Main());
		main.start();
	}

	/**
	 * The run method
	 */
	@Override
	public void run()
	{
		while(run) {
			this.update();
			controlPanel.repaint();
			playPanel.repaint();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
