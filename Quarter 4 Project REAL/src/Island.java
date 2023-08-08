import java.awt.Color;
import java.awt.Graphics;

public class Island {
	private int topLeftX;
	private int topLeftY;
	private int bottomRightX;
	private int bottomRightY;
	public Island(int topLeftX,int topLeftY,int bottomRightX,int bottomRightY) {
		this.topLeftX=topLeftX;
		this.topLeftY=topLeftY;
		this.bottomRightX=bottomRightX;
		this.bottomRightY=bottomRightY;
	}
	public void drawMe(Graphics g,int x,int y) {
		g.setColor(new Color(255, 235, 56)); //set color to sand
		g.fillRect(x+topLeftX,y+topLeftY,bottomRightX-topLeftX,bottomRightY-topLeftY);
	}
	public int getTopLeftX() {
		return topLeftX;
	}
	public int getTopLeftY() {
		return topLeftY;
	}
	public int getBottomRightX() {
		return bottomRightX;
	}
	public int getBottomRightY() {
		return bottomRightY;
	}
}
