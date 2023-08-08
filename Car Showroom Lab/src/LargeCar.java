import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class LargeCar extends Automobile{
	
	public LargeCar(Color bodyColor, int x, int y,int speed) {
		super(bodyColor, x, y,speed);
		
	}

	@Override
	public void drawFrame(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(6));
		g.setColor(Color.black);
		g.drawRect(getX(), getY(), 185,50);
		g.setColor(getBodyColor());
		g.fillRect(getX(), getY(), 185,50);
		g2.setStroke(new BasicStroke(3));
		g.setColor(Color.black);
		g.drawLine(getX()+30, getY()-3,getX()+35,getY()-40);
		//g.drawLine(getX()+35,getY()-40,getX()+130,getY()-40);
		//g.drawLine(getX()+130,getY()-40,getX()+135,getY()-3);
		//g.drawLine(getX()+83,getY()-40,getX()+83,getY()-3);
		g2.setStroke(new BasicStroke(6));
		g.drawOval(getX()-7, getY()+2, 10, 10);
		g.drawOval(getX()-7, getY()+19, 10, 10);
		g.drawOval(getX()-7, getY()+36, 10, 10);
		g.setColor(new Color(246, 255, 0));
		g.fillOval(getX()-7, getY()+2, 10, 10);
		g.fillOval(getX()-7, getY()+19, 10, 10);
		g.fillOval(getX()-7, getY()+36, 10, 10);
	}

	@Override
	public void drawWheels(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillOval(getX()+20, getY()+30, 40, 40);
		g.fillOval(getX()+115, getY()+30, 40, 40);
		
	}
	
}
