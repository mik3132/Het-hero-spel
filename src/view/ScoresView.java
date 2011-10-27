package view;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Point;
import model.Scores;

public class ScoresView extends JPanel{
	
	/** weet ik zelf ook nog niet, hiermee gaat een warning weg in m'n eclipse */
	private static final long serialVersionUID = 1L;
	/** The scores Model */
	public Scores scoresModel;
	/** the jTextFields */
	public HashMap<String, JTextField> textFields;
	
	public ScoresView(Scores scoresModel)
	{
		this.scoresModel = scoresModel;
		scoresModel.setView(this);
		
		this.textFields = new HashMap<String, JTextField>();
		
		HashMap<String, Point> points = scoresModel.points;
		this.setLayout(new GridLayout(10,2));
		for(String pointName : points.keySet())
		{
			JLabel jLabel = new JLabel(pointName);
			JTextField jTextField = new JTextField(""+points.get(pointName).pointsLeft);
			jTextField.setFocusable(false);
			textFields.put(pointName, jTextField);
			
			//Add to the panel
			this.add(jLabel);
			this.add(jTextField);
		}	
		
	}
	
	public void update()
	{
		HashMap<String, Point> points = scoresModel.points;
		for(String pointName : textFields.keySet())
		{
			textFields.get(pointName).setText("" + points.get(pointName).pointsLeft);
		}
	}
	
	
	

}
