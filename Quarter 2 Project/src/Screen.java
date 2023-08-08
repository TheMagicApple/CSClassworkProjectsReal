import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.io.*;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JPanel;
//import java.util.ArrayList;
public class Screen extends JPanel implements KeyListener, ActionListener{
	//private ArrayList<Projectile> proj=new ArrayList<>();
	private Random rrr=new Random();
	private Projectile[] proj;
	private Projectile[] bossProj;
	private Projectile[] retalProj;
	private Projectile p1;
	private Ship s1;
	//private ArrayList<Enemy> enemies=new ArrayList<>();
	private Enemy[] enemies;
	private Enemy[] enemies2;
	private static Enemy[] bossEnemies;
	private static Boss boss;
	int nEnemies=3;
	private int dashes=3;
	private Random r=new Random();
	private int score=0;
	private int level=1;
	private int ammo=7;
	private int maxAmmo=7;
	private boolean shooting=false;
	private Image background1;
	private String going="";
	private JButton reset;
	public static boolean dead=false;
	public static boolean winner=false;
	private boolean dashing=false;
	private int tripleShots=3;
	private boolean firstHit=false;
	public static boolean retaliation=false;
	//private Clip clip;
	//private AudioInputStream audioIn;
	public Screen(){
		setLayout(null);
		reset=new JButton("Reset");
		reset.setBounds(20,20,100,30);
		add(reset);
		reset.addActionListener(this);
		s1 = new Ship(50,300);
		p1 = new Projectile(50,300);
		setFocusable(true);
		addKeyListener(this);
		enemies=new Enemy[nEnemies];
		bossEnemies=new Enemy[20];
		proj=new Projectile[7];
		bossProj=new Projectile[50];
		retalProj=new Projectile[50];
		for(int i=0;i<enemies.length;i++) {
			enemies[i]=new Enemy(r.nextInt(450)+200,r.nextInt(500)+50);
		}
		//scoreText=new JTextField();
		//scoreText.setBounds(100,100,50,50);
		//add(scoreText);
		try {
        	background1=ImageIO.read(new File("backgroundrealreal.jpg"));
        }catch(IOException e) {
        	System.out.println("coud not find background image");
        }
		/*
		try {
			
			
			//clip = AudioSystem.getClip();
			
			File f = new File("./" + "explosin.wav");
			//audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			
		}catch(LineUnavailableException e) {
			System.out.println("the line was unavailable");
		}catch(IOException ee) {
			System.out.println("ioexception");
		}catch(UnsupportedAudioFileException eee) {
			System.out.println("unsupported audio file");
		}
		*/
	}

