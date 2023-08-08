import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Screen extends JPanel implements KeyListener,MouseListener,MouseMotionListener{
	private MyHashTable<Vector,String> map;
	private Player p;
	private int mCooldown=0;
	private int pCooldown=0;
	private int placeholderX=202;
	private int placeholderY=202;
	private int orangeX=-100;
	private int orangeY=-100;
	private int blueX=-100;
	private int blueY=-100;
	private int portalDestination=0;
	private boolean canPlace=true;
	private int level=0;
	private boolean inTransition=false;
	private ArrayList<Box> boxes=new ArrayList<>();
	private ArrayList<Button> buttons=new ArrayList<>();
	private ArrayList<Robot> robots=new ArrayList<>();
	private BufferedImage quest;
	String instructions="";
	int fontSize=30;
	int fontSize2=30;
	int fontSize3=30;
	private float timer=1000;
	private NPC npc;
	private int npcCharactersDisplaying=-1;
	int save=-1;
	Color loadGame=new Color(200,200,200);
	int counter=0;
	ArrayList<Vector> squaresFilled=new ArrayList<>();
	
	private final int SWIDTH=640;
	private final int SHEIGHT=640;
	private final int GWIDTH=32;
	private final int GHEIGHT=32;
	private final int GSIZE=SWIDTH/GWIDTH;
	private final int PSTARTX=21;
	private final int PSTARTY=21;
	private final int EXITX=563;
	private final int EXITY=563;
	private final int MSPEED=20;
	private final int MDELAY=6;
	private final int PDELAY=10;
	private final int FPS=100;
	private final int POFFSET=18;
	private final int PCOOLDOWN=1000;
	private final int PRANGE=200;
	private final int PSIZE=35;
	private final int XOFFSET=1;
	private final int YOFFSET=2;
	private final Color BACKGROUND=new Color(230,230,230);
	private final Color BORDER=new Color(200,200,200);
	private final Color WALL=new Color(61, 61, 61);
	private final Color ORANGE=new Color(245, 199, 73);
	private final Color BLUE=new Color(73, 136, 245);
	private final Color PLACEHOLDER=new Color(196,196,196);
	private final Color CANTPLACE=new Color(255, 153, 153);
	private final Color EXIT=new Color(92, 255, 95);
	
	public Screen() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		readMap(1);
		loadSave();
		quest=ImageIO.read(new File("questreal.png"));
		p=new Player(PSTARTX,PSTARTY);
		addKeyListener(this);
	} 
	public void loadSave() throws IOException{
		BufferedReader r=new BufferedReader(new FileReader("save.txt"));
		save=Integer.parseInt(r.readLine());
		if(save>0) {
			loadGame=new Color(0,0,0);
		}
	}
	public void readMap(int level) throws IOException {
		if(level%2==1 && level<8) { //npc level
			map=new MyHashTable<>();
			BufferedReader r=new BufferedReader(new FileReader("blankmap.txt"));
			for(int i=0;i<GHEIGHT;i++) {
				String s=r.readLine();
				String[] string=s.split("");
				for(int k=0;k<GWIDTH;k++) {
					Vector v=new Vector(k,i);
					map.put(v,string[k]);
				}
			}
			inTransition=false;
			
			if(level==1) {
				npc=new NPC(221,221,"You can move with arrow keys.",level);
				Runner.hideCursor();
			}
			if(level==3) {
				npc=new NPC(221,221,"You can place portals with left and right click.",level);
			}
			if(level==5) {
				npc=new NPC(321,321,"You can move boxes around to activate buttons.",level);
			}
			if(level==7) {
				npc=new NPC(221,221,"You can collect keys to unlock a new path.",level);
			}
			
			
		}else { //actual level
			
			map=new MyHashTable<>();
			String lev="map"+(level/2)+".txt";
			if(level>=9) {
				lev="map"+(level-4)+".txt";
			}
			BufferedReader r=new BufferedReader(new FileReader(lev));
			for(int i=0;i<GHEIGHT;i++) {
				String s=r.readLine();
				String[] string=s.split("");
				for(int k=0;k<GWIDTH;k++) {
					Vector v=new Vector(k,i);
					map.put(v,string[k]);
				}
			}
			inTransition=false;
			boxes=new ArrayList<>();
			buttons=new ArrayList<>();
			robots=new ArrayList<>();
			npc=null;
			timer=30;
			if(level==2) {
				instructions="Get to the Green Portal.";
				Runner.hideCursor();
			}
			if(level==4) {
				instructions="Use a Portal.";
				
			}
			if(level==6) {
				boxes.add(new Box(63,63));
				buttons.add(new Button(305,65,new Vector[] {new Vector(14,8),new Vector(15,8),new Vector(16,8),new Vector(17,8),new Vector(14,9),new Vector(15,9),new Vector(16,9),new Vector(17,9),new Vector(14,10),new Vector(15,10),new Vector(16,10),new Vector(17,10),new Vector(14,11),new Vector(15,11),new Vector(16,11),new Vector(17,11),new Vector(14,12),new Vector(15,12),new Vector(16,12),new Vector(17,12),new Vector(14,13),new Vector(15,13),new Vector(16,13),new Vector(17,13),new Vector(14,14),new Vector(15,14),new Vector(16,14),new Vector(17,14),new Vector(14,15),new Vector(15,15),new Vector(16,15),new Vector(17,15),new Vector(14,16),new Vector(15,16),new Vector(16,16),new Vector(17,16),new Vector(14,17),new Vector(15,17),new Vector(16,17),new Vector(17,17)}));
				
				instructions="Activate the Button.";
				
				
			}
			if(level==8) {
				Robot bot=new Robot(201,101,new Vector[] {new Vector(14,8),new Vector(15,8),new Vector(16,8),new Vector(17,8),new Vector(14,9),new Vector(15,9),new Vector(16,9),new Vector(17,9),new Vector(14,10),new Vector(15,10),new Vector(16,10),new Vector(17,10),new Vector(14,11),new Vector(15,11),new Vector(16,11),new Vector(17,11),new Vector(14,12),new Vector(15,12),new Vector(16,12),new Vector(17,12),new Vector(14,13),new Vector(15,13),new Vector(16,13),new Vector(17,13),new Vector(14,14),new Vector(15,14),new Vector(16,14),new Vector(17,14),new Vector(14,15),new Vector(15,15),new Vector(16,15),new Vector(17,15),new Vector(14,16),new Vector(15,16),new Vector(16,16),new Vector(17,16),new Vector(14,17),new Vector(15,17),new Vector(16,17),new Vector(17,17)});
				robots.add(bot);
				Thread thread=new Thread(bot);
				thread.start();
				instructions="Collect the Key.";	
			}
			if(level==9) {
				boxes.add(new Box(63,63));
				buttons.add(new Button(305,65,new Vector[] {new Vector(5,20)}));
				instructions="Escape";	
			}
			if(level==10) {
				boxes.add(new Box(543,123));
				buttons.add(new Button(583,125,new Vector[] {new Vector(29,11)}));
				Robot bot=new Robot(201,101,new Vector[] {new Vector(20,6),new Vector(21,6),new Vector(20,7),new Vector(21,7)});
				robots.add(bot);
				Thread thread=new Thread(bot);
				thread.start();
				instructions="Escape";
			}
			if(level==11) {
				Robot bot=new Robot(341,61,new Vector[] {new Vector(20,15),new Vector(21,15),new Vector(20,16),new Vector(21,16)});
				robots.add(bot);
				Thread thread=new Thread(bot);
				thread.start();
				instructions="Escape";
			}
			if(level==12) {
				boxes.add(new Box(83,23));
				//7 7   13 7  10 11   16 14   26 16   23 20
				buttons.add(new Button(145,25,new Vector[] {new Vector(7,7)}));
				buttons.add(new Button(185,25,new Vector[] {new Vector(14,7)}));
				buttons.add(new Button(225,25,new Vector[] {new Vector(11,11)}));
				buttons.add(new Button(265,25,new Vector[] {new Vector(17,14)}));
				buttons.add(new Button(305,25,new Vector[] {new Vector(27,16)}));
				buttons.add(new Button(345,25,new Vector[] {new Vector(24,20)}));
				instructions="Escape";
			}
			if(level==14) {
				Robot bot=new Robot(201,301,new Vector[] {new Vector(14,8),new Vector(15,8),new Vector(16,8),new Vector(17,8),new Vector(14,9),new Vector(15,9),new Vector(16,9),new Vector(17,9),new Vector(14,10),new Vector(15,10),new Vector(16,10),new Vector(17,10),new Vector(14,11),new Vector(15,11),new Vector(16,11),new Vector(17,11),new Vector(14,12),new Vector(15,12),new Vector(16,12),new Vector(17,12),new Vector(14,13),new Vector(15,13),new Vector(16,13),new Vector(17,13),new Vector(14,14),new Vector(15,14),new Vector(16,14),new Vector(17,14),new Vector(14,15),new Vector(15,15),new Vector(16,15),new Vector(17,15),new Vector(14,16),new Vector(15,16),new Vector(16,16),new Vector(17,16),new Vector(14,17),new Vector(15,17),new Vector(16,17),new Vector(17,17)});
				robots.add(bot);
				Thread thread=new Thread(bot);
				thread.start();
				instructions="Escape";
			}
			
		}
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(SWIDTH,SHEIGHT);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(level==0) {
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			menuBackground(g);
			
		}else if(level==-72769) {
			g.setFont(new Font("Inter Tight",Font.PLAIN,30));
			g.drawString("Tutorial", 200,100);
			g.drawString("Move with arrow keys", 100,140);
			g.drawString("Press F to interact with NPC",100,180);
			g.drawString("Press Enter to continue", 100,220);
			g.drawString("Click anywhere to go back", 100,300);
		}else if(level==15) {
			g.setFont(new Font("Inter Tight",Font.PLAIN,30));
			g.drawString("Congrats, you beat the game :)", 100,100);
			
		}
		else if(level%2==0 || level>=9){
			renderMap(g);
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);
			for(Button button:buttons) {
				button.drawMe(g);
			}
			for(Box box:boxes) {
				box.drawMe(g);
			}
			for(Robot robot:robots) {
				robot.drawMe(g);
			}
			
			
			
			if(canPlace) {
				g.setColor(PLACEHOLDER);
			}else {
				g.setColor(CANTPLACE);
			}
			g.fillOval(placeholderX, placeholderY, PSIZE,PSIZE);
			g.setColor(ORANGE);
			g.fillOval(orangeX, orangeY, PSIZE,PSIZE);
			g.setColor(BLUE);
			g.fillOval(blueX, blueY, PSIZE,PSIZE);
			g.setColor(EXIT);
			g.fillOval(EXITX, EXITY, 55,55);
			p.drawMe(g);
			
			g.setColor(BACKGROUND);
			g.fillRect(440, 0,200,100);
			g.setColor(WALL);
			g.setFont(new Font("Inter Tight",Font.PLAIN,25));
			int questNum=level-4;
			if(level<9) {
				questNum=level/2;
			}
			g.drawString("Quest "+questNum, 503,31);
			g.setFont(new Font("Inter Tight",Font.PLAIN,17));
			g.drawString(instructions,468+4*(20-instructions.length()),53);
			g.setFont(new Font("Inter Tight",Font.PLAIN,35));
			if(timer>=0) {
				g.drawString(Math.round(timer*100.0f)/100.0f+"", 495,90);
			}else {
				g.drawString("RUN", 499,90);
			}
		}else {
			renderMap(g);
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);
			p.drawMe(g);
			npc.drawMe(g);
			if(npcCharactersDisplaying>=0) {
				int r=g.getFontMetrics(new Font("Inter Tight",Font.PLAIN,20)).stringWidth(npc.dialog);
				
				g.setColor(BACKGROUND);
				//g.fillRect(npc.x-r/2+20,npc.y-40,r+10,30);
				g.setColor(new Color(100,100,100));
				g.drawRect(npc.x-r/2+20,npc.y-40,r+10,30);
				g.setFont(new Font("Inter Tight",Font.PLAIN,20));
				g.setColor(new Color(50,50,50));
				g.drawString(npc.dialog.substring(0,npcCharactersDisplaying),npc.x-r/2+25,npc.y-20);
				
				if(npcCharactersDisplaying!=npc.dialog.length()-1) {
					npcCharactersDisplaying++;
				}
			}
		}
	}
	public void renderMap(Graphics g){
		DLList<Vector> m=map.keySet().toDLList();
		for(int i=0;i<m.size();i++) {
			Vector v=m.get(i);
			DLList<String> square=map.get(v);
			try {
				
			
			String first=square.get(0);
			if(first.equals("b")) {
				g.setColor(BACKGROUND);
				g.fillRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
				g.setColor(BORDER);
				g.drawRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
			}
			if(first.equals("w")) {
				g.setColor(WALL);
				g.fillRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
			}
			if(first.equals("p")) {
				g.setColor(BACKGROUND);
				g.fillRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
				g.setColor(BORDER);
				g.drawRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
				g.setColor(new Color(0, 204, 41));
				g.fillOval(v.x*GSIZE+3, v.y*GSIZE+3, GSIZE-6,GSIZE-6);
			}
			if(square.get(1)!=null){
				if(square.get(1).equals("r")) {
					g.setColor(new Color(255,0,0));
					g.fillRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
					g.setColor(new Color(255,0,0));
					g.drawRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
					
				}
			}
			}catch(NullPointerException e) {
				//...
			}
		}
	}
	public void animate() throws InterruptedException {
		while(true) {
			if(!inTransition) {	
				if(mCooldown>0) {
					mCooldown--;
				}
				if(pCooldown>0) {
					pCooldown--;
				}
				int x=MouseInfo.getPointerInfo().getLocation().x-this.getLocationOnScreen().x-POFFSET;
				int y=MouseInfo.getPointerInfo().getLocation().y-this.getLocationOnScreen().y-POFFSET;
				placeholderX=GSIZE*Math.round(x/GSIZE)+2;
				placeholderY=GSIZE*Math.round(y/GSIZE)+2;
				int xindex=placeholderX/20;
				int yindex=placeholderY/20;
				if(xindex>=0 && yindex>=0 && xindex<GWIDTH-1 && yindex<GHEIGHT-1) {
					if(Math.abs(p.x-placeholderX+XOFFSET)>PRANGE || Math.abs(p.y-placeholderY+YOFFSET)>PRANGE || (map.get(new Vector(xindex,yindex)).get(0).equals("w")) || (map.get(new Vector(xindex+1,yindex)).get(0).equals("w")) || (map.get(new Vector(xindex,yindex+1)).get(0).equals("w")) || (map.get(new Vector(xindex+1,yindex+1)).get(0).equals("w") || (map.get(new Vector(xindex,yindex)).get(0).equals("p")) || (map.get(new Vector(xindex+1,yindex)).get(0).equals("p")) || (map.get(new Vector(xindex,yindex+1)).get(0).equals("p")) || (map.get(new Vector(xindex+1,yindex+1)).get(0).equals("p")))) {
						canPlace=false;
					}else {
						canPlace=true;
					}
					if((Math.abs(p.x/MSPEED-orangeX/MSPEED)<=0 && Math.abs(p.y/MSPEED-orangeY/MSPEED)<=0) && pCooldown==0) {
						pCooldown=PDELAY;
						portalDestination=1;
					}
					if((Math.abs(p.x/MSPEED-blueX/MSPEED)<=0 && Math.abs(p.y/MSPEED-blueY/MSPEED)<=0) && pCooldown==0) {
						pCooldown=PDELAY;
						portalDestination=0;
					}
					if(pCooldown==1) {
						if(portalDestination==0 && (Math.abs(p.x/MSPEED-blueX/MSPEED)<=0 && Math.abs(p.y/MSPEED-blueY/MSPEED)<=0 && orangeX!=-100)) {
							p.x=orangeX-XOFFSET;
							p.y=orangeY-YOFFSET;
							pCooldown=PCOOLDOWN;
							try {
								URL url = this.getClass().getClassLoader().getResource("teleport.wav");
								Clip portal = AudioSystem.getClip();
						        portal.open(AudioSystem.getAudioInputStream(url));
								portal.start();
					        } catch (Exception exc) {
					            exc.printStackTrace(System.out);
					        }
						}
						if(portalDestination==1 && (Math.abs(p.x/MSPEED-orangeX/MSPEED)<=0 && Math.abs(p.y/MSPEED-orangeY/MSPEED)<=0 && blueX!=-100)) {
							p.x=blueX-XOFFSET;
							p.y=blueY-YOFFSET;
							pCooldown=PCOOLDOWN;
							try {
								URL url = this.getClass().getClassLoader().getResource("teleport.wav");
								Clip portal = AudioSystem.getClip();
						        portal.open(AudioSystem.getAudioInputStream(url));
								portal.start();
					        } catch (Exception exc) {
					            exc.printStackTrace(System.out);
					        }
						}
					}
				}
				repaint();
			}
			timer-=0.01d;
			if(timer<=0) {
				if(counter==0) {
					map.put(new Vector(0,0), "r");
					squaresFilled.add(new Vector(0,0));
				}
				counter++;
				
				
				//ArrayList<Vector> squaresFilled=new ArrayList<>();
				
				if(counter%10==0) {
					//System.out.println("EEEE");
					int size=squaresFilled.size();
					for(int i=0;i<size;i++) {
						int x=squaresFilled.get(i).x;
						int y=squaresFilled.get(i).y;
						Vector[] neighbors=new Vector[] {new Vector(x-1,y-1),new Vector(x-1,y),new Vector(x-1,y+1),new Vector(x,y-1),new Vector(x,y+1),new Vector(x+1,y-1),new Vector(x+1,y),new Vector(x+1,y+1)};
						for(Vector neighbor:neighbors) {
							//System.out.println(neighbor);
							if(neighbor.x>=0 && neighbor.y>=0 && map.get(neighbor).get(1)==null) {
								map.put(neighbor, "r");
								squaresFilled.add(neighbor);
							}
						}
					}
					if(Math.floor(p.x/20.0f)<(counter/10) && Math.floor(p.y/20.0f)<(counter/10)) {
						try {
							//level--;
							previousLevel();
							save=0;
							counter=0;
							squaresFilled.clear();
							//loadGame=new Color(200,200,200);
							BufferedWriter b=new BufferedWriter(new FileWriter("save.txt"));
							b.write(""+level);
							b.close();
						} catch (IOException e) {
							
						}
					}
				}
			
			}
			repaint();
			Thread.sleep(1000/FPS);
		}
	}
	public boolean collision(Player p,Box b,int radius) {
		return (Math.abs(p.x/MSPEED-b.x/MSPEED)<=radius && Math.abs(p.y/MSPEED-b.y/MSPEED)<=radius);
	}
	public boolean collision(Player p,Robot k,int radius) {
		return (Math.abs(p.x/MSPEED-k.x/MSPEED)<=radius && Math.abs(p.y/MSPEED-k.y/MSPEED)<=radius);
	}
	public boolean collision(Box b,Button bu,int radius) {
		return (Math.abs(b.x/MSPEED-bu.x/MSPEED)<=radius && Math.abs(b.y/MSPEED-bu.y/MSPEED)<=radius);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int xindex=p.x/MSPEED;
		int yindex=p.y/MSPEED;
		if(e.getKeyCode()==37 && mCooldown==0) {
			if(!map.get(new Vector(xindex-1,yindex)).get(0).equals("w") && !map.get(new Vector(xindex-1,yindex+1)).get(0).equals("w") && !map.get(new Vector(xindex-1,yindex)).get(0).equals("p") && !map.get(new Vector(xindex-1,yindex+1)).get(0).equals("p")) {
				p.x-=MSPEED;
				mCooldown=MDELAY;
				pCooldown=0;
				for(Box box:boxes) {
					if(collision(p,box,1)) {
						box.x-=MSPEED;
						for(Button button:buttons) {
							if(collision(box,button,0)) {
								for(Vector v:button.remove) {
									map.remove(v);
									map.put(v, "b");
								}
							}
						}
					}
				}
				for(int i=0;i<robots.size();i++) {
					if(collision(p,robots.get(i),1)) {
						for(Vector remove:robots.get(i).remove) {
							map.remove(remove);
							map.put(remove, "b");
						}
						robots.remove(i);
						
					}
				}
			}
		}
		if(e.getKeyCode()==38 && mCooldown==0) {
			if(!map.get(new Vector(xindex+1,yindex-1)).get(0).equals("w") && !map.get(new Vector(xindex,yindex)).get(0).equals("w") && !map.get(new Vector(xindex+1,yindex-1)).get(0).equals("p") && !map.get(new Vector(xindex,yindex)).get(0).equals("p")) {
				p.y-=MSPEED;
				mCooldown=MDELAY;
				pCooldown=0;
				for(Box box:boxes) {
					if(collision(p,box,1)) {
						box.y-=MSPEED;
						for(Button button:buttons) {
							if(collision(box,button,0)) {
								for(Vector v:button.remove) {
									map.remove(v);
									map.put(v, "b");
								}
							}
						}
					}
				}
				for(int i=0;i<robots.size();i++) {
					if(collision(p,robots.get(i),1)) {
						for(Vector remove:robots.get(i).remove) {
							map.remove(remove);
							map.put(remove, "b");
						}
						robots.remove(i);
						
					}
				}
			}
		}
		if(e.getKeyCode()==39 && mCooldown==0) {
			if(!map.get(new Vector(xindex+2,yindex+1)).get(0).equals("w") && !map.get(new Vector(xindex+2,yindex)).get(0).equals("w") && !map.get(new Vector(xindex+2,yindex+1)).get(0).equals("p") && !map.get(new Vector(xindex+2,yindex)).get(0).equals("p")) {
				p.x+=MSPEED;
				mCooldown=MDELAY;
				pCooldown=0;
				for(Box box:boxes) {
					if(collision(p,box,1)) {
						box.x+=MSPEED;
						for(Button button:buttons) {
							if(collision(box,button,0)) {
								for(Vector v:button.remove) {
									map.remove(v);
									map.put(v, "b");
								}
							}
						}
					}
				}
				for(int i=0;i<robots.size();i++) {
					if(collision(p,robots.get(i),1)) {
						for(Vector remove:robots.get(i).remove) {
							map.remove(remove);
							map.put(remove, "b");
						}
						robots.remove(i);
						
					}
				}
			}
		}
		if(e.getKeyCode()==40 && mCooldown==0) {
			if(!map.get(new Vector(xindex+1,yindex+2)).get(0).equals("w") && !map.get(new Vector(xindex,yindex+2)).get(0).equals("w") && !map.get(new Vector(xindex+1,yindex+2)).get(0).equals("p") && !map.get(new Vector(xindex,yindex+2)).get(0).equals("p")) {
				p.y+=MSPEED;
				mCooldown=MDELAY;
				pCooldown=0;
				for(Box box:boxes) {
					if(collision(p,box,1)) {
						box.y+=MSPEED;
						for(Button button:buttons) {
							if(collision(box,button,0)) {
								for(Vector v:button.remove) {
									map.remove(v);
									map.put(v, "b");
								}
							}
						}
					}
				}
				for(int i=0;i<robots.size();i++) {
					if(collision(p,robots.get(i),1)) {
						for(Vector remove:robots.get(i).remove) {
							map.remove(remove);
							map.put(remove, "b");
						}
						robots.remove(i);
						
					}
				}
			}
		}
		if(e.getKeyCode()==67) {
			try {
				nextLevel();
				try {
					URL url = this.getClass().getClassLoader().getResource("finish.wav");
					Clip portal = AudioSystem.getClip();
			        portal.open(AudioSystem.getAudioInputStream(url));
					portal.start();
		        } catch (Exception exc) {
		            exc.printStackTrace(System.out);
		        }
				BufferedWriter b=new BufferedWriter(new FileWriter("save.txt"));
				if(level==15) {
					b.write("0");
					b.close();
				}else {
					b.write(""+(level+0));
					b.close();
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(Math.abs(p.x/20-EXITX/20-1)<=2 && Math.abs(p.y/20-EXITY/20-1)<=2){
			try {
				nextLevel();
				try {
					URL url = this.getClass().getClassLoader().getResource("finish.wav");
					Clip portal = AudioSystem.getClip();
			        portal.open(AudioSystem.getAudioInputStream(url));
					portal.start();
		        } catch (Exception exc) {
		            exc.printStackTrace(System.out);
		        }
				BufferedWriter b=new BufferedWriter(new FileWriter("save.txt"));
				if(level==15) {
					b.write("0");
					b.close();
				}else {
					b.write(""+(level+0));
					b.close();
				}
				b.close();
			} catch (IOException e1) {}
		}
		if(e.getKeyCode()==70 && npc!=null && Math.abs(p.x-npc.x)<60 && Math.abs(p.y-npc.y)<60) {
			npcCharactersDisplaying=0;
		}
		if(e.getKeyCode()==10 && npcCharactersDisplaying>=npc.dialog.length()-1) {
			try {
				nextLevel();
				try {
					URL url = this.getClass().getClassLoader().getResource("finish.wav");
					Clip portal = AudioSystem.getClip();
			        portal.open(AudioSystem.getAudioInputStream(url));
					portal.start();
		        } catch (Exception exc) {
		            exc.printStackTrace(System.out);
		        }
				BufferedWriter b=new BufferedWriter(new FileWriter("save.txt"));
				b.write(""+(level+0));
				b.close();
			} catch (IOException e1) {}
		}
		repaint();
	}
	public void nextLevel() throws IOException {
		inTransition=true;
		npcCharactersDisplaying=-1;
		level++;
		if(level==15) {
			//u win!
			timer=1000000;
		}else {
			
		
		readMap(level);
		p.x=PSTARTX;
		p.y=PSTARTY;
		blueX=-100;
		blueY=-100;
		orangeX=-100;
		orangeY=-100;
		if(level%2==0 || level>=9)timer=30;
		else timer=1000;
		}
	}
	public void previousLevel() throws IOException {
		inTransition=true;
		npcCharactersDisplaying=-1;
		level--;
		if(level==15) {
			//u win!
		}else {
			
		
		readMap(level);
		p.x=PSTARTX;
		p.y=PSTARTY;
		blueX=-100;
		blueY=-100;
		orangeX=-100;
		orangeY=-100;
		if(level%2==0)timer=30;
		else timer=1000;
		}
	}
	public void nextLevel(int newLevel) throws IOException {
		inTransition=true;
		level=newLevel;
		readMap(level);
		p.x=PSTARTX;
		p.y=PSTARTY;
		blueX=-100;
		blueY=-100;
		orangeX=-100;
		orangeY=-100;
		timer=30;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x=MouseInfo.getPointerInfo().getLocation().x-this.getLocationOnScreen().x-18;
		int y=MouseInfo.getPointerInfo().getLocation().y-this.getLocationOnScreen().y-18;
		if(level==0) {
			if(x>32 && x<177 && y>306 && y<331) {
				try {
					nextLevel();
					try {
						URL url = this.getClass().getClassLoader().getResource("finish.wav");
						Clip portal = AudioSystem.getClip();
				        portal.open(AudioSystem.getAudioInputStream(url));
						portal.start();
			        } catch (Exception exc) {
			            exc.printStackTrace(System.out);
			        }
					BufferedWriter b=new BufferedWriter(new FileWriter("save.txt"));
					b.write("0");
					b.close();
					
				} catch (IOException e1) {}
			}
			if(x>32 && x<177 && y>345 && y<370 && save>0) {
				try {
					nextLevel(save);
					try {
						URL url = this.getClass().getClassLoader().getResource("finish.wav");
						Clip portal = AudioSystem.getClip();
				        portal.open(AudioSystem.getAudioInputStream(url));
						portal.start();
			        } catch (Exception exc) {
			            exc.printStackTrace(System.out);
			        }
				} catch (IOException e1) {}
			}
			if(x>32 && x<177 && y>385 && y<410) {
				level=-72769;
			}
		}else if(level==-72769){
			level=0;
		}else {
			if(SwingUtilities.isLeftMouseButton(e) && canPlace) {
				orangeX=GSIZE*Math.round(x/GSIZE)+2;
				orangeY=GSIZE*Math.round(y/GSIZE)+2;
				pCooldown=0;
				try {
					URL url = this.getClass().getClassLoader().getResource("portal.wav");
					Clip portal = AudioSystem.getClip();
			        portal.open(AudioSystem.getAudioInputStream(url));
					portal.start();
		        } catch (Exception exc) {
		            exc.printStackTrace(System.out);
		        }
			}else if(SwingUtilities.isRightMouseButton(e) && canPlace) {
				blueX=GSIZE*Math.round(x/GSIZE)+2;
				blueY=GSIZE*Math.round(y/GSIZE)+2;
				pCooldown=0;
				try {
					URL url = this.getClass().getClassLoader().getResource("portal.wav");
					Clip portal = AudioSystem.getClip();
			        portal.open(AudioSystem.getAudioInputStream(url));
					portal.start();
		        } catch (Exception exc) {
		            exc.printStackTrace(System.out);
		        }
			}
		}
		
		repaint();
	}
	public void menuBackground(Graphics g){
		DLList<Vector> m=map.keySet().toDLList();
		for(int i=0;i<m.size();i++) {
			Vector v=m.get(i);
			if(v.x>14) {
				DLList<String> square=map.get(v);
				String first=square.get(0);
				if(first.equals("b")) {
					g.setColor(BACKGROUND);
					g.fillRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
					g.setColor(BORDER);
					g.drawRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
				}
				if(first.equals("w")) {
					g.setColor(BACKGROUND);
					g.fillRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
					g.setColor(BORDER);
					g.drawRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
				}
				if(first.equals("r")) {
					g.setColor(new Color(255,0,0));
					g.fillRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
					g.setColor(BORDER);
					g.drawRect(v.x*GSIZE,v.y*GSIZE, GSIZE,GSIZE);
				}
			}
			
		}
		p.x=401;
		p.y=301;
		p.drawMe(g);
		g.setColor(BLUE);
		g.fillOval(482, 301, 35,35);
		g.setColor(ORANGE);
		g.fillOval(482, 381, 35,35);
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Inter Tight",Font.PLAIN,80));
		g.drawString("Portal",50,300);
		g.setFont(new Font("Inter Tight",Font.PLAIN,fontSize));
		g.drawString("New Game", 50,350);
		g.setFont(new Font("Inter Tight",Font.PLAIN,fontSize2));
		g.setColor(loadGame);
		g.drawString("Load Game", 50,390);
		g.setFont(new Font("Inter Tight",Font.PLAIN,fontSize3));
		g.setColor(new Color(0,0,0));
		g.drawString("Tutorial", 50,430);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		int x=MouseInfo.getPointerInfo().getLocation().x-this.getLocationOnScreen().x-18;
		int y=MouseInfo.getPointerInfo().getLocation().y-this.getLocationOnScreen().y-18;
		if(x>32 && x<177 && y>306 && y<331) {
			fontSize=35;
		}else {
			fontSize=30;
		}
		if(x>32 && x<177 && y>345 && y<370 && save>0) {
			fontSize2=35;
		}else {
			fontSize2=30;
		}
		if(x>32 && x<177 && y>385 && y<410) {
			fontSize3=35;
		}else {
			fontSize3=30;
		}
		repaint();
		
	}


	
}