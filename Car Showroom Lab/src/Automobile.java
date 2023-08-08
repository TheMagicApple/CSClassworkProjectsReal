import java.awt.Graphics;
import java.awt.Color;

public abstract class Automobile{

	private Color bodyColor;
	private int x = 100;
	private int y = 100;
	private int speed;
	
	
	public Automobile(Color bodyColor, int x, int y,int speed){

		this.bodyColor = bodyColor;
		this.x = x;
		this.y = y;
		this.speed=speed;
		
	}

	public void drive() {
		setX(getX()-getSpeed());
	}
	public void goLeft() {
		setX(getX()-getSpeed());
	}
	public void goRight() {
		setX(getX()+getSpeed());
	}
	public void goUp() {
		setY(getY()-getSpeed());
	}
	public void goDown() {
		setY(getY()+getSpeed());
	}
	
	public void drawMe(Graphics g){
		
		this.drawFrame(g);
		this.drawWheels(g);
	}
	public Color getBodyColor() {
		return bodyColor;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setX(int newX) {
		x=newX;
	}
	public void setY(int newY) {
		y=newY;
	}
	public abstract void drawFrame(Graphics g);
	public abstract void drawWheels(Graphics g);
	
}
