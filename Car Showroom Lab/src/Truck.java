import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Truck extends LargeCar{

	public Truck(Color bodyColor, int x, int y,int speed) {
		super(bodyColor, x, y,speed);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void drawFrame(Graphics g) {
		super.drawFrame(g);
		g.setColor(Color.black);
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		g.drawLine(getX()+30, getY()-3,getX()+35,getY()+40);
		g.drawLine(getX()+185, getY(), getX()+185, getY()-40);
		//g.setColor(Color.white);
		//g.drawLine(getX()+130,getY()-40,getX()+135,getY()-3);
		//g.drawLine(getX()+83,getY()-40,getX()+130,getY()-40);
		g.drawLine(getX()+35,getY()-40,getX()+82,getY()-40);
		g.drawLine(getX()+82,getY()-40,getX()+85,getY());
		
	}

}
