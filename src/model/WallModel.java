package model;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 * 
 * @author Martijn
 *
 * Zoals je ziet extends BlockingObject met img kun je bepalen hoe hij eruit ziet.
 * De img return je in de viewklase.
 *
 */
public class WallModel extends BlockingObject 
{
	Image img;
	WallModel()
	{
		  URL url = this.getClass().getResource("anImage.gif");
		  img = Toolkit.getDefaultToolkit().getImage(url); 
	}
	
	public Image getImage()
	{
		return img;
	}
}
