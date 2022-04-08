import java.awt.Graphics2D;
import java.awt.Color;

/**
 * PlayState class represents the "play area" of the game 
 * This is where the user sees the game being played
 * 
 * @author Vachia Thoj
 *
 */
public class PlayState extends State
{
	//TileMap
	private TileMap tileMap;
	
	//Player
	private Player player;
	
	//Constructor
	public PlayState()
	{
		//Create tileMap
		tileMap = new TileMap(0, 0, 20, 20, 32);
		
		//Create Player
		player = new Player(0, 0, 32, 32);
	}
	
	/**
	 * Method that updates the PlayState
	 */
	public void update() 
	{
		//Update Player
		player.update();
	}
	
	/**
	 * Method that draws everything within the PlayState
	 * 
	 * @param g The Graphics2D object that is going to be drawn on
	 */
	public void draw(Graphics2D g)
	{
		//Draw Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		//Draw TileMap
		tileMap.draw(g);
		
		//Draw Player
		player.draw(g);
	}
}
