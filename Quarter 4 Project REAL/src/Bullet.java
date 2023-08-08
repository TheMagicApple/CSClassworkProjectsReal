import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet {
	private int xSpeed;
	private int ySpeed;
	private int x;
	private int y;
	private BufferedImage rocket;
	private boolean left;
	public Bullet(int xSpeed,int ySpeed,int x,int y,BufferedImage rocket,boolean left) {
		this.xSpeed=xSpeed;
		this.ySpeed=ySpeed;
		this.x=x;
		this.y=y;
		this.rocket=rocket;
		this.left=left;
	}
	public void move() {
		if(left) {
			x-=xSpeed;
			
		}else {
			x+=xSpeed;
		}
		
		
	}
	public void drawMe(Graphics g) {
		g.drawImage(rocket, x,y, null);
		/*
		g.setColor(new Color(0,0,0));
		g.drawRect(x, y, 8, 3);
		g.setColor(new Color(255, 225, 0));
		g.fillRect(x, y, 8, 3);
		*/
	}
	public boolean outOfScreen() {
		if(x>600 || x<0 || y>600 || y<0) {
			return true;
		}else {
			return false;
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	
}
