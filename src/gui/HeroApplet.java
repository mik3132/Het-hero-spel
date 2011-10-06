package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * HeroApplet class
 * This class is the graphical representation of the game
 * 
 * @author edofre
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class HeroApplet extends JFrame {
	
	/** size of the grid panels */
	int size = 25;
	/** size of all the panels */
	int panelSize = 500;
	/** the grid */
	private GridView gridView;
	/** Menu bar */
	private JMenuBar menuBar;
	/** Menus */
	private JMenu gameMenu, settingsMenu;
	/** Menu items */
	public static JMenuItem startAction, pauzeAction, exitAction, difficultyAction, soundAction, mapAction;
	/** Labels */
	private JLabel scoreLabel;
	
	 /**
	 * Constructor method
	 */
	public HeroApplet()
	{
	    setTitle("HeroGame");
	    setSize(600,600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    
	    // Create menu bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // Create menus
        gameMenu = new JMenu("Game");
        settingsMenu = new JMenu("Settings");
        
        // Add menus to menu bar
        menuBar.add(gameMenu);
        menuBar.add(settingsMenu);
        
        // Create menu items
        startAction = new JMenuItem("Start");
        pauzeAction = new JMenuItem("Pauze");
        exitAction = new JMenuItem("Exit");
        difficultyAction = new JMenuItem("Difficulty");
        soundAction = new JMenuItem("Sound");
        mapAction = new JMenuItem("Map");
        
        // add menu items to menu
        gameMenu.add(startAction);
        gameMenu.add(pauzeAction);
        gameMenu.add(exitAction);
        settingsMenu.add(difficultyAction);
        settingsMenu.add(soundAction);
        settingsMenu.add(mapAction);
        
        // create the action listeners for the menu items
        buildActionListeners();
        
        // Add score label
        scoreLabel = new JLabel("Score: ", JLabel.CENTER);
        
	    // The actual grid
	    gridView = new GridView();
		
	    // Create the content panel
		JPanel content = new JPanel();
        content.setLayout(new BorderLayout(1,1));

        // Add all the items to the panel
        content.add(scoreLabel , BorderLayout.SOUTH);
        content.add(gridView, BorderLayout.CENTER);
		setContentPane(content);

		setVisible(true);
	}
	
	/**
	 * Method that creates the action listeners for the menu 
	 */
	public static void buildActionListeners()
	{
		// start 
		startAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Start game");
			}
		});
		
		// pauze
		pauzeAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Pauze game");
			}
		});

		// exit
		exitAction.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
		
		// sound 
		soundAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Toggle sound on/off");
			}
		});
		
		// map
		mapAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Change map");
			}
		});
		
		// difficulty
		difficultyAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Change difficulty");
			}
		});
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String args[])
	{
		new HeroApplet();
	}
	
	/**
	 * Gridview class inside a panel to draw the grid 
	 * @author edofre
	 *
	 */
	private class GridView extends JPanel
	{
		/**
		 * Constructor method for GridView
		 */
		public GridView()
		{
			
		}
		
		/**
		 * Method for painting the grid
		 */
		public void paint( Graphics g )
		{
			drawBox(g);
			drawGrid(g);
		}
		 
		/**
		 * Drawing of the grid 
		 * @param Graphics g
		 */
		public void drawGrid( Graphics g )
		{
			g.setColor( Color.black );
			int lines = (panelSize/size);
			
			for(int i = 0; i <= lines; i++)
			{
				g.drawLine((i*size), 0, (i*size), panelSize);
				g.drawLine(0, (i*size), panelSize, (i*size));
			}
		}
		
		/**
		 * Drawing of the rectangle
		 * @param g
		 */
		public void drawBox(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,panelSize,panelSize);
			
			// Testpanel
			g.setColor(Color.red);
			g.fillRect(3,3,20,20);
		}
	}
	
}