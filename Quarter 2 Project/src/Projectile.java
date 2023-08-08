import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Projectile{
	private int x;
	private int y;
	private int speed=15;
	private int width;
	private int height;
	private boolean destroyed=false;
	private boolean destroyed2=false;
	private Color red;
	private boolean visible;
	private Image image;
	public Projectile(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 20;
		
		this.red = new Color(0,255,0);
		this.visible=false;
		try {
			image=ImageIO.read(new File("arrow.png"));
		}catch(IOException e) {
			System.out.println("could not load arrow image");
		}

	}
	public void setVisible() {
		visible=true;
	}

	public void drawMe(Graphics g){
		if(isDestroyed()==false) {
			g.drawImage(image, x, y,null);
		}
		
			//g.setColor(red);
			//g.fillRect(x,y,width,height);
		
		if(x>800) {
			destroy();
		}
		
		
	}
	public void moveRight() {
		if(visible) {
			x+=speed;
		}
		if(x>800) {
			visible=false;
		}
		
	}
	public void reflection() {
		speed=-20;
	}
	public void setPosition(int x,int y) {
		if(!visible) {
			this.x=x;
			this.y=y;
		}
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isDestroyed() {
		return destroyed;
	}
	public boolean isDestroyed2() {
		return destroyed2;
	}
	public void destroy() {
		
		destroyed=true;
	}
	public void destroy2() {
		destroyed2=true;
	}
	
	
	
	
	
	


}
