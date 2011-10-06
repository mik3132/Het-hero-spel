import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

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
	
	int size = 25; //px
	int panelSize = 500; //px
	
	private GridView gridView;
	
	 /**
	 Ê* Constructor method
	 Ê*/
	public HeroApplet()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Herogame");
		
		frame.setSize(750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gridView = new GridView();
		frame.add(gridView);
		
		frame.setVisible(true);
	}
	
	public void init()
	{

	}
	
	@Override
	public void run() {
	}
	
	/**
	 * Gridview class inside a panel to draw the grid 
	 * @author edofre
	 *
	 */
	private class GridView extends JPanel
	{
		public GridView()
		{
			
		}
		
		public void paint( Graphics g )
		{
			drawGrid(g);
			drawBox(g);
		}
		 
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
		
		public void drawBox(Graphics g)
		{
			g.setColor(Color.green);
			g.fillRect(3,3,20,20);
		}
	}
	
}