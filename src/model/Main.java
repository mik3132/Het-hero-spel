package model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.*;

/**
 * 
 * @author Martijn
 *
 * Hoofdklasse, onder deze klasse vallen alle klasses.
 * Het frame & threadpool.
 *
 */

public class Main extends JFrame implements Runnable 
{
	JPanel controlPanel, playPanel;
	GameBoardModel gbm;
	Scores scs;
	
	boolean run = true;
	
	Main()
	{
		scs = new Scores();
		gbm = new GameBoardModel();
		controlPanel = new ControlPanel( scs );
		playPanel = new PlayPanel( gbm );
		
		this.setTitle("Het hero spel");
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.EAST, controlPanel);
		this.add(BorderLayout.CENTER, playPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize( 1150 ,  890 );
		this.setVisible(true);
	}

	private void update()
	{
		scs.update();
		gbm.update();
	}
	
	public static void main(String[] args)
	{
		Thread main = new Thread(new Main());
		main.start();
	}

	@Override
	public void run()
	{
		while(run)
		{
			this.update();
			controlPanel.repaint();
			playPanel.repaint();
		}
	}
}
