package model;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * 
 * @author Martijn
 *
 * De data van het grond model wat getekend moet worden voor de view klasse.
 *
 */
public class GameBoardModel
{
	File file = new File("gamearea.xml");
	public ArrayList<SquareGrid> sglist = new ArrayList<SquareGrid>();
	int sizePlayGroundX, sizePlayGroundY;

	GameBoardModel()
	{
		this.loadGameArea();
	}
	
	public ArrayList<SquareGrid> getGameBoard()
	{
		return sglist;
	}
	
	public void updateGameArea()
	{
		for(int x = 0; x < sizePlayGroundX; x++)
			for(int y = 0; y < sizePlayGroundY; y++)
			{
				boolean found = false;
				for(int list = 0; list < sglist.size(); list++)
				{
					if(sglist.get(list).x == x && sglist.get(list).y == y)
					{
						found = true;
						break;
					} else
						found = false;
				}
				if(!found)
					sglist.add(
                			new SquareGrid(
                					x, 
                					y, 
                					"EMPTY"
                					)
                			);
			}
		
		for(int t = 0; t < sglist.size(); t++)
			System.out.println("COORDS: "+sglist.get(t).x+" :"+sglist.get(t).y+" :"+sglist.get(t).item );
	}
	
	public void loadGameArea()
	{
		if(!file.exists())
			System.out.println("file: '"+file.getPath()+"' not found.");
		else
			try 
			{
	            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	            Document doc = docBuilder.parse ( file );
	
	            doc.getDocumentElement ().normalize ();
	            NodeList gamearea = doc.getElementsByTagName("gamearea");
	            if( gamearea.item(0).getNodeType() == Node.ELEMENT_NODE)
	            {
	            	Element gaElement = (Element)gamearea.item(0);
	            	sizePlayGroundX = Integer.parseInt( gaElement.getAttributes().item(0).getNodeValue() ); //sizeInTileX
	            	sizePlayGroundY = Integer.parseInt( gaElement.getAttributes().item(1).getNodeValue() ); //sizeInTileY
	            }
	            NodeList tileNodes = doc.getElementsByTagName("tile");
	            int tiles = tileNodes.getLength();
	
	            for(int s=0; s < tiles; s++){
	                Node firstPersonNode = tileNodes.item(s);
	                if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE)
	                {
	                    Element tile = (Element)firstPersonNode;
	                    Node tileX = tile.getAttributes().item(0), tileY = tile.getAttributes().item(1);
	                    if(tileX.getNodeName() == "tileX" &&
	                    	tileY.getNodeName() == "tileY" &&
	                    	tile.getFirstChild().getNodeValue() != null )
	                    {
	                    	sglist.add(
	                    			new SquareGrid(
	                    					Integer.parseInt( tileX.getNodeValue() ), 
	                    					Integer.parseInt( tileY.getNodeValue() ), 
	                    					tile.getFirstChild().getNodeValue()
	                    					)
	                    			);
	                    }
	                }
	            }
	        } catch (SAXParseException err) {
		        System.out.println ("** Parsing error" + ", line " 
		             + err.getLineNumber () + ", uri " + err.getSystemId ());
		        System.out.println(" " + err.getMessage ());
	        } catch (SAXException e) {
		        Exception x = e.getException ();
		        ((x == null) ? e : x).printStackTrace ();
	        } catch (Throwable t) {
	        	t.printStackTrace ();
	        }
		this.updateGameArea();
	}
	
	public void update()
	{
	}

}
