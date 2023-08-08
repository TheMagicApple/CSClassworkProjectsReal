import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;

public class Table extends JPanel implements ActionListener{
	private Card[] deck;
	private int playerCards;
	private JButton hit;
	private JButton stand;
	private JButton restart;
	private JButton betMore;
	
	private int y1=0;
	private int y2=-150;
	private int y3=-300;
	private int y4=-450;
	private int y5=-600;
	private int y6=-750;
	private int y7=-900;
	private int y8=-1050;
	private int x1=-200;
	private int x2=-100;
	private int x3=0;
	private int x4=100;
	private int x5=200;
	private int x6=300;
	private int x7=400;
	private int x8=500;
	private int points=20;
	
	private int totalValue=0;
	private boolean finished=false;
	private boolean winner=false;
	private boolean loser=false;
	private int wonPoints=0;
	private boolean animating=false;
	private boolean notWon=true;
	private boolean broke=false;
	private int streak=0;
	private int multiplier=1;
	private int moreMoney=1;
	public Table(){
		deck=new Card[52];
		deck[0]=new Card(2,"2","Hearts");
		deck[1]=new Card(3,"3","Hearts");
		deck[2]=new Card(4,"4","Hearts");
		deck[3]=new Card(5,"5","Hearts");
		deck[4]=new Card(6,"6","Hearts");
		deck[5]=new Card(7,"7","Hearts");
		deck[6]=new Card(8,"8","Hearts");
		deck[7]=new Card(9,"9","Hearts");
		deck[8]=new Card(10,"10","Hearts");
		deck[9]=new Card(10,"J","Hearts");
		deck[10]=new Card(10,"Q","Hearts");
		deck[11]=new Card(10,"K","Hearts");
		deck[12]=new Card(11,"A","Hearts");
		
		deck[13]=new Card(2,"2","Diamonds");
		deck[14]=new Card(3,"3","Diamonds");
		deck[15]=new Card(4,"4","Diamonds");
		deck[16]=new Card(5,"5","Diamonds");
		deck[17]=new Card(6,"6","Diamonds");
		deck[18]=new Card(7,"7","Diamonds");
		deck[19]=new Card(8,"8","Diamonds");
		deck[20]=new Card(9,"9","Diamonds");
		deck[21]=new Card(10,"10","Diamonds");
		deck[22]=new Card(10,"J","Diamonds");
		deck[23]=new Card(10,"Q","Diamonds");
		deck[24]=new Card(10,"K","Diamonds");
		deck[25]=new Card(11,"A","Diamonds");
		
		deck[26]=new Card(2,"2","Clubs");
		deck[27]=new Card(3,"3","Clubs");
		deck[28]=new Card(4,"4","Clubs");
		deck[29]=new Card(5,"5","Clubs");
		deck[30]=new Card(6,"6","Clubs");
		deck[31]=new Card(7,"7","Clubs");
		deck[32]=new Card(8,"8","Clubs");
		deck[33]=new Card(9,"9","Clubs");
		deck[34]=new Card(10,"10","Clubs");
		deck[35]=new Card(10,"J","Clubs");
		deck[36]=new Card(10,"Q","Clubs");
		deck[37]=new Card(10,"K","Clubs");
		deck[38]=new Card(11,"A","Clubs");
		
		deck[39]=new Card(2,"2","Spades");
		deck[40]=new Card(3,"3","Spades");
		deck[41]=new Card(4,"4","Spades");
		deck[42]=new Card(5,"5","Spades");
		deck[43]=new Card(6,"6","Spades");
		deck[44]=new Card(7,"7","Spades");
		deck[45]=new Card(8,"8","Spades");
		deck[46]=new Card(9,"9","Spades");
		deck[47]=new Card(10,"10","Spades");
		deck[48]=new Card(10,"J","Spades");
		deck[49]=new Card(10,"Q","Spades");
		deck[50]=new Card(10,"K","Spades");
		deck[51]=new Card(11,"A","Spades");
		
		
		playerCards=2;
		setLayout(null);
		
		hit=new JButton("HIT");
		stand=new JButton("STAND");
		restart=new JButton("New game");
		betMore=new JButton("bet MORE");
		hit.setBounds(10,140,100,30);
		stand.setBounds(120,140,100,30);
		restart.setBounds(290,20,200,60);
		betMore.setBounds(340,100,100,40);
		add(hit);
		add(stand);
		
		hit.addActionListener(this);
		stand.addActionListener(this);
		restart.addActionListener(this);
		betMore.addActionListener(this);
		shuffle();
		
		
          
        
		
	}
	
