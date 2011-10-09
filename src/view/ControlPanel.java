package view;

import java.awt.Color;
import java.awt.Dimension;
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
		
		this.add(spacer);
		this.setSize(300, 800);
		this.setBackground(Color.gray);
		this.setVisible(true);
	}
}
