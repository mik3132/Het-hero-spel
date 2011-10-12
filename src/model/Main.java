package model;

import java.awt.BorderLayout;
import javax.swing.*;

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
	JPanel playPanel;
	ControlPanel controlPanel;
	GameBoardModel gbm;
	Scores scs;
	Input in;
	HeroModel heroModel;
	
	JMenuBar menuBar;
    JMenu gameMenu, optionsMenu, levelMenu;
    JMenuItem restartItem, quitItem, soundItem, level1Item, level2Item; 
	
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
		in = new Input( heroModel, gbm, scs, controlPanel );
		
		
		this.setTitle("Het hero spel");
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.EAST, controlPanel);
		this.add(BorderLayout.CENTER, playPanel);
		
		// JMENU
		menuBar = new JMenuBar();
		
		gameMenu = new JMenu("Game");
		optionsMenu = new JMenu("Options");
		levelMenu = new JMenu("Level");
		
		menuBar.add(gameMenu);
		menuBar.add(optionsMenu);
		menuBar.add(levelMenu);
		
		restartItem = new JMenuItem("Restart");
		quitItem = new JMenuItem("Quit");
		soundItem = new JMenuItem("Sound");
		level1Item = new JMenuItem("Level 1");
		level2Item = new JMenuItem("Level 2");
		
		gameMenu.add(restartItem);
		gameMenu.add(quitItem);
		
		optionsMenu.add(soundItem);
		
		levelMenu.add(level1Item);
		levelMenu.add(level2Item);
		
		this.add(menuBar);
		
		
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
