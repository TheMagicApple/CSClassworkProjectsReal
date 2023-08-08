import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener,MouseListener,MouseMotionListener{
	static final int displace=20;
	
	MyArrayList<Pair<Pair<Location,Location>,Integer>> path;

	Location luz=new Location(333,217,"Luzhou");
	Location daq=new Location(835,737,"Daqiaotou");
	Location min=new Location(1076,737,"Minquan");
	Location zho=new Location(1076,1013,"Zhongshan");
	Location mai=new Location(1076,1269,"Main Station");
	Location chi=new Location(1076,1513,"Chiang Kai-Shek");
	Location don=new Location(1265,1513,"Dongmen");
	Location daa=new Location(1585,1513,"Daan");
	Location hon=new Location(1585,1269,"Hongxiao Fuxing");
	Location nan=new Location(1585,1013,"Nanjing Fuxing");
	Location zon=new Location(1327,1269,"Zongxiao Xinsheng");
	Location son=new Location(1327,1013,"Songjiang Nanjing");
	Location xim=new Location(859,1335,"Ximen");
	Location bei=new Location(859,1149,"Beimen");
	Location hui=new Location(50,1526,"Huilong");
	Location hai=new Location(383,2130,"Haishan");
	Location ans=new Location(873,2125,"Anshijiao");
	Location dap=new Location(1485,2165,"Dapinglin");
	Location tai=new Location(2361,1995,"Taipei Zoo");
	Location xin=new Location(1879,1853,"Xinhai");
	Location exh=new Location(2541,1265,"Exhibition Center");
	Location jia=new Location(1749,390,"Jiannan Rd");
	Location xia=new Location(2015,1521,"Xiangshan");
	Location zhi=new Location(1075,202,"Zhishan");
	Location gut=new Location(1173,1621,"Guting");
	Location xio=new Location(859,1515,"Xionanmen");
	Location wen=new Location(2245,390,"Wende");
	Location tou=new Location(401,1178,"Touqianzhuang");
	Location sog=new Location(2165,1016,"Sogshan");
	
	final Location[] locations=new Location[] {luz,daq,min,zho,mai,chi,don,daa,hon,nan,zon,son,xim,bei,hui,hai,ans,dap,tai,xin,exh,jia,xia,zhi,gut,xio,wen,tou,sog};
	
	final Graph<Location> graph=new Graph<>();
	
	Color input1Color=new Color(235, 64, 52);
	Color input2Color=new Color(235, 64, 52);
	String input1="";
	String input2="";
	boolean enterInput1=false;
	boolean enterInput2=false;
	boolean input1changinggood=false;
	boolean input1changingbad=false;
	boolean input2changinggood=false;
	boolean input2changingbad=false;
	
	MyArrayList<Location> displayLocations=new MyArrayList<>();
	public Screen() {
		for(Location location:locations) {
			graph.add(location);
		}
		//0=yellow,1=red,2=green,3=blue,4=bronw
		//distances in meters
		graph.ae(luz,daq,new Pair<Integer,Integer>(5700,0));
		graph.ae(daq,tou,new Pair<Integer,Integer>(5400,0));
		graph.ae(tou, hui,new Pair<Integer,Integer>(5200,0));
		graph.ae(daq,min,new Pair<Integer,Integer>(1000,0));
		graph.ae(min,zhi,new Pair<Integer,Integer>(4100,1));
		graph.ae(min,zho,new Pair<Integer,Integer>(1550,1));
		graph.ae(min, son, new Pair<Integer,Integer>(3100,0));
		graph.ae(zho,son,new Pair<Integer,Integer>(1000,2));
		graph.ae(zho, bei, new Pair<Integer,Integer>(1000,2));
		graph.ae(zho, mai, new Pair<Integer,Integer>(1000,1));
		graph.ae(bei, xim, new Pair<Integer,Integer>(1000,2));
		graph.ae(xim, hai, new Pair<Integer,Integer>(8800,3));
		graph.ae(xim, xio, new Pair<Integer,Integer>(1000,2));
		graph.ae(xim, mai, new Pair<Integer,Integer>(1000,3));
		graph.ae(xio, chi, new Pair<Integer,Integer>(1000,2));
		graph.ae(chi, don, new Pair<Integer,Integer>(900,1));
		graph.ae(chi,mai,new Pair<Integer,Integer>(1000,1));
		graph.ae(chi, gut, new Pair<Integer,Integer>(600,2));
		graph.ae(gut, don, new Pair<Integer,Integer>(600,0));
		graph.ae(gut, ans, new Pair<Integer,Integer>(5200,0));
		graph.ae(gut, dap, new Pair<Integer,Integer>(5200,2));
		graph.ae(don, zon, new Pair<Integer,Integer>(1100,0));
		graph.ae(don, daa, new Pair<Integer,Integer>(1200,1));
		graph.ae(daa, xia, new Pair<Integer,Integer>(1400,1));
		graph.ae(daa, xin, new Pair<Integer,Integer>(4100,4));
		graph.ae(xin,tai,new Pair<Integer,Integer>(4100,4));
		graph.ae(zon, mai, new Pair<Integer,Integer>(1000,3));
		graph.ae(zon, hon, new Pair<Integer,Integer>(1000,3));
		graph.ae(zon, son, new Pair<Integer,Integer>(1000,0));
		graph.ae(son, nan, new Pair<Integer,Integer>(1000,2));
		graph.ae(hon, daa, new Pair<Integer,Integer>(1000,4));
		graph.ae(hon, exh, new Pair<Integer,Integer>(7750,3));
		graph.ae(hon, nan, new Pair<Integer,Integer>(1000,4));
		graph.ae(nan, jia, new Pair<Integer,Integer>(5200,4));
		graph.ae(jia, wen, new Pair<Integer,Integer>(2600,4));
		graph.ae(wen, exh, new Pair<Integer,Integer>(5700,4));
		graph.ae(nan, sog, new Pair<Integer,Integer>(3600,2));
		
		
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}
	public void paintComponent(Graphics g) {
		Graphics2D gg=(Graphics2D)g;
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		gg.setStroke(new BasicStroke(20,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		gg.setColor(new Color(230,230,230));
		gg.fillRect(0, 0, 100000, 100000);
		int[][] yellowlines=new int[][] {{333,217,841,729},{841,729,49,1529},{841,729,1325,729},{1325,729,1325,1445},{1325,1445,873,1941},{873,1941,873,2125}};
		int[][] redlines=new int[][] {{1077,201,1077,1513},{1077,1513,2014,1513}};
		int[][] greenlines=new int[][] {{1485,2165,1485,1945},{1485,1945,1077,1513},{1077,1513,861,1513},{861,1513,861,1013},{861,1013,2161,1013}};
		int[][] brownlines=new int[][] {{2541,1269,2541,645},{2541,645,2285,385},{2285,385,1585,389},{1585,389,1585,1717},{1585,1717,1877,1717},{1877,1717,1877,1989},{1877,1989,2365,1989}};
		int[][] bluelines=new int[][] {{385,2129,385,1809},{385,1809,929,1269},{929,1269,2541,1269}};

		gg.setColor(new Color(255, 211, 77));
		for(int[] line:yellowlines) {
			gg.drawLine((int)(line[0]/4.66666f)+displace, (int)(line[1]/4.66666f), (int)(line[2]/4.666666f)+displace,(int)(line[3]/4.66666f));
		}
		gg.setColor(new Color(255, 77, 77));
		for(int[] line:redlines) {
			gg.drawLine((int)(line[0]/4.66666f)+displace, (int)(line[1]/4.66666f), (int)(line[2]/4.666666f)+displace,(int)(line[3]/4.66666f));
		}
		gg.setColor(new Color(88, 252, 76));
		for(int[] line:greenlines) {
			gg.drawLine((int)(line[0]/4.66666f)+displace, (int)(line[1]/4.66666f), (int)(line[2]/4.666666f)+displace,(int)(line[3]/4.66666f));
		}
		gg.setColor(new Color(196, 137, 59));
		for(int[] line:brownlines) {
			gg.drawLine((int)(line[0]/4.66666f)+displace, (int)(line[1]/4.66666f), (int)(line[2]/4.666666f)+displace,(int)(line[3]/4.66666f));
		}
		gg.setColor(new Color(76, 158, 252));
		for(int[] line:bluelines) {
			gg.drawLine((int)(line[0]/4.66666f)+displace, (int)(line[1]/4.66666f), (int)(line[2]/4.666666f)+displace,(int)(line[3]/4.66666f));
		}
		
		gg.setColor(Color.black);
		gg.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		gg.drawRoundRect(10,15,580,470,10,10);
		
		for(Location location:locations) {
			gg.setColor(new Color(0,0,0));
			gg.setStroke(new BasicStroke(15,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			gg.drawLine((int)(location.x/4.66666f)+displace, (int)(location.y/4.66666f), (int)(location.x/4.666666f)+displace,(int)(location.y/4.66666f));
			gg.setColor(new Color(255,255,255));
			gg.setStroke(new BasicStroke(12,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			gg.drawLine((int)(location.x/4.66666f)+displace, (int)(location.y/4.66666f), (int)(location.x/4.666666f)+displace,(int)(location.y/4.66666f));
			gg.setColor(new Color(0,0,0));
			//gg.drawString(location.abbreviation, (int)(location.x/4.66666f)+displace+10,(int)(location.y/4.66666f));
		}
		if(graph.getPath()!=null) {
			MyArrayList<Location> path=graph.getPath();
			for(Location location:locations) {
				if(path.contains(location)) {
					gg.setColor(new Color(0,0,0));
					gg.setStroke(new BasicStroke(18,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
					gg.drawLine((int)(location.x/4.66666f)+displace, (int)(location.y/4.66666f), (int)(location.x/4.666666f)+displace,(int)(location.y/4.66666f));
					gg.setColor(new Color(255, 120, 241));
					gg.setStroke(new BasicStroke(15,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
					gg.drawLine((int)(location.x/4.66666f)+displace, (int)(location.y/4.66666f), (int)(location.x/4.666666f)+displace,(int)(location.y/4.66666f));
					gg.setColor(new Color(0,0,0));
					
				}
			}
		}
		gg.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		gg.setFont(new Font("Inter Tight",Font.PLAIN,40));
		
		if(enterInput1) {
			gg.setColor(new Color(200,200,200));
			gg.drawLine(47, 562, 153, 562);
			gg.drawLine(47, 562, 47, 508);
			gg.drawLine(47, 508, 153, 508);
			gg.drawLine(153, 562, 153, 508);
			gg.setColor(input1Color);
		}else {
			gg.setColor(input1Color);
		}
		gg.drawLine(50, 560, 150, 560);
		gg.drawLine(50, 560, 50, 510);
		gg.drawLine(50, 510, 150, 510);
		gg.drawLine(150, 560, 150, 510);
		drawCenteredString((Graphics)gg,input1.toUpperCase(),new Rectangle(50,510,100,50),new Font("Inter Tight",Font.PLAIN,40));
		
		gg.setColor(Color.black);
		gg.setFont(new Font("Inter Tight",Font.PLAIN,20));
		gg.drawString("TO", 162,543);
		if(enterInput2) {
			gg.setColor(new Color(200,200,200));
			gg.drawLine(197, 562, 303, 562);
			gg.drawLine(197, 562, 197, 508);
			gg.drawLine(197, 508, 303, 508);
			gg.drawLine(303, 562, 303, 508);
			gg.setColor(input2Color);
		}else {
			gg.setColor(input2Color);
		}
		gg.drawLine(200, 560, 300, 560);
		gg.drawLine(200, 560, 200, 510);
		gg.drawLine(200, 510, 300, 510);
		gg.drawLine(300, 560, 300, 510);
		drawCenteredString((Graphics)gg,input2.toUpperCase(),new Rectangle(200,510,100,50),new Font("Inter Tight",Font.PLAIN,40));
		for(int i=0;i<displayLocations.size();i++) {
			Location location=displayLocations.get(i);
			
			gg.setColor(new Color(255,255,255));
			int x=(int)(location.x/4.6666f)+displace;
			int y=(int)(location.y/4.6666f)+displace;
			gg.fillRoundRect(x-50,y-40,100,40,20,10);
			gg.setColor(new Color(0,0,0));
			gg.drawRoundRect(x-50,y-40,100,40,20,10);
			gg.setFont(new Font("Inter Tight",Font.PLAIN,15));
			drawCenteredString((Graphics)gg,location.abbreviation.toUpperCase(),new Rectangle(x-50,y-40,100,30),new Font("Inter Tight",Font.PLAIN,15));
			gg.setFont(new Font("Inter Tight",Font.PLAIN,10));
			drawCenteredString((Graphics)gg,location.name,new Rectangle(x-50,y-20,100,20),new Font("Inter Tight",Font.PLAIN,10));
		}
		if(path==null) {
			gg.setFont(new Font("Inter Tight",Font.PLAIN,14));
			gg.setColor(new Color(0,0,0));
			g.drawString("Hover over locations to see their info.", 330,520);
			g.drawString("Enter 3 letter location abbreviations",330,550);
			g.drawString(" and then press ENTER.", 360,567);
		}
		if(path!=null) {
			int x=350;
			int y=485;
			if(path.size()==1) {
				y=512;
			}else if(path.size()==2) {
				y=510;
			}else if(path.size()==3) {
				y=510;
			}else if(path.size()==4) {
				y=510;
			}
			for(int i=0;i<path.size();i++) {
				Pair<Pair<Location,Location>,Integer> step=path.get(i);
				graph.shortestPath(step.a.a,step.a.b);
				
				if(step.b==0) {
					gg.setColor(new Color(255, 211, 77));
					drawCenteredString(g,"("+Math.round((graph.distance/1000f))+") Take Yellow Line From "+step.a.a+" To "+step.a.b,new Rectangle(x,y,200,30),new Font("Inter Tight",Font.BOLD,16));
				}else if(step.b==1) {
					gg.setColor(new Color(255, 77, 77));
					drawCenteredString(g,"("+Math.round((graph.distance/1000f))+") Take Red Line From "+step.a.a+" To "+step.a.b,new Rectangle(x,y,200,30),new Font("Inter Tight",Font.BOLD,16));
				}else if(step.b==2) {
					gg.setColor(new Color(88, 252, 76));
					drawCenteredString(g,"("+Math.round((graph.distance/1000f))+") Take Green Line From "+step.a.a+" To "+step.a.b,new Rectangle(x,y,200,30),new Font("Inter Tight",Font.BOLD,16));
				}else if(step.b==3) {
					gg.setColor(new Color(76, 158, 252));
					drawCenteredString(g,"("+Math.round((graph.distance/1000f))+") Take Blue Line From "+step.a.a+" To "+step.a.b,new Rectangle(x,y,200,30),new Font("Inter Tight",Font.BOLD,16));
				}else {
					gg.setColor(new Color(196, 137, 59));
					drawCenteredString(g,"("+Math.round((graph.distance/1000f))+") Take Brown Line From "+step.a.a+" To "+step.a.b,new Rectangle(x,y,200,30),new Font("Inter Tight",Font.BOLD,16));
				}
				
				y+=20;
			}
		}
		if(graph.distance!=0) {
			gg.setColor(Color.black);
			graph.shortestPath(path.get(0).a.a,path.get(path.size()-1).a.b);
			drawCenteredString(g,"Distance: "+Math.round((graph.distance/1000f))+" km",new Rectangle(350,490,200,30),new Font("Inter Tight",Font.BOLD,20));
		}
		
	}
	public void animate() throws InterruptedException {
		while(true) {
			if(input1changinggood) {
				if(input1Color.getRed()<=51) {
					input1changinggood=false;
				}else {
					input1Color=new Color(input1Color.getRed()-15,input1Color.getGreen()+9,input1Color.getBlue());
				}
			}
			if(input1changingbad) {
				if(input1Color.getRed()>=235) {
					input1changingbad=false;
				}else {
					input1Color=new Color(input1Color.getRed()+15,input1Color.getGreen()-9,input1Color.getBlue());
				}
			}
			if(input2changinggood) {
				if(input2Color.getRed()<=51) {
					input2changinggood=false;
				}else {
					input2Color=new Color(input2Color.getRed()-15,input2Color.getGreen()+9,input2Color.getBlue());
				}
			}
			if(input2changingbad) {
				if(input2Color.getRed()>=235) {
					input2changingbad=false;
				}else {
					input2Color=new Color(input2Color.getRed()+15,input2Color.getGreen()-9,input2Color.getBlue());
				}
			}
			Thread.sleep(10);
			repaint();
		}
		
	}
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    g.setFont(font);
	    g.drawString(text, x, y);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10 && input1Color.getRed()<=51 && input2Color.getRed()<=51) {
			
			Location l1=null;
			Location l2=null;
			for(Location location:locations) {
				if(location.abbreviation.toLowerCase().equals(input1.toLowerCase())) {
					l1=location;
				}
				if(location.abbreviation.toLowerCase().equals(input2.toLowerCase())) {
					l2=location;
				}
			}
			path=graph.shortestPath(l1, l2);
		}
		if(enterInput1) {
			if(e.getKeyCode()==8) {
				if(input1.length()>0) input1=input1.substring(0,input1.length()-1);
			}else {
				if(input1.length()<3) {
					input1+=e.getKeyChar();
				}
				
			}
			boolean foundLocation=false;
			for(Location location:locations) {
				if(location.abbreviation.toLowerCase().equals(input1.toLowerCase())) {
					input1changingbad=false;
					input1changinggood=true;
					foundLocation=true;
					break;
				}
			}
			if(!foundLocation) {
				input1changinggood=false;
				input1changingbad=true;
			}
		}
		if(enterInput2) {
			if(e.getKeyCode()==8) {
				if(input2.length()>0) input2=input2.substring(0,input2.length()-1);
			}else {
				if(input2.length()<3) {
					input2+=e.getKeyChar();
				}
			}
			boolean foundLocation=false;
			for(Location location:locations) {
				if(location.abbreviation.toLowerCase().equals(input2.toLowerCase())) {
					input2changingbad=false;
					input2changinggood=true;
					foundLocation=true;
					break;
				}
			}
			if(!foundLocation) {
				input2changinggood=false;
				input2changingbad=true;
			}
		}
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX()>50 && e.getX()<160 && e.getY()>520 && e.getY()<600) {
			enterInput1=true;
		}else {
			enterInput1=false;
		}
		if(e.getX()>200 && e.getX()<300 && e.getY()>520 && e.getY()<600) {
			enterInput2=true;
		}else {
			enterInput2=false;
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
		int x=e.getX();
		int y=e.getY();
		for(Location location:locations) {
			int lX=(int)(location.x/4.6666f)+displace;
			int lY=(int)(location.y/4.6666f)+displace;
			//System.out.println(location.abbreviation);
			if(location.abbreviation.equals("Tai")) {
				//System.out.println(x+" "+y+" "+lX+" "+lY);
			}
			if(Math.abs(lX-x)<20 && Math.abs(lY-y)<20) {
				//System.out.println(location.name);
				if(!displayLocations.contains(location))displayLocations.add(location);
			}else {
				displayLocations.remove(location);
			}
		}
		repaint();
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
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
}
