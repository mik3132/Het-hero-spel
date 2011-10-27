package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import view.EmptySlot;
import view.GameBoard;
import view.Enemy;
import view.PlayPanel;
import view.PlayerMessage;
import view.Wall;
import view.Window;

/**
 * 
 * GameBoardModel class
 * The data that will have to drawn on the GameBoard
 * 
 * @author Martijn, Edo
 * @version 0.1
 * @date 04-10-2011
 *
 */
public class GameBoardModel
{
	/** The level to load at first */
	File file = new File("level/level1.xml");
	/** The ArrayList containing the objects on the grid */
	public ArrayList<SquareGrid> sglist = new ArrayList<SquareGrid>();
	/** Integers for keeping track of the size */
	public int sizePlayGroundX, sizePlayGroundY;
	/** The HeroModel representing the current Hero */
	public HeroModel heroModel;
	/** the square size */
	public int squareSize;
	/** The random generator */
	public Random random = new Random();
	/** The ArrayList containing the player messages */
	public ArrayList<PlayerMessage> arrpm = new ArrayList<PlayerMessage>();
	/** The PlayPanel */
	public PlayPanel playPanel;
	

	/**
	 * Constructor method
	 * 
	 * @param HeroModel heroModel The HeroModel representing the hero
	 */
	GameBoardModel(HeroModel heroModel)
	{
		this.heroModel = heroModel;
	}
	
	/**
	 * Getter method for the current HeroModel
	 * 
	 * @return HeroModel The current HeroModel
	 */
	public HeroModel getHeroModel()
	{
		return heroModel;
	}
	
	/**
	 * Getter method for the list of objects to place on the board
	 * 
	 * @return ArrayList<SquareGrid> The list containing the objects
	 */
	public ArrayList<SquareGrid> getGameBoard()
	{
		return sglist;
	}
	
	/**
	 * Method that updates the gamearea based on the hero's movement
	 */
	public void updateGameArea()
	{
		// x <= sizePlayGroundX otherwise the largest position won't be accounted for
		for(int x = 0; x <= sizePlayGroundX; x++) {
			// y <= sizePlayGroundY otherwise the largest position won't be accounted for
			for(int y = 0; y <= sizePlayGroundY; y++) {
				boolean found = false;
				// Loop through the list of objects
				for(int list = 0; list < sglist.size(); list++) {
					if(sglist.get(list).getX() == x && sglist.get(list).getY() == y) {
						found = true;
						break;
					} else {
						found = false;
					}
				}
				if(!found) {
					// If there's no object to place on the GameBoard place and empty field
					sglist.add( new EmptySlot(x,y) );
				}
			}
		}
		drawGameBoardEdge();
	}
	
	/**
	 * Method to get an object at a specified position
	 * 
	 * @param int x The x position of the object to get 
	 * @param int y The y position of the object to get
	 * @return SquareGrid if an object is found and null if no object is found
	 */
	public SquareGrid getObjectFromPlayGround(int x, int y)
	{
		for(int list = 0; list < sglist.size(); list++) {
			if(sglist.get(list).getX() == x && sglist.get(list).getY() == y) {
				return sglist.get(list);
			}
		}
		return null;
	}
	
