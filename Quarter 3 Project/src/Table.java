import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

public class Table extends JPanel implements MouseListener, MouseMotionListener{
	private ArrayList<Card> deck;
	private ArrayList<Card> playerDeck;
	private ArrayList<Card> dealerDeck;
	
	private int playerValue=0;
	private int dealerValue=0;
	private int playerWins=0;
	private int dealerWins=0;
	private int playerStreak=0;
	boolean going=false;
	boolean playerDone=false;
	boolean playerLost=false;
	boolean playerWon=false;
	boolean playerTied=false;
	boolean dealerPlaying=false;
	boolean gameEndStarted=false;
	boolean fadingIn=true;
	boolean exited=false;
	private int a=0;
	Font customFont=null;
	Font customFontSmall=null;
	private BufferedImage hit;
	private BufferedImage stand;
	private BufferedImage restart;
	private BufferedImage advice;
	private BufferedImage arrow;
	private BufferedImage laughing;
	private BufferedImage checkmark;
	private BufferedImage question;
	private BufferedImage rickastley;
	private BufferedImage xMark;
	int alpha=255;
	int arrowX=1000;
	int prob1=0;
	int prob2=0;
	int customCursorX=0;
	int customCursorY=0;
	int customCursorStroke=3;
	Color customCursorColor=new Color(255,255,255);
	private Clip loseClip;
	private AudioInputStream loseStream;
	public Table() {
		setLayout(null);
		
		try {
			File audioFile = new File("jazz.wav");
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			
			AudioFormat format = audioStream.getFormat();
			
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			
			audioClip.open(audioStream);
			audioClip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
		
		
		
		
		
		deck=new ArrayList<>();
		playerDeck=new ArrayList<>();
		dealerDeck=new ArrayList<>();
		
		deck.add(new Card(2,"2","hearts"));
		deck.add(new Card(3,"3","hearts"));
		deck.add(new Card(4,"4","hearts"));
		deck.add(new Card(5,"5","hearts"));
		deck.add(new Card(6,"6","hearts"));
		deck.add(new Card(7,"7","hearts"));
		deck.add(new Card(8,"8","hearts"));
		deck.add(new Card(9,"9","hearts"));
		deck.add(new Card(10,"10","hearts"));
		deck.add(new Card(10,"J","hearts"));
		deck.add(new Card(10,"Q","hearts"));
		deck.add(new Card(10,"K","hearts"));
		deck.add(new Card(11,"A","hearts"));
		
		deck.add(new Card(2,"2","diamonds"));
		deck.add(new Card(3,"3","diamonds"));
		deck.add(new Card(4,"4","diamonds"));
		deck.add(new Card(5,"5","diamonds"));
		deck.add(new Card(6,"6","diamonds"));
		deck.add(new Card(7,"7","diamonds"));
		deck.add(new Card(8,"8","diamonds"));
		deck.add(new Card(9,"9","diamonds"));
		deck.add(new Card(10,"10","diamonds"));
		deck.add(new Card(10,"J","diamonds"));
		deck.add(new Card(10,"Q","diamonds"));
		deck.add(new Card(10,"K","diamonds"));
		deck.add(new Card(11,"A","diamonds"));
		
		deck.add(new Card(2,"2","spades"));
		deck.add(new Card(3,"3","spades"));
		deck.add(new Card(4,"4","spades"));
		deck.add(new Card(5,"5","spades"));
		deck.add(new Card(6,"6","spades"));
		deck.add(new Card(7,"7","spades"));
		deck.add(new Card(8,"8","spades"));
		deck.add(new Card(9,"9","spades"));
		deck.add(new Card(10,"10","spades"));
		deck.add(new Card(10,"J","spades"));
		deck.add(new Card(10,"Q","spades"));
		deck.add(new Card(10,"K","spades"));
		deck.add(new Card(11,"A","spades"));
		
		deck.add(new Card(2,"2","clubs"));
		deck.add(new Card(3,"3","clubs"));
		deck.add(new Card(4,"4","clubs"));
		deck.add(new Card(5,"5","clubs"));
		deck.add(new Card(6,"6","clubs"));
		deck.add(new Card(7,"7","clubs"));
		deck.add(new Card(8,"8","clubs"));
		deck.add(new Card(9,"9","clubs"));
		deck.add(new Card(10,"10","clubs"));
		deck.add(new Card(10,"J","clubs"));
		deck.add(new Card(10,"Q","clubs"));
		deck.add(new Card(10,"K","clubs"));
		deck.add(new Card(11,"A","clubs"));
		
		shuffle();
		
		playerDeck.add(deck.get(0));
		playerDeck.add(deck.get(1));
		deck.remove(0);
		deck.remove(0);
		
		dealerDeck.add(deck.get(0));
		dealerDeck.add(new Card(-1,null,null));
		deck.remove(0);
		
		
		
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Medium.ttf")).deriveFont(40f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
			customFontSmall = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Medium.ttf")).deriveFont(20f);
			ge.registerFont(customFont);
		}catch(IOException e) {
			System.out.println("could not load font");
		}catch(FontFormatException e) {
			System.out.println("could not load font");
		}
		//hit=new JButton("HIT");
		//hit.setFont(customFont);
		
		
		//add(hit);
	
		//hit.addActionListener(this);
		//stand.addActionListener(this);
		try {
			hit=ImageIO.read(new File("hitrealreal.png"));
			stand=ImageIO.read(new File("standreal.png"));
			restart=ImageIO.read(new File("restart.png"));
			advice=ImageIO.read(new File("advicereal.png"));
			arrow=ImageIO.read(new File("arrowreal.png"));
			laughing=ImageIO.read(new File("laughingreal.png"));
			checkmark=ImageIO.read(new File("checkmark.png"));
			question=ImageIO.read(new File("question.png"));
			rickastley=ImageIO.read(new File("rickastley.png"));
			xMark=ImageIO.read(new File("x.png"));
		}catch(IOException e) {
			System.out.println("could not load hit image");
		}
		
		
	}
	
