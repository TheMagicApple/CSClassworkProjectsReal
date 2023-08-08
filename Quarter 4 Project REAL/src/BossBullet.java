import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BossBullet {
	private int xSpeed;
	private int ySpeed;
	private int x;
	private int y;
	private BufferedImage rocket;
	private String direction;
	public BossBullet(int xSpeed,int ySpeed,int x,int y,BufferedImage rocket,String direction) {
		this.xSpeed=xSpeed;
		this.ySpeed=ySpeed;
		this.x=x;
		this.y=y;
		this.rocket=rocket;
		this.direction=direction;
	}
	public void move() {
		if(direction.equals("L")) {
			x-=xSpeed;
		}else if(direction.equals("R")){
			x+=xSpeed;
		}else if(direction.equals("U")) {
			y-=ySpeed;
		}else {
			y+=ySpeed;
		}
		
		
	}
	public void drawMe(Graphics g,int xx,int yy) {
		g.drawImage(rocket, xx+x,yy+y, null);
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
