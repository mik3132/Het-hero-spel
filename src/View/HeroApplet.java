package View;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

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
public class HeroApplet extends Applet{
	int size = 50; //px
	int panelSize = 500; //px

	/**
	 * Constructor method
	 */
	public HeroApplet()
	{
		
	}
	
	/**
	 * StartButton....
	 * @param event
	 */
	void startButton_Action(java.awt.event.ActionEvent event)
	{
		
	}
	
	public void paint( Graphics g )
	{
		drawGrid(g);
	}
	
	public void drawGrid( Graphics g )
	{
		g.setColor( Color.black );
	    int lines = (panelSize/size);
	    for(int i = 0; i < lines; i++)
	    {
		 g.drawLine((i*size), 0, (i*size), 500);
		 g.drawLine(0, (i*size), 500, (i*size));
	    }
	}
}
