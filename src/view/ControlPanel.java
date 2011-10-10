package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

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
	public ControlPanel( Scores scs )
	{
		spacer = new JTextArea("Spacer");
		spacer.setPreferredSize(new Dimension(272, 250));
		spacer.enableInputMethods(false);
		spacer.setEnabled(false);
		spacer.setLayout(new FlowLayout(FlowLayout.LEFT,25,25));
		
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, spacer);
		this.setSize(300, 800);
		this.setBackground(Color.gray);
		this.setVisible(true);
	}
}
