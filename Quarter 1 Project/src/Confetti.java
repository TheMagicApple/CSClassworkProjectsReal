import java.awt.Color;
import java.awt.Graphics;

public class Confetti {
	private int speed;
	private Color color;
	private int x;
	private int y;
	private Color[] colors= {Color.red,Color.orange,Color.green,Color.yellow,Color.blue,Color.pink};
	public Confetti() {
		speed=(int)(Math.random()*10+5);
		color=colors[(int)(Math.random()*colors.length)];
		x=(int)(Math.random()*500);
		y=(int)(Math.random()*100-200);
	}
	public void move() {
		y+=speed;
		if(y>550) {
			y=(int)(Math.random()*100-200);
		}
	}
	public void drawMe(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 10,10);
	}
}
