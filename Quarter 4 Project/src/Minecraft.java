import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Minecraft extends JPanel implements MouseListener, ActionListener, MouseMotionListener, KeyListener{
	private String currentItem;
	private ArrayList<Item> inventory=new ArrayList<>();
	private Block[][] world=new Block[20][60];
	private int[][] blockBreakStates=new int[20][60];
	private BufferedImage player;
	private BufferedImage woodenPickaxe;
	private BufferedImage blockBreak1;
	private BufferedImage blockBreak2;
	private BufferedImage mouseCursor;
	private BufferedImage slime;
	private int playerX=0;
	private int playerXCoord=320;
	private int playerYCoord=100;
	private boolean movingLeft=false;
	private boolean movingRight=false;
	private boolean falling=true;
	private boolean grounded=false;
	private boolean jumpingUp=false;
	private boolean jumpingDown=false;
	private boolean hovering=false;
	private boolean rightClicking=false;
	private int jumpCounter=0;
	private final int playerSpeed=2;
	private int customCursorX=0;
	private int customCursorY=0;
	private boolean mining=false;
	private boolean oppositeMining=false;
	private int mineCounter=-1;
	private int itemX=330;
	private int itemY=playerYCoord+20;
	private int cursorIndexY=10;
	private int cursorIndexX=30;
	private int leftCornerX=0;
	private int position=0;
	private BufferedImage newImageFromBuffer;
	int widthOfImage;
    int heightOfImage;
    int typeOfImage;
    private int currentItemRotation=0;
	public Minecraft(){
		generateWorld();
		try {
			player=ImageIO.read(new File("src/PlayerRealReal.png"));
			woodenPickaxe=ImageIO.read(new File("src/SwordReal.png"));
			blockBreak1=ImageIO.read(new File("src/BlockBreak1.png"));
			mouseCursor=ImageIO.read(new File("src/mouseCursorReal.png"));
			blockBreak2=ImageIO.read(new File("src/BlockBreak2.png"));
			slime=ImageIO.read(new File("src/slime.png"));
			widthOfImage = woodenPickaxe.getWidth();
			heightOfImage = woodenPickaxe.getHeight();
		    typeOfImage = woodenPickaxe.getType();
			newImageFromBuffer=new BufferedImage(widthOfImage, heightOfImage, typeOfImage);
			
		}catch(IOException eeeeeeeeeee) {
			System.out.println("eeeeeeeeeeeeee");
		}
		//world[5][21]=new Block(1);
		//world[5][22]=new Block(1);
		//world[6][23]=new Block(2);
		//world[6][24]=new Block(2);
	}
	public void generateWorld() {
		int minBiomeLen=5;
		int maxBiomeLen=10;
		int block=0;
		int yCoord=10;
		while(block<world[0].length) {
			int biomeLen=(int)(Math.random()*(maxBiomeLen-minBiomeLen+1)+minBiomeLen);
			if(world[0].length-block-1<biomeLen) {
				biomeLen=world[0].length-block;
			}
			int biome=(int)(Math.random()*3);
			int thing=block+biomeLen;
			int thingthing=block;
			//System.out.println("block: "+block);
			for(int i=thingthing;i<thing;i++) {
				if(biome==0) {
					//flat
					//10% chance to go up 1, 10% chance to go down 1
					int change=(int)(Math.random()*10);
					if(change==0) {
						yCoord++;
					}else if(change==1) {
						yCoord--;
					}
					for(int a=yCoord;a<world.length;a++) {
						if(yCoord>=0) {
							if(a==yCoord) {
								world[a][block]=new Block(1);
							}else if(a>yCoord && a<yCoord+(world.length/2)) {
								world[a][block]=new Block(0);
							}else {
								world[a][block]=new Block(2);
							}
						}
						
					}
				}else if(biome==1) {
					//hill
					//30% chance to go up 1, 30% chance to go down 1
					int change=(int)(Math.random()*10);
					if(change==0 || change==1 || change==2) {
						yCoord++;
					}else if(change==3 || change==4 || change==5) {
						yCoord--;
					}
					for(int a=yCoord;a<world.length;a++) {
						if(yCoord>=0) {
							if(a==yCoord) {
								world[a][block]=new Block(1);
							}else if(a>yCoord && a<yCoord+(world.length/2)) {
								world[a][block]=new Block(0);
							}else {
								world[a][block]=new Block(2);
							}
						}
						
					}
					
				}else if(biome==2){
					//mountain
					//20% chance to go up 1, 20% change to go up 2, 20% chance to go down 1, 20% change to go down 2
					int change=(int)(Math.random()*10);
					if(change==0 || change==1) {
						yCoord++;
					}else if(change==2 || change==3) {
						yCoord+=2;
					}else if(change==4 || change==5) {
						yCoord--;
					}else if(change==6 || change==7) {
						yCoord-=2;
					}
					for(int a=yCoord;a<world.length;a++) {
						if(yCoord>=0) {
							if(a==yCoord) {
								world[a][block]=new Block(1);
							}else if(a>yCoord && a<yCoord+(world.length/2)) {
								world[a][block]=new Block(0);
							}else {
								world[a][block]=new Block(2);
							}
						}
						
					}
				}
				block++;
				if(block==world[0].length) {
					break;
				}
			}
		}
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(640,640);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.cyan);
		
		int x=-640-playerX;
		int y=0;
		for(Block[] row:world) {
			for(Block block:row) {
				if(block!=null) {
					block.drawMe(g,x,y);
				}
				x+=32;
			}
			y+=32;
			x=-640-playerX;
		}
		int x2=-640-playerX;
		int y2=0;
		for(int[] blockBreakState:blockBreakStates) {
			for(int blockState:blockBreakState) {
				if(blockState==1) {
					g.drawImage(blockBreak1, x2,y2,null);
					System.out.println("block broken stage 1");
					System.out.println("x: "+x2);
					System.out.println("y: "+y2);
				}else if(blockState==2) {
					g.drawImage(blockBreak2, x2,y2,null);
				}
				x2+=32;
			}
			y2+=32;
			x2=-640-playerX;
		}
		g.drawImage(player, 320,playerYCoord,null);
		//g.drawImage(woodenPickaxe,itemX,playerYCoord-2,null);
		AffineTransform af = AffineTransform.getTranslateInstance(itemX,playerYCoord-2);
		
		// Rotating the Image in 90 degree
		if(mineCounter>=0 && mineCounter<12) {
			af.rotate(Math.toRadians(currentItemRotation), woodenPickaxe.getWidth()/2, woodenPickaxe.getHeight()/1.5);
			currentItemRotation+=10;
			//mineCounter++;
		}else if(mineCounter>=12 && mineCounter<24) {
			af.rotate(Math.toRadians(currentItemRotation), woodenPickaxe.getWidth() /2, woodenPickaxe.getHeight()/1.5);
			currentItemRotation-=10;
		}
		
		
		
		
		
		if(!mining) {
			currentItemRotation=0;
			
		}
	
		Graphics2D graphics2d = (Graphics2D)g;
		
		graphics2d.drawImage(woodenPickaxe, af, null);
		//Graphics2D g2d = (Graphics2D)g.create();
		//g2d.rotate(Math.toRadians(90));
		//g2d.drawImage(woodenPickaxe,null,itemX,playerYCoord+20);
		g.drawImage(mouseCursor, customCursorX-33,customCursorY-55,null);
		g.drawImage(slime, 330,100,null);
	}
	
	public void breakBlock(int xCoord,int yCoord) {
		//calculate block in world array based on xcoord and ycoord
		int distanceX=xCoord-playerXCoord;
		int distanceY=yCoord-playerYCoord;
		
		int blockArrayX=(int)Math.round(getPlayerXInWorld()+distanceX/32.0);
		int blockArrayY=(int)Math.round(getPlayerYInWorld()+distanceY/32.0);
		blockArrayX-=1;
		blockArrayY-=2;
		world[blockArrayY][blockArrayX]=null;
		repaint();
	}
	public void placeBlock(int xCoord,int yCoord) {
		//calculate block in world array based on xcoord and ycoord
				if(position==0)world[getPlayerYInWorld()][getPlayerXInWorld2()+2]=new Block(2);
				if(position==1)world[getPlayerYInWorld()+1][getPlayerXInWorld2()+1]=new Block(2);
				if(position==2)world[getPlayerYInWorld()+1][getPlayerXInWorld2()]=new Block(2);
				if(position==-1)world[getPlayerYInWorld()-1][getPlayerXInWorld2()+2]=new Block(2);
				if(position==-2)world[getPlayerYInWorld()-2][getPlayerXInWorld2()+1]=new Block(2);
				repaint();
	}
	public void animate() {
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			System.out.println("eeeeeeeeeeeeeeeeeee");
		}
		if(movingLeft) {
			if(world[getPlayerYInWorld()-0][getPlayerXInWorld2()-0]==null && world[getPlayerYInWorld()-1][getPlayerXInWorld2()-0]==null) {
				playerX-=playerSpeed;
				playerXCoord-=playerSpeed;
				leftCornerX-=playerSpeed;
			}
			
		}
		/*
		if(world[getPlayerYInWorld()-1][getPlayerXInWorld()]!=null)System.out.println("block to the right of player is: "+world[getPlayerYInWorld()+1][getPlayerXInWorld()+1].getBlockType());
		else System.out.println("block to the right of the player is: null");
		*/
		if(movingRight) {
			if(world[getPlayerYInWorld()-0][getPlayerXInWorld2()+1]==null && world[getPlayerYInWorld()-1][getPlayerXInWorld2()+1]==null) {
				playerX+=playerSpeed;
				playerXCoord+=playerSpeed;
				leftCornerX+=playerSpeed;
			}
		}
		if(falling && !jumpingUp && !hovering) {
			playerYCoord+=5;
		}
		if(jumpingUp || jumpingDown || hovering) {
			jumpCounter++;
			
		}
		if(jumpCounter>=18 && jumpCounter<=26) {
			jumpingUp=false;
			jumpingDown=false;
			falling=false;
			hovering=true;
			//System.out.println("hovering");
		}
		if(jumpCounter>30) {
			jumpingDown=true;
			falling=true;
			hovering=false;
		}
		if(jumpCounter>=45) {
			jumpCounter=0;
			jumpingDown=false;
			
		}
		if(jumpingUp) {
			playerYCoord-=5;
		}
		if(jumpingDown && !grounded) {
			playerYCoord+=5;
		}
		//System.out.println("y:"+getPlayerYInWorld());
		//System.out.println("x:"+getPlayerXInWorld());
		
		if(world[getPlayerYInWorld()+1][(int) (getPlayerXInWorld())]!=null) {
			falling=false;
			grounded=true;
		}else {
			falling=true;
		}
		/*
		if(breakCooldown>=0) {
			breakCooldown++;
		}
		if(breakCooldown>50) {
			breakCooldown=-1;
		}
		*/
		if(rightClicking) {
			//breakBlock(customCursorX,customCursorY);
			
			//breakCooldown=0;
			//rightClicking=false;
		}
		if(mineCounter>=0) {
			mineCounter++;
		}
		if(mineCounter>17) {
			
			
			//mining=false;
		}
		if(mineCounter>34) {
			mineCounter=-1;
		}
		if(mining) {
			//System.out.println("mining");
			
		}
		repaint();
		animate();
	}
	public int getPlayerXInWorld2() {
		int playerXInWorld=(int)Math.floor((playerXCoord/32.0))+20;
		return playerXInWorld;
	}
	public int getPlayerXInWorld() {
		int playerXInWorld=(int)Math.round((playerXCoord/32.0))+20;
		return playerXInWorld;
	}
	public int getPlayerYInWorld() {
		int playerYInWorld=(int)Math.floor((playerYCoord/32.0))+1;
		return playerYInWorld;
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		customCursorX=e.getX();
		customCursorY=e.getY();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		if(SwingUtilities.isRightMouseButton(e) && !rightClicking) {
			//System.out.println("right click");
			rightClicking=true;
			//System.out.println("mouse being pressed");
			Thread thread=new Thread() {
				public void run() {
					try {
						Thread.sleep(500);
					}catch(InterruptedException eee) {
						System.out.println("eeeeeeeeeeeeeeeeeee");
					}
					if(rightClicking) {
						//breakBlock();
						//System.out.println("broke block");
					}
				}
			};
			thread.run();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(SwingUtilities.isRightMouseButton(e)) {
			//System.out.println("released right click");
			rightClicking=false;
		}
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode()==65) {
			//moving left
			movingLeft=true;
			//playerX-=5;
		}
		if(e.getKeyCode()==68) {
			//moving right
			movingRight=true;
			//playerX+=5;
		}
		if(e.getKeyCode()==87 && grounded) {
			//jumping
			jumpingUp=true;
			grounded=false;
		}
		if(e.getKeyCode()==77) {
			mining=true;
			mineCounter=0;
			repaint();
			
			
			//mining=false;
			repaint();
			//System.out.println("mining");
		}
		if(e.getKeyCode()==37) {
			position--;
			Graphics2D graphics2D = newImageFromBuffer.createGraphics();
			graphics2D.rotate(Math.toRadians(90), widthOfImage / 2, heightOfImage / 2);
			graphics2D.drawImage(woodenPickaxe, null,itemX,playerYCoord+20);
			repaint();
		}
		if(e.getKeyCode()==39) {
			position++;
		}
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==65) {
			//moving left
			movingLeft=false;
			//playerX-=5;
		}
		if(e.getKeyCode()==68) {
			//moving right
			movingRight=false;
			//playerX+=5;
		}
		if(e.getKeyCode()==77) {
			//mining=false;
		}
		
	}
	
}
