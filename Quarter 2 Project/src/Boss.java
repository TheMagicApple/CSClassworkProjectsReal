import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
public class Boss {
	private int x=200;
	private int y=200;
	private int goX;
	private int goY;
	private double moveX;
	private double moveY;
	private Random r=new Random();
	public int health=10;
	private int width;
	private int height;
	private Image image;
	private Color blue;
	private int move=3;
	private int moveTimer=-1;
	private boolean gone=false;
	private int charging=0;
	private boolean usedWall=false;
	public boolean backUp=false;
	private boolean backingUp=false;
	public boolean alreadyCharged=false;
	public Boss(){
		
		
		try {
			image=ImageIO.read(new File("boss.png"));
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
		if(moveTimer==-1) {
			moveX=movemoveX();
			moveY=movemoveY();
			//System.out.println(moveX);
			//System.out.println(moveY);
			moveTimer=50;
		}else if(backUp==true && backingUp==false) {
			backUp=false;
			backingUp=true;
			moveX=5;
			moveY=0;
			moveTimer=70;
			//System.out.println(backingUp);
		}else if(moveTimer>0 && (charging==0 || backingUp==true)){
			x+=moveX;
			y+=moveY;
			moveTimer--;
		}else {
			moveTimer=-1;
			backingUp=false;
			alreadyCharged=false;
		}
		if(charging>0 && backingUp==false) {
			if(charging>5) {
				
			}else {
				x-=100;
			}
			
			charging--;
		}
		if(x<-200) {
			//System.out.println("teleport");
			x=600;
		}
		/*
		if(x>600) {
			//System.out.println("teleport");
			x=-200;
		}
		*/
		if(y<-200) {
			//System.out.println("teleport");
			y=500;
		}
		if(y>500) {
			//System.out.println("teleport");
			y=-200;
		}
		
		int attack=r.nextInt(500);
		//System.out.println(attack);
		if(attack==0 && usedWall==false) {
			//System.out.println("boss wall");
			Screen.bossWall();
		}
		if(health==1 && usedWall==false) {
			usedWall=true;
			//System.out.println("WALL");
			Screen.ultraBossWall();
			
		}
		//5% chance
		if(attack>=1 && attack<=2) {
			charging=50;
		}
		
		
	}
	public int movemoveX() {
		int thing;
		if(x>400) {
			thing=r.nextInt(5)-5;
		}else if(x<200) {
			thing=r.nextInt(5);
		}else {
			thing=r.nextInt(11)-5;
		}
		return thing;	
	}
	public int movemoveY() {
		int thing;
		if(y>400) {
			thing=r.nextInt(5)-5;
		}else if(y<200) {
			thing=r.nextInt(5);
		}else {
			thing=r.nextInt(11)-5;
		}
		return thing;	
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
	public void hurt() {
		health-=1;
		if(health==1) {
			//System.out.println("DIE");
			Screen.retaliation=true;
		}
		if(health==0) {
			die();
		}
	}
	public void die() {
		
		Thread thread=new Thread() {
			public void run() {
				try {
					image=ImageIO.read(new File("explosion3.png"));
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
					image=ImageIO.read(new File("explosion3.png"));
					//x-=25;
					//y-=25;
					
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
					//x-=25;
					//y-=25;
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
		Screen.winner=true;
		
	}
	public boolean isDead() {
		return gone;
	}
	
	
}

