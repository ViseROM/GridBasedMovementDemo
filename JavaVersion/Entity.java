/**
 * Abstract class that represents an Entity
 * @author Vachia Thoj
 *
 */
public abstract class Entity 
{
	//x and y coordinate of Entity
	protected int x;
	protected int y;
	
	//width and height of Entity;
	protected int width;
	protected int height;
	
	protected Entity()
	{
		
	}
	
	//Getter Methods
	protected int getX() {return x;}
	protected int getY() {return y;}
	protected int getWidth() {return width;}
	protected int getHeight() {return height;}
	
	//Setter Methods
	protected void setX(int x) {this.x = x;}
	protected void setY(int y) {this.y = y;}
	protected void setWidth(int width) {this.width = width;}
	protected void setHeight(int height) {this.height = height;}
}
