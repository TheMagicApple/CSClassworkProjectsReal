import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Screen extends JPanel implements MouseListener, ActionListener, MouseMotionListener{
	private int colorR=255;
	private int colorG=255;
	private int colorB=255;
	private int circleX;
	private int circleY;
	private int[][][] colors;
	private Square[][] grid;
	//private JButton reset;
	//private JButton undo;
	//private JButton saveFile;
	//private JButton save;
	//private JButton openSaved;
	private int lastRow;
	private int lastColumn;
	private boolean saved=false;
	private boolean saved2=false;
	private ArrayList<ArrayList<Integer>> actions=new ArrayList<>();
	private BufferedImage saveFile;
	private BufferedImage save;
	private BufferedImage openSaved;
	private BufferedImage undo;
	private BufferedImage reset;
	private BufferedImage colorWheel;
	Font customFont=null;
	Font customFontSmall=null;
	public Screen() {
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Raleway-Regular.ttf")).deriveFont(30f);
			customFontSmall = Font.createFont(Font.TRUETYPE_FONT, new File("src/Raleway-Regular.ttf")).deriveFont(13f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
			
			ge.registerFont(customFontSmall);
		}catch(IOException e) {
			System.out.println("could not load font");
		}catch(FontFormatException e) {
			System.out.println("could not load font");
		}
		setLayout(null);
		grid=new Square[16][16];
		try {
			saveFile=ImageIO.read(new File("src/savefileicon.png"));
			save=ImageIO.read(new File("src/saveiconreal.png"));
			openSaved=ImageIO.read(new File("src/opensavedicon.png"));
			undo=ImageIO.read(new File("src/undoicon.png"));
			reset=ImageIO.read(new File("src/reseticonreal.png"));
			colorWheel=ImageIO.read(new File("src/colorwheel.png"));
		}catch(IOException e) {
			System.out.println("IMAGE LOADING FAILED");
		}
		
		
		for(int a=0;a<grid.length;a++) {
			for(int b=0;b<grid[a].length;b++) {
				grid[a][b]=new Square(255,255,255);
			}
		}
		/*
		colors=new int[7][7][3];
		int r=255;
		int g=0;
		int b=0;
		int i=0;
		for(int c=0;c<7;c++) {
			int[] color= {r,g,b};
			colors[i][c]=color;
			g+=35;
		}
		i++;
		for(int c=0;c<7;c++) {
			int[] color= {r,g,b};
			colors[i][c]=color;
			r-=35;
		}
		i++;
		for(int c=0;c<7;c++) {
			int[] color= {r,g,b};
			colors[i][c]=color;
			b+=35;
		}
		i++;
		for(int c=0;c<7;c++) {
			int[] color= {r,g,b};
			colors[i][c]=color;
			g-=35;
		}
		i++;
		for(int c=0;c<7;c++) {
			int[] color= {r,g,b};
			colors[i][c]=color;
			r+=35;
		}
		i++;
		for(int c=0;c<6;c++) {
			int[] color= {r,g,b};
			colors[i][c]=color;
			b-=35;
		}
		int[] black= {0,0,0};
		colors[i][6]=black;
		//reset=new JButton("Reset");
		//undo=new JButton("Undo");
		//save=new JButton("Save");
		//saveFile=new JButton("Save File");
		//openSaved=new JButton("Open saved image");
		//reset.setBounds(400,100,100,30);
		//undo.setBounds(250,100,100,30);
		//save.setBounds(50,25,100,30);
		//saveFile.setBounds(425,25,125,30);
		//openSaved.setBounds(220,25,150,30);
		//reset.addActionListener(this);
		//undo.addActionListener(this);
		//save.addActionListener(this);
		//openSaved.addActionListener(this);
		//saveFile.addActionListener(this);
		//add(reset);
		//add(undo);
		//add(save);
		//add(saveFile);
		//add(openSaved);
		 * *
		 */
		
	}
	public Dimension getPreferredSize(){
		return new Dimension(600,600);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(customFontSmall);
		g.setColor(new Color(35, 35, 35));
		g.fillRect(0, 0, 600, 600);
		g.setColor(Color.white);
		if(saved) {
			g.drawString("Image downloaded", 480,110);
			g.drawString("'PixelArt.png'", 500,130);
			
		}
		if(saved2) {
			g.drawString("Image saved", 400,110);
		}
		g.drawString("Open saved image", 274,15);
		g.drawString("Save image", 400,15);
		g.drawString("Download image", 490,15);
		g.setFont(customFont);
		g.drawString("Current color: ",330,560);
		//g.drawRect(525, 525, 50, 50);
		g.setColor(new Color(colorR,colorG,colorB));
		
		g.fillRect(525, 525, 50,50);
		
		/*
		int cX=0;
		int cY=480;
		for(int a=0;a<colors.length;a++) {
			for(int b=0;b<colors[a].length;b++) {
				g.setColor(new Color(colors[a][b][0],colors[a][b][1],colors[a][b][2]));
				g.fillRect(cX, cY, 20, 20);
				g.setColor(Color.black);
				g.drawRect(cX, cY, 20, 20);
				cX+=20;
			}
			cX=0;
			cY+=20;
		}
		*/
		int x=200;
		int y=150;
		for(int a=0;a<grid.length;a++) {
			for(int b=0;b<grid[a].length;b++) {
				grid[a][b].drawMe(g, x, y);
				x+=20;
				
			}
			x=200;
			y+=20;
		}
		g.drawImage(saveFile,500,25,null);
		g.drawImage(save,400,25,null);
		g.drawImage(openSaved,300,25,null);
		g.drawImage(undo,25,25,null);
		g.drawImage(reset, 125, 25, null);
		g.drawImage(colorWheel,0,420,null);
		g.setColor(Color.black);
		g.drawOval(circleX-10, circleY-35, 10, 10);
	}
	private Image createImage() {
		BufferedImage image=new BufferedImage(320,320,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		int x=0;
		int y=0;
		for(int a=0;a<grid.length;a++) {
			for(int b=0;b<grid[a].length;b++) {
				grid[a][b].drawMeNoBorder(g, x, y);
				x+=20;
				
			}
			x=0;
			y+=20;
		}
		return image;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//System.out.println("x: "+e.getX()+" y: "+e.getY());
		int x=e.getX();
		int y=e.getY();
		if(x>=500 && x<=570 && y>=25 && y<=118) {
			BufferedImage image=(BufferedImage) createImage();
			File f=new File("PixelArt.png");
			try {
				ImageIO.write(image, "PNG", f);
				saved=true;
				repaint();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(x>=400 && x<=470 && y>=25 && y<=118) {
			try {
				File f=new File("savedImage.txt");
				f.delete();
				File blankF=new File("savedImage.txt");
				FileWriter writer=new FileWriter("savedImage.txt");
				for(int a=0;a<grid.length;a++) {
					for(int b=0;b<grid[a].length;b++) {
						int[] color=grid[a][b].getColor();
						writer.write(color[0]+" "+color[1]+" "+color[2]+System.getProperty( "line.separator" ));
						
					}
				}
				saved2=true;
				writer.close();
				repaint();
				
			}catch(IOException eeeeeeeee) {
				System.out.println("bad");
			}
		}
		if(x>=300 && x<=370 && y>=25 && y<=118) {
			try {
				FileReader reader=new FileReader("savedImage.txt");
				BufferedReader b=new BufferedReader(reader);
				ArrayList<String> s=new ArrayList<>();
				String string;
				while((string=b.readLine())!=null) {
					s.add(string);
				}
				int thing=0;
				for(int a=0;a<grid.length;a++) {
					for(int bb=0;bb<grid[a].length;bb++) {
						String[] color=s.get(thing).split(" ");
						int red=Integer.parseInt(color[0]);
						int green=Integer.parseInt(color[1]);
						int blue=Integer.parseInt(color[2]);
						grid[a][bb]=new Square(red,green,blue);
						thing++;
						
					}
				}
			} catch (FileNotFoundException eeeeeee) {
				// TODO Auto-generated catch block
			
			} catch (IOException eeeeee) {
				// TODO Auto-generated catch block
				
			}
			//remove(openSaved);
			repaint();
		}
		if(x>=25 && x<=95 && y>=25 && y<=118) {
			if(actions.size()>0) {
				saved=false;
				ArrayList<Integer> lastAction=actions.get(actions.size()-1);
				grid[lastAction.get(0)][lastAction.get(1)]=new Square(255,255,255);
				actions.remove(actions.size()-1);
				repaint();
			}
		}
		if(x>=125 && x<=195 && y>=25 && y<=118) {
			saved=false;
			for(int a=0;a<grid.length;a++) {
				for(int b=0;b<grid[a].length;b++) {
					grid[a][b]=new Square(255,255,255);
				}
			}
			colorR=255;
			colorG=255;
			colorB=255;
			repaint();
		}
		if(x<200) {
			//choosing color
			/*
			int row=(int) Math.floor((y-480-30)/20.0);

			int column=(int)Math.floor(x/20.0);
			if(row>=0 && row<colors.length && column>=0 && column<colors.length) {
				colorR=colors[row][column][0];
				colorG=colors[row][column][1];
				colorB=colors[row][column][2];
				repaint();
			}
			*/
			try {
				int pixel=colorWheel.getRGB(x, y-450);
				
				Color color=new Color(pixel,true);
				if(color.getRed()==10 && color.getGreen()==0 && color.getBlue()==0) {
					
				}else {
					circleX=x;
					circleY=y;
					colorR=color.getRed();
					colorG=color.getGreen();
					colorB=color.getBlue();
				}
				
				repaint();
			}catch(ArrayIndexOutOfBoundsException eeeeeeeeee) {
				
			}
			
			
			
		}else{
			//filling pixel
			
			int row=(int)Math.floor((y-150-30)/20.0);
			int column=(int)Math.floor((x-200-6)/20.0);
			if(row>=0 && row<grid.length && column>=0 && column<grid.length) {
				saved=false;
				ArrayList<Integer> action=new ArrayList<>();
				action.add(row);
				action.add(column);
				actions.add(action);
				grid[row][column].setColor(colorR, colorG, colorB);
				repaint();
			}
			
			//System.out.println("row:"+row);
			//System.out.println("column:"+column);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reset) {
			
		}
		if(e.getSource()==undo) {
			
			
		}
		
		if(e.getSource()==saveFile) {
			BufferedImage image=(BufferedImage) createImage();
			File f=new File("PixelArt.png");
			try {
				ImageIO.write(image, "PNG", f);
				saved=true;
				repaint();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==save) {
			//System.out.println("saving image for next time");
			
		}
		
			
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x=e.getX();
		int y=e.getY();
		if(x<200) {
			//choosing color (no drag)
		}else {
			//filling pixel
			
			int row=(int)Math.floor((y-150-30)/20.0);
			int column=(int)Math.floor((x-200-6)/20.0);
			if(row>=0 && row<grid.length && column>=0 && column<grid.length) {
				saved=false;
				ArrayList<Integer> action=new ArrayList<>();
				action.add(row);
				action.add(column);
				if(actions.contains(action)) {
					
				}else {
					actions.add(action);
				}
				grid[row][column].setColor(colorR, colorG, colorB);
				repaint();
			}
			
			
			
			//System.out.println("row:"+row);
			//System.out.println("column:"+column);
		}
		
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}