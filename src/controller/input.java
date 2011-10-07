package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import view.ControlPanel;

import model.GameBoardModel;
import model.HeroModel;
import model.Scores;

/**
 * 
 * @author Martijn
 *
 * Hier worden input events behandeld, ook dit moet threaded zijn.
 *
 */

public class Input implements KeyListener, MouseListener, ActionListener
{
	HeroModel heroModel;
	GameBoardModel gbm;
	Scores scs;
	ControlPanel cp;
	
	public Input(HeroModel heroModel, GameBoardModel gbm, Scores scs, ControlPanel cp)
	{
		this.heroModel = heroModel;
		this.gbm = gbm;
		this.scs = scs;
		this.cp = cp;
	}
	
	public void mouseClicked(MouseEvent arg0) { }
	public void mouseEntered(MouseEvent arg0) { }
	public void mouseExited(MouseEvent arg0) { }
	public void mousePressed(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }
	
	public void keyPressed(KeyEvent e)
	{
		cp.spacer.insert("KeyPressed key:"+e.getKeyCode() + " name:" + e.getKeyText( e.getKeyCode() ) + "\n\r", 0);
		if(e.getKeyCode() == 38)
			heroModel.rotateHero(heroModel.MOVEUP);
		if(e.getKeyCode() == 40)
			heroModel.rotateHero(heroModel.MOVEDOWN);
		if(e.getKeyCode() == 37)
			heroModel.rotateHero(heroModel.MOVELEFT);
		if(e.getKeyCode() == 39)
			heroModel.rotateHero(heroModel.MOVERIGHT);
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void keyTyped(KeyEvent arg0) { }
	
	public void actionPerformed(ActionEvent arg0) {}
	
}