	/**
	 * Loads the GameArea from the set xml file
	 */
	public void loadGameArea()
	{
		sglist = new ArrayList<SquareGrid>();
		if(!file.exists()) {
			System.out.println("file: '"+file.getPath()+"' not found.");
		} else {
			try {
				
				// Create a DocumentBuilderFactory to parse the xml file
	            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	            Document doc = docBuilder.parse (file);
	            doc.getDocumentElement ().normalize ();
	            
	            // Create a nodelist to get the Hero attributes
	            NodeList hero = doc.getElementsByTagName("hero");
	            
	            //  Get all the attributes from the hero
	            if( hero.item(0).getNodeType() == Node.ELEMENT_NODE ) {
	            	Element heroPOS = (Element)hero.item(0);
	            	heroModel.heroPosX = Integer.parseInt( heroPOS.getAttributes().item(0).getNodeValue() ); //sizeInTileX
	            	heroModel.heroPosY = Integer.parseInt( heroPOS.getAttributes().item(1).getNodeValue() ); //sizeInTileY
	            	heroModel.posHeroPosX = Integer.parseInt( heroPOS.getAttributes().item(0).getNodeValue() ); //sizeInTileX
	            	heroModel.posHeroPosY = Integer.parseInt( heroPOS.getAttributes().item(1).getNodeValue() ); //sizeInTileY
	            }
	            
	            // Create a nodelist to get the gameArea attributes
	            NodeList gamearea = doc.getElementsByTagName("gamearea");
	            
	            //  Get all the attributes from the gameArea
	            if( gamearea.item(0).getNodeType() == Node.ELEMENT_NODE) {
	            	Element gaElement = (Element)gamearea.item(0);
	            	sizePlayGroundX = Integer.parseInt( gaElement.getAttributes().item(0).getNodeValue() ); //sizeInTileX
	            	sizePlayGroundY = Integer.parseInt( gaElement.getAttributes().item(1).getNodeValue() ); //sizeInTileY
	            }
	            
	            // Create a nodelist to get the tile attributes
	            NodeList tileNodes = doc.getElementsByTagName("tile");
	            int tiles = tileNodes.getLength();
	            
	            // Get all the attributes from the tiles
	            for(int s=0; s < tiles; s++) {
	            	Node firstPersonNode = tileNodes.item(s);
	                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
	                {
	                	NamedNodeMap attrs = firstPersonNode.getAttributes();
	                	Element tile = (Element)firstPersonNode;
	                	// Save all the attributes of a tile
	                	//NodeList ndlist = tile.getChildNodes();
	                	Node tileX = attrs.getNamedItem("tileX"), 
	                    		tileY = attrs.getNamedItem("tileY"),
	                    		vertical = attrs.getNamedItem("vertical"),
	                    		bullets = attrs.getNamedItem("bullets");
	                    if(tileX.getNodeName() == "tileX" &&
	                    	tileY.getNodeName() == "tileY" &&
	                    	tile.getFirstChild().getNodeValue() != null )
	                    {
	                    	// Add the SquareGrid to the ArrayList
	                    	if(Integer.parseInt( tile.getFirstChild().getNodeValue() ) == GameBoard.ENEMY) {
	                    		heroModel.scs.addGamePoints("Enemy left", 1);
	                    		sglist.add( new Enemy( Integer.parseInt( tileX.getNodeValue() ), Integer.parseInt( tileY.getNodeValue() ), this, random, playPanel, 1) );
	                    	} else if(Integer.parseInt( tile.getFirstChild().getNodeValue() ) == GameBoard.SPECIALENEMY && bullets.getNodeValue() != null) {
	                    		heroModel.scs.addGamePoints("Enemy left", 1);
	                    		sglist.add( new Enemy( Integer.parseInt( tileX.getNodeValue() ), Integer.parseInt( tileY.getNodeValue() ), this, random, playPanel, Integer.parseInt( bullets.getNodeValue() )) );
	                    	}  
	                    	else if(Integer.parseInt( tile.getFirstChild().getNodeValue() ) == GameBoard.WALL)
	                    		sglist.add( new Wall( Integer.parseInt( tileX.getNodeValue() ), Integer.parseInt( tileY.getNodeValue() )) );
	                    	else if(Integer.parseInt( tile.getFirstChild().getNodeValue() ) == GameBoard.WINDOW && vertical.getNodeValue() != null )
	                    		sglist.add( new Window( Integer.parseInt( tileX.getNodeValue() ), Integer.parseInt( tileY.getNodeValue() ), Integer.parseInt( vertical.getNodeValue() )) );
	                    }
	                }
	            }
	        } catch (SAXParseException err) {
		        System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
		        System.out.println(" " + err.getMessage ());
	        } catch (SAXException e) {
		        Exception x = e.getException ();
		        ((x == null) ? e : x).printStackTrace ();
	        } catch (Throwable t) {
	        	t.printStackTrace ();
	        }
		}
	    
		// Update the gameArea with the above information
		this.updateGameArea();
	}	
	
	/**
	 * Method that draws the edge around the GameBoard
	 * 
	 * @param int posX The x position calculated based on the hero's movement
	 * @param int posY The y position calculated based on the hero's movement
	 * @param Graphics g The Graphic manager to execute the drawing
	 */
	private void drawGameBoardEdge()
	{
		for(int i=0; i <= sizePlayGroundX; i++) {
			sglist.add( new Wall(i, 0) );
			sglist.add( new Wall(i, sizePlayGroundY+1) );
			sglist.add( new Wall(0, i) );
			sglist.add( new Wall(sizePlayGroundX+1, i ));
		}
		sglist.add( new Wall( sizePlayGroundX+1, sizePlayGroundX+1 ));
	}
	
	/**
	 * Update method
	 */
	public void update()
	{
	}

	/**
	 * Method to get an index from the board based on given coordinates
	 * 
	 * @param int x The x coordinate to get the index 
	 * @param int y The y coordinate to get the index
	 * @return int the index and -1 if no index could be found
	 */
	public int getIndexFromBoard(int x, int y)
	{
		for(int list = 0; list < sglist.size(); list++) {
			if(sglist.get(list).getX() == x && sglist.get(list).getY() == y) {
				return list;
			}
		}
		return -1;
	}
	
	/**
	 * Method to get an index from the board based on given coordinates
	 * 
	 * @param int x The x coordinate to get the index 
	 * @param int y The y coordinate to get the index
	 * @return int the index and -1 if no index could be found
	 */
	public SquareGrid getSquareGridFromBoard(int x, int y)
	{
		for(int list = 0; list < sglist.size(); list++) {
			if(sglist.get(list).getX() == x && sglist.get(list).getY() == y) {
				return sglist.get(list);
			}
		}
		return null;
	}

	/**
	 * Function that removes an object from the GameBoard
	 * 
	 * @param int indexFromBoard The index number to remove
	 */
	public void removeFromPlayGround(int x, int y, String message)
	{
		SquareGrid sq = this.getSquareGridFromBoard(x, y);
		if(sq instanceof Enemy)
		{
			((Enemy)sq).bullets--;
			if( ((Enemy)sq).bullets <= 0)
			{
				heroModel.scs.addGamePoints("Stappen", 200);
				heroModel.scs.removeActionPoints("ENEMY");
				this.sglist.remove( this.getIndexFromBoard(x, y));
				arrpm.add( new PlayerMessage( message ) );
				this.updateGameArea();
			}
		} else {
			this.sglist.remove( this.getIndexFromBoard(x, y) );
			arrpm.add( new PlayerMessage( message ) );
			this.updateGameArea();
		}
	}
	
	public void setSquereSize(int squereSize)
	{
		this.squareSize = squereSize;
	}

	public void setPlayPanel(PlayPanel playPanel)
	{
		this.playPanel = playPanel;
		this.loadGameArea();
		heroModel.setSquareGrids( this );
	}

}
