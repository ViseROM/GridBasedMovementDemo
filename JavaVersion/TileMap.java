import java.awt.Graphics2D;
import java.awt.Color;

/**
 * TileMap class represents a map (Tile Map)
 * @author Vachia Thoj
 *
 */
public class TileMap 
{
	//x and y coordinate of where tileMap starts
	private int startX;
	private int startY;
	
	//x and y coordinate of where tileMap ends
	private int endX;
	private int endY;
	
	//Total width and height of tileMap
	private int width;
	private int height;
	
	//Size of a tile in tileMap
	private int tileSize;
	
	//Number columns and rows of tiles
	private int numCols;
	private int numRows;
	
	//The tileMap
	private Tile[][] tileMap;
	
	//Constructor
	public TileMap(int startX, int startY, int numCols, int numRows, int tileSize)
	{
		this.startX = startX;
		this.startY = startY;
		this.numCols = numCols;
		this.numRows = numRows;
		this.tileSize = tileSize;
		
		this.width = numCols * tileSize;
		this.height = numRows * tileSize;
		
		this.endX = startX + width;
		this.endY = startY + height;
		
		tileMap = new Tile[numRows][numCols];
		
		createTileMap();
	}
	
	/**
	 * Method that creates/initializes tileMap[][]
	 */
	private void createTileMap()
	{
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				//Calculate x and y coordinate of each Tile
				int x = startX + (j * tileSize);
				int y = startY + (i * tileSize);
				
				//Add Tile to tileMap
				tileMap[i][j] = new Tile(x, y, tileSize, tileSize, 0);
			}
		}
	}
	
	//Getter Methods
	public int getStartX() {return startX;}
	public int getStartY() {return startY;}
	public int getEndX() {return endX;}
	public int getEndY() {return endY;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public int getTileSize() {return tileSize;}
	public int getNumCols() {return numCols;}
	public int getNumRows() {return numRows;}
	
	
	/**
	 * Method that draws the TileMap
	 * @param g The Graphics2D object to be drawn on
	 */
	public void draw(Graphics2D g)
	{
		//Draw tileMap
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				Tile temp = tileMap[i][j];
				g.setColor(Color.WHITE);
				g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
				
				g.setColor(Color.BLACK);
				g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
			}
		}
	}
}
