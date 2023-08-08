import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Screen extends JPanel{
	public Screen() {
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.CYAN);
	    g.fillRect(0, 0, 600, 600);
		drawBranch(g, 400, 400, 70, 0);
	    g.setColor(new Color(105, 76, 22));
	    g.fillRect(0, 550, 600, 200);
	    
	    g.setColor(Color.BLACK);
		g.drawLine(400,400,400,550); //trunk of the tree
	}
	public void drawBranch(Graphics g, int startX, int startY, int distance, int degree){
	    //We won't use degree as it's not needed for part 1 and part 2.

	    //Include a base case (stop condition).  At some point the recursive method call has to end.
		//double distanceY=Math.sqrt(Math.pow(distance, 2)-Math.pow(Math.cos((double)(distance))+ degree, 2));
		//double distanceX=Math.sqrt(Math.pow(distance, 2)-Math.pow(Math.sin((double)(distance))+ degree, 2));
		/*
		g.drawLine(startX, startY, startX+(int)(distance)*(int)Math.cos(degree), startY-(int)(distance)*(int)Math.sin(degree));
		g.drawLine(startX, startY, startX-(int)(distance)*(int)Math.cos(degree), startY-(int)(distance)*(int)Math.sin(degree));
		System.out.println(Math.cos(distance+degree));
		if(distance>2) {
			drawBranch(g,startX+(int)Math.cos(distance+degree), startY-(int)Math.sin(distance+degree),distance/2,degree+10);
			drawBranch(g,startX-(int)Math.cos(distance+degree), startY-(int)Math.sin(distance+degree),distance/2,degree+10);
		}
		*/
		g.setColor(Color.BLACK);
		g.drawLine(startX, startY, startX+distance,startY-distance);
		g.drawLine(startX, startY, startX-distance,startY-distance);
		g.setColor(Color.GREEN);
		int leftX=startX-distance/2;
		int rightX=startX+distance/2;
		int leftY=startY-distance/2;
		int rightY=startY-distance/2;
		for(int i=0;i<distance/4+1;i++) {
			g.fillOval(rightX, rightY, 4,4);
			g.fillOval(leftX, leftY, 4,4);
			rightX+=5;
			leftX-=5;
			rightY-=5;
			leftY-=5;
		}
		g.setColor(Color.BLACK);
	    //Draw the left branch from x and y, you can use the distance variable to get the end points. 
	    //Draw the right branch from x and y, you can use the distance variable to get the end points.
	//System.out.println("degree:"+degree);
		
		if(distance>1) {
			drawBranch(g,startX+distance,startY-distance,distance/2,0);
			drawBranch(g,startX-distance,startY-distance,distance/2,0);
		}
		
	    //Shorten the distance for the next set of branches up
	    //Call drawBranch(*) for the left passing in graphics, endx and endy for left branch, and the new distance
	    //Call drawBranch(*) for the rich passing in graphics, endx and endy for right branch, and the new distance    

	   
	}

}
