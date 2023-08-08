import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;

public class Screen extends JPanel implements MouseListener{
	private DLList<Card> deck;
	private DLList<Card> player;
	private int points=50;
	private boolean insideScreen=true;
	private Font font;
	private Font fontSmall;
	private Font fontMid;
	private Font fontSmallSmall;
	private boolean[] hold;
	private int stage=1;
	private int pointsWon=0;
	private Confetti[] confetti=new Confetti[10000];
	public Screen() throws FontFormatException, IOException {
		confetti=new Confetti[10000];
		for(int i=0;i<confetti.length;i++) {
			confetti[i]=new Confetti();
		}
		
		
		deck=new DLList<>();
		player=new DLList<>();
		//deck.add(new Node<Card>(new Card(1,"A","hearts")));
		deck.add(new Node<Card>(new Card(2,"2","hearts")));
		deck.add(new Node<Card>(new Card(3,"3","hearts")));
		deck.add(new Node<Card>(new Card(4,"4","hearts")));
		deck.add(new Node<Card>(new Card(5,"5","hearts")));
		deck.add(new Node<Card>(new Card(6,"6","hearts")));
		deck.add(new Node<Card>(new Card(7,"7","hearts")));
		deck.add(new Node<Card>(new Card(8,"8","hearts")));
		deck.add(new Node<Card>(new Card(9,"9","hearts")));
		deck.add(new Node<Card>(new Card(10,"10","hearts")));
		deck.add(new Node<Card>(new Card(11,"J","hearts")));
		deck.add(new Node<Card>(new Card(12,"Q","hearts")));
		deck.add(new Node<Card>(new Card(13,"K","hearts")));
		deck.add(new Node<Card>(new Card(14,"A","hearts")));
		
		//deck.add(new Node<Card>(new Card(1,"A","spades")));
		deck.add(new Node<Card>(new Card(2,"2","spades")));
		deck.add(new Node<Card>(new Card(3,"3","spades")));
		deck.add(new Node<Card>(new Card(4,"4","spades")));
		deck.add(new Node<Card>(new Card(5,"5","spades")));
		deck.add(new Node<Card>(new Card(6,"6","spades")));
		deck.add(new Node<Card>(new Card(7,"7","spades")));
		deck.add(new Node<Card>(new Card(8,"8","spades")));
		deck.add(new Node<Card>(new Card(9,"9","spades")));
		deck.add(new Node<Card>(new Card(10,"10","spades")));
		deck.add(new Node<Card>(new Card(11,"J","spades")));
		deck.add(new Node<Card>(new Card(12,"Q","spades")));
		deck.add(new Node<Card>(new Card(13,"K","spades")));
		deck.add(new Node<Card>(new Card(14,"A","spades")));
		
		//deck.add(new Node<Card>(new Card(1,"A","clubs")));
		deck.add(new Node<Card>(new Card(2,"2","clubs")));
		deck.add(new Node<Card>(new Card(3,"3","clubs")));
		deck.add(new Node<Card>(new Card(4,"4","clubs")));
		deck.add(new Node<Card>(new Card(5,"5","clubs")));
		deck.add(new Node<Card>(new Card(6,"6","clubs")));
		deck.add(new Node<Card>(new Card(7,"7","clubs")));
		deck.add(new Node<Card>(new Card(8,"8","clubs")));
		deck.add(new Node<Card>(new Card(9,"9","clubs")));
		deck.add(new Node<Card>(new Card(10,"10","clubs")));
		deck.add(new Node<Card>(new Card(11,"J","clubs")));
		deck.add(new Node<Card>(new Card(12,"Q","clubs")));
		deck.add(new Node<Card>(new Card(13,"K","clubs")));
		deck.add(new Node<Card>(new Card(14,"A","clubs")));
		
		//deck.add(new Node<Card>(new Card(1,"A","diamonds")));
		deck.add(new Node<Card>(new Card(2,"2","diamonds")));
		deck.add(new Node<Card>(new Card(3,"3","diamonds")));
		deck.add(new Node<Card>(new Card(4,"4","diamonds")));
		deck.add(new Node<Card>(new Card(5,"5","diamonds")));
		deck.add(new Node<Card>(new Card(6,"6","diamonds")));
		deck.add(new Node<Card>(new Card(7,"7","diamonds")));
		deck.add(new Node<Card>(new Card(8,"8","diamonds")));
		deck.add(new Node<Card>(new Card(9,"9","diamonds")));
		deck.add(new Node<Card>(new Card(10,"10","diamonds")));
		deck.add(new Node<Card>(new Card(11,"J","diamonds")));
		deck.add(new Node<Card>(new Card(12,"Q","diamonds")));
		deck.add(new Node<Card>(new Card(13,"K","diamonds")));
		deck.add(new Node<Card>(new Card(14,"A","diamonds")));
	
		font=new Font("Arial",Font.PLAIN,50);
		fontSmall=new Font("Arial",Font.PLAIN,21);
		fontMid=new Font("Arial",Font.PLAIN,40);
		fontSmallSmall=new Font("Arial",Font.PLAIN,10);
		hold=new boolean[5];
		points--;
		//shuffle();
		riggedDeal();
		
	}
	private void shuffle() {
		for(int i=0;i<deck.size();i++) {
			Card temp=deck.get(i);
			int r=(int)(Math.random()*deck.size());
			deck.set(i, new Node<Card>(deck.get(r)));
			deck.set(r, new Node<Card>(temp));
		}
		for(int i=0;i<hold.length;i++) {
			hold[i]=false;
		}
	}
	private void deal() {
		player.clear();
		player.add(new Node<Card>(deck.get(0)));
		player.add(new Node<Card>(deck.get(1)));
		player.add(new Node<Card>(deck.get(2)));
		player.add(new Node<Card>(deck.get(3)));
		player.add(new Node<Card>(deck.get(4)));
	}
	private void riggedDeal() {
		player.clear();
		player.add(new Node<Card>(deck.get(8)));
		player.add(new Node<Card>(deck.get(9)));
		player.add(new Node<Card>(deck.get(10)));
		player.add(new Node<Card>(deck.get(11)));
		player.add(new Node<Card>(deck.get(12)));
	}
	private void redraw() {
		for(int i=0;i<player.size();i++) {
			if(!hold[i]) {
				player.set(i, new Node<Card>(deck.get((int)(Math.random()*47+5))));
			}
		}
	}
	public void animate() {
		while(true) {
			
			for(int i=0;i<confetti.length;i++) {
				confetti[i].move();
				//System.out.println("MOVE");
			}
			repaint();
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				System.out.println("no no no");
			}
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(225,225,225));
		g.fillRect(0, 0, 500, 500);
		
		
		g.setFont(fontSmallSmall);
		g.setColor(Color.black);
		g.drawString("250 - Royal Flush", 400, 10);
		g.drawString("50 - Straight Flush", 400, 20);
		g.drawString("25 - 4 of a Kind", 400, 30);
		g.drawString("9 - Full House", 400, 40);
		g.drawString("6 - Flush", 400, 50);
		g.drawString("4 - Straight", 400, 60);
		g.drawString("3 - 3 of a Kind", 400, 70);
		g.drawString("2 - 2 Pairs", 400, 80);
		g.drawString("1 - Pair of Jacks+", 400, 90);
		g.setFont(font);
		if(!insideScreen) {
			g.setFont(font);
			g.setColor(Color.red);
			g.drawString("Play again!", 100,200);
		
			
		}else {
			g.setColor(new Color(0,0,0));
			int x=10;
			for(int i=0;i<player.size();i++) {
				
				if(hold[i]==true) {
					player.get(i).selected=true;
					/*
					g.setFont(fontSmall);
					g.setColor(new Color(0,0,0));
					g.drawString("HOLD", x+20,460);
					*/
				}else {
					player.get(i).selected=false;
				}
				player.get(i).drawMe(g, x, 300);
				x+=90;
			}
			g.setColor(Color.black);
			g.setFont(font);
			g.drawString("Points: "+points, 10,50);
			
			if(stage==1) {
				g.setColor(Color.blue);
				g.fillRect(125,195,250,70);
				g.setColor(Color.white);
				g.drawString("REROLL", 145,250);
			}else if(stage==2) {
				
				g.setColor(Color.orange);
				g.fillRect(25,95,450,70);
				g.setColor(Color.white);
				g.setFont(fontMid);
				g.drawString("YOU WIN "+pointsWon+" POINTS!", 45,145);
				g.setColor(Color.blue);
				g.fillRect(150,195,200,70);
				g.setFont(font);
				g.setColor(Color.white);
				g.drawString("PLAY", 175,250);
				int confettii=0;
				if(pointsWon==1) {
					confettii=100;
				}else if(pointsWon==2) {
					confettii=300;
				}else if(pointsWon==3) {
					confettii=500;
				}else if(pointsWon==4) {
					confettii=1000;
				}else if(pointsWon==6) {
					confettii=750;
				}else if(pointsWon==9) {
					confettii=1100;
				}else if(pointsWon==25) {
					confettii=1500;
				}else if(pointsWon==50) {
					confettii=5000;
				}else if(pointsWon==250) {
					confettii=10000;
				}
					
					for(int i=0;i<confettii;i++) {
						confetti[i].drawMe(g);
						
					}
				
			}
		}
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println(e.getX()+" "+e.getY());
		int x=e.getX();
		int y=e.getY();
		if(y>340 && y<456) {
			if(x>37 && x<106) {
				hold[0]=!hold[0];
			}
			if(x>127 && x<198) {
				hold[1]=!hold[1];
			}
			if(x>219 && x<285) {
				hold[2]=!hold[2];
			}
			if(x>307 && x<376) {
				hold[3]=!hold[3];
			}
			if(x>397 && x<468) {
				hold[4]=!hold[4];
			}
		}
		if(x>125 && x<375 && y>195 && y<295 && stage==2) {
			points--;
			shuffle();
			riggedDeal();
			stage=1;
			repaint();
			return;
		}
		if(x>125 && x<375 && y>195 && y<295 && stage==1) {
			stage=2;
			
			redraw();
			//System.out.println(player.size());
			for(int i=0;i<player.size();i++) {
				//System.out.println(player.get(i));
			}
			pointsWon=0;
			int pairs=0;
			for(int i=0;i<player.size();i++) {
				for(int k=i+1;k<player.size();k++) {
					Card c1=player.get(i);
					Card c2=player.get(k);
					if(c1.getValue()==c2.getValue() && c1.getValue()>=11) {
						pointsWon=1;
						
					}
					
					if(c1.getValue()==c2.getValue()) {
						pairs++;
					}
				}
			}
			if(pairs==2) {
				pointsWon=2;
			}
			int triple1=-1;
			int triple2=-1;
			int triple3=-1;
			boolean tripletriple=false;
			for(int i=0;i<player.size();i++) {
				for(int k=i+1;k<player.size();k++) {
					for(int j=k+1;j<player.size();j++) {
						Card c1=player.get(i);
						Card c2=player.get(k);
						Card c3=player.get(j);
						if(c1.getValue()==c2.getValue() && c2.getValue()==c3.getValue()) {
							pointsWon=3;
							tripletriple=true;
							triple1=i;
							triple2=k;
							triple3=j;
						}
					}
				}
			}
			Card[] hand=new Card[5];
			for(int i=0;i<player.size();i++) {
				hand[i]=player.get(i);
			}
			for(int i=0;i<hand.length;i++) {
				for(int k=0;k<hand.length-1;k++) {
					Card c1=hand[k];
					Card c2=hand[k+1];
					if(c1.getValue()>c2.getValue()) {
						hand[k]=c2;
						hand[k+1]=c1;
					}
				}
						
			}
			boolean bad=false;
			boolean royal=false;
			if(hand[0].getValue()==10) {
				royal=true;
			}
			for(int i=1;i<hand.length;i++) {
				
				if(hand[i].getValue()!=hand[i-1].getValue()+1) {
					bad=true;
				}
			}
			/*
			float sum=0;
			int min=10000;
			int max=0;
			for(int i=0;i<player.size();i++) {
				sum+=player.get(i).getValue();
				if(player.get(i).getValue()==min || player.get(i).getValue()==max) {
					//dupe
				}else {
					if(player.get(i).getValue()<min) {
						min=player.get(i).getValue();
					}
					if(player.get(i).getValue()>max) {
						max=player.get(i).getValue();
					}
				}
			}
			*/
			boolean straight=false;
			//sum/=5;
			/*
			if(sum==(min+max)/2.0f) {
				pointsWon=4;
				straight=true;
			}
			*/
			if(!bad) {
				pointsWon=4;
				straight=true;
			}
			String suit=player.get(0).getSuit();
			bad=false;
			for(int i=1;i<player.size();i++) {
				if(!player.get(i).getSuit().equals(suit)) {
					bad=true;
				}
			}
			boolean flush=false;
			if(!bad) {
				flush=true;
				pointsWon=6;
			}
			if(tripletriple) {
				int[] other2=new int[2];
				int index=0;
				for(int i=0;i<5;i++) {
					if(i!=triple1 && i!=triple2 && i!=triple3) {
						other2[index]=i;
						index++;
					}
				}
				Card c1=player.get(other2[0]);
				Card c2=player.get(other2[1]);
				if(c1.getValue()==c2.getValue()) {
					pointsWon=9;
				}
			}
			for(int i=0;i<player.size();i++) {
				for(int k=i+1;k<player.size();k++) {
					for(int j=k+1;j<player.size();j++) {
						for(int a=j+1;a<player.size();a++) {
							Card c1=player.get(i);
							Card c2=player.get(k);
							Card c3=player.get(j);
							Card c4=player.get(a);
							if(c1.getValue()==c2.getValue() && c2.getValue()==c3.getValue() && c3.getValue()==c4.getValue()) {
								pointsWon=25;
								
							}
						}
						
					}
				}
			}
			if(straight && flush) {
				pointsWon=50;
				if(royal) {
					pointsWon=250;
				}
			}
			points+=pointsWon;
			
		}
		
		
		
		
		repaint();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		insideScreen=true;
		repaint();
		
		
		
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		insideScreen=false;
		repaint();
		
	}
	
	
	
}
