package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 
 * @author Martijn
 *
 * Hier worden input events behandeld, ook dit moet threaded zijn.
 *
 */

public class input implements KeyListener, MouseListener
{
	public void mouseClicked(MouseEvent arg0) { }
	public void mouseEntered(MouseEvent arg0) { }
	public void mouseExited(MouseEvent arg0) { }
	public void mousePressed(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }
	public void keyPressed(KeyEvent arg0) { }
	public void keyReleased(KeyEvent arg0) { }
	public void keyTyped(KeyEvent arg0) { }
}
