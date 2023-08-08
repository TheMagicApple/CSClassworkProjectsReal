import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class SmallCar extends Automobile{
	public SmallCar(Color bodyColor,int x,int y,int speed) {
		super(bodyColor,x,y,speed);
	}
	@Override
	public void drawFrame(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(6));
		g.setColor(Color.black);
		g.drawRect(getX(), getY(), 100,20);
		g.setColor(getBodyColor());
		g.fillRect(getX(), getY(), 100,20);
		g2.setStroke(new BasicStroke(3));
		g.setColor(Color.black);
		g.drawLine(getX()+20, getY()-3,getX()+25,getY()-20);
		g.drawLine(getX()+25,getY()-20,getX()+80,getY()-20);
		g.drawLine(getX()+80,getY()-20,getX()+85,getY()-3);
		g.drawLine(getX()+52,getY()-20,getX()+52,getY()-3);
		g2.setStroke(new BasicStroke(6));
		g.drawOval(getX()-6, getY()+5, 7, 7);
		g.setColor(new Color(246, 255, 0));
		g.fillOval(getX()-6, getY()+5, 7, 7);
	}
	@Override
	public void drawWheels(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(getX()+20, getY()+13, 20, 20);
		g.fillOval(getX()+70, getY()+13, 20, 20);
	}
}
