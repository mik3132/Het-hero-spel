package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

import controller.Input;

import model.HeroModel;

/**
*
* ControlPanel class
* This class represents the ControlPanel, this displays the Score and Buttons for the movement of the Hero
*
* @author Martijn, Edo
* @version 0.1
* @date 04-10-2011
*
*/
public class ControlPanel extends JPanel
{
	/** Buttons for the control panel */
	public JButton bUp,bDown,bLeft,bRight,bShoot, newGame, bexit;
	/** Labels for the control panel */
	public JLabel jLabel1, jLabel2;
	/** TextFields for the control panel */
	public JTextField  jTextField2;
	
	public ScoresView jTextField1;
	/** The HeroModel of the current Hero */
	private HeroModel heroModel;
	/** the Points */
	private ArrayList<JTextField> scoreFields;
	
	/**
	 * Constructor 
	 * 
	 * @param HeroModel heroModel The HeroModel of the current Hero
	 */
	public ControlPanel(HeroModel heroModel)
	{
		this.heroModel = heroModel;
		
		bUp = new JButton("/\\");
		bDown = new JButton( "\\/" );
		bLeft = new JButton("<");
		bRight = new JButton(">");
		bShoot = new JButton("FIRE");
		newGame = new JButton("New game");
		bexit = new JButton("Exit");
        jLabel1 = new JLabel("Enemies left");
        
        //add scores
        scoreFields = new ArrayList<JTextField>(); 
        
        jLabel2 = new JLabel("Points left");
        //jTextField1 = new JTextField(""+500);
        jTextField1 = new ScoresView(heroModel.scs);
        jTextField2 = new JTextField("");
        jTextField1.setFocusable(false);
        jTextField2.setFocusable(false);
		
		this.setLayout(new BorderLayout());
		this.setSize(300, 800);
		this.setBackground(Color.gray);
		this.setVisible(true);
		
		// add Buttons to JPanel
		JPanel buttons = new JPanel();

		JPanel pbuttonsNorth = new JPanel();
        GroupLayout layout = new GroupLayout(buttons);;

        buttons.setLayout(layout);
        pbuttonsNorth.setLayout(new BorderLayout());
        
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bLeft, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(bDown, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bUp, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bShoot, GroupLayout.Alignment.LEADING))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bRight, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                    .addGap(28, 28, 28))
            );
        
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                    .addComponent(bUp, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(bShoot, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bRight, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bLeft, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bDown, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29))
            );
            
		// Unfocus buttons so keyboard remains in control
		bUp.setFocusable(false);
		bDown.setFocusable(false);
		bLeft.setFocusable(false);
		bRight.setFocusable(false);
		bShoot.setFocusable(false);
		newGame.setFocusable(false);
		bexit.setFocusable(false);

		// Add the layout to the buttons
		buttons.add(BorderLayout.NORTH, bUp);
		buttons.add(BorderLayout.SOUTH, bDown);
		buttons.add(BorderLayout.EAST, bRight);
		buttons.add(BorderLayout.WEST, bLeft);
		buttons.add(BorderLayout.CENTER, bShoot);
		pbuttonsNorth.add(BorderLayout.NORTH, newGame);
		pbuttonsNorth.add(BorderLayout.SOUTH, bexit);
		
		this.add(BorderLayout.NORTH, pbuttonsNorth);
		this.add(BorderLayout.CENTER, buttons);
	}
	
	/**
	 * Setter method for the actionListener
	 * 
	 * @param Input in The input manager
	 */
	public void setInput(Input in)
	{
		// Add buttons to actionListener
		bUp.addActionListener(in);
		bDown.addActionListener(in);
		bLeft.addActionListener(in);
		bRight.addActionListener(in);
		bShoot.addActionListener(in);
		newGame.addActionListener(in);
		bexit.addActionListener(in);
	}
	
	/**
	 * Update method for updating the Scores
	 */
	public void update ()
	{
		//jTextField1.setText(""+500);
		jTextField1.update();
		jTextField2.setText(""); // kan weg
	}
	

}
