import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Enemy {
	private int x;
	private int y;
	
	private int width;
	private int height;
	private Image image;
	private Color blue;
	private int move=3;
	private boolean gone=false;
	private boolean dead=false;
	public Enemy(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 25;
		this.height = 25;
		
		this.blue = new Color(255,0,0);
		try {
			image=ImageIO.read(new File("targettarget.png"));
		}catch(IOException e) {
			System.out.println("could not load enemy image");
		}

	}
	

	public void drawMe(Graphics g){
		if(!gone) {
			g.drawImage(image,x,y,null);
			g.setColor(blue);
		}else {
			g.setColor(new Color(0,0,0,0));
			g.fillRect(x,y,width,height);
		}
			
		/*
			g.setColor(new Color(0,0,0,0));
			g.fillRect(x,y,width,height);
		*/
		
		
	
	}
	public boolean isDeadreal() {
		return dead;
	}
	public void moveUp() {
		y=y-5;
	}
	public void moveDown() {
		y+=3;
	}
	public void flip() {
		move*=-1;
	}
	public void movemove() {
		y+=move;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void setPos(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void die() {
		Thread thread=new Thread() {
			public void run() {
				dead=true;
				try {
					image=ImageIO.read(new File("explosiona.png"));
					x=x+100;
					y=y+70;
				}catch(IOException e) {
					System.out.println("could not load arrow image");
				}
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {
					System.out.println("uh oh...");
				}
				try {
					image=ImageIO.read(new File("explosion2.png"));
					x-=25;
					y-=25;
					
				}catch(IOException e) {
					System.out.println("could not load arrow image");
				}
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {
					System.out.println("uh oh...");
				}
				try {
					image=ImageIO.read(new File("explosion3.png"));
					x-=25;
					y-=25;
				}catch(IOException e) {
					System.out.println("could not load arrow image");
				}
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {
					System.out.println("uh oh...");
				}
				gone=true;
			}
			
		};
		thread.start();
		
	}
	public boolean isDead() {
		return gone;
	}
	
	
}
