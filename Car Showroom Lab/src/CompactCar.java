import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CompactCar extends SmallCar{

	public CompactCar(Color bodyColor, int x, int y,int speed) {
		super(bodyColor, x, y,speed);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void drawFrame(Graphics g) {
		super.drawFrame(g);
		g.setColor(Color.black);
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		g.drawLine(getX()+20, getY()-3,getX()+25,getY()+20);
		g.drawLine(getX()+85,getY()-3,getX()+80,getY()+30);
	}

}
