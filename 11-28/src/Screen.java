import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;
public class Screen extends JPanel{
	MyHashTable<Vector,String> table=new MyHashTable<>();
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}
	public Screen() {
		for(int i=0;i<10;i++) {
			for(int k=0;k<10;k++) {
				Vector v=new Vector();
				v.add(i);
				v.add(k);
				if(i>=2 && i<=6 && k>=3 && k<=7) {
					table.put(v, "land");
					int choice=(int)(Math.random()*5);
					if(choice==0) {
						table.put(v, "tree");
					}else if(choice==1) {
						table.put(v,"treasure");
					}
				}else {
					table.put(v, "water");
				}
				
			}
			
			
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		DLList<Vector> m=table.keySet().toDLList();
		for(int i=0;i<m.size();i++) {
			Vector v=m.get(i);
			DLList<String> square=table.get(v);
			String first=square.get(0);
			
			if(first.equals("water")) {
				g.setColor(Color.blue);
			}
			if(first.equals("land")) {
				g.setColor(Color.orange);
			}
			g.fillRect((int)v.get(0)*50,(int)v.get(1)*50, 50,50);
			if(square.size()>1) {
				if(square.get(1).equals("tree")) {
					g.setColor(Color.green);
					g.setFont(new Font("Arial",Font.PLAIN,25));
					g.drawString("T", (int)v.get(0)*50,(int)v.get(1)*50);
				}
				if(square.get(1).equals("treasure")) {
					g.setColor(Color.yellow);
					g.fillOval((int)v.get(0)*50,(int)v.get(1)*50,20,20);
				}
			}
			
			
		}
	}
}
