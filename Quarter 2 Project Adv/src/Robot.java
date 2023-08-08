import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Robot implements Runnable{
	private BufferedImage car;
	public int x;
	public int y;
	public Vector[] remove;
	public Robot(int x,int y,Vector[] remove) throws IOException {
		this.x=x;
		this.y=y;
		car=ImageIO.read(new File("key.png"));
		this.remove=remove;
	}
	public void drawMe(Graphics g) {
		g.drawImage(car, x, y, null);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.interrupted()) {
			int direction=(int)(Math.random()*4);
			if(direction==0) {
				x+=20;
			}
			if(direction==1) {
				x-=20;
			}
			if(direction==2) {
				y+=20;
			}
			if(direction==3) {
				y-=20;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				//in tur up t th thred
			}
			
		}
	}
	
}
