import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChattyScreen extends JPanel implements ActionListener{
	public ChattyClient client;
	public JTextField input;
	public JButton send;
	public ChattyScreen() throws IOException {
		client=new ChattyClient();
		client.connect();
		System.out.println("CONNECTED TO SERVER");
		setLayout(null);
		input=new JTextField();
		input.setBounds(200,400,200,50);
		input.addActionListener(this);
		add(input);
	}
	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}
	public void paintComponent(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, 600, 600);
		int y=50;
		int x=100;
		g.setColor(new Color(0,0,0));
		if(client!=null && client.history!=null) {
			for(String[] message:client.history) {
				drawCenteredString(g,message[0]+": "+message[1], new Rectangle(0,y,600,y+30),new Font("Arial",Font.PLAIN,20));
				y+=20;
			}
		}
		
	}
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    g.setFont(font);
	    g.drawString(text, x, y);
	}
	public void animate() throws InterruptedException {
		while(true) {
			Thread.sleep(100);
			repaint();
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input) {
			client.send(input.getText());
			input.setText("");
		}
		repaint();
	}
	
}
