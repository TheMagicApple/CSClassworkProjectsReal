import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Boat{
	private int ogX;
	private int ogY;
	private int destinationX;
	private int destinationY;
	private String direction;
	private int speed;
	private BufferedImage i;
	private boolean inThisBoat;
	public Boat(int ogX,int ogY,int destinationX,int destinationY,String direction,int speed) {
		this.ogX=ogX;
		this.ogY=ogY;
		this.destinationX=destinationX;
		this.destinationY=destinationY;
		this.direction=direction;
		this.speed=speed;
		inThisBoat=false;
		try {
			i=ImageIO.read(new File("src/boat.png"));
		}catch(IOException e) {
			System.out.println("could not load boat image");
		}
	}
	public int[] destination() {
		int[] destiny=new int[2];
		destiny[0]=destinationX;
		destiny[1]=destinationY;
		return destiny;
	}
	public int oX() {
		return ogX;
	}
	public int oY() {
		return ogY;
	}
	public void getIn() {
		inThisBoat=true;
	}
	public void getOut() {
		inThisBoat=false;
	}
	public void reset() {
		
	}
	public boolean inBoat() {
		return inThisBoat;
	}
	public int getSpeed() {
		return speed;
	}
	public void drawMe(Graphics g,int x,int y) {
		if(inThisBoat) {
			g.drawImage(i,220,220,null);
		}else {
			g.drawImage(i,x+ogX, y+ogY,null);
		}
	}
}
