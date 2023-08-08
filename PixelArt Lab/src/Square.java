import java.awt.Graphics;
import java.awt.Color;

public class Square{
	private int red;
	private int green;
	private int blue;
	public Square(int r,int g,int b) {
		red=r;
		green=g;
		blue=b;
	}
	public void drawMe(Graphics g,int x,int y) {
		g.setColor(new Color(red,green,blue));
		g.fillRect(x, y, 20, 20);
		g.setColor(Color.black);
		g.drawRect(x, y, 20, 20);
		
	}
	public void drawMeNoBorder(Graphics g,int x,int y) {
		g.setColor(new Color(red,green,blue));
		g.fillRect(x, y, 20, 20);
	}
	public void setColor(int r,int g,int b) {
		red=r;
		green=g;
		blue=b;
	}
	public int[] getColor() {
		int[] color= {red,green,blue};
		return color;
	}
}