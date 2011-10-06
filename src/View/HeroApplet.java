package view;

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
	
	 /**
	 * Constructor method
	 */
	public HeroApplet()
	{
	    setTitle("HeroGame");
	    setSize(600,600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu gameMenu = new JMenu("Game");
        JMenu settingsMenu = new JMenu("Settings");
        menuBar.add(gameMenu);
        menuBar.add(settingsMenu);
        
        JMenuItem startAction = new JMenuItem("Start");
        JMenuItem pauzeAction = new JMenuItem("Pauze");
        JMenuItem exitAction = new JMenuItem("Exit");
        
        JMenuItem difficultyAction = new JMenuItem("Difficulty");
        JMenuItem soundAction = new JMenuItem("Sound");
        JMenuItem mapAction = new JMenuItem("Map");
        
        JLabel scoreLabel = new JLabel("Score: ", JLabel.CENTER);
        
        gameMenu.add(startAction);
        gameMenu.add(pauzeAction);
        gameMenu.add(exitAction);
        
        settingsMenu.add(difficultyAction);
        settingsMenu.add(soundAction);
        settingsMenu.add(mapAction);
        
        exitAction.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
	    
	    // The actual grid
	    gridView = new GridView();
		
		JPanel content = new JPanel();
        content.setLayout(new BorderLayout(1,1));

        content.add(scoreLabel , BorderLayout.SOUTH);
        content.add(gridView, BorderLayout.CENTER);
		
		setContentPane(content);

		setVisible(true);
	}
	
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