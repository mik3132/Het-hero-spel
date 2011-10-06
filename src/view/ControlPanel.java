package view;

import java.awt.Color;
import java.awt.Dimension;
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
public class ControlPanel extends JPanel {
	JTextArea spacer;
	public ControlPanel(Scores scs)
	{
		spacer = new JTextArea("Spacer");
		spacer.setPreferredSize(new Dimension(272, 250));
		this.add(spacer);
		this.setSize(300, 800);
		this.setBackground(Color.gray);
		this.setVisible(true);
	}
}
