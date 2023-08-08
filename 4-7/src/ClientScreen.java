import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientScreen extends JPanel implements ActionListener{
	
	Client client;
	JTextField input;
	public ClientScreen() throws IOException {
		setFocusable(true);
		client=new Client();
		client.connect();
		System.out.println("CONNECTED TO SERVER");
		setLayout(null);
		input=new JTextField();
		input.setBounds(100,200,100,50);
		add(input);
		input.addActionListener(this);
	}
	public Dimension getPreferredSize() {
		return new Dimension(300,300);
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 300, 300);
		g.setFont(new Font("Arial",Font.PLAIN,20));
		
		String[] images=client.images.get(client.location);
		int y=10;
		for(String image:images) {
			try {
				g.drawImage(ImageIO.read(new File(image)), 100,y,75,50,null);
				y+=50;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public void animate() throws InterruptedException {
		while(true) {
			Thread.sleep(100);
			repaint();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input) {
			System.out.println("GUESS");
			client.guess(input.getText());
		}
		
	}
	
}
