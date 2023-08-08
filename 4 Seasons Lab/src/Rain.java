import java.awt.Color;
import java.awt.Graphics;

public class Rain {
	private int x;;
	private int y;
	private int OGY;
	public static boolean spring;
	public Rain(int x,int OGy) {
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
		if(spring) {
			g.setColor(new Color(2,24,224,125));
		}else {
			g.setColor(new Color(0,0,0,0));
		}
		
		g.fillRect(x, y, 10, 20);
	}
}
