package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.Input;

import model.Scores;

/**
 * 
 * @author Martijn
 *
 * Knoppen & scores
 *
 */
public class ControlPanel extends JPanel
{
	public JTextArea spacer;
	public JButton bUp,bDown,bLeft,bRight,bShoot;
	
	public ControlPanel( Scores scs )
	{
		bUp = new JButton("UP");
		bDown = new JButton( "DOWN" );
		bLeft = new JButton("LEFT");
		bRight = new JButton("RIGHT");
		bShoot = new JButton("FIRE");
		spacer = new JTextArea("Spacer");
		spacer.setBackground( Color.yellow );
		spacer.setPreferredSize(new Dimension(272, 250));
		spacer.enableInputMethods(false);
		spacer.setEnabled(false);
		spacer.setLayout(new FlowLayout(FlowLayout.LEFT,25,25));
		
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, spacer);
		this.setSize(300, 800);
		this.setBackground(Color.gray);
		this.setVisible(true);
		
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
		
		this.add(BorderLayout.SOUTH, buttons);
	}
	
	public void setInput( Input in )
	{
		//Add buttons to actionListener
		bUp.addActionListener(in);
		bDown.addActionListener(in);
		bLeft.addActionListener(in);
		bRight.addActionListener(in);
		bShoot.addActionListener(in);
	}
}
