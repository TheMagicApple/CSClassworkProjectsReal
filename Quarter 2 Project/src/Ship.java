import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.util.concurrent.TimeUnit;
public class Ship{
	private int x;
	private int y;
	public int health=5;
	private int width;
	private int height;
	private Image image;
	private Color blue;
	int counter=0;
	public Ship(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
		
		this.blue = new Color(0,0,255);
		try {
			image=ImageIO.read(new File("bow5.png"));
		}catch(IOException e) {
			System.out.println("could not load bow image");
		}

	}
	
	public void animation() {
		Thread thread=new Thread() {
			public void run() {
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {
					System.out.println("uh oh...");
				}
				try {
					image=ImageIO.read(new File("bow2.png"));
				}catch(IOException e) {
					System.out.println("could not load bow image");
				}
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {
					System.out.println("uh oh...");
				}
				try {
					image=ImageIO.read(new File("bow3.png"));
				}catch(IOException e) {
					System.out.println("could not load bow image");
				}
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {
					System.out.println("uh oh...");
				}
				try {
					image=ImageIO.read(new File("bow4.png"));
				}catch(IOException e) {
					System.out.println("could not load bow image");
				}
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {
					System.out.println("uh oh...");
				}
				try {
					image=ImageIO.read(new File("bow1.png"));
				}catch(IOException e) {
					System.out.println("could not load bow image");
				}
			}
		};
		thread.start();
		/*
		try{
			Thread.sleep(200);
		}catch(InterruptedException e) {
			System.out.println("uh oh...");
		}
		try {
			if(counter==0) {
				image=ImageIO.read(new File("bow2.png"));
			}else if(counter==1) {
				image=ImageIO.read(new File("bow3.png"));
			}else if(counter==2) {
				image=ImageIO.read(new File("bow4.png"));
			}
			counter++;
			
		}catch(IOException e) {
			System.out.println("could not load bow image");
		}
		if(counter<3) {
			animation();
		}
		*/
		
	}
	public void hurt(int damage) {
		health-=damage;
		if(health<=0) {
			//System.out.println("dead");
			Screen.dead=true;
		}
	}
	public void drawMe(Graphics g){
		g.drawImage(image, x, y,null);
		//g.setColor(blue);
		//g.fillRect(x,y,width,height);
	}
	public void moveUp() {
		y=y-5;
	}
	public void moveDown() {
		y+=5;
	}
	public void dash() {
		y-=30;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x=x;
	}
}