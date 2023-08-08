import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Screen extends JPanel{
	private static Square[] mySquares=new Square[10];
	private static Circle[] myCircles=new Circle[10];
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	@Override
	public void paintComponent(Graphics g) {
		for(int i=0;i<mySquares.length;i++) {
			
			mySquares[i]=new Square((int)(Math.random()*780),(int)(Math.random()*580));
		}
		for(int i=0;i<myCircles.length;i++) {
			
			myCircles[i]=new Circle((int)(Math.random()*780),(int)(Math.random()*580));
		}
		for(int i=0;i<mySquares.length;i++) {
			if(mySquares[i]!=null) {
				mySquares[i].drawMe(g);
			}
			
		}
		for(int i=0;i<myCircles.length;i++) {
			if(myCircles[i]!=null) {
				myCircles[i].drawMe(g);
			}
			
		}
	}
	
}
