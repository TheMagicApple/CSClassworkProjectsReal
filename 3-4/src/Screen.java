import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


public class Screen extends JPanel implements MouseListener, ActionListener{
	private Game game;
	private boolean done=false;
	private boolean playerWin=false;
	private boolean computerWin=false;
	private JButton restart;
	public Screen() {
		game=new Game();
		restart=new JButton("Restart");
		restart.setBounds(250,20,100,30);
		//add(restart);
		restart.addActionListener(this);
	}



    
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(600, 600);
    }   



    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    	game.drawMe(g);
        if(done) {
        	add(restart);
        	if(playerWin) {
        		g.drawString("Player wins!", 100,570);
        	}else if(computerWin) {
        		g.drawString("Computer wins!", 20,570);
        	}else {
        		g.drawString("Tie!", 225,570);
        	}
        }


        

    }

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!done) {
			
		
		boolean played = false;
		//System.out.println(e.getX()+" "+e.getY());
		int x=e.getX();
		int y=e.getY();
		if(x>=108 && x<=235 && y>=131 && y<=255) {
			game.insertXO(0, 0);
            played = true;
		}
		if(x>=247 && x<=375 && y>=131 && y<=255) {
			game.insertXO(0, 1);
            played = true;
		}
		if(x>=386 && x<=505 && y>=131 && y<=255) {
			game.insertXO(0, 2);
            played = true;
		}
		if(x>=108 && x<=235 && y>=270 && y<=400) {
			game.insertXO(1, 0);
            played = true;
		}
		if(x>=247 && x<=375 && y>=270 && y<=400) {
			game.insertXO(1, 1);
            played = true;
		}
		if(x>=386 && x<=505 && y>=270 && y<=400) {
			game.insertXO(1, 2);
            played = true;
		}
		if(x>=108 && x<=235 && y>=408 && y<=523) {
			game.insertXO(2, 0);
            played = true;
		}
		if(x>=247 && x<=375 && y>=408 && y<=523) {
			game.insertXO(2, 1);
            played = true;
		}
		if(x>=386 && x<=505 && y>=408 && y<=523) {
			game.insertXO(2, 2);
            played = true;
		}

        if(played == true){
            if(game.checkTicTacToe()==1){
            	done=true;
            	playerWin=true;
            	//System.out.println("PLAYER WINS");
            }
            if(game.checkFull() && !done) {
            	done=true;
            	//System.out.println("TIE");
            }
            repaint();
            if(!done) {
            	game.computer();
            	repaint();
            	
            	
            }
            
            if(game.checkTicTacToe()==2){
            	done=true;
            	computerWin=true;
            	//System.out.println("COMPUTER WINS");
            }
            if(game.checkFull() && !done) {
            	done=true;
            	System.out.println("TIE");
            }
            
        }
		
		repaint();
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==restart) {
			//System.out.println("restart");
			game.restart();
			done=false;
			playerWin=false;
			computerWin=false;
			remove(restart);
			repaint();
			
			
		}
		repaint();
		
	}
}
