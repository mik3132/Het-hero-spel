package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.ControlPanel;

import model.GameBoardModel;
import model.HeroModel;
import model.Scores;

/**
 * 
 * Input class
 * 
 * This class handles all the user input 
 * 
 * @author Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class Input implements KeyListener, MouseListener, ActionListener
{
	/** The HeroModel that represents the hero */
	HeroModel heroModel;
	/** The GameBoardModel that represents the gameboard */
	GameBoardModel gbm;
	/** The Scores model to keep track of the score */
	Scores scs;
	/** The ControlPanel that contains the control */
	ControlPanel cp;
	
	/**
	 * Constructor method
	 * 
	 * @param HeroModel heroModel
	 * @param GameBoardModel gbm
	 * @param Scores scs
	 * @param ControlPanel cp
	 */
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
		cp.spacer.insert("KeyPressed key:"+e.getKeyCode() + " name:" + KeyEvent.getKeyText( e.getKeyCode() ) + "\n\r", 0);
		if(e.getKeyCode() == 38)
			heroModel.rotateHero(HeroModel.VIEWUP);
		if(e.getKeyCode() == 40)
			heroModel.rotateHero(HeroModel.VIEWDOWN);
		if(e.getKeyCode() == 37)
			heroModel.rotateHero(HeroModel.VIEWLEFT);
		if(e.getKeyCode() == 39)
			heroModel.rotateHero(HeroModel.VIEWRIGHT);
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void keyTyped(KeyEvent arg0) { }
	
	public void actionPerformed(ActionEvent arg0) {}
	
}
