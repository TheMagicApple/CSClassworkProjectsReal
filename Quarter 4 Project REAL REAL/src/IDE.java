import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;

public class IDE extends JPanel implements MouseListener, KeyListener{
	//-------VARIABLES-----------
	private ArrayList<String>[] code=new ArrayList[10];
	ArrayList<String> codeLine=new ArrayList<>();
	private int currentLine=-1;
	//---------------------------
	//-------CONSTRUCTOR---------
	public IDE() {
		setLayout(null);
	}
	//----------------------------
	//--------DIMENSIONS-----------
	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}
	//----------------------------
	//------PAINTCOMPONENT--------
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
		int y=100;
		g.setColor(Color.BLACK);
		for(int i=0;i<code.length;i++) {
			if(code[i]!=null) {
				String line="";
				for(String s:code[i]) {
					line+=s;
				}
				System.out.println(line);
				g.drawString(line, 100,y);
				y+=20;
			}
			
		}
	}
	//----------------------------
	//---------MOUSE--------------
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//-----------------------------
	//----------KEY----------------
	@Override
	public void keyPressed(KeyEvent e) {
			
		if(e.getKeyCode()>=65 && e.getKeyCode()<=90) {
				codeLine.add(Character.toString(e.getKeyChar()));
				//System.out.println(codeLine);
				code[currentLine]=(ArrayList<String>) codeLine.clone();
			}
			if(e.getKeyCode()==32) {
				codeLine.add(" ");
				code[currentLine]=(ArrayList<String>) codeLine.clone();
			}
			if(e.getKeyCode()==8) {
				codeLine.remove(codeLine.size()-1);
				code[currentLine]=(ArrayList<String>) codeLine.clone();
			}
			if(e.getKeyCode()==10) {
				
				codeLine.clear();
				currentLine++;
				code[currentLine]=new ArrayList<String>();
			}
			System.out.println(e.getKeyCode());
			repaint();
		
		
	}
	//-----------------------------
	//------------END--------------
	//------------END--------------
	//------------END--------------
	
	
	
	
	
	
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
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
