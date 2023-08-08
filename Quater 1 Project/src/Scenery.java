import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.util.ArrayList;
public class Scenery extends JPanel{
	private int selection1;
	private int selection2;
	private int selection3;
	private int move=1;
	private int duckX=400;
	private int duckY=450;
	private int generateSnow=0;
	Random r=new Random();
	
	private int snownum=0;
	private ArrayList<Integer> xValues=new ArrayList<>();
	private ArrayList<Integer> yValues=new ArrayList<>();
	private ArrayList<Integer> speed=new ArrayList<>();
	public Scenery(int selection1,int selection2,int selection3) {
		this.selection1=selection1;
		this.selection2=selection2;
		this.selection3=selection3;
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(selection1==1) {
			g.setColor(new Color(108,206,209));
			g.fillRect(0, 0, 800, 600);
			g.setColor(new Color(255,255,0));
			g.fillOval(300, 50, 100, 100);
		}else if(selection1==2){
			g.setColor(new Color(0,0,0));
			g.fillRect(0, 0, 800, 600);
			g.setColor(new Color(255,255,255));
			g.fillOval(300, 50, 100, 100);
			//drawStars(g);
		}else {
			g.setColor(new Color(255,125,0));
			g.fillRect(0, 0, 800, 600);
			g.setColor(new Color(255,200,0));
			g.fillOval(370, 210, 100, 100);
		}
		if(selection2==1) {
			g.setColor(new Color(255,255,255));
			g.fillRect(0, 250, 800, 350);
			
		}else {
			g.setColor(new Color(0,255,0));
			g.fillRect(0, 250, 800, 350);
		}
		if(selection3==1) {
			g.setColor(new Color(0,0,255));
			g.fillOval(100,300,600,500);
			duckX+=move;
			if(duckX>570) {
				move=-1;
			}
			if(duckX<130) {
				move=1;
			}
		}else {
			g.setColor(new Color(0,0,255));
			g.fillRect(350,250,150,350);
			duckY+=move;
			if(duckY>530) {
				move=-1;
			}
			if(duckY<270) {
				move=1;
			}
		}
		for(int i=0;i<yValues.size();i++) {
			yValues.set(i, yValues.get(i)+speed.get(i));
		}
		
		drawTree(g,200,200);
		drawTree(g,300,200);
		drawTree(g,250,250);
		drawHouse(g);
		drawFlower(g,100,400);
		drawFlower(g,75,500);
		drawFlower(g,50,425);
		drawFlower(g,100,450);
		drawFlower(g,25,475);
		drawDuck(g);
		if(selection2==1) {
			drawCowWinter(g);
			drawSnow(g);
		}else {
			drawCow(g);
		}
		
		newSnow();
		
		
		
		
		
		
		
	}
	public void newSnow(){
		if(generateSnow==0) {
			xValues.add(r.nextInt(800));
			yValues.add(r.nextInt(100)-400);
			speed.add(r.nextInt(5)+1);
		}
		
		generateSnow+=1;
		if(generateSnow>=5) {
			generateSnow=0;
		}
		
	}
	public void drawTree(Graphics g,int x,int y) {
		g.setColor(new Color(99,48,0));
		g.fillRect(x, y, 25, 70);
		g.setColor(new Color(0,77,0));
		g.fillOval(x-20, y-50, 65, 70);
	}
	public void drawHouse(Graphics g) {
		g.setColor(new Color(227,125,0));
		g.fillRect(500, 150, 150, 150);
		g.setColor(new Color(94,0,0));
		g.fillPolygon(new int[] {500,575,650},new int[] {150,100,150},3);
		g.setColor(new Color(255,255,255));
		g.fillRect(525, 200, 25, 25);
		g.fillRect(600, 200, 25, 25);
		g.setColor(new Color(0,0,0));
		g.fillRect(562, 250, 25, 50);
	}
	public void drawFlower(Graphics g,int x,int y) {
		g.setColor(new Color(128,63,0));
		g.fillRect(x, y, 5, 35);
		g.setColor(new Color(255,128,0));
		g.fillOval(x-15, y-25, 40, 40);
		g.setColor(new Color(255,209,0));
		g.fillOval(x-10, y-20, 27, 27);
		
	}
	public void drawDuck(Graphics g) {
		g.setColor(new Color(250,237,0));
		g.fillOval(duckX, duckY, 75, 75);
		g.fillOval(duckX+40, duckY-25, 50, 50);
		g.setColor(new Color(0,0,0));
		g.fillOval(duckX+60,duckY-10, 10, 10);
		g.setColor(new Color(255,125,0));
		g.fillRect(duckX+80, duckY-10, 20, 10);
		
	}
	public void drawCow(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.fillOval(40, 265, 100, 60);
		g.fillOval(120,250,50,60);
		g.fillOval(50, 310, 20, 50);
		g.fillOval(110, 310, 20, 50);
		g.setColor(new Color(0,0,0));
		g.fillOval(130, 260, 7, 7);
		g.fillOval(150, 260, 7, 7);
		g.fillOval(50, 280, 40, 30);
		g.fillOval(100, 280, 20, 15);
		g.setColor(new Color(255,125,235));
		g.fillOval(125, 280, 40, 30);
	}
	public void drawCowWinter(Graphics g) {
		
		g.setColor(new Color(220,220,220));
		g.fillOval(40, 265, 100, 60);
		g.fillOval(50, 310, 20, 50);
		g.fillOval(110, 310, 20, 50);
		g.fillOval(120,250,50,60);
		g.setColor(new Color(255,255,255));
		
		
		g.setColor(new Color(0,0,0));
		g.fillOval(130, 260, 7, 7);
		g.fillOval(150, 260, 7, 7);
		g.fillOval(50, 280, 40, 30);
		g.fillOval(100, 280, 20, 15);
		g.setColor(new Color(255,125,235));
		g.fillOval(125, 280, 40, 30);
	}
	
	
	public void drawSnow(Graphics g) {
		g.setColor(new Color(255,255,255));
		for(int i=0;i<yValues.size();i++) {
			g.fillOval(xValues.get(i), yValues.get(i), 10, 10);
		}
		
		snownum+=1;
		
	}
	/*
	public void drawStars(Graphics g) {
		Random r=new Random();
		g.setColor(new Color(255, 250, 186));
		for(int i=0;i<50;i++) {
			g.fillOval(r.nextInt(800), r.nextInt(150),5, 5);
		}
	}
	*/
}
	
