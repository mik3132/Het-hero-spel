package model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Input;

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
	JPanel playPanel;
	ControlPanel controlPanel;
	GameBoardModel gbm;
	Scores scs;
	Input in;
	HeroModel heroModel;
	
	boolean run = true;
	
	Main()
	{
		scs = new Scores();
		gbm = new GameBoardModel();
		heroModel = new HeroModel( PlayPanel.width, PlayPanel.height );
		controlPanel = new ControlPanel( scs );
		playPanel = new PlayPanel( gbm, heroModel);
		in = new Input( heroModel, gbm, scs, controlPanel );
		
		this.setTitle("Het hero spel");
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.EAST, controlPanel);
		this.add(BorderLayout.CENTER, playPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize( 1150 ,  890 );
		this.addKeyListener( in );
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
			
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
