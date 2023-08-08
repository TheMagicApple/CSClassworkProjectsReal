import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JPanel;

public class ClientScreen extends JPanel implements MouseListener{
	
	TicTacClient client;
	public ClientScreen() throws IOException {
		client=new TicTacClient();
		client.connect();
		System.out.println("CONNECTED TO SERVER");
	}
	public Dimension getPreferredSize() {
		return new Dimension(300,300);
	}
	public void paintComponent(Graphics g) {
		g.setFont(new Font("Arial",Font.PLAIN,20));
		int[][] grid=client.game.grid;
		int winner=checkWinner(grid);
		if(winner==1) {
			g.drawString("CLIENT WINS!", 100,100);
		}
		if(winner==2) {
			g.drawString("SERVER WINS!", 100,100);
		}
		g.setFont(new Font("Arial",Font.PLAIN,40));
		
		int x=0;
		int y=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				String s="";
				if(grid[i][j]==1) {
					s="X";
				}
				if(grid[i][j]==2) {
					s="O";
				}
				g.drawString(s, x+20, y+40);
				x+=100;
			}
			x=0;
			y+=100;
		}
	}
	public int checkWinner(int[][] g) {
		if(g[0][0]==1 && g[0][1]==1 && g[0][2]==1) {
			return 1;
		}
		if(g[1][0]==1 && g[1][1]==1 && g[1][2]==1) {
			return 1;
		}
		if(g[2][0]==1 && g[2][1]==1 && g[2][2]==1) {
			return 1;
		}
		if(g[0][0]==1 && g[1][0]==1 && g[2][0]==1) {
			return 1;
		}
		if(g[0][1]==1 && g[1][1]==1 && g[2][1]==1) {
			return 1;
		}
		if(g[0][2]==1 && g[1][2]==1 && g[2][2]==1) {
			return 1;
		}
		if(g[0][0]==1 && g[1][1]==1 && g[2][2]==1) {
			return 1;
		}
		if(g[0][2]==1 && g[1][1]==1 && g[2][0]==1) {
			return 1;
		}
		
		if(g[0][0]==2 && g[0][1]==2 && g[0][2]==2) {
			return 2;
		}
		if(g[1][0]==2 && g[1][1]==2 && g[1][2]==2) {
			return 2;
		}
		if(g[2][0]==2 && g[2][1]==2 && g[2][2]==2) {
			return 2;
		}
		if(g[0][0]==2 && g[1][0]==2 && g[2][0]==2) {
			return 2;
		}
		if(g[0][1]==2 && g[1][1]==2 && g[2][1]==2) {
			return 2;
		}
		if(g[0][2]==2 && g[1][2]==2 && g[2][2]==2) {
			return 2;
		}
		if(g[0][0]==2 && g[1][1]==2 && g[2][2]==2) {
			return 2;
		}
		if(g[0][2]==2 && g[1][1]==2 && g[2][0]==2) {
			return 2;
		}
		return 0;
	}
	public void animate() throws InterruptedException {
		while(true) {
			Thread.sleep(100);
			repaint();
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		client.play(e.getY()/100,e.getX()/100);
		
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