	public Dimension getPreferredSize() {
		//Sets the size of the panel
		return new Dimension(800,600);
	}

	public void paintComponent(Graphics g){
		
		
		
		
		g.setColor(Color.black);
		g.fillRect(0,0,800,600);
		int x=200;
		int y=400;
		playerValue=0;
		
		for(Card card:playerDeck) {
			card.drawMe(g, x,y);
			playerValue+=card.getValue();
			x+=80;
		}
		if(playerValue>21) {
			
			playerDone=true;
			playerLost=true;
		}else if(playerValue==21) {
			dealerPlaying=true;
			
		}
		
		if(playerWon) {
			if(!gameEndStarted) {
				playerWins++;
				playerStreak++;
				gameEndStarted=true;
				//System.out.println("player wins "+playerWins);
			}
			g.drawImage(checkmark, 10,10,null);
			g.drawImage(checkmark, 80,10,null);
			g.drawImage(checkmark, 150,10,null);
			g.drawImage(checkmark, 220,10,null);
			g.drawImage(checkmark, 10,140,null);
			g.drawImage(checkmark, 80,140,null);
			g.drawImage(checkmark, 150,140,null);
			g.drawImage(checkmark, 220,140,null);
			g.setFont(customFont);
			g.setColor(new Color(3, 252, 3));
			g.drawString("WINNER",70,120);
			
			
		}
		if(playerLost) {
			if(!gameEndStarted) {
				dealerWins++;
				playerStreak=0;
				/*
				try {
					File loseFile=new File("src/nevergonnagiveyouup.wav");
					loseStream=AudioSystem.getAudioInputStream(loseFile);
					AudioFormat loseFormat=loseStream.getFormat();
					DataLine.Info loseInfo=new DataLine.Info(Clip.class, loseFormat);
					loseClip=(Clip)AudioSystem.getLine(loseInfo);
					loseClip.open(loseStream);
				}catch(IOException e) {
					System.out.println("could not open lose clip");
				}catch(LineUnavailableException e) {
					System.out.println("could not open lose clip");
				}catch(UnsupportedAudioFileException e) {
					System.out.println("could not open lose clip");
				}
				
				loseClip.start();
				*/
				gameEndStarted=true;
			}
			/*
			g.drawImage(rickastley, -100,-100,null);
			g.drawImage(laughing, 10,350,null);
			g.drawImage(laughing, 80,350,null);
			g.drawImage(laughing, 150,350,null);
			g.drawImage(laughing, 220,350,null);
			g.drawImage(laughing, 290,350,null);
			g.drawImage(laughing, 360,350,null);
			g.drawImage(laughing, 430,350,null);
			g.drawImage(laughing, 500,350,null);
			g.drawImage(laughing, 570,350,null);
			g.drawImage(laughing, 640,350,null);
			g.drawImage(laughing, 710,350,null);
			g.drawImage(laughing, 780,350,null);
			g.drawImage(laughing, 10,430,null);
			g.drawImage(laughing, 80,430,null);
			g.drawImage(laughing, 150,430,null);
			g.drawImage(laughing, 220,430,null);
			g.drawImage(laughing, 290,430,null);
			g.drawImage(laughing, 360,430,null);
			g.drawImage(laughing, 430,430,null);
			g.drawImage(laughing, 500,430,null);
			g.drawImage(laughing, 570,430,null);
			g.drawImage(laughing, 640,430,null);
			g.drawImage(laughing, 710,430,null);
			g.drawImage(laughing, 780,430,null);
			*/
			g.drawImage(xMark, 10,10,null);
			g.drawImage(restart, 300,-30,null);
			g.setFont(customFont);
			g.setColor(new Color(252, 32, 3));
			g.drawString("LOSER",150,100);
		}
		if(playerTied) {
			g.drawImage(question, 10,10,null);
			g.drawImage(question, 80,10,null);
			g.drawImage(question, 150,10,null);
			g.drawImage(question, 220,10,null);
			g.drawImage(question, 10,140,null);
			g.drawImage(question, 80,140,null);
			g.drawImage(question, 150,140,null);
			g.drawImage(question, 220,140,null);
			g.setFont(customFont);
			g.setColor(Color.white);
			g.drawString("TIED",80,120);
		}
		int x2=200;
		int y2=200;
		dealerValue=0;
		int i=0;
		
		if(going) {
			dealerValue=calculateDealerValue(false);
			//System.out.println("no hidden cards");
		}else {
			dealerValue=calculateDealerValue(true);
		}
		//System.out.println(dealerValue);
		
			
		
		g.setFont(customFont);
		g.setColor(Color.white);
		g.drawString("Dealer: "+dealerValue, 25, 250);
		
		if(dealerPlaying) {
			
			try {
				Thread.sleep(100);
				//System.out.println("hello");
			}catch(InterruptedException e) {
				System.out.println("something went wrong with thread sleep");
			}
			//System.out.println("dealer playing");
			a++;
			going=true;
			if(dealerValue<17) {
				if(dealerDeck.get(1).getValue()==-1) {
					dealerDeck.remove(1);
					//System.out.println("removing bad card");
				}
				for(Card card:dealerDeck) {
					card.drawMe(g, x2,y2);
					
					x2+=80;
				}
				dealerDeck.add(deck.get(0));
				deck.remove(0);
				
				repaint();
				
				
				
			}else {		
				dealerPlaying=false;
				for(Card card:dealerDeck) {
					card.drawMe(g, x2,y2);
					
					x2+=80;
				}
				//System.out.println("dealer finished");
				//System.out.println("player: "+playerValue);
				//System.out.println("dealer: "+dealerValue);
				if(dealerValue>21) {
					playerDone=true;
					playerWon=true;
				}else {
				if(playerValue>dealerValue) {
					playerDone=true;
					playerWon=true;
				}
				if(dealerValue>playerValue) {
					playerDone=true;
					playerLost=true;
				}
				if(playerValue==dealerValue) {
					playerDone=true;
					playerTied=true;
				}
				}
				repaint();
			}
		}else {
			for(Card card:dealerDeck) {
				i++;
				if(card.getValue()==-1) {
					card.drawMeHidden(g,x2,y2);
					//System.out.println("hidden card");
				}else {
					card.drawMe(g, x2,y2);
					dealerValue+=card.getValue();
				}
				
				x2+=80;
			}
		}
		
		g.setFont(customFont);
		g.setColor(Color.white);
		
		g.drawString("Player: "+playerValue, 25, 450);
		g.setFont(customFontSmall);
		g.drawString("Player wins: "+playerWins,650,30);
		g.drawString("Dealer wins: "+dealerWins,650,50);
		g.drawString("Player streak: "+playerStreak,650,70);
		
		String rank="";
		if(playerStreak==0) {
			rank="Loser";
		}else if(playerStreak==1) {
			rank="Amateur";
		}else if(playerStreak==2) {
			rank="Novice";
		}else if(playerStreak==3) {
			rank="Average";
		}else if(playerStreak==4) {
			rank="Skilled";
		}else if(playerStreak==5) {
			rank="Accomplished";
		}else if(playerStreak==6) {
			rank="Renowned";
		}else if(playerStreak==7) {
			rank="God";
		}else if(playerStreak==8) {
			rank="Hacker";
		}else if(playerStreak==9) {
			rank="Transcendant";
		}else if(playerStreak>9) {
			rank="IMPOSSIBLE";
		}
		g.drawString("Player rank: "+rank,10,390);
		if(!playerDone) {
			g.setFont(customFontSmall);
			if(prob1==0) {
				prob1=loseWithStand();
				prob2=loseWithHit();
			}
			
			g.drawString("Lose with stand: "+prob1+"%", 10, 490);
			g.drawString("Lose with hit: "+prob2+"%", 20, 520);
			g.drawImage(hit, 220,-30,null);
			g.drawImage(stand, 400, -25,null);
			g.drawImage(advice, 650, 70, null);
			g.drawImage(arrow, arrowX,30,null );
		}
		if(playerDone) {
			g.drawImage(restart, 300,-30,null);
		}
		
		
		g.setColor(new Color(0,0,0,alpha));
		g.fillRect(0, 0, 800, 600);
		if(exited) {
			g.setColor(new Color(255,255,255));
			g.fillRect(0,0,800,600);
			g.setColor(new Color(0,0,0));
			g.setFont(customFont);
			g.drawString("Hey! Come back!", 250,300);
		}
		//System.out.println("paint component");
		Graphics2D g2=(Graphics2D) g;
		g2.setStroke(new BasicStroke(customCursorStroke));
		g2.setColor(customCursorColor);
		
		g2.drawRect(customCursorX-25, customCursorY-50,50,50);
		
		
		
	}
	public void animate() {
		
		if(alpha<180) {
			alpha-=5;
		}else {
			alpha-=5;
		}
		
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			System.out.println("something went wrong witht thread.sleep");
		}
		repaint();
		if(alpha>5) {
			animate();
		}else {
			fadingIn=false;
		}
		
	}
	public int loseWithStand() {
		int currentValue=0;
		for(Card card:playerDeck) {
			currentValue+=card.getValue();
		}
		int currentDealerValue=dealerDeck.get(0).getValue();
		ArrayList<Integer> scenarios=new ArrayList<>();
		for(Card card:deck) {
			int thing=currentDealerValue+card.getValue();
			while(thing<17) {
				thing+=deck.get((int)(Math.random()*deck.size())).getValue();
			}
			scenarios.add(thing);
			
		}
		int totalScenarios=scenarios.size();
		int loseScenarios=0;
		for(int i:scenarios) {
			if(i<=21 && i>currentValue) {
				loseScenarios++;
			}
		}
		float prob=((float)loseScenarios/totalScenarios)*100;
		return Math.round(prob);
			
	}
	public int loseWithHit() {
		int currentValue=0;
		for(Card card:playerDeck) {
			currentValue+=card.getValue();
		}
		ArrayList<Integer> scenarios=new ArrayList<>();
		for(Card card:deck) {
			scenarios.add(currentValue+card.getValue());
		}
		int totalScenarios=scenarios.size();
		int loseScenarios=0;
		for(int i:scenarios) {
			if(i>21) {
				loseScenarios++;
			}
		}
		float prob=((float)loseScenarios/totalScenarios)*100;
		return Math.round(prob);
			
	}
	public int calculateDealerValue(boolean hidden){
		int total=0;
		for(Card card:dealerDeck) {
			total+=card.getValue();
		}
		if(hidden) {
			return total+1;
		}else {
			return total;
		}
		
		
	}
	public int calculatePlayerValue(){
		int total=0;
		for(Card card:playerDeck) {
			total+=card.getValue();
		}
		return total;
		
		
	}


	public void shuffle(){
		for(int i=0;i<deck.size();i++) {
			int choice=(int)(Math.random()*deck.size());
			Card temp=deck.get(i);
			deck.set(i, deck.get(choice));
			deck.set(choice, temp);
		}
	}
	
	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==hit) {
			playerDeck.add(deck.get(0));
			deck.remove(0);
			
		}
		repaint();
	}
	*/
	public void hit() {
		playerDeck.add(deck.get(0));
		deck.remove(0);
		arrowX=1000;
		prob1=0;
		repaint();
	}
	public void stand() {
		playerDone=true;
		dealerPlaying=true;
		arrowX=1000;
		repaint();
		//System.out.println("stand");
		
	}
	public void restart() {
		playerDone=false;
		playerWon=false;
		playerLost=false;
		playerTied=false;
		dealerPlaying=false;
		gameEndStarted=false;
		going=false;
		arrowX=1000;
		prob1=0;
		/*
		loseClip.stop();
		loseClip.close();
		*/
		//System.out.println(loseClip.isRunning());
		for(Card card:playerDeck) {
			
			deck.add(card);
			
			
		}
		for(Card card:dealerDeck) {
			if(card.getValue()!=-1) {
				deck.add(card);
			}
		}
		playerDeck.clear();
		dealerDeck.clear();
		shuffle();
		playerDeck.add(deck.get(0));
		playerDeck.add(deck.get(1));
		deck.remove(0);
		deck.remove(0);
		
		dealerDeck.add(deck.get(0));
		dealerDeck.add(new Card(-1,null,null));
		deck.remove(0);
		repaint();
	}
	public void advice() {
		if(prob2>prob1) {
			arrowX=410;
		}else {
			arrowX=250;
		}
		repaint();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
		//System.out.println("x: "+x+" y: "+y);
		if(playerDone) {
			if(x>=325 && x<=486 && y>=60 && y<=119) {
				restart();
			}
		}
		else {
			if(x>=281 && x<=387 && y>=60 && y<=113) {
				hit();
			}
			if(x>=407 && x<=586 && y>=60 && y<=111) {
				stand();
			}
			if(x>=655 && x<=783 && y>=144 && y<=179) {
				advice();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		exited=false;
		repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		exited=true;
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		customCursorX=e.getX();
		customCursorY=e.getY();
		if(customCursorX>=281 && customCursorX<=387 && customCursorY>=60 && customCursorY<=113) {
			customCursorColor=new Color(0,100,255);
			customCursorStroke=5;
		}else if(customCursorX>=407 && customCursorX<=586 && customCursorY>=60 && customCursorY<=111){
			customCursorColor=new Color(0,100,255);
			customCursorStroke=5;
		}else {
			customCursorColor=new Color(255,255,255);
			customCursorStroke=3;
		}
		
		repaint();
		
	}
	


}
