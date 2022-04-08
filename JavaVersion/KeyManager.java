import java.awt.event.KeyEvent;
/**
 * KeyManager class manages and keeps track of keyboard inputs
 * @author Vachia Thoj
 *
 */
public class KeyManager 
{
	//For singleton
	private static KeyManager keyManager;
	
	//Number of keys
	private static final int NUM_KEYS = 5;
	
	//Possible keys to keep track of
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	private static final int SHIFT = 4;
	
	//Keeps track of which key has been pressed
	private boolean[] isDown;
	
	//Constructor
	private KeyManager()
	{
		isDown = new boolean[NUM_KEYS];
		
		for(int i = 0; i < NUM_KEYS; i++)
		{
			isDown[i] = false;
		}
	}
	
	public static KeyManager instance()
	{
		if(keyManager == null)
		{
			keyManager = new KeyManager();
		}
		
		return keyManager;
	}
	
	/**
	 * Method that sets a key press
	 * @param i integer value of key
	 * @param b true for key has been pressed, false for key has not been pressed
	 */
	public void setKey(int i, boolean b)
	{
		switch(i) {
			case KeyEvent.VK_LEFT:
				isDown[LEFT] = b;
				break;
			case KeyEvent.VK_RIGHT:
				isDown[RIGHT] = b;
				break;
			case KeyEvent.VK_UP:
				isDown[UP] = b;
				break;
			case KeyEvent.VK_DOWN:
				isDown[DOWN] = b;
				break;
			case KeyEvent.VK_SHIFT:
				isDown[SHIFT] = b;
				break;
			default:
				break;
		}
	}
	
	/**
	 * Method that checks if a certain key is being pressed
	 * @param i integer value of key
	 * @return true if certain key is pressed otherwise false for that key
	 */
	public boolean isKeyDown(int i)
	{
		return isDown[i];
	}
}