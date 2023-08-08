
import java.awt.Graphics;

public class Circle {
	private int x;
	private int y;
	
	public Circle(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void drawMe(Graphics g) {
		g.fillOval(x, y, 20, 20);
	}
}