	public Dimension getPreferredSize() {
		//Sets the size of the panel
		return new Dimension(800,600);
	}

	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1000,600);
		if(broke) {
			g.setColor(Color.WHITE);
			remove(hit);
			remove(stand);
			g.setFont(new Font("Arial",Font.PLAIN,50));
			g.drawString("you ran out of money:(", 200, 200);
		}else {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial",Font.PLAIN,40));
			g.drawString("Cash: $"+points*100, 10,40);
			totalValue=0;
			for(int i=0;i<playerCards;i++) {
				totalValue+=deck[i].getValue();
			}
			if(totalValue==21 && notWon) {
				finished=true;
				winner=true;
				loser=false;
				
				streak++;
				multiplier+=streak-1;
				wonPoints=10*multiplier;
				points+=wonPoints;
				notWon=false;
			}
			if(totalValue>21 && !loser) {
				//EXTREMELY RARE DOUBLE ACE
				finished=true;
				winner=false;
				loser=true;
				multiplier=1;
				streak=0;
			}
			g.drawString("Value: "+totalValue, 10,80);
			g.drawString("Multiplier: "+multiplier, 10, 120);
			g.drawString("Streak: "+streak, 600,550);
			int x=20;
			int y=200;
			for(int i=0;i<playerCards;i++) {
				deck[i].drawMe(g,x ,y );
				x+=100;
			}
			g.setFont(new Font("Arial",Font.PLAIN,40));
			if(finished) {
				add(restart);
				add(betMore);
				
				
				remove(hit);
				remove(stand);
				if(winner) {
					//System.out.println("winner!");
					
					
					if(!animating) {
						animating=true;
					}
					g.setColor(Color.GREEN);
					if(wonPoints==10) {
						g.drawString("JACKPOT!!!!!!!!!!!!!!", 500, 50);
					}else {
						g.drawString("WINNER!!!!", 500, 50);
					}
					
					g.drawString("You won $"+wonPoints*100, 500, 100);
					BufferedImage checkmark=null;
					try {
						checkmark=ImageIO.read(new File("src/moneyrealreal.png"));
					}catch(IOException e) {
						System.out.println("could not load checkmark");
					}
					
					
					
					g.drawImage(checkmark,x1,y1,null);
					g.drawImage(checkmark,x2,y2,null);
					g.drawImage(checkmark,x3,y3,null);
					g.drawImage(checkmark,x4,y4,null);
					g.drawImage(checkmark,x5,y5,null);
					g.drawImage(checkmark,x6,y6,null);
					g.drawImage(checkmark,x7,y7,null);
					g.drawImage(checkmark,x8,y8,null);
					g.drawImage(checkmark,400-x1,y1,null);
					g.drawImage(checkmark,400-x2,y2,null);
					g.drawImage(checkmark,400-x3,y3,null);
					g.drawImage(checkmark,400-x4,y4,null);
					g.drawImage(checkmark,400-x5,y5,null);
					g.drawImage(checkmark,400-x6,y6,null);
					g.drawImage(checkmark,400-x7,y7,null);
					g.drawImage(checkmark,400-x8,y8,null);
					
					
					//System.out.println(x);
					
					
				}
				if(loser) {
					
					g.setColor(Color.RED);
					g.drawString("LOSER", 550, 80);
					BufferedImage emoji=null;
					try {
						emoji=ImageIO.read(new File("src/emoji.png"));
					}catch(IOException e) {
						System.out.println("could not load emoji");
					}
					
					g.drawImage(emoji,500,100,null);
					
					
					
					
				}
			}
		}
		
	
	}
	


	private void shuffle(){
		for(int i=0;i<deck.length;i++) {
			int choice=(int)(Math.random()*deck.length);
			Card temp=deck[i];
			deck[i]=deck[choice];
			deck[choice]=temp;
		}
	
	}
	public void animate() {
		while(true) {
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				System.out.println("uh oh...");
			}
			if(animating) {
				int speed=25;
				y1+=speed;
				y2+=speed;
				y3+=speed;
				y4+=speed;
				y5+=speed;
				y6+=speed;
				y7+=speed;
				y8+=speed;
				/*
				x1+=(int)(Math.random()*100-50);
				x2+=(int)(Math.random()*100-50);
				x3+=(int)(Math.random()*100-50);
				x4+=(int)(Math.random()*100-50);
				x5+=(int)(Math.random()*100-50);
				x6+=(int)(Math.random()*100-50);
				x7+=(int)(Math.random()*100-50);
				x8+=(int)(Math.random()*100-50);
			
				if(x1>800)x1=0;
				if(x2>800)x2=0;
				if(x3>800)x3=0;
				if(x4>800)x4=0;
				if(x5>800)x5=0;
				if(x6>800)x6=0;
				if(x7>800)x7=0;
				if(x8>800)x8=0;
				if(x1<0)x1=800;
				if(x2<0)x2=800;
				if(x3<0)x3=800;
				if(x4<0)x4=800;
				if(x5<0)x5=800;
				if(x6<0)x6=800;
				if(x7<0)x7=800;
				if(x8<0)x8=800;
				*/
			}
			if(y1>700) {
				y1=-500;
			}
			if(y2>700) {
				y2=-500;
			}
			if(y3>700) {
				y3=-500;
			}
			if(y4>700) {
				y4=-500;
			}
			if(y5>700) {
				y5=-500;
			}
			if(y6>700) {
				y6=-500;
			}
			if(y7>700) {
				y7=-500;
			}
			if(y8>700) {
				y8=-500;
			}
			
			//System.out.println(x);
			repaint();
		}
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==hit) {
			
			playerCards++;
			if(totalValue+deck[playerCards-1].getValue()==21) {
				winner=true;
				loser=false;
				finished=true;
				
				streak++;
				multiplier+=streak-1;
				wonPoints=10*multiplier;
				points+=wonPoints;
			}
			if(totalValue+deck[playerCards-1].getValue()>21 && !loser) {
				//System.out.println("loser");
				loser=true;
				multiplier=1;
				streak=0;
				winner=false;
				finished=true;
			}
			
			/*
			if(totalValue>21) {
				System.out.println("loser");
				loser=true;
				winner=false;
				finished=true;
				
			}
			*/
			
			repaint();
		}
		if(e.getSource()==stand) {
			finished=true;
			
			if(totalValue<16) {
				loser=true;
				winner=false;
				multiplier=1;
				//System.out.println("less than 16");
			}else {
				winner=true;
				loser=false;
				streak++;
				multiplier+=streak-1;
				if(totalValue==16 || totalValue==17) {
					wonPoints=1*multiplier;
				}else if(totalValue==18 || totalValue==19) {
					wonPoints=2*multiplier;
				}else if(totalValue==20) {
					wonPoints=3*multiplier;
					
				}else {
					System.out.println("this should not be happening. (stand with more than 21 points)");
				}
				points+=wonPoints;
			}
			repaint();
		}
		if(e.getSource()==restart) {
			points-=1*moreMoney;
			moreMoney=1;
			if(points<0) {
				broke=true;
			}
			playerCards=2;
			shuffle();
			winner=false;
			loser=false;
			finished=false;
			remove(restart);
			remove(betMore);
			add(hit);
			add(stand);
			animating=false;
			notWon=true;
			repaint();
			
			
			
		}
		if(e.getSource()==betMore) {
			multiplier++;
			moreMoney++;
		}
		
	}
	
	
}
