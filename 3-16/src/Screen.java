import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Screen extends JPanel{
	private Dog dog;
	private Bird bird;
	public Screen() {
		dog=new Dog("Fido");
		bird=new Bird("Tweety");
	}
	public Dimension getPreferredSize() {
		//Sets the size of the panel
		return new Dimension(800,600);
	}

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		dog.drawMe(g,300,300);
		g.drawString(dog.getName(), 300,270);
		bird.drawMe(g, 300, 500);
		g.drawString(bird.getName(), 300,470);
	}
	
	
}
