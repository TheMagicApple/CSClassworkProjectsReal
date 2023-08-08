import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Button {
	public int x;
	public int y;
	public Vector[] remove;
	public Button(int x,int y,Vector[] remove) throws IOException {
		this.x=x;
		this.y=y;
		this.remove=remove;
	}
	public void drawMe(Graphics g) {
		g.setColor(new Color(255,26,0));
		g.fillOval(x, y, 30, 30);
		g.setColor(Color.black);
		//g.drawOval(x, y, 30, 30);
		g.setColor(new Color(224, 23, 0));
		g.fillOval(x+5, y+5, 20, 20);
		g.setColor(Color.black);
		//g.drawOval(x+5,y+5,20,20);
	}
}
