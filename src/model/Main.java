package model;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Input;

import view.*;

/**
 *
 * Hoofdklasse, onder deze klasse vallen alle klasses.
 * Het frame & threadpool.
 *
 *
 * @author TeamX
 * @version 0.1
 * @date 09-10-2011
 * 
 */
public class Main extends JFrame implements Runnable 
{
	PlayPanel playPanel;
	ControlPanel controlPanel;
	GameBoardModel gbm;
	Scores scs;
	Input in;
	HeroModel heroModel;
	
	boolean run = true;

	/**
	 * Constructor method
	 */
	Main()
	{
		scs = new Scores();
		heroModel = new HeroModel( PlayPanel.width, PlayPanel.height );
		gbm = new GameBoardModel( heroModel );
		controlPanel = new ControlPanel( scs );
		playPanel = new PlayPanel( gbm, heroModel);
		in = new Input( heroModel, gbm, scs, controlPanel, playPanel );
		controlPanel.setInput(in); //SetActionListners
		
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
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
