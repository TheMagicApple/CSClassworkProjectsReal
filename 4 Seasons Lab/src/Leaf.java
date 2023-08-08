
import java.awt.Color;
import java.awt.Graphics;

public class Leaf {
	private int x;;
	private int y;
	private int OGY;
	public static boolean fall;
	public Leaf(int x,int OGy) {
		this.x=x;
		y=OGy;
		OGY=OGy;
	}
	public void changeY() {
		y++;
	}
	public void drawMe(Graphics g) {
		if(y>=600) {
			y=OGY;
		}
		if(fall) {
			g.setColor(new Color(252, 186, 3,255));
		}else {
			g.setColor(new Color(0,0,0,0));
		}
		
		
		
		
		
		g.fillOval(x, y, 10, 20);
	}
}

