import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class ClientScreen extends JPanel implements MouseListener, MouseMotionListener,KeyListener,ActionListener{
	private int[][] grid;
	private int[][] colors=new int[][] {{0,0,0},{255,0,0},{0,255,0},{0,0,255}};
	private int selectedColor=0;
	boolean drawer=true;
	//public String word="ArrayList";
	public ArrayList<String> guesses=new ArrayList<>();
	private JTextField input;
	Client c;
	public ClientScreen() throws IOException {
		setLayout(null);
		grid=new int[16][16];
		guesses.add("dog");
		guesses.add("cat");
		guesses.add("hashmap");
		input=new JTextField();
		input.setBounds(200,500,200,50);
		input.addActionListener(this);
		add(input);
		c=new Client();
		c.connect();
	}
	public Dimension getPreferredSize(){
		return new Dimension(600,600);
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, 600, 600);
		g.setColor(Color.white);
		int x=200;
		int y=150;
		for(int a=0;a<grid.length;a++) {
			for(int b=0;b<grid[a].length;b++) {
				int[] color;
				//System.out.print(grid[a][b]);
				if(grid[a][b]==0) {
					color=new int[] {255,255,255};
				}else {
					
					color=colors[grid[a][b]-1];
				}
				g.setColor(new Color(color[0],color[1],color[2]));
				g.fillRect(x, y, 20, 20);
				g.setColor(Color.black);
				g.drawRect(x, y, 20, 20);
				x+=20;
			}
			//System.out.println();
			x=200;
			y+=20;
		}
		if(c.drawer) {
			drawCenteredString(g,"Word: "+c.word,new Rectangle(200,100,320,50),new Font("Arial",Font.PLAIN,20));
		}
		if(c.drawer) {
			input.setVisible(false);
		}
		y=200;
		for(String guess:guesses) {
			drawCenteredString(g,"User: "+guess,new Rectangle(50,y,100,30),new Font("Arial",Font.PLAIN,15));
			y+=30;
		}
	}
	public void animate() throws InterruptedException {
		while(true) {
			Thread.sleep(100);
			//System.out.println(c.grid);
			String[] g=c.grid.split(";");
			for(String ssssssss:g) {
				//System.out.println(ssssssss);
			}
			//System.out.println("LAST:"+g[15].charAt(15));
			for(int i=0;i<16;i++) {
				for(int j=0;j<g[i].length();j++) {
					grid[i][j]=(int)g[i].charAt(j)-48;
					//System.out.print(g[i].charAt(j)+" ");
				}
			}
			guesses=c.history;
			drawer=c.drawer;
		}
	}
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    g.setFont(font);
	    g.drawString(text, x, y);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
			int row=(int)Math.floor((y-150-30)/20.0);
			int column=(int)Math.floor((x-200-6)/20.0);
			if(row>=0 && row<grid.length && column>=0 && column<grid.length) {
				grid[row][column]=selectedColor+1;
				repaint();
			}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
			int row=(int)Math.floor((y-150-30)/20.0);
			int column=(int)Math.floor((x-200-6)/20.0);
			if(row>=0 && row<grid.length && column>=0 && column<grid.length) {
				grid[row][column]=selectedColor+1;
				String send="";
				for(int i=0;i<grid.length;i++) {
					for(int j=0;j<grid[i].length;j++) {
						send+=""+grid[i][j];
					}
					send+=";";
				}
				c.send(send);
				System.out.println("just sent: "+send);
				repaint();
			}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()-49>=0 && e.getKeyCode()-49<=8) {
			selectedColor=e.getKeyCode()-49;
		}
		if(e.getKeyChar()=='e') {
			selectedColor=-1;
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
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input) {
			//guesses.add(input.getText());
			c.send(input.getText());
		}
		repaint();
		
	}
}