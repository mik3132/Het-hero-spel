package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Input;

import model.HeroModel;
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
	public JButton bUp,bDown,bLeft,bRight,bShoot;
	public JLabel jLabel1, jLabel2;
	public JTextField jTextField1, jTextField2;
	private HeroModel heroModel;
	
	public ControlPanel(HeroModel heroModel)
	{
		this.heroModel = heroModel;
		
		bUp = new JButton("/\\");
		bDown = new JButton( "\\/" );
		bLeft = new JButton("<");
		bRight = new JButton(">");
		bShoot = new JButton("FIRE");
        jLabel1 = new JLabel("Score");
        jLabel2 = new JLabel("Points left");
        jTextField1 = new JTextField(""+heroModel.scs.points);
        jTextField2 = new JTextField("0");
        jTextField1.setFocusable(false);
        jTextField2.setFocusable(false);
        
		
		this.setLayout(new BorderLayout());
		this.setSize(300, 800);
		this.setBackground(Color.gray);
		this.setVisible(true);
		
		//add Buttons to JPanel
		JPanel buttons = new JPanel();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(buttons);
        buttons.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(bDown, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bUp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bShoot, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bRight, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                    .addGap(28, 28, 28))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                    .addComponent(bUp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bShoot, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bRight, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bDown, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29))
            );
            
		// Unfocus buttons
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
		
		this.add(BorderLayout.CENTER, buttons);
	}
	
	public void setInput( Input in )
	{
		// Add buttons to actionListener
		bUp.addActionListener(in);
		bDown.addActionListener(in);
		bLeft.addActionListener(in);
		bRight.addActionListener(in);
		bShoot.addActionListener(in);
	}
	
	public void update ()
	{
		jTextField1.setText(""+heroModel.scs.points);
	}
	

}
