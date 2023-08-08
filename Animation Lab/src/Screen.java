import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;



public class Screen extends JPanel {
	private int skyColorR=0;
	private int skyColorG=0;
	private int skyColorB=0;
	private Color SUN=new Color(255,255,0);
	private Color CLOUD=new Color(255,255,255);
	private Color SKY=new Color(skyColorR, skyColorG, skyColorB);
	private Color GROUND=new Color(168, 117, 50);
	private Color GRASS=new Color(12, 232, 34);
	private Color FLOWER=new Color(232, 12, 195);
	private Color STEM=new Color(93, 232, 12);
	private int sunY=0;
	private int sunX=0;
	private int cloudX=500;
	private int cowX=20;
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//B  A  C  K  R  O  U  N  D
		//System.out.println(skyColorG);
		g.setColor(new Color(skyColorR,skyColorG,skyColorB));
		g.fillRect(0, 0, 800, 600);
		// S    U    N
		g.setColor(SUN);
		g.fillOval(sunX, sunY, 50, 50);
		// C   L   O   U   D 
		g.setColor(CLOUD);
		g.fillOval(cloudX, 100, 100, 40);
		g.fillOval(cloudX-200, 50, 100, 40);
		// C   O   W
		g.setColor(CLOUD);
		g.fillOval(cowX, 352, 50, 30);
		g.fillOval(cowX+40,345,25,30);
		g.fillOval(cowX+5, 375, 10, 25);
		g.fillOval(cowX+35, 375, 10, 25);
		g.setColor(new Color(0,0,0));
		g.fillOval(cowX+45, 350, 4, 4);
		g.fillOval(cowX+55, 350, 4, 4);
		g.fillOval(cowX+5, 360, 20, 15);
		g.fillOval(cowX+30, 360, 10, 7);
		g.setColor(new Color(255,125,235));
		g.fillOval(cowX+42, 360, 20, 15);
		//G  R  O  U  N  D
		g.setColor(GROUND);
		g.fillRect(0, 400, 800, 200);
		//G   R   A   S   S
		g.setColor(GRASS);
		int x=0;
		while(x<500) {
			g.fillRect(x, 380, 3, 20);
			x+=5;
		}
		//T   R   E   E  
		g.setColor(GROUND);
		x=500;
		while(x<800) {
			g.fillRect(x, 300, 20, 100);
			x+=40;
		}
		g.setColor(GRASS);
		x=500;
		while(x<800) {
			g.fillOval(x-20, 280, 60, 60);
			x+=40;
		}
		//F  L  O  W  E  R
		g.setColor(STEM);
		x=0;
		while(x<500) {
			g.fillRect(x, 360, 5, 40);
			x+=70;
		}
		g.setColor(FLOWER);
		x=0;
		while(x<500) {
			g.fillOval(x-7, 350, 20, 20);
			x+=70;
		}
	}
	public void animate() {
		int mSeconds=0;
		int counter=0;
		while(true) {
			if(mSeconds<=2000) {
				if(skyColorG<255) {
					skyColorG+=1;
				}
				if(skyColorB<255) {
					skyColorB+=1;
				}
				
			}
			if(mSeconds>=4000 && mSeconds<=6000) {
				if(skyColorR<254) {
					skyColorR+=2;
				}
				if(skyColorG>180) {
					skyColorG--;
				}
				if(skyColorB>2) {
					skyColorB-=2;
				}
			}
			if(mSeconds>=6000 && mSeconds<=8000) {
				if(skyColorR>1) {
					skyColorR-=2;
				}
				if(skyColorG>1) {
					skyColorG-=2;
				}
			}
			
			sunX+=1;
			sunY=(int) ((0.003*Math.pow(sunX-350,2))+100);
			//System.out.println(sunY);
			cloudX--;
			cowX+=1;
			if(sunY>=600) {
				sunX=0;
				//System.out.println(mSeconds);
			}
			if(cloudX<=-100) {
				cloudX=1000;
			}
			if(cowX>=800) {
				cowX=-50;
			}
			try{
				Thread.sleep(10);
				mSeconds+=10;
				if(mSeconds>=7580) {
					mSeconds=0;
				}
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			repaint();
		}
	}
}

