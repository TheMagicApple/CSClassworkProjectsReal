import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Screen extends JPanel implements ActionListener{
	private JTextField n1;
	private JTextField n2;
	private JButton add;
	private JButton sub;
	private JButton mul;
	private JButton div;
	private String result="";
	private Component[] stuff={new JTextField(),new JTextField(),new JButton("+"),new JButton("-"),new JButton("x"),new JButton("/")};
	public Screen() {
		setLayout(null);
		int[][] c= {{125,100,50,50},{225,100,50,50},{125,200,50,50},{225,200,50,50},{125,300,50,50},{225,300,50,50}};
		for(int i=0;i<stuff.length;i++) {
			stuff[i].setBounds(c[i][0],c[i][1],c[i][2],c[i][3]);
			add(stuff[i]);
			if(stuff[i].getClass()==JButton.class) ((JButton) stuff[i]).addActionListener(this);
		}
		setVisible(true);
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400,400);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(result, 190,80);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Component cc=(Component) e.getSource();
		for(Component c:stuff) {
			if(c.equals(cc)) {
				if(c.getBounds().equals(stuff[2].getBounds())) {
					result=String.valueOf(Integer.parseInt(((JTextField) stuff[0]).getText())+Integer.parseInt(((JTextField) stuff[1]).getText()));
				}else if(c.getBounds().equals(stuff[3].getBounds())) {
					result=String.valueOf(Integer.parseInt(((JTextField) stuff[0]).getText())-Integer.parseInt(((JTextField) stuff[1]).getText()));
				}else if(c.getBounds().equals(stuff[4].getBounds())) {
					result=String.valueOf(Integer.parseInt(((JTextField) stuff[0]).getText())*Integer.parseInt(((JTextField) stuff[1]).getText()));
				}else if(c.getBounds().equals(stuff[5].getBounds())){
					result=String.valueOf(Integer.parseInt(((JTextField) stuff[0]).getText())/Double.parseDouble(((JTextField) stuff[1]).getText()));
				}
			}
		}
		repaint();
	}
}