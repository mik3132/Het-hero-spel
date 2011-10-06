package model;

import javax.swing.JFrame;

/**
 * 
 * @author Martijn
 *
 * Hoofdklasse, onder deze klasse vallen alle klasses.
 * Het frame & threadpool.
 *
 */

public class Main extends JFrame {
	//HoofdFrame
	//Threading
	//Pannels
	Main()
	{
		this.setSize( 400 ,  400 );
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Main();
	}
}
