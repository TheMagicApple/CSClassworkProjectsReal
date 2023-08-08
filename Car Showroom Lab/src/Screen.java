import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;


public class Screen extends JPanel implements ActionListener, KeyListener{
	
	//---------------------------------------------------------
	private JButton compactCar;
	private JButton smallSportsCar;
	private JButton sedan;
	private JButton sportsCar;
	private JButton suv;
	private JButton truck;
	private JButton testDrive;
	//----------------------------------------------------------
	private ArrayList<Automobile> carlist;
	private ArrayList<ArrayList<Integer>> conePositions=new ArrayList<>();
	//----------------------------------------------------------
	private int carShowing=0;
	private int nCones=7;
	//----------------------------------------------------------
	private boolean vroom=false;
	private boolean movingUp=false;
	private boolean movingDown=false;
	private boolean movingRight=false;
	private boolean movingLeft=false;
	private boolean drawedCones=false;
	//----------------------------------------------------------
	public Screen(){
		//--------------------------------------------------------------
		setLayout(null);
		compactCar=new JButton("Compact Car");
		smallSportsCar=new JButton("Small S Car");
		sedan=new JButton("Sedan");
		sportsCar=new JButton("Sports Car");
		suv=new JButton("SUV");
		truck=new JButton("Truck");
		testDrive=new JButton("vroom vroom");
		compactCar.setBounds(20,550,110,30);
		smallSportsCar.setBounds(140,550,120,30);
		sedan.setBounds(270,550,120,30);
		sportsCar.setBounds(400,550,120,30);
		suv.setBounds(530,550,120,30);
		truck.setBounds(660,550,120,30);
		testDrive.setBounds(300,30,200,50);
		add(compactCar);
		add(smallSportsCar);
		add(sedan);
		add(sportsCar);
		add(suv);
		add(truck);
		add(testDrive);
		compactCar.addActionListener(this);
		smallSportsCar.addActionListener(this);
		sedan.addActionListener(this);
		sportsCar.addActionListener(this);
		suv.addActionListener(this);
		truck.addActionListener(this);
		testDrive.addActionListener(this);
		compactCar.setFocusable(false);
		smallSportsCar.setFocusable(false);
		sedan.setFocusable(false);
		sportsCar.setFocusable(false);
		suv.setFocusable(false);
		truck.setFocusable(false);
		testDrive.setFocusable(false);
		//------------------------------------------------------------
		carlist=new ArrayList<>();
		carlist.add(new CompactCar(new Color(188, 226, 245),350,280,10));
		carlist.add(new SmallSportsCar(Color.RED,350,280,90));
		carlist.add(new Sedan(new Color(188, 226, 245),350,280,7));
		carlist.add(new SportsCar(Color.RED,350,280,15));
		carlist.add(new SUV(new Color(188, 226, 245),320,280,5));
		carlist.add(new Truck(Color.RED,320,280,3));
		//------------------------------------------------------------
		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//draw background
		g.setColor( Color.white );
		g.fillRect(0,0,800,600);
		
		//draw cars
		carlist.get(carShowing).drawMe(g);
		if(vroom) {
			g.setColor(Color.BLACK);
			g.drawString("Use arrow keys to control car...go through the cone obstacle course!",250,20);
			
			
			Graphics2D g2=(Graphics2D)g;
			g2.setStroke(new BasicStroke(5));
			for(int i=0;i<nCones;i++) {
				int x=conePositions.get(i).get(0);
				int y=conePositions.get(i).get(1);
						
				int[] trafficConeX= {x,x+20,x+40};
				int[] trafficConeY= {y,y-50,y};
				g2.setColor(Color.BLACK);
				g2.drawPolygon(trafficConeX,trafficConeY,3);
				g2.setColor(Color.ORANGE);
				g2.fillPolygon(trafficConeX,trafficConeY,3);
			}
			drawedCones=true;
			
			
		}
	}
	
	public void newConePositions() {
		conePositions.clear();
		for(int i=0;i<nCones;i++) {
			int x=(int)(Math.random()*500);
			int y=(int)(Math.random()*550+50);
			ArrayList<Integer> conePosition=new ArrayList<>();
			conePosition.add(x);
			conePosition.add(y);
			conePositions.add(conePosition);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==compactCar) {
			carShowing=0;
			vroom=false;
		}
		if(e.getSource()==smallSportsCar) {
			carShowing=1;
			vroom=false;
		}
		if(e.getSource()==sedan){
			carShowing=2;
			vroom=false;
		}
		if(e.getSource()==sportsCar) {
			carShowing=3;
			vroom=false;
		}
		if(e.getSource()==suv) {
			carShowing=4;
			vroom=false;
		}
		if(e.getSource()==truck) {
			carShowing=5;
			vroom=false;
		}
		if(e.getSource()==testDrive) {
			vroom=!vroom;
			movingUp=false;
			movingDown=false;
			movingRight=false;
			movingLeft=false;
			newConePositions();
			
		}
		repaint();
	}
	public void animate() {
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			System.out.println("eeeeeeeeeeeeeeeeeee");
		}
		if(vroom) {
			//carlist.get(carShowing).drive();
			
			if(carlist.get(carShowing).getX()<-200) {
				carlist.get(carShowing).setX(800);
				carlist.get(carShowing).setY(300);
			}
			
		}
		if(movingUp) {
			carlist.get(carShowing).goUp();
		}
		if(movingDown) {
			carlist.get(carShowing).goDown();
		}
		if(movingLeft) {
			carlist.get(carShowing).goLeft();
		}
		if(movingRight) {
			carlist.get(carShowing).goRight();		
		}
		
		repaint();
		animate();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==38 && vroom) {
			movingUp=true;
			movingDown=false;
			movingRight=false;
			movingLeft=false;
		}
		if(e.getKeyCode()==39 && vroom) {
			movingRight=true;
			movingUp=false;
			movingDown=false;
			movingLeft=false;
		}
		if(e.getKeyCode()==37 && vroom) {
			movingLeft=true;
			movingRight=false;
			movingUp=false;
			movingDown=false;
		}
		if(e.getKeyCode()==40 && vroom) {
			movingDown=true;
			movingUp=false;
			movingRight=false;
			movingLeft=false;
		}
		
		//System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		/*
		if(e.getKeyCode()==38) {
			movingUp=false;
		}
		if(e.getKeyCode()==37) {
			movingLeft=false;
		}
		if(e.getKeyCode()==39) {
			movingRight=false;
		}
		if(e.getKeyCode()==40) {
			movingDown=false;
		}
		*/
	}

	
	
}