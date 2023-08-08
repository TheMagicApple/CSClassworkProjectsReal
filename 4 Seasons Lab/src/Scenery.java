import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Scenery extends JPanel implements ActionListener{
	private String season="SUMMER";
	private JButton summer;
	private JButton fall;
	private JButton winter;
	private JButton spring;
	private Mountain[] m=new Mountain[5];
	private Tree[] t=new Tree[5];
	private Rain[] rain=new Rain[100];
	private Snow[] snow=new Snow[200];
	private Leaf[][] leaves=new Leaf[5][10];
	private int[] treeX=new int[5];
	private Random r=new Random();
	int overlayAlpha=0;
	int transition=0;
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	public Scenery() {
		setLayout(null);
		summer=new JButton("SUMMER");
		summer.setBounds(50,550,100,30);
		add(summer);
		summer.addActionListener(this);
		fall=new JButton("FALL");
		fall.setBounds(250,550,100,30);
		add(fall);
		fall.addActionListener(this);
		spring=new JButton("SPRING");
		spring.setBounds(450,550,100,30);
		add(spring);
		spring.addActionListener(this);
		winter=new JButton("WINTER");
		winter.setBounds(650,550,100,30);
		add(winter);
		winter.addActionListener(this);
		setFocusable(true);
		for(int i=0;i<m.length;i++) {
			m[i]=new Mountain(r.nextInt(600),200,false);
		}
		for(int i=0;i<t.length;i++) {
			int x=r.nextInt(700)+50;
			int y=r.nextInt(300)+200;
			for(int p:treeX) {
				if(Math.abs(x-p)<50) {
					x-=100;
				}
			}
			treeX[i]=x;
			t[i]=new Tree(x,y,0,255,30);
			for(int k=0;k<leaves[0].length;k++) {
				leaves[i][k]=new Leaf(r.nextInt(70)-30+x,r.nextInt(50)-20+y);
			}
		}
		for(int i=0;i<rain.length;i++) {
			rain[i]=new Rain(r.nextInt(800),r.nextInt(800)-800);
		}
		for(int i=0;i<snow.length;i++) {
			snow[i]=new Snow(r.nextInt(800),r.nextInt(800)-800);
		}
		
		
		
		
	}
	@Override
	public void paintComponent(Graphics g) {
		if(transition>0) {
			if(transition>85) {
				overlayAlpha+=17;
			}else if(transition<25){
				overlayAlpha-=10;
			}
			transition--;
		}
		
		if(season.equals("SPRING")) {
			Rain.spring=true;
		}else {
			Rain.spring=false;
		}
		if(season.equals("WINTER")) {
			Snow.winter=true;
			//System.out.println("turning on the snow");
			Mountain.winter=true;
			Tree.winter=true;
		}else {
			Snow.winter=false;
			Mountain.winter=false;
			Tree.winter=false;
		}
		if(season.equals("FALL")) {
			Tree.fall=true;
			Leaf.fall=true;
		}else {
			Tree.fall=false;
			Leaf.fall=false;
		}
		
		g.setColor(new Color(0,255,251));
		g.fillRect(0, 0, 800, 600);
		if(season.equals("WINTER")) {
			g.setColor(new Color(220,220,220));
		}else {
			g.setColor(new Color(2,224,36));
		}
		g.fillRect(0, 200, 800, 400);
		if(season.equals("SUMMER") || season.equals("SPRING")) {
			g.setColor(new Color(252,236,3));
			g.fillOval(400, 0, 100, 100);
		}
		
		for(Mountain mountain:m) {
			mountain.drawMe(g);
		}
		for(Leaf[] leafes:leaves) {
			for(Leaf leaf:leafes) {
				leaf.drawMe(g);
			}
		}
		for(Tree tree:t) {
			tree.drawMe(g);
		}
		for(Rain r:rain) {
			r.drawMe(g);
			//System.out.println("drawing rain");
		}
		for(Snow s:snow) {
			s.drawMe(g);
			//System.out.println("drawing rain");
		}
		
		if(season.equals("FALL") || season.equals("WINTER")) {
			g.setColor(new Color(255,255,255,230));
			//SMALL CLOUDS
			g.fillRect(103, 50, 100, 50);
			g.fillRect(576, 100, 100, 50);
			g.fillRect(223,70,100,50);
			g.fillRect(345, 23, 100, 50);
			g.fillRect(650, 48, 100, 50);
			//BIG CLOUD
			//g.fillRect(0, 0, 800, 150);
		}
		g.setColor(new Color(0,0,0,overlayAlpha));
		g.fillRect(0, 0, 800, 600);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==summer) {
			season="SUMMER";
			transition=100;
			overlayAlpha=0;
		}
		if(e.getSource()==fall) {
			season="FALL";
			transition=100;
			overlayAlpha=0;
		}
		if(e.getSource()==winter) {
			season="WINTER";
			transition=100;
			overlayAlpha=0;
		}
		if(e.getSource()==spring) {
			season="SPRING";
			transition=100;
			overlayAlpha=0;
			
		}
	}
	public void animate() {
		
		if(season.equals("SPRING")) {
			for(Rain r:rain) {
				r.changeY();
			}
		}
		if(season.equals("WINTER")) {
			for(Snow s:snow) {
				s.changeY();
			}
		}
		if(season.equals("FALL")) {
			for(Leaf[] leafes:leaves) {
				for(Leaf leaf:leafes) {
					leaf.changeY();
				}
			}
		}
		
		
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			System.out.println("um");
		}
		repaint();
		animate();
	}
	
	
	
}
