import java.awt.Color;
import java.awt.Graphics;
public class Tree {
	private int x;
	private int y;
	public static boolean fall;
	public static boolean winter;
	public Tree(int x,int y,int r,int g,int b) {
		this.x=x;
		this.y=y;
		
	}
	public void drawMe(Graphics g) {
		g.setColor(new Color(77,56,0));
		g.fillRect(x, y, 30, 100);
		if(fall) {
			g.setColor(new Color(245, 173, 66));
		}else {
			g.setColor(new Color(0,255,30));
		}
		if(winter) {
			g.setColor(new Color(0,0,0,0));
		}
		g.fillOval(x-20, y-20, 70, 70);
	}
}
