import java.awt.Graphics;

public class Square {
	private int x;
	private int y;
	public Square(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void drawMe(Graphics g) {
		g.fillRect(x, y, 20, 20);
	}
}
