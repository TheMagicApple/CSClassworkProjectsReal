import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Scenery extends JPanel {
	@Override
	public Dimension getPreferredSize() {
		
		return new Dimension(800,800);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(253, 94, 83));
		g.fillRect(0,0,800,800);
		g.setColor(new Color(253,184,19));
		g.fillOval(300,100,100,100);
		g.setColor(new Color(128, 128, 128));
		g.fillPolygon(new int[] {0, 200, 400,600,800}, new int[] {400, 0, 400,0,400}, 5);
		g.setColor(new Color(255,255,255,100));
		g.fillOval(50,50,200,100);
		g.fillOval(350,20,200,100);
		g.fillOval(650,50,100,50);
		g.setColor(new Color(100,42,42));
		g.fillRect(0,400,800,300);
		g.setColor(new Color(100	,0,200));
		g.fillOval(0,400,800,300);
		g.setColor(new Color(165,42,42));
		g.fillRect(25, 375, 20, 50);
		g.fillRect(700,375,20,50);
		g.fillRect(20, 600, 20, 50);
		g.setColor(new Color(1, 121, 111));
		g.fillPolygon(new int[] {10, 35, 60}, new int[] {400, 340, 400},3);
		g.fillPolygon(new int[] {685, 710, 735}, new int[] {400, 340, 400},3);
		g.fillPolygon(new int[] {5, 30, 55}, new int[] {625, 565, 625},3);

		
	}
}

