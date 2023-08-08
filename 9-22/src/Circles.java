import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Circles extends JPanel {
	private int x, y;

	public Circles() {
		//(1) What is imported to get Graphics to work?
		x = 300;
		y = 200;
	}

	@Override
	public Dimension getPreferredSize() {
		//Sets the size of the panel
		return new Dimension(800,600);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//(2) In the paintComponent method, what do you think it is drawing?
		Color colorRed = new Color(0,255,0);
		g.setColor(colorRed);
		g.fillOval(x,y,100,100);
		g.setColor(new Color(165,42,42));
		g.fillRect(325,290,50,100);
	}
}

