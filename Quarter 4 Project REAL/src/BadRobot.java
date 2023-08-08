import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BadRobot{
	private double x;
	private double y;
	public BadRobot(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void move(int playerX,int playerY,int xx,int yy) {
		if(Math.abs(playerX-x)>400 || Math.abs(playerY-y)>400) {
			
		}else {
			Vector v=new Vector(x,y,playerX,playerY);
			double[] m=v.unitVector();
			x+=m[0];
			y+=m[1];
		}
		
		//System.out.println("ROBOT: "+x+" "+y);
		//System.out.println("PLAYER: "+playerX+" "+playerY);
	}
	public void drawMe(Graphics g,BufferedImage i,int xx,int yy) {
		g.drawImage(i, xx+(int)Math.round(x)-100, yy+(int)Math.round(y)-120, null);
	}
	
	public int getX(int xx) {
		return (int) Math.round(x)+xx;
	}
	public int getY(int yy) {
		return (int)Math.round(y)+yy;
	}
	
}
