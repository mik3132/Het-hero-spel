package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.ControlPanel;
import view.PlayPanel;

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
	HeroModel heroModel;
	GameBoardModel gbm;
	Scores scs;
	ControlPanel cp;
	PlayPanel playPanel;
	
	boolean ctrl = false;
	
	/**
	 * Constructor method
	 * @param playPanel 
	 * 
	 * @param HeroModel heroModel
	 * @param GameBoardModel gbm
	 * @param Scores scs
	 * @param ControlPanel cp
	 */
	public Input(HeroModel heroModel, GameBoardModel gbm, ControlPanel cp, PlayPanel playPanel)
	{
		this.heroModel = heroModel;
		this.gbm = gbm;
		this.scs = scs;
		this.cp = cp;
		this.playPanel = playPanel;
	}
	
	public void mouseClicked(MouseEvent arg0) { }
	public void mouseEntered(MouseEvent arg0) { }
	public void mouseExited(MouseEvent arg0) { }
	public void mousePressed(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_CONTROL)
			ctrl = true;
		if(e.getKeyCode() == 38)
			heroModel.rotateHero(HeroModel.VIEWUP, ctrl);
		if(e.getKeyCode() == 40)
			heroModel.rotateHero(HeroModel.VIEWDOWN, ctrl);
		if(e.getKeyCode() == 37)
			heroModel.rotateHero(HeroModel.VIEWLEFT, ctrl);
		if(e.getKeyCode() == 39)
			heroModel.rotateHero(HeroModel.VIEWRIGHT, ctrl);
		if(e.getKeyCode() == 32)
			playPanel.setNewProjectile();
	}
	
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_CONTROL)
			ctrl = false;
	}
	
	public void keyTyped(KeyEvent arg0) { }
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == cp.bUp) 
			heroModel.rotateHero(HeroModel.VIEWUP, true);
		if(arg0.getSource() == cp.bDown)
			heroModel.rotateHero(HeroModel.VIEWDOWN, true);
		if(arg0.getSource() == cp.bLeft)
			heroModel.rotateHero(HeroModel.VIEWLEFT, true);
		if(arg0.getSource() == cp.bRight)
			heroModel.rotateHero(HeroModel.VIEWRIGHT, true);
		if(arg0.getSource() == cp.bShoot)
			playPanel.setNewProjectile();
	}
	
}
