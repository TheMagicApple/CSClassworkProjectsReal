import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Bank.*;
public class Screen extends JPanel{
	AccountManager a;
	public Screen() {
		a=new AccountManager();
	}

	public Dimension getPreferredSize() {
		//Sets the size of the panel
        	return new Dimension(800,600);
	}
	public void paintComponent(Graphics g) {
		a.drawMe(g);
	}
}
