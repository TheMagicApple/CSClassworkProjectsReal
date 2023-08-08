import java.awt.Color;
import java.awt.Graphics;

public class Mountain {
	private int x;
	private int y;
	public static boolean winter;
	public Mountain(int x,int y,boolean winter) {
		this.x=x;
		this.y=y;
		//this.winter=winter;
	}
	public void drawMe(Graphics g) {
		
			
		
		g.setColor(new Color(125,125,125));
		
		g.fillPolygon(new int[]{x-200,x,x+200},new int[] {y,y-150,y},3);
		if(winter) {
			g.setColor(new Color(255,255,255));
			g.fillPolygon(new int[] {x-70,x,x+70},new int[] {y-100,y-150,y-100},3);
		}
	}
}
