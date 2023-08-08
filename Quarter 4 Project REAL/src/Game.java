import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener,MouseListener{
	private BufferedImage map;
	private BufferedImage player;
	private BufferedImage tree;
	private BufferedImage boat;
	private BufferedImage gun;
	private BufferedImage robot;
	private BufferedImage cow;
	private BufferedImage rocket;
	private BufferedImage explosion;
	private BufferedImage goldenshard;
	private BufferedImage boss;
	private BufferedImage bossbullet;
	
	private int speed=5;
	private final int boatSpeed=10;
	private final int nTrees=20;
	private int rotation=0;
	private final int ogBoatX=-400;
	private final int ogBoatY=0;
	private int x=100;
	private int y=100;
	private int playerX=250;
	private int playerY=255;
	private int boatX=ogBoatX;
	private int boatY=ogBoatY;
	private int cowX=-200;
	private int cowY=-200;
	private int playerMapX=playerX/100+50;
	private int playerMapY=playerY/100+50;
	private int quest=-1;
	private int completedQuest=-1;
	private int interactionStep=0;
	private int charCount=0;
	private int explosionCounter=-1;
	private int explosionX=0;
	private int explosionY=0;
	private int triggerCounter=0; 
	private int killCount=0;
	private int shards=0;
	private int alpha=1;
	private int bossHits=0;
	private int bossRounds=-1;
	private int endTransition=-1;
	private int lostTransition=-1;
	private int lostAlpha=1;
	private int wonTransition=-1;
	private int wonAlpha=1;
	private int animTest=0;
	private int boatCounter=0;
			
	
	private boolean movingUp=false;
	private boolean movingDown=false;
	private boolean movingRight=false;
	private boolean movingLeft=false;
	private boolean noRight=false;
	private boolean noLeft=false;
	private boolean noUp=false;
	private boolean noDown=false;
	private boolean inBoat=false;
	private boolean interacting=false;
	private boolean slowMo=false;
	private boolean questTrigger=false;
	private boolean startQuestTrigger=false;
	private boolean gunEnabled=false;
	private boolean questReward=false;
	private boolean rewardInteracting=false;
	private boolean endGame=false;
	private boolean facingLeft=false;
	private boolean gg=false;
	private boolean lost=false;
	private boolean starting=true;
	private boolean about=false;
	
	private String dPWMBC="";

	
	private ArrayList<int[]> trees;
	private ArrayList<Bullet> bullets=new ArrayList<>();
	private ArrayList<BossBullet> bossbullets=new ArrayList<>();
	private ArrayList<BadRobot> robots;
	private ArrayList<Island> islands;
	private ArrayList<Quest> quests=new ArrayList<>();
	private ArrayList<Quest> rewards=new ArrayList<>();
	
	private int[][] miniMap;
	private int[][] ogMiniMap;
	
	private Font customFont;
	private Font customFontBig;
	private Font customFontSmall;
	
	private Boss epicboss;
	
	private Clip audioClip;
	
	public Game() {
		music();
		font();
		images();
		islands();
		trees();
		minimap();
		robots();
		quests();
		
	}
	public void music() {
		try {
			File audioFile = new File("src/coconut.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.start();
			
	      } catch (UnsupportedAudioFileException e) {
	    	  System.out.println("audio bad");
	      } catch (IOException e) {
	         System.out.println("audio bad bad");
	      } catch (LineUnavailableException e) {
	         System.out.println("audio bad bad bad");
	      }
	}
	public void font() {
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Tickerbit-regular.otf")).deriveFont(20f);
			customFontBig = Font.createFont(Font.TRUETYPE_FONT, new File("src/Tickerbit-regular.otf")).deriveFont(100f);
			customFontSmall = Font.createFont(Font.TRUETYPE_FONT, new File("src/Tickerbit-regular.otf")).deriveFont(15f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
			ge.registerFont(customFontBig);
			ge.registerFont(customFontSmall);
			
		}catch(IOException e) {
			System.out.println("could not load font");
		}catch(FontFormatException e) {
			System.out.println("could not load font");
		}
	}
	public void images() {
		try {
			map=ImageIO.read(new File("src/map.png"));
			player=ImageIO.read(new File("src/player.png"));
			tree=ImageIO.read(new File("src/tree2.png"));
			boat=ImageIO.read(new File("src/boat.png"));
			gun=ImageIO.read(new File("src/gun.png"));
			robot=ImageIO.read(new F<b>ile("src/robot.png"));
			cow=ImageIO.read(new File("src/cow.png"));
			rocket=ImageIO.read(new File("src/rocket.png"));
			explosion=ImageIO.read(new File("src/explosion.png"));
			goldenshard=ImageIO.read(new File("src/goldenshard.png"));
			boss=ImageIO.read(new File("src/boss.png"));
			bossbullet=ImageIO.read(new File("src/bossbullet.png"));
		}catch(IOException e) {
			System.out.println("eeeeeeeee (could not load image)");
		}
	}
	public void trees() {
		trees=new ArrayList<>();
		for(Island island:islands) {
			int x=island.getTopLeftX()+0;
			int y=island.getTopLeftY()+00;
			int finalX=island.getBottomRightX();
			int finalY=island.getBottomRightY()-30;
			while(y<finalY-100) {
				while(x<finalX-150) {
					//System.out.println("run");
					int[] tree=new int[2];
					tree[0]=x;
					tree[1]=y;
					trees.add(tree);
					x+=Math.random()*100+100;
				}
				x=island.getTopLeftX();
				y+=Math.random()*100+100;
			}
			
			
		}
	}
	public void islands() {
		islands=new ArrayList<>();
		Island island1=new Island(-300,-300,300,300);
		islands.add(island1);
		Island island2=new Island(-1000,-300,-600,300);
		islands.add(island2);
		Island island3=new Island(-100,-2000,700,-1000);
		islands.add(island3);
	}
	public void minimap() {
		miniMap=new int[100][100];
		ogMiniMap=new int[100][100];
		//right now, map goes from -5000 to 5000 in x and y
		//each map unit will be 100 pixel in the real world
		//for the map array, if the value is 0, it is ocean, if it is 1, it is land
		int i=0;
		int k=0;
		for(int mapY=-2000;mapY<2000;mapY+=40) {
			for(int mapX=-2000;mapX<2000;mapX+=40) {
				boolean foundIsland=false;
				for(Island island:islands) {
					int leftX=island.getTopLeftX();
					int rightX=island.getBottomRightX();
					int topY=island.getTopLeftY();
					int bottomY=island.getBottomRightY();
					if(mapX>=leftX && mapX<=rightX && mapY>=topY && mapY<=bottomY) {
						foundIsland=true;
						//System.out.println("foundisland");
					}
				}
				if(!foundIsland) {
					miniMap[i][k]=0;
					ogMiniMap[i][k]=0;
				}else {
					miniMap[i][k]=1;
					ogMiniMap[i][k]=1;
				}
				k++;
			}
			k=0;
			i++;
		}
		
	}
	public void robots() {
		robots=new ArrayList<>();
		BadRobot r=new BadRobot(-900,0);
		robots.add(r);
		
		BadRobot r2=new BadRobot(-950,100);
		robots.add(r2);
		BadRobot r3=new BadRobot(-850,-100);
		robots.add(r3);
		robots.add(new BadRobot(0,-1500));
		robots.add(new BadRobot(50,-1500));
		robots.add(new BadRobot(100,-1500));
		robots.add(new BadRobot(150,-1500));
		robots.add(new BadRobot(200,-1500));
		robots.add(new BadRobot(250,-1500));
		robots.add(new BadRobot(300,-1500));
		robots.add(new BadRobot(350,-1500));
		robots.add(new BadRobot(400,-1500));
		robots.add(new BadRobot(450,-1500));
		
	}
	public void quests() {
		quests=new ArrayList<>();
		String[] a= {"Hi!","My name is Bessie the cow.","I'm going to be your guide for this adventure!","To get started, find the boat and press b to enter.","When you're done, come see me for a reward!"};
		Quest q1=new Quest(a);
		quests.add(q1);
		String[] a3= {"Now, let's put that rocket launcher to use!","Blow 3 robots up, and I will reward you."};
		Quest q3=new Quest(a3);
		quests.add(q3);
		rewards=new ArrayList<>();
		String[] a2= {"Nice!","Here's a rocket launcher for you.","You can press space to blow things up!"};
		Quest q2=new Quest(a2);
		rewards.add(q2);
		String[] a4= {"Boom!","Here's a golden shard!","Collect 3 of them and you can travel to the boss dimension."};
		Quest q4=new Quest(a4);
		rewards.add(q4);
		String[] a5= {"Now, I heard there was something interesting on the island above us.","Use the boat to travel up there and explore."};
		Quest q5=new Quest(a5);
		quests.add(q5);
		String[] a6= {"Great!","Here's another golden shard!"};
		Quest q6=new Quest(a6);
		rewards.add(q6);
		String[] a7= {"Before you can go into the boss dimension, you need to get ready to fight!","To receive your last golden shard, slay 10 robots"};
		Quest q7=new Quest(a7);
		quests.add(q7);
		String[] a8= {"You are ready.","Here is the final golden shard.","Good luck..."};
		Quest q8=new Quest(a8);
		rewards.add(q8);
				
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(starting) {
			if(about) {
				drawAboutScreen(g);
			}else {
				drawStartScreen(g);
			}
			
		}else {
			drawLandscape(g);
			
			drawEntities(g);
			if(!endGame)drawMiniMap(g);
			checkWaterCollision(g);
		}
		
	}
	public void drawStartScreen(Graphics g) {
		g.setColor(new Color(0,0,0));
		g.fillRect(0,0,600,600);
		g.setFont(customFontBig);
		g.setColor(new Color(255,255,255));
		g.drawString("INSULAE",75,100);
		g.setFont(customFont);
		g.drawString("the best game ever?™", 190,130);
		g.drawString("Arrow keys - Movement", 200,230);
		g.drawString("I - Interact", 230,250);
		g.drawString("Enter - Next dialogue", 200,270);
		g.fillRect(150,300,300,150);
		g.setColor(new Color(0,0,0));
		g.setFont(customFontBig);
		g.drawString("PLAY", 180,410);
		g.setColor(new Color(255,255,255));
		g.fillRect(250, 500, 100, 50);
		g.setColor(new Color(0,0,0));
		g.setFont(customFont);
		g.drawString("ABOUT", 268,532);
	}
	public void drawAboutScreen(Graphics g) {
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, 600, 600);
		g.setFont(customFont);
		g.setColor(new Color(255,255,255));
		g.drawString("literally the best game ever™",170,100);
		g.setFont(customFontBig);
		g.drawString("stats", 170,250);
		g.setFont(customFont);
		g.drawString("11 classes", 250,300);
		g.drawString("1600 lines of code total", 200,330);
		g.drawString("1200+ lines of code in game class", 150,360);
		g.drawString("118 instance variables", 200,390);
		g.drawString("12 hand-drawn images", 200,420);
		g.drawString("(estimated) 15+ hours work", 170,450);
		g.drawString("made ENTIRELY in java swing :O", 150,480);
		g.fillRect(20, 20, 100, 50);
		g.setColor(new Color(0,0,0));
		g.drawString("BACK", 45,52);
		
		
		
		
	}
	public void drawLandscape(Graphics g) {
		if(!endGame) {
			
		
		g.setColor(new Color(3, 252, 252)); //set color to ocean
		g.fillRect(0, 0, 600,600); //draw the ocean
		g.setColor(new Color(255, 235, 56)); //set color to sand
		for(Island island:islands) {
			island.drawMe(g, x, y);
		}
		g.setColor(new Color(59, 59, 59));
		g.fillRect(x-300, y, 500, 100);
		g.fillRect(x-1000, y+100, 400, 100);
		g.fillRect(x+100, y-1300,500,100);
		for(int[] tre:trees) {
			g.drawImage(tree, x+tre[0],y+tre[1],null); //draw the trees
		}
		
		}else {
			g.setColor(new Color(245, 66, 66));
			g.fillRect(0, 0, 600, 600);
		}
		
	}
	public void drawEntities(Graphics g) {
		
		if(endTransition>0)endTransition--;
		if(endTransition>90) {
			alpha+=4;
		}else if(endTransition>0 && endTransition<50){
			alpha-=4;
		}
		if(endTransition==60) {
			epicboss=new Boss(100,100);
			endGame=true;
			
			robots.clear();
			
		}
		
		
		
		g.setColor(new Color(171, 106, 21));
		if(!endGame) {
			g.fillRect(x+boatX, y+boatY,100,100); //boat
			int[] xPoints= {x+boatX,x+boatX-50,x+boatX};
			int[] yPoints= {y+boatY,y+boatY+50,y+boatY+100};
			g.fillPolygon(xPoints,yPoints,3);
		}
		if(facingLeft) {
			g.drawImage(player, 250+player.getWidth(), 220, -player.getWidth(), player.getHeight(), null);
			if(gunEnabled) g.drawImage(gun, 295,240,-gun.getWidth(),gun.getHeight(),null); //gun
		}else {
			g.drawImage(player, 250,220,null); //player
			if(gunEnabled) g.drawImage(gun, 295,240,null); //gun
		}
		
		if(endGame) {
			epicboss.drawMe(g, boss, x, y);
			//System.out.println(epicboss.getX(x)+" "+epicboss.getY(y));
		}
		if(!endGame)g.drawImage(cow, x+cowX,y+cowY,null); //cow
		if(explosionCounter>10) {
			if(explosionCounter>40) {
				explosionCounter-=1;
			}else {
				explosionCounter-=2;
			}
			
			
			Image explosion2=explosion.getScaledInstance((255-(int)(explosionCounter*5)), 255-(int)(explosionCounter*5), Image.SCALE_DEFAULT);
			g.drawImage(explosion2, explosionX-(100-explosionCounter*2), explosionY-(100-explosionCounter*2), null);
		}
		if(explosionCounter<40) {
			slowMo=false;
		}
		if(interacting==true) {
			if(interactionStep>=quests.get(quest).getDialogue().length) {
				
			}else {
				charCount++;
				if(charCount>=quests.get(quest).getDialogue()[interactionStep].length()) {
					charCount=quests.get(quest).getDialogue()[interactionStep].length();
				}
				g.setColor(new Color(255,255,255));
				g.fillRect(x+cowX-(3*charCount)-5, y+cowY-18, charCount*8+15, 25);
				g.setColor(new Color(0,0,0));
				g.setFont(customFontSmall);
				g.drawString(quests.get(quest).getDialogue()[interactionStep].substring(0,charCount), x+cowX-(3*charCount),y+cowY);
			}
			
			
		}
		if(rewardInteracting==true) {
			if(interactionStep>=rewards.get(completedQuest).getDialogue().length) {
				
			}else {
				if(completedQuest==0 && interactionStep==1) {
					gunEnabled=true;
				}
				if(completedQuest==1 && interactionStep==1 && charCount==0) {
					shards++;
				
				}
				if(completedQuest==2 && interactionStep==1 && charCount==0) {
					shards++;
				}
				if(completedQuest==3 && interactionStep==0 && charCount==0) {
					shards++;
				}
				if(completedQuest==1 && interactionStep==1) {
					g.drawImage(goldenshard,100,100,null);
				}
				if(completedQuest==2 && interactionStep==1) {
					g.drawImage(goldenshard,100,100,null);
				}
				if(completedQuest==3 && interactionStep==0) {
					g.drawImage(goldenshard,100,100,null);
				}
				charCount++;
				if(charCount>=rewards.get(completedQuest).getDialogue()[interactionStep].length()) {
					charCount=rewards.get(completedQuest).getDialogue()[interactionStep].length();
				}
				g.setColor(new Color(255,255,255));
				g.fillRect(x+cowX-(3*charCount)-5, y+cowY-18, charCount*8+10, 25);
				g.setColor(new Color(0,0,0));
				g.setFont(customFontSmall);
				g.drawString(rewards.get(completedQuest).getDialogue()[interactionStep].substring(0,charCount), x+cowX-(3*charCount),y+cowY);
			}
		}
		if(!endGame) {
			g.setColor(new Color(0,0,0));
			g.fillRect(0, 550, 70, 50);
			g.drawImage(goldenshard, -40,510,null);
			g.setFont(customFont);
			g.setColor(new Color(255,255,255));
			g.drawString("x"+shards,33,580);
		}
		
		
		for(int i=0;i<bullets.size();i++) {
			bullets.get(i).drawMe(g);
			bullets.get(i).move();
			if(bullets.get(i).outOfScreen()) {
				bullets.remove(i);
			}
		}
		for(int i=0;i<bossbullets.size();i++) {
			bossbullets.get(i).drawMe(g,x,y);
			bossbullets.get(i).move();
			if(bossbullets.get(i).outOfScreen()) {
				//bossbullets.remove(i);
			}
		}
		for(BadRobot b:robots) {
			b.drawMe(g,robot,x,y);
			b.move(playerX,playerY,x,y);
		}
		if(questTrigger) {
			g.setColor(new Color(0,0,0));
			if(triggerCounter>50)g.fillRect(400+((triggerCounter-50)*2),0,200,50);
			else g.fillRect(400,0,200,50);
			g.setFont(customFont);
			g.setColor(new Color(255,255,255));
			if(triggerCounter>50)g.drawString("Quest completed!", 410+((triggerCounter-50)*2),30);
			else g.drawString("Quest completed!", 410,30);
			triggerCounter--;
		}
		if(startQuestTrigger) {
			
			g.setColor(new Color(0,0,0));
			if(triggerCounter>50)g.fillRect(400+((triggerCounter-50)*2),0,200,50);
			else g.fillRect(400,0,200,50);
			g.setFont(customFont);
			g.setColor(new Color(255,255,255));
			if(triggerCounter>50)g.drawString("Quest started.", 430+((triggerCounter-50)*2),30);
			else g.drawString("Quest started.", 430,30);
			triggerCounter--;
		}
		if(triggerCounter<0) {
			questTrigger=false;
			startQuestTrigger=false;
		}
		/*
		for(int k=0;k<bullets.size();k++) {
			for(int i=0;i<robots.size();i++) {
				int x1=robots.get(i).getX(x);
				int y1=robots.get(i).getY(y);
				int x2=bullets.get(k).getX();
				int y2=bullets.get(k).getY();
				//System.out.println(x1+" "+y1+" "+x2+" "+y2);
				if(Math.abs(x2-x1)-50<10 && Math.abs(y2-y1+70)<50) {
					//System.out.println("COLLISION");
					
					explosionCounter=100;
					explosionX=x1-50;
					explosionY=y1-70;
					robots.remove(i);
					bullets.remove(k);
					repaint();
					break;
				}
			}
		}
		*/
		for(int i=0;i<robots.size();i++) {
			for(int k=0;k<bullets.size();k++) {
				int x1=robots.get(i).getX(x);
				int y1=robots.get(i).getY(y);
				int x2=bullets.get(k).getX();
				int y2=bullets.get(k).getY();
				//System.out.println(x1+" "+y1+" "+x2+" "+y2);
				
				if(Math.abs(x2-x1)-50<10 && Math.abs(y2-y1+80)<50) {
					//System.out.println("COLLISION");
					//System.out.println(i);
					explosionCounter=50;
					explosionX=x1-50;
					explosionY=y1-70;
					slowMo=true;
					killCount++;
					if(killCount==3 && quest==1 && questReward==false) {
						completedQuest++;
						questReward=true;
						questTrigger=true;
						triggerCounter=150;
						//System.out.println("COMPLETED");
					}
					if(killCount==13 && quest==3 && questReward==false) {
						completedQuest++;
						questReward=true;
						questTrigger=true;
						triggerCounter=150;
						//System.out.println("COMPLETED");
					}
					//System.out.println(robots.size());
					/*
					for(int a=0;a<robots.size();a++) {
						int xx1=robots.get(a).getX(x);
						int yy1=robots.get(a).getY(y);
						//System.out.println("r");
						if(Math.abs(x2-xx1)-50<200 && Math.abs(y2-yy1+70)<100) {
							//System.out.println("area destruction");
							robots.remove(a);
						}
					}
					*/
					robots.remove(i);
					bullets.remove(k);
					repaint();
					break;
				}
			}
		}
		if(endGame) {
		for(int i=0;i<bullets.size();i++) {
			int x1=epicboss.getX(x);
			int y1=epicboss.getY(y);
			int x2=bullets.get(i).getX();
			int y2=bullets.get(i).getY();
			if(Math.abs(x2-x1)-50<10 && Math.abs(y2-y1+80)<100) {
				bossHits++;
				//System.out.println("HIT");
				
				explosionCounter=50;
				explosionX=x1+20;
				explosionY=y1-30;
				slowMo=true;
				if(bossHits==3 && !lost) {
					//System.out.println("GG");
					gg=true;
					audioClip.stop();
					wonTransition=127;
				}
				bullets.remove(i);
				repaint();
				break;
			}
			
		}
		}
		if(endGame) {
			for(int i=0;i<bossbullets.size();i++) {
				int x1=playerX;
				int y1=playerY;
				int x2=bossbullets.get(i).getX()+100;
				int y2=bossbullets.get(i).getY();
				//if(i==3)System.out.println(x2+" "+y2);
				//if(i==3)System.out.println(x1+" player "+y1);
				if(Math.abs(x2-x1)<70 && Math.abs(y2-y1+100)<50 && !gg) {
					//System.out.println("DEAD:(");
					if(!lost) {
						lostTransition=124;
						audioClip.stop();
					}
					lost=true;
					
				}
			}
		}
		for(BadRobot r:robots) {
			int x1=r.getX(x);
			int y1=r.getY(y);
			//System.out.println(x1+" "+y1);
			if(Math.abs(x1-345)<25 && Math.abs(y1-360)<50) {
				this.x=100;
				this.y=100;
				playerX=250;
				playerY=255;
				inBoat=false;
				boatX=ogBoatX;
				boatY=ogBoatY;
				repaint();
			}
			/*
			if(Math.abs(x1-playerX)<100 && Math.abs(y1-y)<100) {
				this.x=100;
				this.y=100;
				playerX=250;
				playerY=255;
				inBoat=false;
				boatX=ogBoatX;
				boatY=ogBoatY;
				repaint();
			}
			*/
		}
		if(endGame) {
			int bossX=epicboss.getX(x);
			int bossY=epicboss.getY(y);
			if(Math.abs(bossX-345)<100 && Math.abs(bossY-360)<100 && !gg) {
				if(!lost) {
					lostTransition=124;
					audioClip.stop();
				}
				lost=true;
			}
		}
		
		if(endTransition>0) {
			//System.out.println(alpha);
		
			//System.out.println((int)0.5*(500+-1*(endTransition-500)));
			g.setColor(new Color(255,255,255,alpha));
			g.fillRect(0, 0, 600, 600);
		}
		if(lost) {
			if(lostTransition>0)lostTransition--;
			if(lostTransition>0)lostAlpha+=2;
			g.setColor(new Color(0,0,0,lostAlpha));
			g.fillRect(0, 0, 600, 600);
			if(lostTransition==0) {
				g.setColor(new Color(255,255,255));
				g.setFont(customFontBig);
				g.drawString("R.I.P.", 200,200);
				g.setFont(customFont);
				g.drawString("Better luck next time...", 200,300);
				
			}
			
		}
		if(gg) {
			if(wonTransition>0)wonTransition--;
			if(wonTransition>0)wonAlpha+=2;
			g.setColor(new Color(255,255,255,wonAlpha));
			g.fillRect(0, 0, 600, 600);
			if(wonTransition==0) {
				g.setColor(new Color(0,140,0));
				g.setFont(customFontBig);
				g.drawString("GG :)", 200,200);
				g.setFont(customFont);
				g.drawString("", 200,300);
			}
		}
	}
	public void drawMiniMap(Graphics g) {
		g.setColor(new Color(0,0,0));
		g.drawRect(0, 0, 100, 100);
		miniMap[playerMapY][playerMapX]=ogMiniMap[playerMapY][playerMapX];
		miniMap[playerMapY-1][playerMapX-1]=ogMiniMap[playerMapY-1][playerMapX-1];
		miniMap[playerMapY-1][playerMapX]=ogMiniMap[playerMapY-1][playerMapX];
		miniMap[playerMapY-1][playerMapX+1]=ogMiniMap[playerMapY-1][playerMapX+1];
		miniMap[playerMapY][playerMapX-1]=ogMiniMap[playerMapY][playerMapX-1];
		miniMap[playerMapY][playerMapX+1]=ogMiniMap[playerMapY][playerMapX+1];
		miniMap[playerMapY+1][playerMapX-1]=ogMiniMap[playerMapY+1][playerMapX-1];
		miniMap[playerMapY+1][playerMapX]=ogMiniMap[playerMapY+1][playerMapX];
		miniMap[playerMapY+1][playerMapX+1]=ogMiniMap[playerMapY+1][playerMapX+1];
		playerMapX=playerX/40+50;
		playerMapY=playerY/40+50;
		miniMap[playerMapY-1][playerMapX-1]=2;
		miniMap[playerMapY-1][playerMapX]=2;
		miniMap[playerMapY-1][playerMapX+1]=2;
		miniMap[playerMapY][playerMapX-1]=2;
		miniMap[playerMapY][playerMapX+1]=2;
		miniMap[playerMapY+1][playerMapX-1]=2;
		miniMap[playerMapY+1][playerMapX]=2;
		miniMap[playerMapY+1][playerMapX+1]=2;
		miniMap[playerMapY][playerMapX]=2;
		for(int i=0;i<miniMap.length;i++) {
			for(int k=0;k<miniMap[i].length;k++) {
				if(miniMap[i][k]==0) {
					g.setColor(new Color(3,252,252));
				}else if(miniMap[i][k]==1) {
					g.setColor(new Color(255,235,56));
				}else if(miniMap[i][k]==2) {
					g.setColor(new Color(255,0,0));
				}
				g.fillRect(k,i, 1, 1);
			}
		}
		g.setFont(customFont);
		g.setColor(new Color(0,0,0));
		g.drawString("Quest: "+(quest+1), 500,570);
			
		
	}
	
	public void checkWaterCollision(Graphics g) {
		try {
			Robot robot=new Robot();
			
			double xx =getLocationOnScreen().getX();
			double yy=getLocationOnScreen().getY();
			Color color;
			if(facingLeft) {
				color=robot.getPixelColor((int)xx+280,(int)yy+310);
			}else {
				color=robot.getPixelColor((int)xx+300,(int)yy+310);
			}
			
			if(color.getRed()==3) {
				//System.out.println("you died");
				this.x=100;
				this.y=100;
				playerX=250;
				playerY=255;
				inBoat=false;
				boatX=ogBoatX;
				boatY=ogBoatY;
				repaint();
			}
		
			if(inBoat) {
				
				//collision check
				//System.out.println("x: "+x+" y: "+y);
				boolean foundCollision=false;
				stop:
				for(Island island:islands) {
					int leftX;
					int rightX;
					int topY;
					int bottomY;
					if(island.getTopLeftX()<=0) {
						leftX=-1*island.getTopLeftX()+250;
					}else {
						leftX=island.getTopLeftX()+250;
					}
					if(island.getBottomRightX()<0) {
						rightX=-1*island.getBottomRightX()+250;
					}else {
						rightX=-1*island.getBottomRightX()+250;
					}
					if(island.getTopLeftY()<0) {
						topY=-1*island.getTopLeftY()+250;
					}else {
						topY=island.getTopLeftY()+250;
					}
					if(island.getBottomRightY()<0) {
						bottomY=-1*island.getBottomRightY()+350;
					}else {
						bottomY=island.getBottomRightY()-250;
					}
					//System.out.println(y);
					//System.out.println(topY);
					//System.out.println(bottomY);
					
					//System.out.println(x);
					//System.out.println(y);
					
					if(x-90<=leftX && x>=rightX && y+100>=bottomY && y-100<=topY && boatCounter>=10) {
						//System.out.println(x+100);
						//System.out.println(rightX);
						if(dPWMBC.equals("")) {
							if(movingRight) {
								dPWMBC="R";
							}else if(movingLeft) {
								dPWMBC="L";
							}else if(movingUp) {
								dPWMBC="U";
							}else if(movingDown){
								dPWMBC="D";
							}
						}
						
						if(dPWMBC.equals("R")) {
							noRight=true;
						}else if(dPWMBC.equals("L")) {
							noLeft=true;
						}else if(dPWMBC.equals("U")) {
							noUp=true;
						}else if(dPWMBC.equals("D")){
							noDown=true;
						}
						foundCollision=true;
						break stop;
					}else {
						noRight=false;
						noLeft=false;
						noUp=false;
						noDown=false;
						dPWMBC="";
					}
				}
					
			}else {
				boatCounter=0;
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void animate() {
		while(true) {
			
		
		try {
			if(slowMo) {
				Thread.sleep(50);
			}else {
				Thread.sleep(15);
			}
		}catch(InterruptedException e) {
			System.out.println("eeeeeeeee (thread sleep didnt work)");
		}
		//animTest++;
		//System.out.println("a: "+animTest);
		//System.out.println(playerX);
		if(movingUp && !noUp) {
			if(inBoat) {
				boatCounter++;
			}
			y+=speed;
			playerY-=speed;
		}
		if(movingDown && !noDown) {
			if(inBoat) {
				boatCounter++;
			}
				y-=speed;
				playerY+=speed;
			
			
		}
		if(movingRight && !noRight) {
			if(inBoat) {
				boatCounter++;
			}
				x-=speed;
				playerX+=speed;
			
			
		}
		if(movingLeft && !noLeft) {
			if(inBoat) {
				boatCounter++;
			}
				x+=speed;
				playerX-=speed;
		}
		

		
		
		if(inBoat) {
			boatX=-1*x+240;
			boatY=-1*y+250;
			speed=10;
		}else {
			speed=5;
		}
		//.out.println(playerY);
		if(quest==2 && questReward==false) {
			if(playerX>=0 && playerX<=700 && playerY<=-1000 && playerY>=-2000) {
				
					
					completedQuest++;
					questReward=true;
					questTrigger=true;
					triggerCounter=150;
					//System.out.println("COMPLETED");
				
			}
		}
		
		if(endGame && !gg) {
			epicboss.move(playerX, playerY, x, y);
			
			int random=(int)(Math.random()*100);
			if(random==0) {
				bossRounds=30;
			}else if(bossRounds>=0){
				bossRounds--;
			}
			if(random==0 || bossRounds%10==0) {
				BossBullet b=new BossBullet(5,5,epicboss.getX(x)-x-20,epicboss.getY(y)-y-20,bossbullet,"R");
				BossBullet b2=new BossBullet(5,5,epicboss.getX(x)-x-20,epicboss.getY(y)-y-20,bossbullet,"L");
				BossBullet b3=new BossBullet(5,5,epicboss.getX(x)-x-20,epicboss.getY(y)-y-20,bossbullet,"U");
				BossBullet b4=new BossBullet(5,5,epicboss.getX(x)-x-20,epicboss.getY(y)-y-20,bossbullet,"D");
				bossbullets.add(b);
				bossbullets.add(b2);
				bossbullets.add(b3);
				bossbullets.add(b4);
				//bossRounds--;
				//System.out.println("FIRE");
			}
		}
		repaint();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==38) {
			movingUp=true;
			movingLeft=false;
			movingRight=false;
			movingDown=false;
		}
		if(e.getKeyCode()==40) {
			movingDown=true;
			movingLeft=false;
			movingRight=false;
			movingUp=false;
		}
		if(e.getKeyCode()==39) {
			movingRight=true;
			facingLeft=false;
			movingLeft=false;
			movingUp=false;
			movingDown=false;
		}
		if(e.getKeyCode()==37) {
			movingLeft=true;
			facingLeft=true;
			movingUp=false;
			movingDown=false;
			movingRight=false;
					
		}
		
		if(e.getKeyChar()=='b') {
			
			int targetX=-1*boatX+240;
			int targetY=-1*boatY+250;
			if(Math.abs(x-targetX)<100 && Math.abs(y-targetY)<100) {
				x=-1*boatX+240;
				y=-1*boatY+250;
				inBoat=!inBoat;
				if(quest==0 && questReward==false) {
					
					completedQuest++;
					questReward=true;
					questTrigger=true;
					triggerCounter=150;
					//System.out.println("COMPLETED");
				}
			}
			
			noRight=false;
			noLeft=false;
			noUp=false;
			noDown=false;
					
			repaint();
		}
		if(e.getKeyCode()==32 && gunEnabled) {
			Bullet b;
			if(facingLeft) {
				b=new Bullet(10,0,250-60,255-4,rocket,facingLeft);
			}else {
				b=new Bullet(10,0,250+60,255-4,rocket,facingLeft);
			}
			
			bullets.add(b);
		}
		if(e.getKeyChar()=='i') {
			
			if(Math.abs(playerX-cowX-100)<100 && Math.abs(playerY-cowY-120)<100) {
				if(questReward==true) {
					questReward=false;
					
					rewardInteracting=true;
				}else {
					quest++;
					//System.out.println("quest:"+quest);
							
					charCount=0;
					interacting=true;
				}
				
			}
			
		}
		if(e.getKeyCode()==10 && (interacting==true || rewardInteracting==true)) {
			interactionStep++;
			if(completedQuest==3 && interactionStep==3 && endGame==false) {
				//System.out.println("END");
				endTransition=153;
				
			}
			if(interacting) {
				if(interactionStep>=quests.get(quest).getDialogue().length) {
					interacting=false;
					interactionStep=0;
					startQuestTrigger=true;
					triggerCounter=150;
				}
			}else {
				if(interactionStep>=rewards.get(completedQuest).getDialogue().length) {
					rewardInteracting=false;
					interactionStep=0;
					
				}
			}
			
			charCount=0;
		}
		if(e.getKeyCode()==192) {
			completedQuest++;
			if(quest==completedQuest-1)quest+=1;
			if(completedQuest==1)gunEnabled=true;
			if(completedQuest==2 && shards==0) {
				shards++;
				killCount=3;
			}
			if(completedQuest==3 && shards==1)shards++;
			if(completedQuest==4 && shards==2) {
				shards++;
			}
			if(completedQuest==4) {
				endTransition=153;
			}else if(!endGame){
				questReward=true;
				questTrigger=true;
				triggerCounter=150;
				//System.out.println("COMPLETED");
			}
			if(endGame) {
				gg=true;
				audioClip.stop();
				wonTransition=127;
			}
			
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==38) {
			movingUp=false;
		}
		if(e.getKeyCode()==40) {
			movingDown=false;
		}
		if(e.getKeyCode()==39) {
			movingRight=false;
		}
		if(e.getKeyCode()==37) {
			movingLeft=false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(e.getX()+" "+e.getY());
		if(e.getX()>150 && e.getX()<455 && e.getY()>330 && e.getY()<477 && starting) {
			starting=false;
			repaint();
		}
		if(e.getX()>257 && e.getX()<355 && e.getY()>530 && e.getY()<577 && starting) {
			about=true;
			repaint();
		}
		if(e.getX()>27 && e.getX()<125 && e.getY()>49 && e.getY()<97 && about) {
			about=false;
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
	
	
	//actually dead code
	/*
	//System.out.println("ON ISLAND");
	if(x-100<=leftX && x+100>=rightX) {
		if(x<-1*(rightX-leftX)/2) {
			noLeft=true;
		}else {
			noRight=true;
		}
		//System.out.println("MOVEMENT LIMITED");
		System.out.println(island.getTopLeftX());
		//break stop;
		
	}
	if(y-100<=topY && y+100>=bottomY) {
		if(y<-1*(bottomY-topY)/2) {
			noUp=true;
		}else {
			noDown=true;
		}
		System.out.println("MOVEMENT LIMITED");
		//break stop;
		
	}
	
}else {
	//System.out.println("MOVEMENT NOT LIMITED");
	
			
	/*
	System.out.println(x-100);
	System.out.println(leftX);
	System.out.println(x+100);
	System.out.println(rightX);
	System.out.println(y+100);
	System.out.println(bottomY);
	System.out.println(y-100);
	System.out.println(topY);
	System.out.println("MOVEMENT NOT LIMITED");
	
}
//System.out.println(rightX);
}
if(!foundCollision) {
dPWMBC="";
noLeft=false;
noRight=false;
noUp=false;
noDown=false;
}
/*
Color boatcolor=robot.getPixelColor((int)x+200, (int)y+310); //color to the left of boat
Color boatcolor2=robot.getPixelColor((int)x+400, (int)y+310); //color to the right of boat
Color boatcolor3=robot.getPixelColor((int)x+300, (int)y+360); //color to the down of boat
Color boatcolor4=robot.getPixelColor((int)x+300, (int)y+260); //color to the up of boat
//System.out.println(counter);
if((boatcolor.getRed()==255 || boatcolor2.getRed()==255 || boatcolor3.getRed()==255 || boatcolor4.getRed()==255) && counter>25) {
//System.out.println("kicked out of boat");
inBoat=false;
counter=-1;
speed=5;
repaint();
}
*/

	
	
}
