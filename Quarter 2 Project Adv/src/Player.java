import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private BufferedImage car;
	public int x;
	public int y;
	public Player(int x,int y) throws IOException {
		this.x=x;
		this.y=y;
		car=ImageIO.read(new File("blobsupermegarealreal.png"));
	}
	public void drawMe(Graphics g) {
		g.drawImage(car, x, y, null);
	}
}
