import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NPC {
	private BufferedImage car;
	public int x;
	public int y;
	public String dialog;
	public NPC(int x,int y,String dialog,int level) throws IOException {
		this.x=x;
		this.y=y;
		this.dialog=dialog;
		
		
		car=ImageIO.read(new File("npc.png"));
		if(level==3 || level==7) {
			car=ImageIO.read(new File("robot.png"));
		}
	}
	public void drawMe(Graphics g) {
		g.drawImage(car, x, y, null);
	}
}