	public Dimension getPreferredSize() {
		//Sets the size of the panel
        	return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
	
        
		//g.setColor(new Color(25,25,25,200));
		//g.fillRect(0, 0, 800, 600);
        
        
        g.drawImage(background1,0,0,null);
		if(level==1) {
			for(Enemy e:enemies) {
	        	e.drawMe(g);
	        }
		}else if(level==2) {
			for(Enemy e:enemies) {
				e.drawMe(g);
			}
			for(Enemy e:enemies2) {
	        	e.drawMe(g);
	        }
		}else if(level==3) {
			for(Enemy e:enemies2) {
				e.drawMe(g);
			}
			boss.drawMe(g);
			for(int i=0;i<bossEnemies.length;i++) {
				if(bossEnemies[i]!=null) {
					bossEnemies[i].drawMe(g);
					if(i<5) {
						bossEnemies[i].setPos(boss.getX()-50,boss.getY()-10+50*i);
					}else if(i<10) {
						bossEnemies[i].setPos(boss.getX()-100,boss.getY()-10+50*(i-5));
					}else if(i<15) {
						bossEnemies[i].setPos(boss.getX()-150,boss.getY()-10+50*(i-10));
					}else {
						bossEnemies[i].setPos(boss.getX()-200,boss.getY()-10+50*(i-15));
					}
					
				}
			}
			
		}
		
		//Draw ship
		s1.drawMe(g);
		
		//Draw Projectile
		for(int i=0;i<proj.length;i++) {
			if(proj[i]!=null) {
				
				proj[i].drawMe(g);
				/*
				if(p.isDestroyed()) {
					proj.remove(p);
					break;
				}
				*/
			}
			
		}
		if(level==3) {
			for(int i=0;i<bossProj.length;i++) {
				if(bossProj[i]!=null) {
					
					bossProj[i].drawMe(g);
					/*
					if(p.isDestroyed()) {
						proj.remove(p);
						break;
					}
					*/
				}
				
			}
			for(Projectile p:retalProj) {
				if(p!=null) {
					p.drawMe(g);
				}
				
			}
			
		}
		
		g.setColor(new Color(255,255,255));
		g.drawString("Health: "+s1.health, 400,30);
		g.drawString("Score: "+score,400,50);
		g.drawString("Level "+level, 400, 70);
		g.drawString("Arrows left: "+ammo+"/"+maxAmmo, 400, 90);
		if(level==3) {
			g.drawString("Boss health: "+boss.health,400,110);
		}
		if(dead==true && winner==false) {
			Image lose;
			try {
				lose=ImageIO.read(new File("lose.png"));
			}catch(IOException e) {
				lose=null;
				System.out.println("could not find win background");
			}
			g.drawImage(lose,0,0,null);
			
		}
		if(winner==true && dead==false) {
			Image win;
			try {
				win=ImageIO.read(new File("win.png"));
			}catch(IOException e) {
				win=null;
				System.out.println("could not find win background");
			}
			g.drawImage(win,0,0,null);
			
		}
			
	} 
	public static void bossWall() {
		for(int i=0;i<5;i++) {
			bossEnemies[i]=new Enemy(boss.getX()-50,boss.getY()-10+50*i);
		}
	}
	public static void ultraBossWall() {
		for(int i=0;i<bossEnemies.length;i++) {
			
			if(i<5) {
				bossEnemies[i]=new Enemy(boss.getX()-50,boss.getY()-10+50*i);
			}else if(i<10) {
				bossEnemies[i]=new Enemy(boss.getX()-100,boss.getY()-10+50*(i-5));
			}else if(i<15) {
				bossEnemies[i]=new Enemy(boss.getX()-150,boss.getY()-10+50*(i-10));
			}else {
				bossEnemies[i]=new Enemy(boss.getX()-200,boss.getY()-10+50*(i-15));
			}
			
		}
		//System.out.println("generated enemies");
	}
	public void playSound() {
		try {
			URL url = this.getClass().getClassLoader().getResource("sound/explosin.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
		}catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	public void animate() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		
		while(true){
			//wait for .01 second
			try {
			    if(!firstHit) {
			    	Thread.sleep(10);
			    }else {
			    	Thread.sleep(15);
			    }
				
			} catch(InterruptedException ex) {
			    System.out.println("thread interrupted");
				Thread.currentThread().interrupt();
			}
			if(ammo<=0) {
				Thread thread=new Thread() {
					public void run() {
						try {
							Thread.sleep(2000);
						}catch(InterruptedException e) {
							System.out.println("thats not good...");
						}
						if(ammo<=0) {
							dead=true;
						}
						
					}
				};
				thread.start();
				
			}
			if(nEnemies==0 && level==1) {
				for(Enemy eee:enemies) {
					eee.die();
				}
				level=2;
				nEnemies=5;
				enemies2=new Enemy[nEnemies];
				try {
		        	background1=ImageIO.read(new File("backgroundrealreal2.jpg"));
		        }catch(IOException eeeeeeeeeeeee) {
		        	System.out.println("coud not find background image");
		        }
				ammo=7;
				
				
				for(int i=0;i<5;i++) {
					
					
					enemies2[i]=new Enemy(r.nextInt(450)+200,r.nextInt(400)+50);
				}
			
			}else if(nEnemies==0 && level==2) {
				for(Enemy eee:enemies2) {
					eee.die();
				}
				level=3;
				boss=new Boss();
				
				try {
		        	background1=ImageIO.read(new File("backgroundrealreal3.jpg"));
		        }catch(IOException eeeeeeeeeeeee) {
		        	System.out.println("coud not find background image");
		        }
				ammo=50;
				maxAmmo=50;
				
				
				
				
			}
			
			if(going.equals("up")) {
				s1.moveUp();
			}
			if(going.equals("down")) {
				s1.moveDown();
			}
			if(dashing==true) {
				s1.dash();
			}
			if(retaliation==true) {
				retaliation=false;
				for(int i=0;i<50-ammo;i++) {
					Projectile p=new Projectile(50,300);
					p.setPosition(800, r.nextInt(600));
					p.setVisible();
					p.reflection();
					retalProj[i]=p;
				}
			}
			for(Projectile p:proj) {
				if(p!=null) {
					p.moveRight();
				}
				
			}
			if(level==3) {
				for(Projectile p:bossProj) {
					if(p!=null) {
						p.moveRight();
					}
				}
			}
			if(level==1) {
				for(int k=0;k<enemies.length;k++) {
					for(int i=0;i<proj.length;i++) {
						if(proj[i]!=null) {
							
							int pX=proj[i].getX();
							int pY=proj[i].getY()+25;
							int tX=enemies[k].getX()+80;
							int tY=enemies[k].getY()+120;
							int pWidth=50;
							int pHeight=25;
							int tWidth=25;
							int tHeight=25;
							if(pX+pWidth >= tX && pX <= tX + tWidth  &&  
									pY+pHeight >= tY && pY <= tY + tHeight && !enemies[k].isDead() && proj[i].isDestroyed()==false){
										//System.out.println("clown down");
										score++;
										enemies[k].die();
										nEnemies--;
										
										//calling p.destroy() removes piercing effect
										proj[i].destroy();
										playSound();
										if(!firstHit) {
											firstHit=true;
										}
										/*
										Thread thread=new Thread() {
											public void run() {
												try {
													Thread.sleep(2000);
												}catch(InterruptedException e) {
													System.out.println("interrupted");
												}
												clip.close();
												System.out.println("hello???");
											}
										};
										*/
										
										
													
												
											
										
										
							}
						}
						

					}
				}
			}else if(level==2) {
				for(int k=0;k<enemies2.length;k++) {
					if(enemies2[k]!=null) {
						for(int i=0;i<proj.length;i++) {
							if(proj[i]!=null) {
								Projectile p=proj[i];
								int pX=p.getX();
								int pY=p.getY()+25;
								int tX=enemies2[k].getX()+80;
								int tY=enemies2[k].getY()+120;
								int pWidth=50;
								int pHeight=25;
								int tWidth=25;
								int tHeight=25;
								if(pX+pWidth >= tX && pX <= tX + tWidth  &&  
										pY+pHeight >= tY && pY <= tY + tHeight && !enemies2[k].isDead() && proj[i].isDestroyed()==false){
											//System.out.println("clown down");
											score++;
											enemies2[k].die();
											nEnemies--;
											
											//calling p.destroy() removes piercing effect
											p.destroy();
											playSound();
											if(!firstHit) {
												firstHit=true;
											}
								}
							}
							

						}
					}
					
				}
			}else if(level==3) {
				for(int i=0;i<bossProj.length;i++) {
					for(int k=0;k<bossEnemies.length;k++) {
						if(bossProj[i]!=null) {
							int pX=bossProj[i].getX();
							int pY=bossProj[i].getY();
							int tX=boss.getX()+130;
							int tY=boss.getY()+100;
							int pWidth=50;
							int pHeight=25;
							int tWidth=150;
							int tHeight=190;
							if(pX+pWidth >= tX && pX <= tX + tWidth  &&  
									pY+pHeight >= tY && pY <= tY + tHeight && !boss.isDead() && bossProj[i].isDestroyed()==false && bossProj[i].isDestroyed2()==false){
								int reflect=r.nextInt(2);
								if(reflect==0) {
									bossProj[i].destroy2();
									bossProj[i].reflection();
								}else {
									bossProj[i].destroy();
									
								}
								playSound();
								if(!firstHit) {
									firstHit=true;
								}
								//System.out.println("clown down");
										score++;
										boss.hurt();
										nEnemies--;
										
										//calling p.destroy() removes piercing effect
										
							}
						}
							if(bossEnemies[k]!=null && bossProj[i]!=null) {
								int pX=bossProj[i].getX();
								int pY=bossProj[i].getY();
								int eX=bossEnemies[k].getX()+130;
								int eY=bossEnemies[k].getY()+100;
								int pWidth=50;
								int pHeight=25;
								int eWidth=25;
								int eHeight=25;
								if(pX+pWidth >= eX && pX <= eX + eWidth  &&  
										pY+pHeight >= eY && pY <= eY + eHeight && !bossEnemies[k].isDeadreal() && bossProj[i].isDestroyed()==false){
									bossProj[i].destroy();
									//System.out.println("clown down");
											score++;
											bossEnemies[k].die();
											nEnemies--;
											
											playSound();
											if(!firstHit) {
												firstHit=true;
											}
											//calling p.destroy() removes piercing effect
											
								}
							}
							
					}
					if(bossProj[i]!=null) {
						int pX=bossProj[i].getX();
						int pY=bossProj[i].getY();
						int tX=s1.getX();
						int tY=s1.getY();
						int pWidth=50;
						int pHeight=25;
						int tWidth=25;
						int tHeight=30;
						if(pX+pWidth >= tX && pX <= tX + tWidth  &&  
								pY+pHeight >= tY && pY <= tY + tHeight && !boss.isDead() && bossProj[i].isDestroyed()==false && bossProj[i].isDestroyed2()==true){
							
							
								bossProj[i].destroy();
							
							
							//System.out.println("clown down");
									
									s1.hurt(1);
									
									
									//calling p.destroy() removes piercing effect
									
						}
						
					}
					if(boss!=null) {
						int pX=s1.getX();
						int pY=s1.getY();
						int tX=boss.getX()+130;
						int tY=boss.getY()+100;
						int pWidth=50;
						int pHeight=25;
						int tWidth=150;
						int tHeight=190;
						if(pX+pWidth >= tX && pX <= tX + tWidth  &&  
								pY+pHeight >= tY && pY <= tY + tHeight && !boss.isDead()){
							
							
							//System.out.println("clown down");
									boss.backUp=true;
									if(boss.alreadyCharged==false) {
										s1.hurt(3);
										boss.alreadyCharged=true;
									}
									
									
									//calling p.destroy() removes piercing effect
									
						}
					}
					
					
					
						
				}
					
				
			}
			
				if(level==1) {
					for(Enemy ee:enemies) {
						if(ee!=null) {
							ee.moveDown();
							if(ee.getY()>550) {
								ee.setY(-200);
							}
						}
						
					}
				}else if(level==2) {
					for(Enemy ee:enemies2) {
						if(ee!=null) {
							ee.movemove();
							if(ee.getY()>500 || ee.getY()<-125) {
								ee.flip();
							}
						}
						
					}
				}else if(level==3) {
					for(Projectile p:retalProj) {
						if(p!=null) {
							p.moveRight();
						}
					}
				}
				
				
			

			
			//repaint the graphics drawn
			repaint();
		}

	}
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode()==32 && ammo>0 && shooting==false) {
			s1.animation();
			ammo--;
			
			Thread thread=new Thread() {
				public void run() {
					try {
						shooting=true;
						Thread.sleep(400);
						shooting=false;
					}catch(InterruptedException eeeeee) {
						System.out.println("uh oh...");
					}
					Projectile p=new Projectile(50,300);
					p.setPosition(s1.getX(), s1.getY());
					p.setVisible();
					if(level==3) {
						if(ammo+1>0) {
							//System.out.println("is this running");
							bossProj[50-ammo-1]=p;
						}
					}else {
						if(ammo+1>0) {
							proj[7-ammo-1]=p;
						}
					}
					
					
				}
			};
			thread.start();
			
		
			//DOUBLE SHOT
			/*
			try {
				Thread.sleep(100);
			}catch(InterruptedException ee) {
				
			}
			Projectile p2=new Projectile(50,300);
			p2.setPosition(s1.getX(), s1.getY());
			p2.setVisible();
			proj.add(p2);
			*/
		}else if(e.getKeyCode()==38) {
			//s1.moveUp();
			going="up";
		}else if(e.getKeyCode()==40) {
			//s1.moveDown();
			going="down";
		}else if(e.getKeyCode()=='C' && level==1) {
			for(Enemy eee:enemies) {
				eee.die();
			}
			level=2;
			nEnemies=5;
			enemies2=new Enemy[nEnemies];
			try {
	        	background1=ImageIO.read(new File("backgroundrealreal2.jpg"));
	        }catch(IOException eeeeeeeeeeeee) {
	        	System.out.println("coud not find background image");
	        }
			ammo=7;
			
			
			for(int i=0;i<5;i++) {
				
				
				enemies2[i]=new Enemy(r.nextInt(450)+200,r.nextInt(400)+50);
			}
		
		}else if(e.getKeyCode()=='C' && level==2) {
			for(Enemy eee:enemies2) {
				eee.die();
			}
			level=3;
			boss=new Boss();
			
			try {
	        	background1=ImageIO.read(new File("backgroundrealreal3.jpg"));
	        }catch(IOException eeeeeeeeeeeee) {
	        	System.out.println("coud not find background image");
	        }
			ammo=50;
			maxAmmo=50;
			
			
			
			
		}else if(e.getKeyCode()=='C' && level==3) {
			winner=true;
		}else if(e.getKeyCode()=='R' && dashes>0) {
			dashes--;
			Thread thread=new Thread() {
				public void run() {
					dashing=true;
					try {
						Thread.sleep(100);
					}catch(InterruptedException e) {
						System.out.println("thats not good...");
					}
					dashing=false;
				}
			};
			thread.start();
		}else if(e.getKeyCode()=='T' && tripleShots>0) {
			tripleShots--;
			Thread thread=new Thread() {
				public void run() {
					s1.animation();
					ammo-=1;
					try {
						shooting=true;
						Thread.sleep(400);
						shooting=false;
					}catch(InterruptedException eeeeee) {
						System.out.println("uh oh...");
					}
					Projectile p=new Projectile(50,300);
					p.setPosition(s1.getX(), s1.getY());
					p.setVisible();
					if(level==3) {
						if(ammo+1>0) {
							//System.out.println("is this running");
							bossProj[50-ammo-1]=p;
						}
					}else {
						if(ammo+1>0) {
							proj[7-ammo-1]=p;
						}
					}
					
					try {
						Thread.sleep(100);
					}catch(InterruptedException eeeeeeeeeeee) {
						System.out.println("eeeeeeeeeeeee");
					}
					ammo-=1;
					Projectile p2=new Projectile(50,300);
					p2.setPosition(s1.getX(), s1.getY());
					p2.setVisible();
					if(level==3) {
						if(ammo+1>0) {
							//System.out.println("is this running");
							bossProj[50-ammo-1]=p2;
						}
					}else {
						if(ammo+1>0) {
							proj[7-ammo-1]=p2;
						}
					}
					try {
						Thread.sleep(100);
					}catch(InterruptedException eeeeeeeeeeee) {
						System.out.println("eeeeeeeeeeeee");
					}
					ammo-=1;
					Projectile p3=new Projectile(50,300);
					p3.setPosition(s1.getX(), s1.getY());
					p3.setVisible();
					if(level==3) {
						if(ammo+1>0) {
							//System.out.println("is this running");
							bossProj[50-ammo-1]=p3;
						}
					}else {
						if(ammo+1>0) {
							proj[7-ammo-1]=p3;
						}
					}
				}
			};
			thread.start();
		}
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==38 || e.getKeyCode()==40) {
			going="";
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reset) {
			level=1;
			nEnemies=3;
			ammo=7;
			score=0;
			s1.health=5;
			winner=false;
			dead=false;
			if(boss!=null) {
				boss.health=10;
				retaliation=false;
			}
			
			dashes=3;
			tripleShots=3;
			maxAmmo=7;
			enemies=new Enemy[nEnemies];
			proj=new Projectile[7];
			for(int i=0;i<enemies.length;i++) {
				enemies[i]=new Enemy(r.nextInt(450)+200,r.nextInt(500)+50);
			}
			try {
	        	background1=ImageIO.read(new File("backgroundrealreal.jpg"));
	        }catch(IOException eeeeeeeeeeeeeeeeeeeeeeeeeeeee) {
	        	System.out.println("coud not find background image");
	        }
			requestFocus();
			setFocusable(true);	
		}
	}
	

}
