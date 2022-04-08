import java.awt.Graphics2D;

public class StateManager 
{
	//For singleton
	private static StateManager stateManager;
	
	//CurrentState
	private State currentState;
	
	private StateManager()
	{
		currentState = new PlayState();
	}
	
	public static StateManager instance()
	{
		if(stateManager == null)
		{
			stateManager = new StateManager();
		}
		
		return stateManager;
	}
	
	/**
	 * Method that updates the current state
	 */
	public void update()
	{
		currentState.update();
	}
	
	/**
	 * Method that draws the current state
	 * 
	 * @param g The Graphics2D object to be drawn on
	 */
	public void draw(Graphics2D g)
	{
		currentState.draw(g);
	}
}
