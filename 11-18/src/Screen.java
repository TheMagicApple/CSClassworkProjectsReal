import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Screen extends JPanel implements MouseListener{
	private MyArrayList<Circle> circles=new MyArrayList<>();
	private int timer=30;
	private int frameCounter=0;
	private int circlesLeft=20;
	Thread t;
	public Screen() {
		Animate a=new Animate(this);
		t=new Thread(a);
		t.start();
		for(int i=0;i<circlesLeft;i++) {
			Circle c=new Circle(500,500);
			Thread thread=new Thread(c);
			circles.add(c);
			thread.start();
		}
	}
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Circle circle:circles) {
			circle.drawMe(g);
			
		}
		frameCounter++;
		if(frameCounter%100==0) {
			timer--;
			if(timer<=0) {
				t.interrupt();
			}
		}
		
		if(timer<=0) {
			g.drawString("LOSER", 240,240);
		}
		if(circlesLeft<=0) {
			g.drawString("WINNER", 240,240);
			t.interrupt();
			
		}
		g.drawString(timer+" seconds left",20,20);
		g.drawString(circlesLeft+" bubbles left", 200,20);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
		for(int i=0;i<circles.size();i++) {
			if(Math.abs((circles.get(i).getX()+10)-x)<=40 && Math.abs((circles.get(i).getY()+10)-y)<=40) {
				try {
					circles.remove(i);
					
				}catch(ArrayIndexOutOfBoundsException eeeee) {
					
				}
				circlesLeft--;
				break;
			}
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
