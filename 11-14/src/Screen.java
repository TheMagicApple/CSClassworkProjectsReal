import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener{
	private Player p;
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
		
	}
	public Screen() {
		p=new Player();
		p.x=100;
		p.y=100;
		try {
			ObjectInputStream o=new ObjectInputStream(new FileInputStream("save.dat"));
			p=(Player)o.readObject();
			o.close();
		}catch(FileNotFoundException e) {
			
		}catch(Exception e) {
			System.out.println("rip");
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect( p.x,p.y,50,50);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==37) {
			p.x-=5;
		}
		if(e.getKeyCode()==38) {
			p.y-=5;
		}
		if(e.getKeyCode()==39) {
			p.x+=5;
		}
		if(e.getKeyCode()==40) {
			p.y+=5;
		}
		ObjectOutputStream o;
		try {
			o = new ObjectOutputStream(new FileOutputStream("save.dat"));
			o.writeObject(p);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
