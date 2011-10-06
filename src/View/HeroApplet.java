package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

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
public class HeroApplet extends JApplet implements Runnable{
	
	/** size of the grid panels */
	int size = 25;
	/** size of all the panels */
	int panelSize = 500;
	
	private GridView gridView;
	
	 /**
	 �* Constructor method
	 �*/
	public HeroApplet()
	{
		Thread t = new Thread(this);
		t.start();
	}
	
	/**
	 * Initialize method for the JApplet
	 */
	public void init()
	{
		setSize(panelSize+1, panelSize+1);
		setBackground(Color.gray);
		
		gridView = new GridView();
		Container content = getContentPane();
		content.add(gridView);
	}
	
	/**
	 * Run method for the JApplet
	 */
	public void run()
	{
		System.out.println("Running");
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
			drawGrid(g);
			drawBox(g);
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
			g.setColor(Color.green);
			g.fillRect(3,3,20,20);
		}
	}
	
}