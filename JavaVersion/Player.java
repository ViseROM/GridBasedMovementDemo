import java.awt.Graphics2D;
import java.awt.Color;
/**
 * Player class represents a the Player
 * @author Vachia Thoj
 *
 */
public class Player extends Entity 
{
	//To manage key inputs
	private KeyManager keyManager;
	
	//Player's speed
	private int speed;
	
	//Distance player traveled
	private int distance;
	
	//Color of player
	private Color color;
	
	//Direction Player is moving
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	//Flag to see if player is moving
	private boolean moving;
	
	//For key inputs
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	
	//Amount of distance Player should move 
	private static final int TARGET_DISTANCE = 32;
	
	//Constructor
	public Player(int x, int y, int width, int height)
	{
		keyManager = KeyManager.instance();
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		speed = 4;
		distance = 0;
		color = Color.RED;
		
		left = false;
		right = false;
		up = false;
		down = false;
		moving = false;
	}
	
	//Getter methods
	public int getSpeed() {return speed;}
	public boolean isMoving() {return moving;}
	public Color getColor() {return color;}
	
	//Setter methods
	public void setSpeed(int speed) {this.speed = speed;}
	public void setMoving(boolean b) {moving = b;}
	public void setColor(Color color) {this.color = color;}
	
	/**
	 * Method that checks if a movement key has been pressed
	 */
	private void checkMoveKeys()
	{
		//Exit method if player is currently moving
		if(moving == true)
		{
			return;
		}
		
		if(keyManager.isKeyDown(LEFT))	//Left key check
		{
			left = true;
			moving = true;
		}
		else if(keyManager.isKeyDown(RIGHT)) //Right key check
		{	
			right = true;
			moving = true;
		}
		else if(keyManager.isKeyDown(UP)) //Up key check
		{
			up = true;
			moving = true;
		}
		else if(keyManager.isKeyDown(DOWN)) //Down key check
		{
			down = true;
			moving = true;
		}
	}
	
	/**
	 * Method that moves the Player
	 */
	private void move()
	{
		if(left == true)	//Moving left
		{
			x = x - speed;
			distance = distance + speed;
			
			if(distance == TARGET_DISTANCE)
			{
				distance = 0;
				left = false;
				moving = false;
			}
		}
		else if(right == true)	//Moving right
		{
			x = x + speed;
			distance = distance + speed;
		
			if(distance == TARGET_DISTANCE)
			{
				distance = 0;
				right = false;
				moving = false;
			}
		}
		else if(up == true)	//Moving up
		{
			y = y - speed;
			distance = distance + speed;
			
			if(distance == TARGET_DISTANCE)
			{
				distance = 0;
				up = false;
				moving = false;
			}
		}
		else if(down == true)	//Moving down
		{
			y = y + speed;
			distance = distance + speed;
			
			if(distance == TARGET_DISTANCE)
			{
				distance = 0;
				down = false;
				moving = false;
			}
		}
	}
	
	/**
	 * Method that checks if Player is at the edges of window
	 * Won't allow Player to go beyond boundaries
	 */
	private void checkBoundary()
	{
		if(x < 0)	//Left boundary
		{
			x = 0;
		}
		else if(x > GamePanel.WIDTH - width)	//Right boundary
		{
			x = GamePanel.WIDTH - width;
		}
		
		if(y < 0)	//Top boundary
		{
			y = 0;
		}
		else if(y > GamePanel.HEIGHT - height) //Bottom boundary
		{
			y = GamePanel.HEIGHT - height;
		}
	}
	
	/**
	 * Method that updates the Player
	 */
	public void update()
	{	
		//Check if a movement key has been pressed
		checkMoveKeys();
		
		//Move Player if necessary
		move();
		
		//Check if Player has touched edges of window
		checkBoundary();
	}
	
	/**
	 * Method that draws the Player
	 * @param g The Graphics2D object that is going to be drawn on
	 */
	public void draw(Graphics2D g)
	{
		//Draw Player
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
