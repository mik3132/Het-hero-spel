package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
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
	
	//Create buttons
	private JButton bUp = new JButton("∧");
	private JButton bDown = new JButton("∨");
	private JButton bLeft = new JButton("<");
	private JButton bRight = new JButton(">");
	private JButton bShoot = new JButton("*");
	
	public Input(HeroModel heroModel, GameBoardModel gbm, Scores scs, ControlPanel cp)
	{
		this.heroModel = heroModel;
		this.gbm = gbm;
		this.scs = scs;
		this.cp = cp;
	
		//Add buttons to actionListener
		bUp.addActionListener(this);
		bDown.addActionListener(this);
		bLeft.addActionListener(this);
		bRight.addActionListener(this);
		bShoot.addActionListener(this);
		
		//add Buttons to JPanel
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		
		//unfocus buttons
		bUp.setFocusable(false);
		bDown.setFocusable(false);
		bLeft.setFocusable(false);
		bRight.setFocusable(false);
		bShoot.setFocusable(false);

		buttons.add(BorderLayout.NORTH, bUp);
		buttons.add(BorderLayout.SOUTH, bDown);
		buttons.add(BorderLayout.EAST, bRight);
		buttons.add(BorderLayout.WEST, bLeft);
		buttons.add(BorderLayout.CENTER, bShoot);
		
		cp.add(BorderLayout.SOUTH, buttons);
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
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == bUp) 
			heroModel.rotateHero(HeroModel.VIEWUP);
		if(arg0.getSource() == bDown)
			heroModel.rotateHero(HeroModel.VIEWDOWN);
		if(arg0.getSource() == bLeft)
			heroModel.rotateHero(HeroModel.VIEWLEFT);
		if(arg0.getSource() == bRight)
			heroModel.rotateHero(HeroModel.VIEWRIGHT);
	}
	
}
