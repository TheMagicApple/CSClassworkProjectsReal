import java.awt.Color;
import java.awt.Graphics;

public class Snow {
	private int x;;
	private int y;
	private int OGY;
	public static boolean winter;
	public Snow(int x,int OGy) {
		this.x=x;
		y=OGy;
		OGY=OGy;
	}
	public void changeY() {
		y+=2;
	}
	public void drawMe(Graphics g) {
		if(y>=600) {
			y=OGY;
		}
		if(winter==true) {
			g.setColor(new Color(255,255,255,125));
			//System.out.println("winter time");
		}else {
			g.setColor(new Color(0,0,0,0));
		}
		
		g.fillOval(x, y, 10, 10);
	}
}
