import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Box {
	private BufferedImage car;
	public int x;
	public int y;
	public Box(int x,int y) throws IOException {
		this.x=x;
		this.y=y;
		car=ImageIO.read(new File("boxreal.png"));
	}
	public void drawMe(Graphics g) {
		g.drawImage(car, x, y, null);
	}
}
